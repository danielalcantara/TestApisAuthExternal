package br.com.hubfintech.extauthtests.infra;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.stereotype.Component;

@Component
public class ConnectionLDAPInfra implements IConnectionLDAPInfra {

	private static final String MEMBER_OF = "memberOf";
	private static final String LDAP_URL = "ldap://192.168.56.2:389";
	private static final String DEFAULT_DOMAIN = "systemfactory.com.br";

	@Override
	public List<String> authenticate(String userName, String passWord, String domain) throws NamingException {

		Hashtable<String, String> authEnv = new Hashtable<>();
		String securityPrincipal = userName + "@" + domain;
		List<String> memberOfGroups = new ArrayList<>();

		authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		authEnv.put(Context.PROVIDER_URL, LDAP_URL);
		authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		authEnv.put(Context.SECURITY_PRINCIPAL, securityPrincipal);
		authEnv.put(Context.SECURITY_CREDENTIALS, passWord);

		try {

			DirContext authContext = new InitialDirContext(authEnv);

			String[] dcParts = domain.split("\\.");
			String domainSearch = "";
			
			for (String dcPart : dcParts) {
				domainSearch += "DC=" + dcPart + ",";
			}
			
			domainSearch = domainSearch.substring(0, domainSearch.length() - 1);

			// Create the search controls
			SearchControls searchCtls = new SearchControls();
			String[] attributes = new String[] { MEMBER_OF };
			searchCtls.setReturningAttributes(attributes);

			// Specify the search scope
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

			// Search for objects using the filter
			NamingEnumeration<?> result = authContext.search(domainSearch, MessageFormat.format("(SAMAccountName={0})", userName),
					searchCtls);

			// Get the first result
			SearchResult sr = (SearchResult) result.next();

			Attribute memberOf = sr.getAttributes().get(MEMBER_OF);
			
			if (memberOf != null) {
				for (Enumeration<?> e1 = memberOf.getAll(); e1.hasMoreElements();) {
					memberOfGroups.add(e1.nextElement().toString());
				}
			}

			System.out.println("Authentication Success!");
			
		} catch (AuthenticationException authEx) {
			System.out.println("Authentication failed!");
		} catch (NamingException namEx) {
			System.out.println("Something went wrong!");
			namEx.printStackTrace();
		}

		return memberOfGroups;

	}

}
