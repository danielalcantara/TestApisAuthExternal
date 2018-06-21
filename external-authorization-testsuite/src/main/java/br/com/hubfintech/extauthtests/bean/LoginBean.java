package br.com.hubfintech.extauthtests.bean;

import java.io.Serializable;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.hubfintech.extauthtests.service.ILoginService;
import br.com.hubfintech.extauthtests.util.IFacesUtil;
import br.com.hubfintech.extauthtests.util.IMessagesUtil;

@Controller
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 2916754823877224037L;

	private String user;
	private String password;

	@Inject
	ILoginService loginService;

	@Inject
	IFacesUtil facesUtil;

	@Inject
	IMessagesUtil messages;

	public void login(ActionEvent actionEvent) {
		System.out.println("Usuário logado!");
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
