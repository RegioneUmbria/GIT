package it.webred.cs.csa.web.manbean.schedaSegr;

import it.webred.cs.data.model.CsSsSchedaSegr;
import it.webred.cs.jsf.interfaces.IIterInfoStato;
import it.webred.ejb.utility.ClientUtility;
import it.webred.ss.data.model.SsScheda;
import it.webred.ss.data.model.SsSchedaAccesso;
import it.webred.ss.data.model.SsSchedaSegnalato;
import it.webred.ss.data.model.SsTipoScheda;
import it.webred.ss.ejb.client.SsSchedaSessionBeanRemote;
import it.webred.ss.ejb.dto.BaseDTO;

import java.util.Date;

public class SchedaSegr{
	
	private Long id;
	private Date dataAccesso;
	private String cognome = "-";
	private String nome = "";
	private Date dataNascita;
	private String tipo = "-";
	private String stato = "-";
	private String operatore = "-";
	private String ufficio = "-";
	
	private SsScheda ssScheda;
	private SsSchedaSegnalato ssSchedaSegnalato;
	private CsSsSchedaSegr csSsSchedaSegr;
	private IIterInfoStato lastIterStepInfo;
	private boolean showStatoCartella = true;
		
	public SchedaSegr(Date dataAccesso, String cognome, String nome,
			Date dataNascita, String tipo, String stato, String operatore) {
		super();
		this.dataAccesso = dataAccesso;
		this.cognome = cognome;
		this.nome = nome;
		this.dataNascita = dataNascita;
		this.tipo = tipo;
		this.stato = stato;
		this.operatore = operatore;
	}

	public SchedaSegr(SsScheda scheda, SsSchedaAccesso accesso, SsTipoScheda tipoScheda) {
		if(scheda != null){
			ssScheda = scheda;
			id = scheda.getId();
			if(tipoScheda != null)
				tipo = tipoScheda.getTipo();
		}
		if(accesso != null){
			dataAccesso = accesso.getData();
			operatore = accesso.getOperatore();
			setUfficio(accesso.getSede().getNome());
		}	
	}

	public SchedaSegr(SsScheda scheda, SsTipoScheda tipoScheda) {
		ssScheda = scheda;
		id = scheda.getId();
		dataAccesso = scheda.getAccesso().getData();
		operatore = scheda.getAccesso().getOperatore();
		ufficio = scheda.getAccesso().getSede().getNome();
		if(tipoScheda != null)
			tipo = tipoScheda.getTipo();
	}
	
	public SchedaSegr(SsScheda scheda, SsSchedaSegnalato segnalato, SsTipoScheda tipoScheda) {
		ssScheda = scheda;
		id = scheda.getId();
		if(tipoScheda != null)
			tipo = tipoScheda.getTipo();
		
		if(scheda.getAccesso() != null){
			dataAccesso = scheda.getAccesso().getData();
			operatore = scheda.getAccesso().getOperatore();
			ufficio = scheda.getAccesso().getSede().getNome();
		}
	
		if(segnalato != null){
			ssSchedaSegnalato = segnalato;
			dataNascita = segnalato.getAnagrafica().getData_nascita();
			nome = segnalato.getAnagrafica().getNome();
			cognome = segnalato.getAnagrafica().getCognome();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAccesso() {
		return dataAccesso;
	}

	public void setDataAccesso(Date dataAccesso) {
		this.dataAccesso = dataAccesso;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getIntervento() {
		return tipo;
	}

	public void setIntervento(String intervento) {
		this.tipo = intervento;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getUfficio() {
		return ufficio;
	}

	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	
	@Override
	public boolean equals(Object scheda){
		return this.id.equals(((SchedaSegr)scheda).id);
	}

	public SsScheda getSsScheda() {
		return ssScheda;
	}

	public void setSsScheda(SsScheda ssScheda) {
		this.ssScheda = ssScheda;
	}

	public SsSchedaSegnalato getSsSchedaSegnalato() {
		return ssSchedaSegnalato;
	}

	public void setSsSchedaSegnalato(SsSchedaSegnalato ssSchedaSegnalato) {
		this.ssSchedaSegnalato = ssSchedaSegnalato;
	}

	public CsSsSchedaSegr getCsSsSchedaSegr() {
		return csSsSchedaSegr;
	}

	public void setCsSsSchedaSegr(CsSsSchedaSegr csSsSchedaSegr) {
		this.csSsSchedaSegr = csSsSchedaSegr;
	}

	public IIterInfoStato getLastIterStepInfo() {
		return lastIterStepInfo;
	}

	public void setLastIterStepInfo(IIterInfoStato lastIterStepInfo) {
		this.lastIterStepInfo = lastIterStepInfo;
	}

	public boolean isShowStatoCartella() {
		return showStatoCartella;
	}

	public void setShowStatoCartella(boolean showStatoCartella) {
		this.showStatoCartella = showStatoCartella;
	}
}
