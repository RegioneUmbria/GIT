package it.webred.ct.service.tsSoggiorno.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the IS_RIFIUTO database table.
 * 
 */
@Entity
@Table(name="IS_RIFIUTO")
public class IsRifiuto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="CAP_RES")
	private String capRes;

	@Column(name="CIVICO_RES")
	private String civicoRes;

	private String codfisc;

	private String cognome;

	@Column(name="COMUNE_NASC")
	private String comuneNasc;

	@Column(name="COMUNE_RES")
	private String comuneRes;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASC")
	private Date dataNasc;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_INS")
	private Date dtIns;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_MOD")
	private Date dtMod;

	private String email;

	private String fax;

	@Column(name="FK_IS_DICHIARAZIONE")
	private java.math.BigDecimal fkIsDichiarazione;

	@Column(name="INDIRIZZO_RES")
	private String indirizzoRes;

	@Column(name="MOTIVO_RIFIUTO")
	private String motivoRifiuto;

	private String nome;

	@Column(name="SIGLA_PROV_NASC")
	private String siglaProvNasc;

	@Column(name="SIGLA_PROV_RES")
	private String siglaProvRes;

	@Temporal(TemporalType.DATE)
	@Column(name="SOGGIORNO_AL")
	private Date soggiornoAl;

	@Temporal(TemporalType.DATE)
	@Column(name="SOGGIORNO_DAL")
	private Date soggiornoDal;

	@Column(name="STATO_ESTERO_NASC")
	private String statoEsteroNasc;

	@Column(name="STATO_ESTERO_RES")
	private String statoEsteroRes;

	private String tel;

	@Column(name="USR_INS")
	private String usrIns;

	@Column(name="USR_MOD")
	private String usrMod;

	//bi-directional many-to-one association to IsRifiutoGruppo
	@OneToMany(mappedBy="isRifiuto")
	private List<IsRifiutoGruppo> isRifiutoGruppos;

	public IsRifiuto() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCapRes() {
		return this.capRes;
	}

	public void setCapRes(String capRes) {
		this.capRes = capRes;
	}

	public String getCivicoRes() {
		return this.civicoRes;
	}

	public void setCivicoRes(String civicoRes) {
		this.civicoRes = civicoRes;
	}

	public String getCodfisc() {
		return this.codfisc;
	}

	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getComuneNasc() {
		return this.comuneNasc;
	}

	public void setComuneNasc(String comuneNasc) {
		this.comuneNasc = comuneNasc;
	}

	public String getComuneRes() {
		return this.comuneRes;
	}

	public void setComuneRes(String comuneRes) {
		this.comuneRes = comuneRes;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public java.math.BigDecimal getFkIsDichiarazione() {
		return this.fkIsDichiarazione;
	}

	public void setFkIsDichiarazione(java.math.BigDecimal fkIsDichiarazione) {
		this.fkIsDichiarazione = fkIsDichiarazione;
	}

	public String getIndirizzoRes() {
		return this.indirizzoRes;
	}

	public void setIndirizzoRes(String indirizzoRes) {
		this.indirizzoRes = indirizzoRes;
	}

	public String getMotivoRifiuto() {
		return this.motivoRifiuto;
	}

	public void setMotivoRifiuto(String motivoRifiuto) {
		this.motivoRifiuto = motivoRifiuto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSiglaProvNasc() {
		return this.siglaProvNasc;
	}

	public void setSiglaProvNasc(String siglaProvNasc) {
		this.siglaProvNasc = siglaProvNasc;
	}

	public String getSiglaProvRes() {
		return this.siglaProvRes;
	}

	public void setSiglaProvRes(String siglaProvRes) {
		this.siglaProvRes = siglaProvRes;
	}

	public Date getSoggiornoAl() {
		return this.soggiornoAl;
	}

	public void setSoggiornoAl(Date soggiornoAl) {
		this.soggiornoAl = soggiornoAl;
	}

	public Date getSoggiornoDal() {
		return this.soggiornoDal;
	}

	public void setSoggiornoDal(Date soggiornoDal) {
		this.soggiornoDal = soggiornoDal;
	}

	public String getStatoEsteroNasc() {
		return this.statoEsteroNasc;
	}

	public void setStatoEsteroNasc(String statoEsteroNasc) {
		this.statoEsteroNasc = statoEsteroNasc;
	}

	public String getStatoEsteroRes() {
		return this.statoEsteroRes;
	}

	public void setStatoEsteroRes(String statoEsteroRes) {
		this.statoEsteroRes = statoEsteroRes;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsrIns() {
		return this.usrIns;
	}

	public void setUsrIns(String usrIns) {
		this.usrIns = usrIns;
	}

	public String getUsrMod() {
		return this.usrMod;
	}

	public void setUsrMod(String usrMod) {
		this.usrMod = usrMod;
	}

	public List<IsRifiutoGruppo> getIsRifiutoGruppos() {
		return this.isRifiutoGruppos;
	}

	public void setIsRifiutoGruppos(List<IsRifiutoGruppo> isRifiutoGruppos) {
		this.isRifiutoGruppos = isRifiutoGruppos;
	}

}