package br.com.dasa.infra;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dasa.infra.response.ResponseTest;
import br.com.dasa.request.RequestTest;

public class RestTemplateTest {

	public static void main(String[] args) {
		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("http://localhost:8181/testrest/testpost");
		RequestTest request = new RequestTest();

		request.setCode("fsdfj4324");
		request.setContent("skajhdaksjhd654654");

		// set headers
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<RequestTest> httpEntity = new HttpEntity<RequestTest>(request, headers);

		// send request and parse result
		ResponseTest response = restTemplate.postForObject(uriBuilder.toUriString(), httpEntity, ResponseTest.class);
		
		System.out.println(response.getCode() + " : " + response.getContent());

	}

}
