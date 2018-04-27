package br.com.hubfintech.application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MainWebAppInitializer {

	public void onStartup(ServletContext sc) throws ServletException {
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.register(SpringCoreConfig.class);
		sc.addListener(new ContextLoaderListener(root));
	}

}
