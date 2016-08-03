package it.webred.cs.data.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CS_CFG_IT_STATO_ATTR database table.
 * 
 */
@Entity
@Table(name="CS_CFG_IT_STATO_ATTR")
@NamedQuery(name="CsCfgItStatoAttr.findAll", query="SELECT c FROM CsCfgItStatoAttr c")
public class CsCfgItStatoAttr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CS_CFG_IT_STATO_ATTR_ID_GENERATOR", sequenceName="SQ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CS_CFG_IT_STATO_ATTR_ID_GENERATOR")
	private long id;

	//bi-directional many-to-one association to CsCfgAttr
	@ManyToOne
	@JoinColumn(name="CFG_ATTR_ID")
	private CsCfgAttr csCfgAttr;

	//bi-directional many-to-one association to CsCfgItStato
	@ManyToOne
	@JoinColumn(name="CFG_IT_STATO_ID")
	private CsCfgItStato csCfgItStato;

	public CsCfgItStatoAttr() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CsCfgAttr getCsCfgAttr() {
		return this.csCfgAttr;
	}

	public void setCsCfgAttr(CsCfgAttr csCfgAttr) {
		this.csCfgAttr = csCfgAttr;
	}

	public CsCfgItStato getCsCfgItStato() {
		return this.csCfgItStato;
	}

	public void setCsCfgItStato(CsCfgItStato csCfgItStato) {
		this.csCfgItStato = csCfgItStato;
	}

}