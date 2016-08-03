package it.webred.ct.data.model.redditi;

import it.webred.ct.data.model.ici.VIciTSoggAllPK;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * The primary key class for the RedDatiAnagrafici database table.
 * 
 */
@Embeddable
public class RedDatiAnagraficiPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Column(name="IDE_TELEMATICO")
	private String ideTelematico;

	@Column(name="CODICE_FISCALE_DIC")
	private String codiceFiscaleDic;
	
	public  RedDatiAnagraficiPK() {
		 
	}
	
	public String getIdeTelematico() {
		return this.ideTelematico;
	}

	public void setIdeTelematico(String ideTelematico) {
		this.ideTelematico = ideTelematico;
	}
	public String getCodiceFiscaleDic() {
		return this.codiceFiscaleDic;
	}

	public void setCodiceFiscaleDic(String codiceFiscaleDic) {
		this.codiceFiscaleDic = codiceFiscaleDic;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RedDatiAnagraficiPK)) {
			return false;
		}
		RedDatiAnagraficiPK castOther = (RedDatiAnagraficiPK)other;
		return 
			this.ideTelematico.equals(castOther.ideTelematico)
			&& this.codiceFiscaleDic.equals(castOther.codiceFiscaleDic);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ideTelematico.hashCode();
		hash = hash * prime + this.codiceFiscaleDic.hashCode();
		
		return hash;
    }

}
