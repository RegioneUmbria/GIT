package it.webred.cs.data.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the CS_TB_INTERVENTI_UOL database table.
 * 
 */
@Entity
@Table(name="CS_TB_INTERVENTI_UOL")
@NamedQuery(name="CsTbInterventiUOL.findAll", query="SELECT c FROM CsTbInterventiUOL c")
public class CsTbInterventiUOL implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CS_TB_INTERVENTI_UOL_ID_GENERATOR", sequenceName="SQ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CS_TB_INTERVENTI_UOL_ID_GENERATOR")
	private long id;

	private String abilitato;

	private String descrizione;

	private String tooltip;

	public CsTbInterventiUOL() {
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
}