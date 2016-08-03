package it.escsolution.escwebgis.concessioni.bean;

import it.escsolution.escwebgis.common.EscObject;

import java.io.Serializable;

public class ConcessioneVisuraDoc extends EscObject implements Serializable{
	
	private String inxdoc = "";
	private String cdr = "";
	private String vlm = "";
	private String pag = "";
	private String ext = "";
	private String sizee = "";
	private String npag = "";
	private String filee = "";

	public ConcessioneVisuraDoc() {
		
	}//-------------------------------------------------------------------------

	public String getInxdoc() {
		return inxdoc;
	}

	public void setInxdoc(String inxdoc) {
		this.inxdoc = inxdoc;
	}

	public String getCdr() {
		return cdr;
	}

	public void setCdr(String cdr) {
		this.cdr = cdr;
	}

	public String getVlm() {
		return vlm;
	}

	public void setVlm(String vlm) {
		this.vlm = vlm;
	}

	public String getPag() {
		return pag;
	}

	public void setPag(String pag) {
		this.pag = pag;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getSizee() {
		return sizee;
	}

	public void setSizee(String sizee) {
		this.sizee = sizee;
	}

	public String getNpag() {
		return npag;
	}

	public void setNpag(String npag) {
		this.npag = npag;
	}

	public String getFilee() {
		return filee;
	}

	public void setFilee(String filee) {
		this.filee = filee;
	}

}