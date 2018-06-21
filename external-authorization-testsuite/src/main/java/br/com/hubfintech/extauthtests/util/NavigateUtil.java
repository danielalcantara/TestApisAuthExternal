package br.com.hubfintech.extauthtests.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
public class NavigateUtil implements INavigateUtil {

	@Override
	public void redirect(String url) {
		FacesContext context = FacesContext.getCurrentInstance();
		NavigationHandler handler = context.getApplication().getNavigationHandler();

		handler.handleNavigation(context, null, "/pages/" + url + "?faces-redirect=true");
		context.renderResponse();
	}

	@Override
	public void forward(String url) {
		// TODO Auto-generated method stub

	}

}
