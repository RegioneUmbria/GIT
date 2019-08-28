package it.webred.cs.csa.ejb.dto;

import java.io.Serializable;

public class CasoSearchCriteria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean permessoCasiSettore;
	private boolean permessoCasiOrganizzazione;
	
	private String denominazione;
	private String codiceFiscale;
	private String dataNascita;
	private Long idOrganizzazione;
	private Long idSettore;
	private Long idOperatore;
	private String username;
	private Long idCatSociale;
	private Long idLastIter;
	private boolean withResponsabile;
	
	public String getDenominazione() {
		return denominazione;
	}
	
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getDataNascita() {
		return dataNascita;
	}
	
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Long getIdSettore() {
		return idSettore;
	}

	public void setIdSettore(Long idSettore) {
		this.idSettore = idSettore;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getIdOperatore() {
		return idOperatore;
	}

	public void setIdOperatore(Long idOperatore) {
		this.idOperatore = idOperatore;
	}

	public boolean isPermessoCasiSettore() {
		return permessoCasiSettore;
	}

	public void setPermessoCasiSettore(boolean permessoCasiSettore) {
		this.permessoCasiSettore = permessoCasiSettore;
	}

	public Long getIdCatSociale() {
		return idCatSociale;
	}

	public void setIdCatSociale(Long idCatSociale) {
		this.idCatSociale = idCatSociale;
	}

	public Long getIdLastIter() {
		return idLastIter;
	}

	public void setIdLastIter(Long idLastIter) {
		this.idLastIter = idLastIter;
	}

	public boolean isWithResponsabile() {
		return withResponsabile;
	}

	public void setWithResponsabile(boolean withResponsabile) {
		this.withResponsabile = withResponsabile;
	}

	public Long getIdOrganizzazione() {
		return idOrganizzazione;
	}

	public void setIdOrganizzazione(Long idOrganizzazione) {
		this.idOrganizzazione = idOrganizzazione;
	}

	public boolean isPermessoCasiOrganizzazione() {
		return permessoCasiOrganizzazione;
	}

	public void setPermessoCasiOrganizzazione(boolean permessoCasiOrganizzazione) {
		this.permessoCasiOrganizzazione = permessoCasiOrganizzazione;
	}
	
}
