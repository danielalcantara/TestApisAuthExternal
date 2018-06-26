package br.com.dasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.dasa")
public class MsLaudoEvolutivoApplication {

	public static void main(String[] args) {
		System.getProperties().put("server.port", 8181);
		SpringApplication.run(MsLaudoEvolutivoApplication.class, args);
	}

}
