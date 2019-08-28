package it.webred.cs.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the CS_TB_TIPO_COMUNITA database table.
 * 
 */
@Entity
@Table(name="CS_TB_TIPO_COMUNITA")
@NamedQuery(name="CsTbTipoComunita.findAll", query="SELECT c FROM CsTbTipoComunita c")
public class CsTbTipoComunita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CS_TB_TIPO_COMUNITA_ID_GENERATOR", sequenceName="SQ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CS_TB_TIPO_COMUNITA_ID_GENERATOR")
	private long id;

	private String abilitato;

	private String descrizione;

	private String tooltip;

	//bi-directional many-to-one association to CsCComunita
	@OneToMany(mappedBy="csTbTipoComunita")
	private List<CsCComunita> csCComunitas;

	public CsTbTipoComunita() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAbilitato() {
		return this.abilitato;
	}

	public void setAbilitato(String abilitato) {
		this.abilitato = abilitato;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTooltip() {
		return this.tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public List<CsCComunita> getCsCComunitas() {
		return this.csCComunitas;
	}

	public void setCsCComunitas(List<CsCComunita> csCComunitas) {
		this.csCComunitas = csCComunitas;
	}

	public CsCComunita addCsCComunita(CsCComunita csCComunita) {
		getCsCComunitas().add(csCComunita);
		csCComunita.setCsTbTipoComunita(this);

		return csCComunita;
	}

	public CsCComunita removeCsCComunita(CsCComunita csCComunita) {
		getCsCComunitas().remove(csCComunita);
		csCComunita.setCsTbTipoComunita(null);

		return csCComunita;
	}

}