package br.com.hubfintech.extauthtests.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import br.com.valepresente.kharon.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class)
public class SpringConfig {

}
