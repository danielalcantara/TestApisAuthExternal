package br.com.hubfintech.extauthtests.bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.primefaces.model.UploadedFileWrapper;
import org.springframework.stereotype.Controller;

import br.com.hubfintech.extauthtests.util.IMessagesUtil;

@Controller
public class FileValidatorBean {

	@Inject
	IMessagesUtil messages;

	public void validateFileJson(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		UploadedFileWrapper file = (UploadedFileWrapper) value;
		String messageStr = "";

		if (file == null || file.getSize() <= 0 || file.getContentType().isEmpty())
			messageStr = messages.getMessage("msg.error.validate.file.type.invalide");
		else if (!file.getContentType().endsWith("json") || !validateTypeJson(file))
			messageStr = messages.getMessage("msg.error.validate.file.type.json");
		else if (file.getSize() > 2000000)
			messageStr = messages.getMessage("msg.error.validate.file.size.2m");

		if (messageStr != null && !messageStr.isEmpty()) {
			FacesMessage message = new FacesMessage(messageStr);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

	}
	
	private boolean validateTypeJson(UploadedFileWrapper file) {
		if (file.getContentType().equals("application/json"))
			return true;
		
		return false;
	}

}
