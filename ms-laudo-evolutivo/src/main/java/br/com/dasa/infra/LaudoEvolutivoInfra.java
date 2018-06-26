package br.com.dasa.infra;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.dasa.infra.response.laudo.ResponseAPILaudo;
import br.com.dasa.util.IPropertyUtil;

@Component
public class LaudoEvolutivoInfra implements ILaudoEvolutivoInfra {

	private String endpointAPILaudosURL;
	private String token;
	private String host;
	private String environmet;

	final String PARAM_FAP_NAME = "codigoOrigem";
	final String PRAM_MARCA_ORIGEM_NAME = "marcaOrigem";
	final String PARAM_CID_NAME = "cip";

	@Autowired
	public LaudoEvolutivoInfra(IPropertyUtil propertyUtilParam) {

		super();
		environmet = propertyUtilParam.getConfigParamByKey("ENVIRONMENT");
		token = propertyUtilParam.getConfigParamByKey("TOKEN");

		switch (environmet) {

		case "desenv":
			endpointAPILaudosURL = propertyUtilParam.getConfigParamByKey("CLOUD_SEARCH_ENDPOINT_DESENV");
			host = propertyUtilParam.getConfigParamByKey("HOST_DESENV");
			break;
		case "homologacao":
			endpointAPILaudosURL = propertyUtilParam.getConfigParamByKey("CLOUD_SEARCH_ENDPOINT_HOMOLOGACAO");
			host = propertyUtilParam.getConfigParamByKey("HOST_HOMOLOGACAO");
			break;
		case "prod":
			endpointAPILaudosURL = propertyUtilParam.getConfigParamByKey("CLOUD_SEARCH_ENDPOINT_PROD");
			host = propertyUtilParam.getConfigParamByKey("HOST_PROD");
			break;
		case "mock":
			endpointAPILaudosURL = propertyUtilParam.getConfigParamByKey("CLOUD_SEARCH_ENDPOINT_MOCK");
			break;
		default:
			break;

		}

	}

	@Override
	public ResponseAPILaudo getResponseFromFap(Long fap)
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		JSONObject requestBody = new JSONObject();

		requestBody.put(PARAM_FAP_NAME, fap);

		return getLaudosFromRestTemplate(requestBody, 0);
	}

	@Override
	public ResponseAPILaudo getResponseFromCip(Long cid, String marcaOrigem, Integer qtdLaudos)
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		int start = 0;
		JSONObject requestBody = new JSONObject();

		requestBody.put(PARAM_CID_NAME, cid);
		requestBody.put(PRAM_MARCA_ORIGEM_NAME, marcaOrigem);

		ResponseAPILaudo responseAPILaudoResult = getLaudosFromRestTemplate(requestBody, start);
		ResponseAPILaudo responseAPILaudoTemp = new ResponseAPILaudo();

		while (responseAPILaudoResult != null && responseAPILaudoResult.getResults() != null
				&& responseAPILaudoResult.getResults().size() < qtdLaudos
				&& (responseAPILaudoResult.getMetadata().getTotal() != null && responseAPILaudoResult.getResults()
						.size() < responseAPILaudoResult.getMetadata().getTotal())) {

			start += responseAPILaudoResult.getMetadata().getLimit();
			responseAPILaudoTemp = getLaudosFromRestTemplate(requestBody, start);

			if (responseAPILaudoTemp != null && !responseAPILaudoTemp.getResults().isEmpty()) {
				responseAPILaudoResult.getResults().addAll(responseAPILaudoTemp.getResults());
			}

		}

		if (responseAPILaudoResult.getResults().size() > qtdLaudos) {
			responseAPILaudoResult.setResults(responseAPILaudoResult.getResults().subList(0, qtdLaudos));
		}

		return responseAPILaudoResult;

	}

	private ResponseAPILaudo getLaudosFromRestTemplate(JSONObject requestBody, int start)
			throws JSONException, JsonParseException, JsonMappingException, IOException {

		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(endpointAPILaudosURL)
				// Add query parameter
				.queryParam("start", start);

		// set headers
		headers.setContentType(MediaType.APPLICATION_JSON);

		if (token != null && !token.isEmpty()) {
			headers.add("Authorization", "Bearer " + token);
		}

		if (!"mock".equals(environmet) && host != null && !host.isEmpty())
			headers.add("Host", host);

		HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody.toString(), headers);

		// send request and parse result
		ResponseAPILaudo response = restTemplate.postForObject(uriBuilder.toUriString(), httpEntity,
				ResponseAPILaudo.class);

		return response;

	}

}
