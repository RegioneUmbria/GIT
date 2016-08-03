package it.webred.ct.service.comma340.web.catasto;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;
import org.ajax4jsf.model.SerializableDataModel;

import it.webred.ct.data.access.basic.catasto.*;
import it.webred.ct.data.access.basic.catasto.dto.*;
import it.webred.ct.data.access.basic.common.CommonService;

import it.webred.ct.service.comma340.web.Comma340BaseBean;

public class CatastoDataModel extends SerializableDataModel implements Serializable {

	private Map<String, SintesiImmobileDTO> wrappedData = new HashMap<String, SintesiImmobileDTO>();

	private CommonService commonService;
	private List<String> wrappedKeys = null;
	private boolean detached = false;
	private String currentPk;
	

	private CatastoDataProvider dataProvider;
	private CatastoSearchCriteria criteria = new CatastoSearchCriteria();

	public Object getRowKey() {
		return currentPk;
	}

	/**
	 * This method normally called by Visitor before request Data Row.
	 */
	@Override
	public void setRowKey(Object key) {
		this.currentPk = (String) key;

	}

	@Override
	public void walk(FacesContext context, DataVisitor visitor, Range range,Object argument) throws IOException {
		int firstRow = ((SequenceRange) range).getFirstRow();
		int numberOfRows = ((SequenceRange) range).getRows();
		
		//System.out.println("Walk [ " + firstRow+ "- " + numberOfRows + " ]");
		if (detached) { // Is this serialized model
			for (String key : wrappedKeys) {
				setRowKey(key);
				visitor.process(context, key, argument);
			}
		} else { // if not serialized, than we request data from data provider
			wrappedKeys = new ArrayList<String>();
			for (SintesiImmobileDTO item : dataProvider.getDataByRange(
					firstRow, numberOfRows, criteria)) {
				System.out.println("Item ["+item+"]");
				wrappedKeys.add(item.getIdImmobile());
				wrappedData.put(item.getIdImmobile(),item);
				visitor.process(context, item.getIdImmobile(), argument);
			}
		}
	}

	private Integer rowCount; // better to buffer row count locally

	@Override
	public int getRowCount() {
		rowCount = new Integer((int) dataProvider.getRecordCount(criteria));
		//System.out.println("Row count ["+rowCount+"]");
		return rowCount.intValue();
	}

	public Object getRowData() {
		if (currentPk == null) {
			return null;
		} else {
			SintesiImmobileDTO ret = wrappedData.get(currentPk);
			if (ret == null) {
				// ret = dataProvider.getStanza(currentPk);
				// wrappedData.put(currentPk, ret);
				// return ret;
				return null;
			} else {
				return ret;
			}
		}
	}

	@Override
	public int getRowIndex() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getWrappedData() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isRowAvailable() {
		/*
		 * if (currentPk==null) { return false; } else { if
		 * (dataProvider.getStanza(currentPk) != null) return true; else return
		 * false; }
		 */

		return true;
	}

	@Override
	public void setRowIndex(int rowIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setWrappedData(Object data) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update() {
	}

	public CatastoDataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(CatastoDataProvider dataProvider) {
		this.dataProvider = dataProvider;
		System.out.println("Data Provider ["+this.dataProvider+"]");
	}

	public CatastoSearchCriteria getCriteria() {
		
		if (criteria.getCodNazionale() == null)
			criteria.setCodNazionale(commonService.getEnte().getCodent());
		
		/*if(this.criteria.getNonANorma()== null)
			this.criteria.setNonANorma(Boolean.FALSE);
		
		if(this.criteria.getCodCategoria()== null)
			this.criteria.setCodCategoria("");*/
		
		return criteria;
	}
	

	public void setCriteria(CatastoSearchCriteria criteria) {
				
		this.criteria = criteria;		
		
		if (this.criteria.getCodNazionale() == null) 
			this.criteria.setCodNazionale(commonService.getEnte().getCodent());
		
		/*if(this.criteria.getNonANorma()== null)
			this.criteria.setNonANorma(Boolean.FALSE);
		
		if(this.criteria.getCodCategoria()== null)
			this.criteria.setCodCategoria("");*/
	}

	public void setResetData(String val) {
		dataProvider.resetData();
	}

	public void setResetData() {
		criteria = new CatastoSearchCriteria();
	}
	
	public void pulisciFiltro(ActionEvent event) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("catastoDataModel");
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

}
