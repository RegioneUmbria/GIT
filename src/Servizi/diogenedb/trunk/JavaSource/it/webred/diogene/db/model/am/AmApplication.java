package it.webred.diogene.db.model.am;
// Generated 22-nov-2007 11.42.35 by Hibernate Tools 3.1.0.beta4

import java.util.HashSet;
import java.util.Set;


/**
 * AmApplication generated by hbm2java
 */

public class AmApplication  implements java.io.Serializable {


    // Fields    

     private String name;
     private String url;
     private String ente;
     private String tipoApp;
     private Long catApp;
     private Set amApplicationItems = new HashSet(0);


    // Constructors

    /** default constructor */
    public AmApplication() {
    }

	/** minimal constructor */
    public AmApplication(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public AmApplication(String name, String url, String ente, String tipoApp, Long catApp, Set amApplicationItems) {
        this.name = name;
        this.url = url;
        this.ente = ente;
        this.tipoApp = tipoApp;
        this.catApp = catApp;
        this.amApplicationItems = amApplicationItems;
    }
    

   
    // Property accessors

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public String getEnte() {
        return this.ente;
    }
    
    public void setEnte(String ente) {
        this.ente = ente;
    }

    public String getTipoApp() {
        return this.tipoApp;
    }
    
    public void setTipoApp(String tipoApp) {
        this.tipoApp = tipoApp;
    }

    public Long getCatApp() {
        return this.catApp;
    }
    
    public void setCatApp(Long catApp) {
        this.catApp = catApp;
    }

    public Set getAmApplicationItems() {
        return this.amApplicationItems;
    }
    
    public void setAmApplicationItems(Set amApplicationItems) {
        this.amApplicationItems = amApplicationItems;
    }
   








}
