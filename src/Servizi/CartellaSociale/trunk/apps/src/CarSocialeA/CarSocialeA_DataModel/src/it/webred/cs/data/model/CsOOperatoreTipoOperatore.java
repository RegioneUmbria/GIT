package it.webred.cs.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CS_O_OPERATORE_TIPO_OPERATORE database table.
 * 
 */
@Entity
@Table(name="CS_O_OPERATORE_TIPO_OPERATORE")
@NamedQuery(name="CsOOperatoreTipoOperatore.findAll", query="SELECT c FROM CsOOperatoreTipoOperatore c")
public class CsOOperatoreTipoOperatore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CS_O_OPERATORE_TIPO_OPERATORE_ID_GENERATOR", sequenceName="SQ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CS_O_OPERATORE_TIPO_OPERATORE_ID_GENERATOR")
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_FINE_APP")
	private Date dataFineApp;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INIZIO_APP")
	private Date dataInizioApp;

	//bi-directional many-to-one association to CsACasoOpeTipoOpe
	@OneToMany(mappedBy="csOOperatoreTipoOperatore")
	private List<CsACasoOpeTipoOpe> csACasoOpeTipoOpes;

	//bi-directional many-to-one association to CsOOperatore
	@ManyToOne
	@JoinColumn(name="OPERATORE_SETTORE_ID")
	private CsOOperatoreSettore csOOperatoreSettore;

	//bi-directional many-to-one association to CsTbTipoOperatore
	@ManyToOne
	@JoinColumn(name="TIPO_OPERATORE_ID")
	private CsTbTipoOperatore csTbTipoOperatore;

	public CsOOperatoreTipoOperatore() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataFineApp() {
		return this.dataFineApp;
	}

	public void setDataFineApp(Date dataFineApp) {
		this.dataFineApp = dataFineApp;
	}

	public Date getDataInizioApp() {
		return this.dataInizioApp;
	}

	public void setDataInizioApp(Date dataInizioApp) {
		this.dataInizioApp = dataInizioApp;
	}

	public List<CsACasoOpeTipoOpe> getCsACasoOpeTipoOpes() {
		return this.csACasoOpeTipoOpes;
	}

	public void setCsACasoOpeTipoOpes(List<CsACasoOpeTipoOpe> csACasoOpeTipoOpes) {
		this.csACasoOpeTipoOpes = csACasoOpeTipoOpes;
	}

	public CsACasoOpeTipoOpe addCsACasoOpeTipoOpe(CsACasoOpeTipoOpe csACasoOpeTipoOpe) {
		getCsACasoOpeTipoOpes().add(csACasoOpeTipoOpe);
		csACasoOpeTipoOpe.setCsOOperatoreTipoOperatore(this);

		return csACasoOpeTipoOpe;
	}

	public CsACasoOpeTipoOpe removeCsACasoOpeTipoOpe(CsACasoOpeTipoOpe csACasoOpeTipoOpe) {
		getCsACasoOpeTipoOpes().remove(csACasoOpeTipoOpe);
		csACasoOpeTipoOpe.setCsOOperatoreTipoOperatore(null);

		return csACasoOpeTipoOpe;
	}

	public CsOOperatoreSettore getCsOOperatoreSettore() {
		return csOOperatoreSettore;
	}

	public void setCsOOperatoreSettore(CsOOperatoreSettore csOOperatoreSettore) {
		this.csOOperatoreSettore = csOOperatoreSettore;
	}

	public CsTbTipoOperatore getCsTbTipoOperatore() {
		return this.csTbTipoOperatore;
	}

	public void setCsTbTipoOperatore(CsTbTipoOperatore csTbTipoOperatore) {
		this.csTbTipoOperatore = csTbTipoOperatore;
	}

}