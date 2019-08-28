package it.webred.cs.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CS_REL_SETTORE_CATSOC database table.
 * 
 */
@Entity
@Table(name="CS_REL_SETTORE_CATSOC")
@NamedQuery(name="CsRelSettoreCatsoc.findAll", query="SELECT c FROM CsRelSettoreCatsoc c")
public class CsRelSettoreCatsoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CsRelSettoreCatsocPK id;

	private BigDecimal abilitato;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_INS")
	private Date dtIns;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_MOD")
	private Date dtMod;

	@Column(name="USER_INS")
	private String userIns;

	@Column(name="USR_MOD")
	private String usrMod;

	//bi-directional many-to-one association to CsCCategoriaSociale
	@ManyToOne
	@JoinColumn(name="CATEGORIA_SOCIALE_ID",insertable=false, updatable=false)
	private CsCCategoriaSociale csCCategoriaSociale;

	//bi-directional many-to-one association to CsOSettore
	@ManyToOne
	@JoinColumn(name="SETTORE_ID",insertable=false, updatable=false)
	private CsOSettore csOSettore;

	//bi-directional many-to-one association to CsRelSettCsocTipoInter
	@OneToMany(mappedBy="csRelSettoreCatsoc")
	private List<CsRelSettCsocTipoInter> csRelSettCsocTipoInters;

	//bi-directional many-to-one association to CsRelSettCsocTipoInterEr
	@OneToMany(mappedBy="csRelSettoreCatsoc")
	private List<CsRelSettCsocTipoInterEr> csRelSettCsocTipoInterErs;

	public CsRelSettoreCatsoc() {
	}

	public CsRelSettoreCatsocPK getId() {
		return this.id;
	}

	public void setId(CsRelSettoreCatsocPK id) {
		this.id = id;
	}

	public BigDecimal getAbilitato() {
		return this.abilitato;
	}

	public void setAbilitato(BigDecimal abilitato) {
		this.abilitato = abilitato;
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

	public CsCCategoriaSociale getCsCCategoriaSociale() {
		return this.csCCategoriaSociale;
	}

	public void setCsCCategoriaSociale(CsCCategoriaSociale csCCategoriaSociale) {
		this.csCCategoriaSociale = csCCategoriaSociale;
	}

	public CsOSettore getCsOSettore() {
		return this.csOSettore;
	}

	public void setCsOSettore(CsOSettore csOSettore) {
		this.csOSettore = csOSettore;
	}

	public List<CsRelSettCsocTipoInter> getCsRelSettCsocTipoInters() {
		return this.csRelSettCsocTipoInters;
	}

	public void setCsRelSettCsocTipoInters(List<CsRelSettCsocTipoInter> csRelSettCsocTipoInters) {
		this.csRelSettCsocTipoInters = csRelSettCsocTipoInters;
	}

	public CsRelSettCsocTipoInter addCsRelSettCsocTipoInter(CsRelSettCsocTipoInter csRelSettCsocTipoInter) {
		getCsRelSettCsocTipoInters().add(csRelSettCsocTipoInter);
		csRelSettCsocTipoInter.setCsRelSettoreCatsoc(this);

		return csRelSettCsocTipoInter;
	}

	public CsRelSettCsocTipoInter removeCsRelSettCsocTipoInter(CsRelSettCsocTipoInter csRelSettCsocTipoInter) {
		getCsRelSettCsocTipoInters().remove(csRelSettCsocTipoInter);
		csRelSettCsocTipoInter.setCsRelSettoreCatsoc(null);

		return csRelSettCsocTipoInter;
	}

	public List<CsRelSettCsocTipoInterEr> getCsRelSettCsocTipoInterErs() {
		return this.csRelSettCsocTipoInterErs;
	}

	public void setCsRelSettCsocTipoInterErs(List<CsRelSettCsocTipoInterEr> csRelSettCsocTipoInterErs) {
		this.csRelSettCsocTipoInterErs = csRelSettCsocTipoInterErs;
	}

	public CsRelSettCsocTipoInterEr addCsRelSettCsocTipoInterEr(CsRelSettCsocTipoInterEr csRelSettCsocTipoInterEr) {
		getCsRelSettCsocTipoInterErs().add(csRelSettCsocTipoInterEr);
		csRelSettCsocTipoInterEr.setCsRelSettoreCatsoc(this);

		return csRelSettCsocTipoInterEr;
	}

	public CsRelSettCsocTipoInterEr removeCsRelSettCsocTipoInterEr(CsRelSettCsocTipoInterEr csRelSettCsocTipoInterEr) {
		getCsRelSettCsocTipoInterErs().remove(csRelSettCsocTipoInterEr);
		csRelSettCsocTipoInterEr.setCsRelSettoreCatsoc(null);

		return csRelSettCsocTipoInterEr;
	}

}