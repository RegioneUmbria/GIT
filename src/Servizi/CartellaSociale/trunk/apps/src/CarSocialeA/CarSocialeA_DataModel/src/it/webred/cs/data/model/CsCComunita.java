package it.webred.cs.data.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CS_C_COMUNITA database table.
 * 
 */
@Entity
@Table(name="CS_C_COMUNITA")
@NamedQuery(name="CsCComunita.findAll", query="SELECT c FROM CsCComunita c")
public class CsCComunita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CS_C_COMUNITA_SETTOREID_GENERATOR", sequenceName="SQ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CS_C_COMUNITA_SETTOREID_GENERATOR")
	@Column(name="SETTORE_ID")
	private long settoreId;

	private String costi;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_INS")
	private Date dtIns;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_MOD")
	private Date dtMod;

	@Column(name="FASCIA_ETA")
	private String fasciaEta;

	@Column(name="PSICO_TERAP")
	private BigDecimal psicoTerap;

	private String sesso;

	@Column(name="SOGGGIU_RAGSOC")
	private String sogggiuRagsoc;

	@Column(name="USER_INS")
	private String userIns;

	@Column(name="USR_MOD")
	private String usrMod;

	//bi-directional many-to-one association to CsAAnagrafica
	/*@ManyToOne
	@JoinColumn(name="ANAGRAFICA_ID")
	private CsAAnagrafica csAAnagrafica;*/

	//bi-directional many-to-one association to CsAAnaIndirizzo
	@ManyToOne
	@JoinColumn(name="ANA_INDIRIZZO_ID")
	private CsAAnaIndirizzo csAAnaIndirizzo;

	//bi-directional one-to-one association to CsOSettore
	@OneToOne
	@JoinColumn(name="SETTORE_ID")
	private CsOSettore csOSettore;

	//bi-directional many-to-one association to CsTbTipoComunita
	@ManyToOne
	@JoinColumn(name="TIPO_COMUNITA_ID")
	private CsTbTipoComunita csTbTipoComunita;

	//bi-directional many-to-one association to CsIResiMinore
	@OneToMany(mappedBy="csCComunita")
	private List<CsIResiMinore> csIResiMinores;
	
	//bi-directional many-to-one association to CsIResiAdulti
	@OneToMany(mappedBy="csCComunita")
	private List<CsIResiAdulti> csIResiAdultis;

	//bi-directional many-to-one association to CsISemiResiMin
	@OneToMany(mappedBy="csCComunita")
	private List<CsISemiResiMin> csISemiResiMins;

	public CsCComunita() {
	}

	public long getSettoreId() {
		return this.settoreId;
	}

	public void setSettoreId(long settoreId) {
		this.settoreId = settoreId;
	}

	public String getCosti() {
		return this.costi;
	}

	public void setCosti(String costi) {
		this.costi = costi;
	}

	public Date getDtIns() {
		return this.dtIns;
	}

	public void setDtIns(Date dtIns) {
		this.dtIns = dtIns;
	}

	public Date getDtMod() {
		return this.dtMod;
	}

	public void setDtMod(Date dtMod) {
		this.dtMod = dtMod;
	}

	public String getFasciaEta() {
		return this.fasciaEta;
	}

	public void setFasciaEta(String fasciaEta) {
		this.fasciaEta = fasciaEta;
	}

	public BigDecimal getPsicoTerap() {
		return this.psicoTerap;
	}

	public void setPsicoTerap(BigDecimal psicoTerap) {
		this.psicoTerap = psicoTerap;
	}

	public String getSesso() {
		return this.sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getSogggiuRagsoc() {
		return this.sogggiuRagsoc;
	}

	public void setSogggiuRagsoc(String sogggiuRagsoc) {
		this.sogggiuRagsoc = sogggiuRagsoc;
	}

	public String getUserIns() {
		return this.userIns;
	}

	public void setUserIns(String userIns) {
		this.userIns = userIns;
	}

	public String getUsrMod() {
		return this.usrMod;
	}

	public void setUsrMod(String usrMod) {
		this.usrMod = usrMod;
	}

	public CsAAnaIndirizzo getCsAAnaIndirizzo() {
		return this.csAAnaIndirizzo;
	}

	public void setCsAAnaIndirizzo(CsAAnaIndirizzo csAAnaIndirizzo) {
		this.csAAnaIndirizzo = csAAnaIndirizzo;
	}

	public CsOSettore getCsOSettore() {
		return this.csOSettore;
	}

	public void setCsOSettore(CsOSettore csOSettore) {
		this.csOSettore = csOSettore;
	}

	public CsTbTipoComunita getCsTbTipoComunita() {
		return this.csTbTipoComunita;
	}

	public void setCsTbTipoComunita(CsTbTipoComunita csTbTipoComunita) {
		this.csTbTipoComunita = csTbTipoComunita;
	}

	public List<CsIResiMinore> getCsIResiMinores() {
		return this.csIResiMinores;
	}

	public void setCsIResiMinores(List<CsIResiMinore> csIResiMinores) {
		this.csIResiMinores = csIResiMinores;
	}

	public CsIResiMinore addCsIResiMinore(CsIResiMinore csIResiMinore) {
		getCsIResiMinores().add(csIResiMinore);
		csIResiMinore.setCsCComunita(this);

		return csIResiMinore;
	}

	public CsIResiMinore removeCsIResiMinore(CsIResiMinore csIResiMinore) {
		getCsIResiMinores().remove(csIResiMinore);
		csIResiMinore.setCsCComunita(null);

		return csIResiMinore;
	}
	
	public List<CsIResiAdulti> getCsIResiAdultis() {
		return this.csIResiAdultis;
	}

	public void setCsIResiAdultis(List<CsIResiAdulti> csIResiAdultis) {
		this.csIResiAdultis = csIResiAdultis;
	}

	public CsIResiAdulti addCsIResiAdulti(CsIResiAdulti csIResiAdulti) {
		getCsIResiAdultis().add(csIResiAdulti);
		csIResiAdulti.setCsCComunita(this);

		return csIResiAdulti;
	}

	public CsIResiAdulti removeCsIResiAdulti(CsIResiAdulti csIResiAdulti) {
		getCsIResiAdultis().remove(csIResiAdulti);
		csIResiAdulti.setCsCComunita(null);

		return csIResiAdulti;
	}

	public List<CsISemiResiMin> getCsISemiResiMins() {
		return this.csISemiResiMins;
	}

	public void setCsISemiResiMins(List<CsISemiResiMin> csISemiResiMins) {
		this.csISemiResiMins = csISemiResiMins;
	}

	public CsISemiResiMin addCsISemiResiMin(CsISemiResiMin csISemiResiMin) {
		getCsISemiResiMins().add(csISemiResiMin);
		csISemiResiMin.setCsCComunita(this);

		return csISemiResiMin;
	}

	public CsISemiResiMin removeCsISemiResiMin(CsISemiResiMin csISemiResiMin) {
		getCsISemiResiMins().remove(csISemiResiMin);
		csISemiResiMin.setCsCComunita(null);

		return csISemiResiMin;
	}
}