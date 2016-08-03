package it.webred.AMProfiler.beans;

// Generated 7-lug-2006 12.31.07 by Hibernate Tools 3.1.0.beta5

import java.util.HashSet;
import java.util.Set;

/**
 * AmApplication generated by hbm2java
 */
public class AmApplication implements java.io.Serializable {

	// Fields
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String url;
	private String tipo_app;
	private String cat_app;
	private Set<AmItem> amItems = new HashSet<AmItem>(0);
	private AmComune amComune = new AmComune();

	private boolean accessoAutorizzato = false;

	// Constructors

	/** default constructor */
	public AmApplication() {
	}

	/** minimal constructor */
	public AmApplication(String name) {
		this.name = name;
	}

	/** full constructor */
	public AmApplication(String name, String url, AmComune comune, String tipo_app, Set<AmItem> amItems) {
		this.name = name;
		this.url = url;
		this.amItems = amItems;
		amComune = comune;
		this.tipo_app = tipo_app;
	}

	// Property accessors
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<AmItem> getAmItems() {
		return amItems;
	}

	public void setAmItems(Set<AmItem> amItems) {
		this.amItems = amItems;
	}

	public AmComune getComune() {
		return amComune;
	}

	public void setComune(AmComune comune) {
		amComune = comune;
	}

	public String getTipo_app() {
		return tipo_app;
	}

	public void setTipo_app(String tipo_app) {
		this.tipo_app = tipo_app;
	}

	public boolean isAccessoAutorizzato() {
		return accessoAutorizzato;
	}

	public void setAccessoAutorizzato(boolean accessoAutorizzato) {
		this.accessoAutorizzato = accessoAutorizzato;
	}

	public String getCat_app() {
		return cat_app;
	}

	public void setCat_app(String cat_app) {
		this.cat_app = cat_app;
	}

}