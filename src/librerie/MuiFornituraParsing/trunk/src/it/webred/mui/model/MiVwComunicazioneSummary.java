package it.webred.mui.model;
// Generated 15-lug-2008 10.19.13 by Hibernate Tools 3.1.0.beta4



/**
 * MiVwComunicazioneSummary generated by hbm2java
 */

public class MiVwComunicazioneSummary  implements java.io.Serializable {


    // Fields    

     private long iid_fornitura;
     private long totale;
     private long massimo;
     private MiDupFornitura miDupFornitura;


    // Constructors

    /** default constructor */
    public MiVwComunicazioneSummary() {
    }

	/** minimal constructor */
    public MiVwComunicazioneSummary(long iid_fornitura) {
        this.iid_fornitura = iid_fornitura;
    }
    
    /** full constructor */
    public MiVwComunicazioneSummary(long iid_fornitura, long totale, long massimo, MiDupFornitura miDupFornitura) {
        this.iid_fornitura = iid_fornitura;
        this.totale = totale;
        this.massimo = massimo;
        this.miDupFornitura = miDupFornitura;
    }
    

   
    // Property accessors

    public long getIid_fornitura() {
        return this.iid_fornitura;
    }
    
    public void setIid_fornitura(long iid_fornitura) {
        this.iid_fornitura = iid_fornitura;
    }

    public long getTotale() {
        return this.totale;
    }
    
    public void setTotale(long totale) {
        this.totale = totale;
    }

    public long getMassimo() {
        return this.massimo;
    }
    
    public void setMassimo(long massimo) {
        this.massimo = massimo;
    }

    public MiDupFornitura getMiDupFornitura() {
        return this.miDupFornitura;
    }
    
    public void setMiDupFornitura(MiDupFornitura miDupFornitura) {
        this.miDupFornitura = miDupFornitura;
    }
   








}
