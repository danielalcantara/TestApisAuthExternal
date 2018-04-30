package br.com.hubfintech.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.hubfintech" })
public class SpringPrimeFacesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrimeFacesApplication.class, args);
	}

}
