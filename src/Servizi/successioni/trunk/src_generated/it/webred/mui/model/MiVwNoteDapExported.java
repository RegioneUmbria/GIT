package it.webred.mui.model;
// Generated 1-apr-2009 13.23.58 by Hibernate Tools 3.1.0.beta4



/**
 * MiVwNoteDapExported generated by hbm2java
 */

public class MiVwNoteDapExported  implements java.io.Serializable {


    // Fields    

     private long iidFornitura;
     private Integer codice;
     private long totali;
     private String descr;


    // Constructors

    /** default constructor */
    public MiVwNoteDapExported() {
    }

	/** minimal constructor */
    public MiVwNoteDapExported(long iidFornitura, Integer codice) {
        this.iidFornitura = iidFornitura;
        this.codice = codice;
    }
    
    /** full constructor */
    public MiVwNoteDapExported(long iidFornitura, Integer codice, long totali, String descr) {
        this.iidFornitura = iidFornitura;
        this.codice = codice;
        this.totali = totali;
        this.descr = descr;
    }
    

   
    // Property accessors

    public long getIidFornitura() {
        return this.iidFornitura;
    }
    
    public void setIidFornitura(long iidFornitura) {
        this.iidFornitura = iidFornitura;
    }

    public Integer getCodice() {
        return this.codice;
    }
    
    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public long getTotali() {
        return this.totali;
    }
    
    public void setTotali(long totali) {
        this.totali = totali;
    }

    public String getDescr() {
        return this.descr;
    }
    
    public void setDescr(String descr) {
        this.descr = descr;
    }
   








}