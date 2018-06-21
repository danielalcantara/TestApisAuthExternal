package br.com.hubfintech.extauthtests.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.hubfintech.extauthtests.enums.EStatusTest;
import br.com.hubfintech.extauthtests.exception.TestExtAuthException;
import br.com.hubfintech.extauthtests.functional.ThrowingConsumer;
import br.com.hubfintech.extauthtests.model.TestModel;
import br.com.hubfintech.extauthtests.model.TestModelReport;
import br.com.hubfintech.extauthtests.report.GeradorRelatorio;
import br.com.hubfintech.extauthtests.util.IFileUtil;
import br.com.valepresente.kharon.external.dto.Message;
import br.com.valepresente.kharon.external.dto.RequestDTO;
import br.com.valepresente.kharon.external.dto.Response;
import br.com.valepresente.kharon.external.enums.EAction;
import br.com.valepresente.kharon.external.factory.IRequestFactory;
import br.com.valepresente.kharon.external.socket.ExternalAuthorizationService;
import br.com.valepresente.kharon.external.util.JsonUtil;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ExtAuthorizationTestService implements IExtAuthorizationTestService {

	private static final Logger log = LoggerFactory.getLogger(ExtAuthorizationTestService.class);

	@Inject
	ExternalAuthorizationService extAuthorizationService;

	@Inject
	private IRequestFactory requestFactory;

	@Inject
	IFileUtil fileUtil;

	@Inject
	private HttpServletRequest request;

	@Override
	public List<TestModel> executeTests(String tests, String url, Integer port) throws TestExtAuthException {

		try {
			List<RequestDTO> requestDTOs = JsonUtil.listFromJson(tests, RequestDTO.class);

			return mapReqResp(url, port, requestDTOs);

		} catch (IOException exExecuteTests) {
			log.error("Erro na execução dos testes.", exExecuteTests);
			throw new TestExtAuthException(exExecuteTests);
		}

	}

	@Override
	public List<TestModel> reloadTests(List<TestModel> processedTests, String url, Integer port)
			throws TestExtAuthException {

		try {

			List<RequestDTO> requestDTOs = new ArrayList<>();

			processedTests.stream().forEach((ThrowingConsumer<TestModel>) processedTest -> {
				String requestJson = processedTest.getRequestJson().replace("<p>", "\n").replace("</p>", "").trim();
				RequestDTO requestDTO = JsonUtil.fromJson(requestJson, RequestDTO.class);
				requestDTO.generateRequestId();

				requestDTOs.add(requestDTO);
			});

			return mapReqResp(url, port, requestDTOs);

		} catch (Exception ex) {
			log.error("Erro ao refazer os testes.", ex);
			throw new TestExtAuthException(ex);
		}

	}

	private List<TestModel> mapReqResp(String url, Integer port, List<RequestDTO> requestDTOs) {

		Map<RequestDTO, Map<Message, Response>> mapReqDtoReqRes = new HashMap<>();
		mapReferRequestId(requestDTOs);

		requestDTOs.stream().forEach((ThrowingConsumer<RequestDTO>) requestDTO -> {
			Map<Message, Response> mapReqResp = new HashMap<>();
			Message request = requestFactory.createRequest(requestDTO);
			Response response = extAuthorizationService.sendMessage(request, url, port);
			response.action = request.action.name();

			mapReqResp.put(request, response);
			mapReqDtoReqRes.put(requestDTO, mapReqResp);
		});

		return processTests(mapReqDtoReqRes);

	}

	private void mapReferRequestId(List<RequestDTO> requestDTOs) {
		requestDTOs.forEach(requestDTO -> {
			requestDTOs.stream()
					.filter(requestDTORef -> (requestDTORef.indexRequest.equals(requestDTO.indexRequestRefer)))
					.forEach(requestDTORef -> {
						if (EAction.cancel.equals(requestDTO.action))
							requestDTO.requestIdToCancel = requestDTORef.requestId;
						else
							requestDTO.requestIdToSearch = requestDTORef.requestId;
					});
		});
	}

	private List<TestModel> processTests(Map<RequestDTO, Map<Message, Response>> mapReqDtoReqRes) {

		List<TestModel> testModels = new ArrayList<>();

		mapReqDtoReqRes.forEach((request, reqResp) -> {
			TestModel testModel = new TestModel();
			boolean resultTest = true;
			Message requestMessage = reqResp.keySet().stream().findFirst().orElse(null);
			Response response = reqResp.values().stream().findFirst().orElse(null);

			resultTest = request.statusExpected.equals(response.status);

			if (resultTest)
				resultTest = request.codeExpected == null || request.codeExpected.equals(response.content.code);

			if (resultTest)
				testModel.setStatus(EStatusTest.SUCCESS);
			else
				testModel.setStatus(EStatusTest.ERROR);

			testModel.setIndex(request.indexRequest);
			testModel.setAccountId(request.accountId);
			testModel.setAction(request.action);
			testModel.setAmount(request.amount);
			testModel.setCodeExpected(request.codeExpected);

			if (response.content != null)
				testModel.setCodeReturned(response.content.code);

			if (request.commerce != null)
				testModel.setCommerceName(request.commerce.name);

			testModel.setResponseCode(response.status);
			testModel.setTruncCardNumber(request.truncCardNumber);
			testModel.setType(request.type);
			testModel.setRequestJson(JsonUtil.toJsonPrettyRaw(request));
			testModel.setResponseJson(JsonUtil.toJsonPrettyRaw(response));
			testModel.setRequestJsonMessage(JsonUtil.toJsonRaw(requestMessage));
			testModel.setResponseJsonMessage(JsonUtil.toJsonRaw(response));
			testModel.setRequestId(request.requestId);

			testModels.add(testModel);
		});

		testModels.sort((t1, t2) -> t1.getIndex().compareTo(t2.getIndex()));

		return testModels;

	}

	@Override
	public InputStream reportTests(List<TestModel> testModels, Map<String, Object> params) throws TestExtAuthException {
		try {
			String nameReportFile = "report_test.jasper";
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			String pathReport = request.getServletContext().getRealPath("/WEB-INF/jasper/".concat(nameReportFile));
			int totalError = (int) testModels.stream().filter((test) -> EStatusTest.ERROR.equals(test.getStatus()))
					.count();
			int totalSuccess = (int) testModels.stream().filter((test) -> EStatusTest.SUCCESS.equals(test.getStatus()))
					.count();
			params.put("TOTAL_SUCCESS", totalSuccess);
			params.put("TOTAL_ERROR", totalError);
			params.put("STATUS_REPORT", (int) totalError > 0 ? EStatusTest.ERROR.name() : EStatusTest.SUCCESS.name());
			params.put("SUBREPORT_DIR", pathReport.replace(nameReportFile, ""));

			List<TestModelReport> testsReport = testModels.stream().map((testModel) -> {
				TestModelReport modelReport = new TestModelReport();

				modelReport.setAccountId(testModel.getAccountId());
				modelReport.setAction(testModel.getAction().name());
				modelReport.setAmount(testModel.getAmount());
				modelReport.setCodeExpected(testModel.getCodeExpected());
				modelReport.setCodeReturned(testModel.getCodeReturned());
				modelReport.setCommerceName(testModel.getCommerceName());
				modelReport.setIdx(testModel.getIndex());
				modelReport.setRequestJsonMessage(testModel.getRequestJsonMessage());
				modelReport.setResponseJsonMessage(testModel.getResponseJsonMessage());
				modelReport.setResponseCode(testModel.getResponseCode());
				modelReport.setStatus(testModel.getStatus().name());
				modelReport.setTruncCardNumber(testModel.getTruncCardNumber());
				modelReport.setTypeTest(testModel.getType());
				modelReport.setRequestId(testModel.getRequestId());

				return modelReport;
			}).collect(Collectors.toList());

			List<TestModelReport> testsSubReport = testsReport.stream()
					.filter((t) -> EStatusTest.ERROR.name().equals(t.getStatus())).collect(Collectors.toList());

			params.put("DATA_SOURCE", new JRBeanCollectionDataSource(testsSubReport));

			GeradorRelatorio geradorRelatorio = new GeradorRelatorio(pathReport, params,
					new JRBeanCollectionDataSource(testsReport));
			geradorRelatorio.geraPDFParaOutputStream(outputStream);

			return fileUtil.getInputStreamByOutputStream(outputStream);
		} catch (Exception ex) {
			log.error("Erro ao gerar relatório.", ex);
			throw new TestExtAuthException(ex);
		}
	}

}
