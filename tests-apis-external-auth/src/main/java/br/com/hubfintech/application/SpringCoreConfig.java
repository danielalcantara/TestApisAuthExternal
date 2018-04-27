package br.com.hubfintech.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "br.com.hubfintech", "br.com.valepresente.kharon.external" })
public class SpringCoreConfig {

}
