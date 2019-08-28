package it.webred.mui.model;
// Generated 1-apr-2009 13.23.52 by Hibernate Tools 3.1.0.beta4



/**
 * MiDupIndirizziSog generated by hbm2java
 */

public class MiDupIndirizziSog  implements java.io.Serializable {


    // Fields    

     private long iid;
     private MiDupFornitura miDupFornitura;
     private String idNota;
     private MiDupNotaTras miDupNotaTras;
     private String idSoggettoNota;
     private MiDupSoggetti miDupSoggetti;
     private String tipoIndirizzo;
     private String comune;
     private String provincia;
     private String indirizzo;
     private String cap;


    // Constructors

    /** default constructor */
    public MiDupIndirizziSog() {
    }

	/** minimal constructor */
    public MiDupIndirizziSog(MiDupFornitura miDupFornitura) {
        this.miDupFornitura = miDupFornitura;
    }
    
    /** full constructor */
    public MiDupIndirizziSog(MiDupFornitura miDupFornitura, String idNota, MiDupNotaTras miDupNotaTras, String idSoggettoNota, MiDupSoggetti miDupSoggetti, String tipoIndirizzo, String comune, String provincia, String indirizzo, String cap) {
        this.miDupFornitura = miDupFornitura;
        this.idNota = idNota;
        this.miDupNotaTras = miDupNotaTras;
        this.idSoggettoNota = idSoggettoNota;
        this.miDupSoggetti = miDupSoggetti;
        this.tipoIndirizzo = tipoIndirizzo;
        this.comune = comune;
        this.provincia = provincia;
        this.indirizzo = indirizzo;
        this.cap = cap;
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

    public String getIdNota() {
        return this.idNota;
    }
    
    public void setIdNota(String idNota) {
        this.idNota = idNota;
    }

    public MiDupNotaTras getMiDupNotaTras() {
        return this.miDupNotaTras;
    }
    
    public void setMiDupNotaTras(MiDupNotaTras miDupNotaTras) {
        this.miDupNotaTras = miDupNotaTras;
    }

    public String getIdSoggettoNota() {
        return this.idSoggettoNota;
    }
    
    public void setIdSoggettoNota(String idSoggettoNota) {
        this.idSoggettoNota = idSoggettoNota;
    }

    public MiDupSoggetti getMiDupSoggetti() {
        return this.miDupSoggetti;
    }
    
    public void setMiDupSoggetti(MiDupSoggetti miDupSoggetti) {
        this.miDupSoggetti = miDupSoggetti;
    }

    public String getTipoIndirizzo() {
        return this.tipoIndirizzo;
    }
    
    public void setTipoIndirizzo(String tipoIndirizzo) {
        this.tipoIndirizzo = tipoIndirizzo;
    }

    public String getComune() {
        return this.comune;
    }
    
    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }
    
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCap() {
        return this.cap;
    }
    
    public void setCap(String cap) {
        this.cap = cap;
    }
   








}
