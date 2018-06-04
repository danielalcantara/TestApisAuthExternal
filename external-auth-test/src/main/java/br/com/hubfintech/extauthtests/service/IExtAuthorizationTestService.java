package br.com.hubfintech.extauthtests.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface IExtAuthorizationTestService {

	public void executeTests(String tests) throws JsonParseException, JsonMappingException, IOException;

}
