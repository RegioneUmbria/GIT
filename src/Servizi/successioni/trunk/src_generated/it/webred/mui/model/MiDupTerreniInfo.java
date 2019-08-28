package it.webred.mui.model;
// Generated 1-apr-2009 13.23.51 by Hibernate Tools 3.1.0.beta4

import java.util.HashSet;
import java.util.Set;


/**
 * MiDupTerreniInfo generated by hbm2java
 */

public class MiDupTerreniInfo  implements java.io.Serializable {


    // Fields    

     private long iid;
     private MiDupFornitura miDupFornitura;
     private String idNota;
     private MiDupNotaTras miDupNotaTras;
     private String tipologiaImmobile;
     private String idImmobile;
     private String idCatastaleImmobile;
     private String codiceEsito;
     private String sezioneCensuaruia;
     private String foglio;
     private String numero;
     private String denominatore;
     private String subalterno;
     private String edificabilita;
     private String natura;
     private String qualita;
     private String classe;
     private String ettari;
     private String are;
     private String centiare;
     private String flagReddito;
     private String redditoDominicaleEuro;
     private String redditoAgrarioEuro;
     private String partita;
     private Set<MiDupTitolarita> miDupTitolaritas = new HashSet<MiDupTitolarita>(0);


    // Constructors

    /** default constructor */
    public MiDupTerreniInfo() {
    }

	/** minimal constructor */
    public MiDupTerreniInfo(MiDupFornitura miDupFornitura) {
        this.miDupFornitura = miDupFornitura;
    }
    
    /** full constructor */
    public MiDupTerreniInfo(MiDupFornitura miDupFornitura, String idNota, MiDupNotaTras miDupNotaTras, String tipologiaImmobile, String idImmobile, String idCatastaleImmobile, String codiceEsito, String sezioneCensuaruia, String foglio, String numero, String denominatore, String subalterno, String edificabilita, String natura, String qualita, String classe, String ettari, String are, String centiare, String flagReddito, String redditoDominicaleEuro, String redditoAgrarioEuro, String partita, Set<MiDupTitolarita> miDupTitolaritas) {
        this.miDupFornitura = miDupFornitura;
        this.idNota = idNota;
        this.miDupNotaTras = miDupNotaTras;
        this.tipologiaImmobile = tipologiaImmobile;
        this.idImmobile = idImmobile;
        this.idCatastaleImmobile = idCatastaleImmobile;
        this.codiceEsito = codiceEsito;
        this.sezioneCensuaruia = sezioneCensuaruia;
        this.foglio = foglio;
        this.numero = numero;
        this.denominatore = denominatore;
        this.subalterno = subalterno;
        this.edificabilita = edificabilita;
        this.natura = natura;
        this.qualita = qualita;
        this.classe = classe;
        this.ettari = ettari;
        this.are = are;
        this.centiare = centiare;
        this.flagReddito = flagReddito;
        this.redditoDominicaleEuro = redditoDominicaleEuro;
        this.redditoAgrarioEuro = redditoAgrarioEuro;
        this.partita = partita;
        this.miDupTitolaritas = miDupTitolaritas;
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

    public String getTipologiaImmobile() {
        return this.tipologiaImmobile;
    }
    
    public void setTipologiaImmobile(String tipologiaImmobile) {
        this.tipologiaImmobile = tipologiaImmobile;
    }

    public String getIdImmobile() {
        return this.idImmobile;
    }
    
    public void setIdImmobile(String idImmobile) {
        this.idImmobile = idImmobile;
    }

    public String getIdCatastaleImmobile() {
        return this.idCatastaleImmobile;
    }
    
    public void setIdCatastaleImmobile(String idCatastaleImmobile) {
        this.idCatastaleImmobile = idCatastaleImmobile;
    }

    public String getCodiceEsito() {
        return this.codiceEsito;
    }
    
    public void setCodiceEsito(String codiceEsito) {
        this.codiceEsito = codiceEsito;
    }

    public String getSezioneCensuaruia() {
        return this.sezioneCensuaruia;
    }
    
    public void setSezioneCensuaruia(String sezioneCensuaruia) {
        this.sezioneCensuaruia = sezioneCensuaruia;
    }

    public String getFoglio() {
        return this.foglio;
    }
    
    public void setFoglio(String foglio) {
        this.foglio = foglio;
    }

    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDenominatore() {
        return this.denominatore;
    }
    
    public void setDenominatore(String denominatore) {
        this.denominatore = denominatore;
    }

    public String getSubalterno() {
        return this.subalterno;
    }
    
    public void setSubalterno(String subalterno) {
        this.subalterno = subalterno;
    }

    public String getEdificabilita() {
        return this.edificabilita;
    }
    
    public void setEdificabilita(String edificabilita) {
        this.edificabilita = edificabilita;
    }

    public String getNatura() {
        return this.natura;
    }
    
    public void setNatura(String natura) {
        this.natura = natura;
    }

    public String getQualita() {
        return this.qualita;
    }
    
    public void setQualita(String qualita) {
        this.qualita = qualita;
    }

    public String getClasse() {
        return this.classe;
    }
    
    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEttari() {
        return this.ettari;
    }
    
    public void setEttari(String ettari) {
        this.ettari = ettari;
    }

    public String getAre() {
        return this.are;
    }
    
    public void setAre(String are) {
        this.are = are;
    }

    public String getCentiare() {
        return this.centiare;
    }
    
    public void setCentiare(String centiare) {
        this.centiare = centiare;
    }

    public String getFlagReddito() {
        return this.flagReddito;
    }
    
    public void setFlagReddito(String flagReddito) {
        this.flagReddito = flagReddito;
    }

    public String getRedditoDominicaleEuro() {
        return this.redditoDominicaleEuro;
    }
    
    public void setRedditoDominicaleEuro(String redditoDominicaleEuro) {
        this.redditoDominicaleEuro = redditoDominicaleEuro;
    }

    public String getRedditoAgrarioEuro() {
        return this.redditoAgrarioEuro;
    }
    
    public void setRedditoAgrarioEuro(String redditoAgrarioEuro) {
        this.redditoAgrarioEuro = redditoAgrarioEuro;
    }

    public String getPartita() {
        return this.partita;
    }
    
    public void setPartita(String partita) {
        this.partita = partita;
    }

    public Set<MiDupTitolarita> getMiDupTitolaritas() {
        return this.miDupTitolaritas;
    }
    
    public void setMiDupTitolaritas(Set<MiDupTitolarita> miDupTitolaritas) {
        this.miDupTitolaritas = miDupTitolaritas;
    }
   








}
