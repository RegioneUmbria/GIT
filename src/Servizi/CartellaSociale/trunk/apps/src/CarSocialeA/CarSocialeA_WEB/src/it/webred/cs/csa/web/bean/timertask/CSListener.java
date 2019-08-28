package it.webred.cs.csa.web.bean.timertask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jboss.logging.Logger;

public class CSListener implements ServletContextListener {
	
	protected static Logger logger = Logger.getLogger("carsociale.log");

	//5 Minuti
	private static Long _delay = new Long(300000);
	private static Long _period = new Long(300000);
		
	public CSListener() {
		super();
	}

	
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub	
	}
	

	public void contextInitialized(ServletContextEvent arg0) {
			
		//recupero tutti gli enti dal properties per far girare il task su tutti i DB
		String path = System.getProperty("jboss.server.config.dir")
				+ "\\datarouter.properties";
		String newpath = "file:///" + path.replaceAll("\\\\", "/");
		URL url;
		try {
			url = new URL(newpath);

			Properties props = new Properties();
			props.load(url.openStream());
			Enumeration e = props.propertyNames();
	
		    while (e.hasMoreElements()) {
		    	
		    	String enteId = (String) e.nextElement();
			
				logger.debug("Inizializzazione CSTimerTask ");
				Timer timer = new Timer();
				
				CSTimerTask.setLogger(logger);
				timer.schedule(new CSTimerTask(enteId), _delay, _period);
		    }
	    
		} catch (Exception e) {
			logger.error("__ CSTimerTask: Eccezione: " + e.getMessage(), e);
		}
		
	}

}
