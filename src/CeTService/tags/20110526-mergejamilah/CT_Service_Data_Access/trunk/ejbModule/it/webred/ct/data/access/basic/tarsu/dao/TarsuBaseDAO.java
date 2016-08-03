package it.webred.ct.data.access.basic.tarsu.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public class TarsuBaseDAO implements Serializable {

	@PersistenceContext(unitName="CT_Siti")
	protected EntityManager manager_siti;
	
	@PersistenceContext(unitName="CT_Diogene")
	protected EntityManager manager_diogene;
	
	protected Logger logger = Logger.getLogger("CTservice_log");

}
