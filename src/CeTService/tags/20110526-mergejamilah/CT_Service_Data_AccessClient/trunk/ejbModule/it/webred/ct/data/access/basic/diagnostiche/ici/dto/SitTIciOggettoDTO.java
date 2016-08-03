package it.webred.ct.data.access.basic.diagnostiche.ici.dto;

import java.io.Serializable;
import java.util.List;

import it.webred.ct.data.model.diagnostiche.*;
import it.webred.ct.data.model.ici.SitTIciOggetto;

public class SitTIciOggettoDTO implements Serializable{
	
	private SitTIciOggetto sitTIciOggetto;
	private String via;
	
	public SitTIciOggetto getSitTIciOggetto() {
		return sitTIciOggetto;
	}
	public void setSitTIciOggetto(SitTIciOggetto sitTIciOggetto) {
		this.sitTIciOggetto = sitTIciOggetto;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	
}
