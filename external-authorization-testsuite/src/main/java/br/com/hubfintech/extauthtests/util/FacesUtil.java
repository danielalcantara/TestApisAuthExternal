package br.com.hubfintech.extauthtests.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
public class FacesUtil implements IFacesUtil {
	
	public void setMessageErro(String message) {
		FacesMessage messageError = new FacesMessage(message);
		messageError.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, messageError);
	}
	
	public void setMessageInfo(String message) {
		FacesMessage messageInfo = new FacesMessage(message);
		FacesContext.getCurrentInstance().addMessage(null, messageInfo);
	}

}
