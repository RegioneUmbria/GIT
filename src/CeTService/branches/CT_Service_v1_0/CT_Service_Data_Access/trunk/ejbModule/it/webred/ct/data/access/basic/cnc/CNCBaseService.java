package it.webred.ct.data.access.basic.cnc;

import it.webred.ct.data.access.basic.CTServiceBaseBean;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public class CNCBaseService extends CTServiceBaseBean implements Serializable {

	@PersistenceContext(unitName="CT_Diogene_CNC")
	protected EntityManager manager;
	
	// Rimosso
	//protected Logger logger = Logger.getLogger("CTservice_log");
}
