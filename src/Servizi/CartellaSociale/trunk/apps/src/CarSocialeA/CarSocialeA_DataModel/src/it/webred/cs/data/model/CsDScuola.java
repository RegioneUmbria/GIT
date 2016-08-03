package it.webred.cs.data.model;

import it.webred.cs.data.base.ICsDDiarioChild;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the CS_D_SCUOLA database table.
 * 
 */
@Entity
@Table(name="CS_D_SCUOLA")
@NamedQuery(name="CsDScuola.findAll", query="SELECT c FROM CsDScuola c")
public class CsDScuola implements ICsDDiarioChild {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DIARIO_ID")
	private Long diarioId;

	@Column(name="ANNO_SCOLASTICO")
	private String annoScolastico;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_INS")
	private Date dtIns;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_MOD")
	private Date dtMod;

	private Boolean fermo;

	private String grado;

	private String nome;

	private String progetto;

	@Column(name="USER_INS")
	private String userIns;

	@Column(name="USR_MOD")
	private String usrMod;
	
	//bi-directional many-to-one association to CsTbTipoScuola
	@ManyToOne
	@JoinColumn(name="TIPO_SCUOLA_ID")
	private CsTbTipoScuola csTbTipoScuola;

	//bi-directional many-to-one association to CsTbScuola
	@ManyToOne
	@JoinColumn(name="SCUOLA_ID")
	private CsTbScuola csTbScuola;
	
	//bi-directional one-to-one association to CsDDiario
	@OneToOne
	@JoinColumn(name="DIARIO_ID")
	private CsDDiario csDDiario;
	
	public CsDScuola() {
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

	public Boolean getFermo() {
		return this.fermo;
	}

	public void setFermo(Boolean fermo) {
		this.fermo = fermo;
	}

	public String getGrado() {
		return this.grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProgetto() {
		return this.progetto;
	}

	public void setProgetto(String progetto) {
		this.progetto = progetto;
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

	public Long getDiarioId() {
		return diarioId;
	}

	public void setDiarioId(Long diarioId) {
		this.diarioId = diarioId;
	}

	public String getAnnoScolastico() {
		return annoScolastico;
	}

	public void setAnnoScolastico(String annoScolastico) {
		this.annoScolastico = annoScolastico;
	}

	public CsTbTipoScuola getCsTbTipoScuola() {
		return csTbTipoScuola;
	}

	public void setCsTbTipoScuola(CsTbTipoScuola csTbTipoScuola) {
		this.csTbTipoScuola = csTbTipoScuola;
	}

	public CsTbScuola getCsTbScuola() {
		return csTbScuola;
	}

	public void setCsTbScuola(CsTbScuola csTbScuola) {
		this.csTbScuola = csTbScuola;
	}

	public CsDDiario getCsDDiario() {
		return csDDiario;
	}

	public void setCsDDiario(CsDDiario csDDiario) {
		this.csDDiario = csDDiario;
	}

}