package it.webred.docfa.model;
// Generated 1-apr-2009 13.23.52 by Hibernate Tools 3.1.0.beta4

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * UseDocfaComunicazione generated by hbm2java
 */

public class UseDocfaComunicazione  implements java.io.Serializable {


    // Fields    

     private BigDecimal iidComunicazione;
     private String iidProtocolloReg;
     private String iidFornitura;
     private String codfiscalePiva;
     private String prefisso;
     private String telefono;
     private String denominazione;
     private String nome;
     private String dataNascita;
     private String comuneNascita;
     private String provinciaNascita;
     private String sesso;
     private String indirizzo;
     private String cap;
     private String comune;
     private String provincia;
     private String indirizzoDomicilio;
     private String capDomicilio;
     private String comuneDomicilio;
     private String provinciaDomicilio;
     private String codiceFiscalerl;
     private String prefissorl;
     private String telefonorl;
     private String cognomerl;
     private String nomerl;
     private String dataNascitarl;
     private String comuneNascitarl;
     private String provinciaNascitarl;
     private String sessorl;
     private String indirizzorl;
     private String caprl;
     private String comunerl;
     private String provinciarl;
     private String indirizzoDomiciliorl;
     private String capDomiciliorl;
     private String comuneDomiciliorl;
     private String provinciaDomiciliorl;
     private Boolean flagRappresentanteLegale;
     private Boolean flagCuratoreFallimentare;
     private Boolean flagTutore;
     private Boolean flagErede;
     private String altraNatura;
     private Character flagPersona;
     private Date dataComunicazione;
     private Long stato;
     private String pagine;
     private Long flagElaborato;
     private Set<DocfaComunOggetto> docfaComunOggettos = new HashSet<DocfaComunOggetto>(0);


    // Constructors

    /** default constructor */
    public UseDocfaComunicazione() {
    }

	/** minimal constructor */
    public UseDocfaComunicazione(BigDecimal iidComunicazione) {
        this.iidComunicazione = iidComunicazione;
    }
    
    /** full constructor */
    public UseDocfaComunicazione(BigDecimal iidComunicazione, String iidProtocolloReg, String iidFornitura, String codfiscalePiva, String prefisso, String telefono, String denominazione, String nome, String dataNascita, String comuneNascita, String provinciaNascita, String sesso, String indirizzo, String cap, String comune, String provincia, String indirizzoDomicilio, String capDomicilio, String comuneDomicilio, String provinciaDomicilio, String codiceFiscalerl, String prefissorl, String telefonorl, String cognomerl, String nomerl, String dataNascitarl, String comuneNascitarl, String provinciaNascitarl, String sessorl, String indirizzorl, String caprl, String comunerl, String provinciarl, String indirizzoDomiciliorl, String capDomiciliorl, String comuneDomiciliorl, String provinciaDomiciliorl, Boolean flagRappresentanteLegale, Boolean flagCuratoreFallimentare, Boolean flagTutore, Boolean flagErede, String altraNatura, Character flagPersona, Date dataComunicazione, Long stato, String pagine, Long flagElaborato, Set<DocfaComunOggetto> docfaComunOggettos) {
        this.iidComunicazione = iidComunicazione;
        this.iidProtocolloReg = iidProtocolloReg;
        this.iidFornitura = iidFornitura;
        this.codfiscalePiva = codfiscalePiva;
        this.prefisso = prefisso;
        this.telefono = telefono;
        this.denominazione = denominazione;
        this.nome = nome;
        this.dataNascita = dataNascita;
        this.comuneNascita = comuneNascita;
        this.provinciaNascita = provinciaNascita;
        this.sesso = sesso;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.comune = comune;
        this.provincia = provincia;
        this.indirizzoDomicilio = indirizzoDomicilio;
        this.capDomicilio = capDomicilio;
        this.comuneDomicilio = comuneDomicilio;
        this.provinciaDomicilio = provinciaDomicilio;
        this.codiceFiscalerl = codiceFiscalerl;
        this.prefissorl = prefissorl;
        this.telefonorl = telefonorl;
        this.cognomerl = cognomerl;
        this.nomerl = nomerl;
        this.dataNascitarl = dataNascitarl;
        this.comuneNascitarl = comuneNascitarl;
        this.provinciaNascitarl = provinciaNascitarl;
        this.sessorl = sessorl;
        this.indirizzorl = indirizzorl;
        this.caprl = caprl;
        this.comunerl = comunerl;
        this.provinciarl = provinciarl;
        this.indirizzoDomiciliorl = indirizzoDomiciliorl;
        this.capDomiciliorl = capDomiciliorl;
        this.comuneDomiciliorl = comuneDomiciliorl;
        this.provinciaDomiciliorl = provinciaDomiciliorl;
        this.flagRappresentanteLegale = flagRappresentanteLegale;
        this.flagCuratoreFallimentare = flagCuratoreFallimentare;
        this.flagTutore = flagTutore;
        this.flagErede = flagErede;
        this.altraNatura = altraNatura;
        this.flagPersona = flagPersona;
        this.dataComunicazione = dataComunicazione;
        this.stato = stato;
        this.pagine = pagine;
        this.flagElaborato = flagElaborato;
        this.docfaComunOggettos = docfaComunOggettos;
    }
    

   
    // Property accessors

