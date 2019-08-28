package it.webred.cs.csa.web.manbean.fascicolo.schedaMultidimAnz.barthel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Alessandro Feriani
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonBarthelBean {

	private static final long serialVersionUID = 1L;

	private String test;
	
	public JsonBarthelBean() {
		test = "Questo è una stringa di testo";
	}

	public JsonBarthelBean(JsonBarthelBean jsonOriginal) {
		if( jsonOriginal != null)
		{
			test = jsonOriginal.test;
		}
		else
			test = "Questo è una stringa di testo";
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	
	
}
