package br.com.hubfintech.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.valepresente.kharon.external.dto.Message;
import br.com.valepresente.kharon.external.socket.ExternalAuthorizationService;

@ManagedBean(name = "testsApisView")
public class TestsApisExternalAuthView {

	private UploadedFile file;

	@Autowired
	private ExternalAuthorizationService authorizationService;

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			Message messageAuth = new Message();
			try {
				authorizationService.sendMessage(messageAuth);
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

}
