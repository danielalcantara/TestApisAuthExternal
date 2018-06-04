package br.com.hubfintech.extauthtests.service.impl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.hubfintech.extauthtests.service.IExtAuthorizationTestService;
import br.com.valepresente.kharon.external.dto.RequestDTO;
import br.com.valepresente.kharon.external.socket.ExternalAuthorizationService;
import br.com.valepresente.kharon.external.util.JsonUtil;

@Component
public class ExtAuthorizationTestService implements IExtAuthorizationTestService {

	@Inject
	ExternalAuthorizationService extAuthorizationService;

	@Override
	public void executeTests(String tests) throws JsonParseException, JsonMappingException, IOException {
		List<RequestDTO> dtos = JsonUtil.listFromJson(tests, RequestDTO.class);
		
		//dtos
	}

}