    public BigDecimal getIidComunicazione() {
        return this.iidComunicazione;
    }
    
    public void setIidComunicazione(BigDecimal iidComunicazione) {
        this.iidComunicazione = iidComunicazione;
    }

    public String getIidProtocolloReg() {
        return this.iidProtocolloReg;
    }
    
    public void setIidProtocolloReg(String iidProtocolloReg) {
        this.iidProtocolloReg = iidProtocolloReg;
    }

    public String getIidFornitura() {
        return this.iidFornitura;
    }
    
    public void setIidFornitura(String iidFornitura) {
        this.iidFornitura = iidFornitura;
    }

    public String getCodfiscalePiva() {
        return this.codfiscalePiva;
    }
    
    public void setCodfiscalePiva(String codfiscalePiva) {
        this.codfiscalePiva = codfiscalePiva;
    }

    public String getPrefisso() {
        return this.prefisso;
    }
    
    public void setPrefisso(String prefisso) {
        this.prefisso = prefisso;
    }

    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDenominazione() {
        return this.denominazione;
    }
    
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascita() {
        return this.dataNascita;
    }
    
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getComuneNascita() {
        return this.comuneNascita;
    }
    
    public void setComuneNascita(String comuneNascita) {
        this.comuneNascita = comuneNascita;
    }

    public String getProvinciaNascita() {
        return this.provinciaNascita;
    }
    
    public void setProvinciaNascita(String provinciaNascita) {
        this.provinciaNascita = provinciaNascita;
    }

    public String getSesso() {
        return this.sesso;
    }
    
