package it.webred.amprofiler.ejb.client;

import it.webred.amprofiler.ejb.AmProfilerSessionFacade;
import it.webred.ct.config.model.AmKeyValue;
import it.webred.ct.config.model.AmSection;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
	public static void main(String[] args) throws NamingException {
		Hashtable<String, String> hash = new Hashtable<String, String>();
		hash.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		hash.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");
		hash.put("java.naming.provider.url", "localhost");
		InitialContext ctx = new InitialContext(hash);

		AmProfilerSessionFacade facade = (AmProfilerSessionFacade) ctx
				.lookup("AmProfiler/AmProfilerSessionFacadeBean/remote");

		System.out.println("Sezioni:");
		for (AmSection item : facade.findAmSections("PortaleServizi")) {
			//System.out.println(item.getId() + "     ");
			System.out.println(item.getId() + "     " + item.getName());
		}
		//facade.deleteAmSection(1);
		AmSection section = facade.findAmSectionById(0);
		boolean isNew =(section==null);
	
		if(isNew){
			section = new AmSection();
			section.setName("Common1");

			//section.setAmKeyValues(new Set<AmKeyValue>()) ;
			AmKeyValue value= new AmKeyValue();
			value.setAmSection(section);
			value.setKey("PrimaChiave");
			value.setValue("PrimoValore");
			value.setMustBeSet("Y");
			value.setOverwType("0");
			section.getAmKeyValues().add(value);
			
			AmKeyValue value1= new AmKeyValue();
			value1.setAmSection(section);
			value1.setKey("SecondaChiave");
			value1.setValue("SecondoValore");
			value1.setMustBeSet("Y");
			value1.setOverwType("0");
			section.getAmKeyValues().add(value1);

			AmKeyValue value2= new AmKeyValue();
			value2.setAmSection(section);
			value2.setKey("TerzaChiave"); 
			value2.setValue("TerzoValore");
			value2.setMustBeSet("Y");
			value2.setOverwType("0");
			section.getAmKeyValues().add(value2);
			
			facade.createAmSection(section, "PortaleServizi",null);
		}else{
			section.setTipo(0);
			//section.getAmKeyValues().get(0).setKey("PrimaChiaveModificata");
			//section.getAmKeyValues().get(0).setValue("PrimoValore");
			facade.updateAmSection(section);
		}
			
		for (AmSection item : facade.findAmSections("PortaleServizi",null)) {
			AmSection amSection = facade.findAmSectionById(item.getId());
			System.out.println(amSection.getId() + "     " + amSection.getName());
			for (AmKeyValue keyValue : amSection.getAmKeyValues()) {
				System.out.println(keyValue.getKey()+" - "+keyValue.getValue());
			}
		}

	}
}