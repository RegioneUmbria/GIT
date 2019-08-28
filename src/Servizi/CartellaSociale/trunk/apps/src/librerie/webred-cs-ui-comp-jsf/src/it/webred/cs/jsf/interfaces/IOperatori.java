package it.webred.cs.jsf.interfaces;

import it.webred.dto.utility.KeyValuePairBean;

import java.util.List;

import javax.faces.model.SelectItem;

public interface IOperatori {
	
	public List<SelectItem> getLstTipoOperatore();
	public List<SelectItem> getLstSettori();
	@SuppressWarnings("rawtypes")
	public List<KeyValuePairBean> getLstItems();
	public void salva();
	public Long getIdSettore();
	public Long getIdTipoOperatore();

}
