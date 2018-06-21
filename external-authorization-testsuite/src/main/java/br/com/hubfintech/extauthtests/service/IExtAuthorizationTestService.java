package br.com.hubfintech.extauthtests.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import br.com.hubfintech.extauthtests.exception.TestExtAuthException;
import br.com.hubfintech.extauthtests.model.TestModel;

public interface IExtAuthorizationTestService {

	public List<TestModel> executeTests(String tests, String url, Integer port) throws TestExtAuthException;

	public List<TestModel> reloadTests(List<TestModel> processedTests, String url, Integer port)
			throws TestExtAuthException;

	public InputStream reportTests(List<TestModel> testModels, Map<String, Object> params) throws TestExtAuthException;

}
