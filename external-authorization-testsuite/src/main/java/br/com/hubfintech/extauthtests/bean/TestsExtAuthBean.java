package br.com.hubfintech.extauthtests.bean;

import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import br.com.hubfintech.extauthtests.enums.EStatusTest;
import br.com.hubfintech.extauthtests.exception.TestExtAuthException;
import br.com.hubfintech.extauthtests.model.TestModel;
import br.com.hubfintech.extauthtests.service.IExtAuthorizationTestService;
import br.com.hubfintech.extauthtests.util.IFacesUtil;
import br.com.hubfintech.extauthtests.util.IMessagesUtil;

@Controller
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class TestsExtAuthBean implements Serializable {

	private static final long serialVersionUID = 5372182245955402498L;

	private UploadedFile file;
	private String url;
	private Integer port;
	private String tests;
	private List<TestModel> processedTests;
	private Integer totalTests = 0;
	private Integer totalTestsSucess = 0;
	private Integer totalTestsError = 0;
	private TestModel testSelected;
	private boolean testFail = false;
	private StreamedContent fileModelTests;
	private StreamedContent fileReport;

	@Inject
	IExtAuthorizationTestService authorizationTestService;

	@Inject
	IFacesUtil facesUtil;

	@Inject
	IMessagesUtil messages;
	
	public TestsExtAuthBean() {
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext()
				.getResourceAsStream("/resources/files/massa-teste-apis-mp.json");
		fileModelTests = new DefaultStreamedContent(stream, "application/json", "file_model_tests.json");
	}

	public void upload() {
		if ((file != null && file.getContents().length > 0)) {
			tests = new String(file.getContents());
			executeTests(false);
		}
	}

	public void reloadTests() {
		if (processedTests != null && !processedTests.isEmpty()) {
			executeTests(true);
		}
	}

	private void executeTests(boolean reload) {
		try {
			if (reload)
				processedTests = authorizationTestService.reloadTests(processedTests, url, port);
			else
				processedTests = authorizationTestService.executeTests(tests, url, port);
		} catch (Exception ex) {
			String msg = ex.getMessage() != null ? ex.getMessage() : messages.getMessage("msg.error.nullpointer");
			facesUtil.setMessageErro(messages.getMessage("msg.error.request.process.fail", msg));
			testFail = true;

			return;
		}

		totalTests = processedTests.size();
		totalTestsSucess = (int) processedTests.stream().filter((test) -> EStatusTest.SUCCESS.equals(test.getStatus()))
				.count();
		totalTestsError = (int) processedTests.stream().filter((test) -> EStatusTest.ERROR.equals(test.getStatus()))
				.count();

		if (totalTestsError > 0)
			testFail = true;

		facesUtil.setMessageInfo(messages.getMessage("msg.info.tests.process.success", processedTests.size()));
	}

	public void cleanTests() {
		this.tests = null;
		this.port = null;
		this.url = null;
		this.testSelected = null;
		this.processedTests = null;
		this.testFail = false;
		this.totalTests = 0;
		this.totalTestsError = 0;
		this.totalTestsSucess = 0;
	}
	
	public StreamedContent getReportTests() {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("URL_API", url);
			params.put("PORTA", port);
			
			InputStream stream = authorizationTestService.reportTests(processedTests, params);
			fileReport = new DefaultStreamedContent(stream, "application/pdf", "report_tests.pdf");
		} catch (TestExtAuthException ex) {
			String msg = ex.getMessage() != null ? ex.getMessage() : messages.getMessage("msg.error.nullpointer");
			facesUtil.setMessageErro(messages.getMessage("msg.error.request.report.fail", msg));
			testFail = true;
		}
		
		return this.fileReport;
	}
	
	public void testUpdate() {
		facesUtil.setMessageInfo(messages.getMessage("msg.info.tests.update.test.success"));
	}

	public StreamedContent getFileModelTests() {
		return fileModelTests;
	}

	public void detailTest() {
		System.out.println("Entrou no modal!!");
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public List<TestModel> getProcessedTests() {
		return processedTests;
	}

	public void setProcessedTests(List<TestModel> processedTests) {
		this.processedTests = processedTests;
	}

	public Integer getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(Integer totalTests) {
		this.totalTests = totalTests;
	}

	public Integer getTotalTestsSucess() {
		return totalTestsSucess;
	}

	public void setTotalTestsSucess(Integer totalTestsSucess) {
		this.totalTestsSucess = totalTestsSucess;
	}

	public Integer getTotalTestsError() {
		return totalTestsError;
	}

	public void setTotalTestsError(Integer totalTestsError) {
		this.totalTestsError = totalTestsError;
	}

	public TestModel getTestSelected() {
		return testSelected;
	}

	public void setTestSelected(TestModel testSelected) {
		this.testSelected = testSelected;
	}

	public boolean isStatusTest() {
		return testFail;
	}

	public void setStatusTest(boolean statusTest) {
		this.testFail = statusTest;
	}

	public String getTests() {
		return tests;
	}

}
