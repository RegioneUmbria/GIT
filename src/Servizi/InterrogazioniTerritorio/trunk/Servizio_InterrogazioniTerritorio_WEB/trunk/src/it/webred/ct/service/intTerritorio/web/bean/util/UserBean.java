package it.webred.ct.service.intTerritorio.web.bean.util;

import java.io.IOException;

import it.webred.cet.permission.CeTUser;
import it.webred.ct.config.model.AmComune;
import it.webred.ct.service.intTerritorio.web.bean.InterrogazioneTerritorioBaseBean;

import org.apache.log4j.Logger;

public class UserBean extends InterrogazioneTerritorioBaseBean{

	private static Logger logger = Logger.getLogger(UserBean.class.getName());

	private String username;
	
	private String ente;
	
	public void doLogout(){
		
		getRequest().getSession().invalidate();
		try {
			getResponse().sendRedirect(getRequest().getContextPath() + "/");
		} catch (IOException e) {
			logger.error("Eccezione: "+e.getMessage(),e);
		}
		
	}

	public String getUsername() {
		
		if (getRequest().getUserPrincipal()==null || getRequest().getUserPrincipal().getName()==null)
			return "admin";
		
		username = getRequest().getUserPrincipal().getName();
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEnte() {
		
		String es = getRequest().getParameter("es");
		if(es != null && !es.equals("") && getUser() != null){
			AmComune am = comuneService.getComune(getUser().getCurrentEnte());
			ente = am != null? am.getDescrizione(): "";
			ente = ente.substring(0,1).toUpperCase() + ente.substring(1).toLowerCase();
		}
		return ente;
	}

	public void setEnte(String ente) {
		this.ente = ente;
	}
	
}
