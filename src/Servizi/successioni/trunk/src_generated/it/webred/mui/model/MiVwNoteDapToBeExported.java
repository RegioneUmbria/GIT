package it.webred.mui.model;
// Generated 1-apr-2009 13.23.53 by Hibernate Tools 3.1.0.beta4



/**
 * MiVwNoteDapToBeExported generated by hbm2java
 */

public class MiVwNoteDapToBeExported  implements java.io.Serializable {


    // Fields    

     private long iid;
     private MiDupFornitura miDupFornitura;
     private MiDupTitolarita miDupTitolarita;


    // Constructors

    /** default constructor */
    public MiVwNoteDapToBeExported() {
    }

	/** minimal constructor */
    public MiVwNoteDapToBeExported(long iid, MiDupFornitura miDupFornitura) {
        this.iid = iid;
        this.miDupFornitura = miDupFornitura;
    }
    
    /** full constructor */
    public MiVwNoteDapToBeExported(long iid, MiDupFornitura miDupFornitura, MiDupTitolarita miDupTitolarita) {
        this.iid = iid;
        this.miDupFornitura = miDupFornitura;
        this.miDupTitolarita = miDupTitolarita;
    }
    

   
    // Property accessors

    public long getIid() {
        return this.iid;
    }
    
    public void setIid(long iid) {
        this.iid = iid;
    }

    public MiDupFornitura getMiDupFornitura() {
        return this.miDupFornitura;
    }
    
    public void setMiDupFornitura(MiDupFornitura miDupFornitura) {
        this.miDupFornitura = miDupFornitura;
    }

    public MiDupTitolarita getMiDupTitolarita() {
        return this.miDupTitolarita;
    }
    
    public void setMiDupTitolarita(MiDupTitolarita miDupTitolarita) {
        this.miDupTitolarita = miDupTitolarita;
    }
   








}