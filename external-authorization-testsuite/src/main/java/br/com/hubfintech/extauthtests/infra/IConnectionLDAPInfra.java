package br.com.hubfintech.extauthtests.infra;

import java.util.List;

import javax.naming.NamingException;

public interface IConnectionLDAPInfra {

	public List<String> authenticate(String user, String securityToken, String domain) throws NamingException;

}
