package it.webred.mui.model;
// Generated 15-lug-2008 10.19.08 by Hibernate Tools 3.1.0.beta4



/**
 * MiQryFornitureLogDetail generated by hbm2java
 */

public class MiQryFornitureLogDetail  implements java.io.Serializable {


    // Fields    

     private long iidFornitura;
     private String codiceRegola;
     private String tabella;
     private String colonna;
     private String bloccante;
     private long totali;


    // Constructors

    /** default constructor */
    public MiQryFornitureLogDetail() {
    }

	/** minimal constructor */
    public MiQryFornitureLogDetail(long iidFornitura, String codiceRegola, String tabella, String colonna, String bloccante) {
        this.iidFornitura = iidFornitura;
        this.codiceRegola = codiceRegola;
        this.tabella = tabella;
        this.colonna = colonna;
        this.bloccante = bloccante;
    }
    
    /** full constructor */
    public MiQryFornitureLogDetail(long iidFornitura, String codiceRegola, String tabella, String colonna, String bloccante, long totali) {
        this.iidFornitura = iidFornitura;
        this.codiceRegola = codiceRegola;
        this.tabella = tabella;
        this.colonna = colonna;
        this.bloccante = bloccante;
        this.totali = totali;
    }
    

   
    // Property accessors

    public long getIidFornitura() {
        return this.iidFornitura;
    }
    
    public void setIidFornitura(long iidFornitura) {
        this.iidFornitura = iidFornitura;
    }

    public String getCodiceRegola() {
        return this.codiceRegola;
    }
    
    public void setCodiceRegola(String codiceRegola) {
        this.codiceRegola = codiceRegola;
    }

    public String getTabella() {
        return this.tabella;
    }
    
    public void setTabella(String tabella) {
        this.tabella = tabella;
    }

    public String getColonna() {
        return this.colonna;
    }
    
    public void setColonna(String colonna) {
        this.colonna = colonna;
    }

    public String getBloccante() {
        return this.bloccante;
    }
    
    public void setBloccante(String bloccante) {
        this.bloccante = bloccante;
    }

    public long getTotali() {
        return this.totali;
    }
    
    public void setTotali(long totali) {
        this.totali = totali;
    }
   








}
