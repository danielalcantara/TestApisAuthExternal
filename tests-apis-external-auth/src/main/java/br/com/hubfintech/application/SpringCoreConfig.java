package br.com.hubfintech.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import br.com.hubfintech.testsapisauthexternal.service.ITestApisAuthExternalService;
import br.com.hubfintech.testsapisauthexternal.service.TestsApisAuthExternalService;
import br.com.valepresente.kharon.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class)
public class SpringCoreConfig {
	
	@Bean
	public ITestApisAuthExternalService getArrayTest() {
		System.out.println("Aplicação iniciando!!!");
		ITestApisAuthExternalService apisAuthExternalService = new TestsApisAuthExternalService();
		
		return apisAuthExternalService;
	}

}
