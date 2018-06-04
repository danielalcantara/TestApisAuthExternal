package br.com.hubfintech.extauthtests.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Controller;

import br.com.hubfintech.extauthtests.service.IExtAuthorizationService;

@Controller
public class TestsExtAuthBean implements Serializable {

	private static final long serialVersionUID = 5372182245955402498L;

	private UploadedFile file;
	private String url;

	@Inject
	IExtAuthorizationService authorizationService;

	/*
	 * @Autowired private ExternalAuthorizationService authorizationService;
	 */

	public void upload() {

		if (file != null) {
			authorizationService.authorization();
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			// Message messageAuth = new Message();
			try {
				// authorizationService.sendMessage(messageAuth);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void validaArquivo(FacesContext context, UIComponent component, Object object) throws ValidatorException {
		FacesMessage message = new FacesMessage("Arquivo é necessário!");
		FacesContext.getCurrentInstance().addMessage(component.getId(), message);

		message.setSeverity(FacesMessage.SEVERITY_ERROR);

		//throw new ValidatorException(message);
	}

}