    public void setSesso(String sesso) {
        this.sesso = sesso;
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

    public String getIndirizzoDomicilio() {
        return this.indirizzoDomicilio;
    }
    
    public void setIndirizzoDomicilio(String indirizzoDomicilio) {
        this.indirizzoDomicilio = indirizzoDomicilio;
    }

    public String getCapDomicilio() {
        return this.capDomicilio;
    }
    
    public void setCapDomicilio(String capDomicilio) {
        this.capDomicilio = capDomicilio;
    }

    public String getComuneDomicilio() {
        return this.comuneDomicilio;
    }
    
    public void setComuneDomicilio(String comuneDomicilio) {
        this.comuneDomicilio = comuneDomicilio;
    }

    public String getProvinciaDomicilio() {
        return this.provinciaDomicilio;
    }
    
    public void setProvinciaDomicilio(String provinciaDomicilio) {
        this.provinciaDomicilio = provinciaDomicilio;
    }

    public String getCodiceFiscalerl() {
        return this.codiceFiscalerl;
    }
    
    public void setCodiceFiscalerl(String codiceFiscalerl) {
        this.codiceFiscalerl = codiceFiscalerl;
    }

    public String getPrefissorl() {
        return this.prefissorl;
    }
    
    public void setPrefissorl(String prefissorl) {
        this.prefissorl = prefissorl;
    }

    public String getTelefonorl() {
        return this.telefonorl;
    }
    
    public void setTelefonorl(String telefonorl) {
        this.telefonorl = telefonorl;
    }

    public String getCognomerl() {
        return this.cognomerl;
    }
    
    public void setCognomerl(String cognomerl) {
        this.cognomerl = cognomerl;
    }

    public String getNomerl() {
        return this.nomerl;
    }
    
    public void setNomerl(String nomerl) {
        this.nomerl = nomerl;
    }

    public String getDataNascitarl() {
        return this.dataNascitarl;
    }
    
    public void setDataNascitarl(String dataNascitarl) {
        this.dataNascitarl = dataNascitarl;
    }

    public String getComuneNascitarl() {
        return this.comuneNascitarl;
    }
    
    public void setComuneNascitarl(String comuneNascitarl) {
        this.comuneNascitarl = comuneNascitarl;
    }

    public String getProvinciaNascitarl() {
        return this.provinciaNascitarl;
    }
    
    public void setProvinciaNascitarl(String provinciaNascitarl) {
        this.provinciaNascitarl = provinciaNascitarl;
    }

    public String getSessorl() {
        return this.sessorl;
    }
    
    public void setSessorl(String sessorl) {
        this.sessorl = sessorl;
    }

    public String getIndirizzorl() {
        return this.indirizzorl;
    }
    
    public void setIndirizzorl(String indirizzorl) {
        this.indirizzorl = indirizzorl;
    }

    public String getCaprl() {
        return this.caprl;
    }
    
    public void setCaprl(String caprl) {
        this.caprl = caprl;
    }

    public String getComunerl() {
        return this.comunerl;
    }
    
    public void setComunerl(String comunerl) {
        this.comunerl = comunerl;
    }

    public String getProvinciarl() {
        return this.provinciarl;
    }
    
    public void setProvinciarl(String provinciarl) {
        this.provinciarl = provinciarl;
    }

    public String getIndirizzoDomiciliorl() {
        return this.indirizzoDomiciliorl;
    }
    
    public void setIndirizzoDomiciliorl(String indirizzoDomiciliorl) {
        this.indirizzoDomiciliorl = indirizzoDomiciliorl;
    }

    public String getCapDomiciliorl() {
        return this.capDomiciliorl;
    }
    
    public void setCapDomiciliorl(String capDomiciliorl) {
        this.capDomiciliorl = capDomiciliorl;
    }

    public String getComuneDomiciliorl() {
        return this.comuneDomiciliorl;
    }
    
    public void setComuneDomiciliorl(String comuneDomiciliorl) {
        this.comuneDomiciliorl = comuneDomiciliorl;
    }

    public String getProvinciaDomiciliorl() {
        return this.provinciaDomiciliorl;
    }
    
    public void setProvinciaDomiciliorl(String provinciaDomiciliorl) {
        this.provinciaDomiciliorl = provinciaDomiciliorl;
    }

    public Boolean getFlagRappresentanteLegale() {
        return this.flagRappresentanteLegale;
    }
    
    public void setFlagRappresentanteLegale(Boolean flagRappresentanteLegale) {
        this.flagRappresentanteLegale = flagRappresentanteLegale;
    }

    public Boolean getFlagCuratoreFallimentare() {
        return this.flagCuratoreFallimentare;
    }
    
    public void setFlagCuratoreFallimentare(Boolean flagCuratoreFallimentare) {
        this.flagCuratoreFallimentare = flagCuratoreFallimentare;
    }

    public Boolean getFlagTutore() {
        return this.flagTutore;
    }
    
    public void setFlagTutore(Boolean flagTutore) {
        this.flagTutore = flagTutore;
    }

    public Boolean getFlagErede() {
        return this.flagErede;
    }
    
    public void setFlagErede(Boolean flagErede) {
        this.flagErede = flagErede;
    }

    public String getAltraNatura() {
        return this.altraNatura;
    }
    
    public void setAltraNatura(String altraNatura) {
        this.altraNatura = altraNatura;
    }

    public Character getFlagPersona() {
        return this.flagPersona;
    }
    
    public void setFlagPersona(Character flagPersona) {
        this.flagPersona = flagPersona;
    }

    public Date getDataComunicazione() {
        return this.dataComunicazione;
    }
    
    public void setDataComunicazione(Date dataComunicazione) {
        this.dataComunicazione = dataComunicazione;
    }

    public Long getStato() {
        return this.stato;
    }
    
    public void setStato(Long stato) {
        this.stato = stato;
    }

    public String getPagine() {
        return this.pagine;
    }
    
    public void setPagine(String pagine) {
        this.pagine = pagine;
    }

    public Long getFlagElaborato() {
        return this.flagElaborato;
    }
    
    public void setFlagElaborato(Long flagElaborato) {
        this.flagElaborato = flagElaborato;
    }

    public Set<DocfaComunOggetto> getDocfaComunOggettos() {
        return this.docfaComunOggettos;
    }
    
    public void setDocfaComunOggettos(Set<DocfaComunOggetto> docfaComunOggettos) {
        this.docfaComunOggettos = docfaComunOggettos;
    }
   








}
