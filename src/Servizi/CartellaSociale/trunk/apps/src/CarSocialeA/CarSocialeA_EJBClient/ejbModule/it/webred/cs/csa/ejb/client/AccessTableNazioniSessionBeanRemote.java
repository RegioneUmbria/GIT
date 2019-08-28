package it.webred.cs.csa.ejb.client;

import it.webred.ct.config.model.AmTabNazioni;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AccessTableNazioniSessionBeanRemote {
	
	public List<AmTabNazioni> getNazioniByDenominazioneStartsWith(String nazione);
	public AmTabNazioni getNazioneByIstat(String codIstat);
	public AmTabNazioni getNazioneByDenominazione(String denominazione);
	public List<String>  getCittadinanze();

}
