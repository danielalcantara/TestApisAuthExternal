package br.com.hubfintech.extauthtests.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AutorizadorListener implements PhaseListener {

	private static final long serialVersionUID = 1606592939942080532L;

	@Override
	public void afterPhase(PhaseEvent event) {
		/*FacesContext context = event.getFacesContext();
		String nomePagina = context.getViewRoot().getViewId();

		System.out.println(nomePagina);

		if ("/pages/login.xhtml".equals(nomePagina)) {
			return;
		}

		
		 //Usuario usuarioLogado = (Usuario) context.getExternalContext()
		 //.getSessionMap().get("usuarioLogado");
		 
		 //if (usuarioLogado != null) { return; }
		 

		// redirecionamento para login.xhtml

		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/pages/login?faces-redirect=true");
		context.renderResponse();*/
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
