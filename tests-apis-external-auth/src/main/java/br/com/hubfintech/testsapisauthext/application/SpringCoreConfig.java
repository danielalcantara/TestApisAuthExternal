package br.com.hubfintech.testsapisauthext.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import br.com.valepresente.kharon.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class)
public class SpringCoreConfig {
	
	/*@Bean
	public ITestApisAuthExternalService getArrayTest() {
		System.out.println("Aplicação iniciando!!!");
		ITestApisAuthExternalService apisAuthExternalService = new TestsApisAuthExternalService();
		
		return apisAuthExternalService;
	}*/

}
