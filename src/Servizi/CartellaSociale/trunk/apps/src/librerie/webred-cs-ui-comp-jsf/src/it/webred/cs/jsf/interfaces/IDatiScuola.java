package it.webred.cs.jsf.interfaces;

import it.webred.cs.data.model.CsDScuola;

import java.util.List;

import javax.faces.model.SelectItem;

public interface IDatiScuola {
	
	public void initializeData();
	public void nuovo();
	public void carica();
	public void salva();
	public void elimina();
	public Long getIdCaso();
	public int getIdxSelected();
	public List<CsDScuola> getListaScuole();
	public List<SelectItem> getListaAnni();
	public List<SelectItem> getListaTipi();
	public List<SelectItem> getListaNomi();
	public List<SelectItem> getListaGradi();
	public List<SelectItem> getListaProgetti();
	public CsDScuola getScuola();
	public boolean isRenderScuole();
}
