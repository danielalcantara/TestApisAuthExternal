package br.com.hubfintech.extauthtests.service;

import br.com.hubfintech.extauthtests.exception.TestExtAuthException;

public interface ILoginService {

	public void executeTests(String user, String password) throws TestExtAuthException;

}
