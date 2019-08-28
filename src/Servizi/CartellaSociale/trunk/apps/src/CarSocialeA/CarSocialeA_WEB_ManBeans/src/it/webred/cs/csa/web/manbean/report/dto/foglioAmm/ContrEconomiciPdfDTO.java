package it.webred.cs.csa.web.manbean.report.dto.foglioAmm;

import it.webred.cs.csa.web.manbean.report.dto.BasePdfDTO;

public class ContrEconomiciPdfDTO extends BasePdfDTO {

	private String contrRichiesto = EMPTY_VALUE;
	private String perErogazione = EMPTY_VALUE;
	private String richiestoPer = EMPTY_VALUE;
	private	String tipoRiscossione = EMPTY_VALUE;
	private	String accreditoA = EMPTY_VALUE;
	private	String iban = EMPTY_VALUE;
	private	String delDenominazione = EMPTY_VALUE;
	private	String delIndirizzo = EMPTY_VALUE;
	private	String delLuogo = EMPTY_VALUE;
	private	String delTelefono = EMPTY_VALUE;
	
	public String getContrRichiesto() {
		return contrRichiesto;
	}
	public void setContrRichiesto(String contrRichiesto) {
		this.contrRichiesto = format(contrRichiesto);
	}
	public String getPerErogazione() {
		return perErogazione;
	}
	public void setPerErogazione(String perErogazione) {
		this.perErogazione = format(perErogazione);
	}
	public String getRichiestoPer() {
		return richiestoPer;
	}
	public void setRichiestoPer(String richiestoPer) {
		this.richiestoPer = format(richiestoPer);
	}
	public String getTipoRiscossione() {
		return tipoRiscossione;
	}
	public void setTipoRiscossione(String tipoRiscossione) {
		this.tipoRiscossione = format(tipoRiscossione);
	}
	public String getAccreditoA() {
		return accreditoA;
	}
	public void setAccreditoA(String accreditoA) {
		this.accreditoA = format(accreditoA);
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = format(iban);
	}
	public String getDelDenominazione() {
		return delDenominazione;
	}
	public void setDelDenominazione(String delDenominazione) {
		this.delDenominazione = format(delDenominazione);
	}
	public String getDelIndirizzo() {
		return delIndirizzo;
	}
	public void setDelIndirizzo(String delIndirizzo) {
		this.delIndirizzo = format(delIndirizzo);
	}
	public String getDelLuogo() {
		return delLuogo;
	}
	public void setDelLuogo(String delLuogo) {
		this.delLuogo = format(delLuogo);
	}
	public String getDelTelefono() {
		return delTelefono;
	}
	public void setDelTelefono(String delTelefono) {
		this.delTelefono = format(delTelefono);
	}
	
}
