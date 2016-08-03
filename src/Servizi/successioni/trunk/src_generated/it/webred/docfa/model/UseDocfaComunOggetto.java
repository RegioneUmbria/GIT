package it.webred.docfa.model;
// Generated 1-apr-2009 13.23.56 by Hibernate Tools 3.1.0.beta4

import java.math.BigDecimal;
import java.util.Date;


/**
 * UseDocfaComunOggetto generated by hbm2java
 */

public class UseDocfaComunOggetto  implements java.io.Serializable {


    // Fields    

     private BigDecimal iid;
     private DocfaComunicazione docfaComunicazione;
     private String iidProtocolloReg;
     private String iidFornitura;
     private String codiceVariazione;
     private String descVariazione;
     private Date decorrenza;
     private Boolean flagFabbricato;
     private Boolean flagAreaFabbricabile;
     private Boolean flagFabbricatoD;
     private Boolean flagTerrenoAgricolo;
     private String indirizzo;
     private String sezione;
     private String foglio;
     private String particella;
     private String subalterno;
     private String numeroProtocollo;
     private Date anno;
     private String categoria;
     private String classe;
     private Boolean flagRenditaPresunta;
     private Boolean flagRenditaDefinitiva;
     private Boolean flagValoreVenale;
     private Boolean flagCostiContabili;
     private Boolean flagRedditoDomenicale;
     private BigDecimal redditoEuro;
     private String sezioneVar;
     private String foglioVar;
     private String particellaVar;
     private String subalternoVar;
     private String numeroProtocolloVar;
     private Date annoVar;
     private String categoriaVar;
     private String classeVar;
     private BigDecimal percentualePossesso;
     private Boolean flagPossessoProprieta;
     private Boolean flagPossessoUsufrutto;
     private Boolean flagPossessoUso;
     private Boolean flagPossessoDirittoAbit;
     private Boolean flagPossessoSuperficie;
     private Boolean flagPossessoLeasing;
     private String altroPossesso;
     private Boolean flagAbitPrincipale;
     private Boolean flagAbitPrincipaleNm;
     private Long contitolariAbitPrincipale;
     private Boolean flagInagibile;
     private Boolean flagAgricolturaDiretta;
     private Boolean flagImmobileEscluso;
     private Boolean flagRiduzioneLocazione;
     private Boolean flagStorico;
     private Boolean flagDetrazioneDelib;
     private Boolean flagDetrazioneDelibNm;
     private Long membriNucleoFamiliare;
     private Boolean flagPensionato;
     private Boolean flagConiugePensionato;
     private Boolean flagInvalido;
     private Boolean flagDisoccupato;
     private Boolean flagMobilita;
     private Boolean flagInterinale;
     private Boolean flagCococo;
     private String graffato;


    // Constructors

    /** default constructor */
    public UseDocfaComunOggetto() {
    }

	/** minimal constructor */
    public UseDocfaComunOggetto(BigDecimal iid, DocfaComunicazione docfaComunicazione) {
        this.iid = iid;
        this.docfaComunicazione = docfaComunicazione;
    }
    
    /** full constructor */
    public UseDocfaComunOggetto(BigDecimal iid, DocfaComunicazione docfaComunicazione, String iidProtocolloReg, String iidFornitura, String codiceVariazione, String descVariazione, Date decorrenza, Boolean flagFabbricato, Boolean flagAreaFabbricabile, Boolean flagFabbricatoD, Boolean flagTerrenoAgricolo, String indirizzo, String sezione, String foglio, String particella, String subalterno, String numeroProtocollo, Date anno, String categoria, String classe, Boolean flagRenditaPresunta, Boolean flagRenditaDefinitiva, Boolean flagValoreVenale, Boolean flagCostiContabili, Boolean flagRedditoDomenicale, BigDecimal redditoEuro, String sezioneVar, String foglioVar, String particellaVar, String subalternoVar, String numeroProtocolloVar, Date annoVar, String categoriaVar, String classeVar, BigDecimal percentualePossesso, Boolean flagPossessoProprieta, Boolean flagPossessoUsufrutto, Boolean flagPossessoUso, Boolean flagPossessoDirittoAbit, Boolean flagPossessoSuperficie, Boolean flagPossessoLeasing, String altroPossesso, Boolean flagAbitPrincipale, Boolean flagAbitPrincipaleNm, Long contitolariAbitPrincipale, Boolean flagInagibile, Boolean flagAgricolturaDiretta, Boolean flagImmobileEscluso, Boolean flagRiduzioneLocazione, Boolean flagStorico, Boolean flagDetrazioneDelib, Boolean flagDetrazioneDelibNm, Long membriNucleoFamiliare, Boolean flagPensionato, Boolean flagConiugePensionato, Boolean flagInvalido, Boolean flagDisoccupato, Boolean flagMobilita, Boolean flagInterinale, Boolean flagCococo, String graffato) {
        this.iid = iid;
        this.docfaComunicazione = docfaComunicazione;
        this.iidProtocolloReg = iidProtocolloReg;
        this.iidFornitura = iidFornitura;
        this.codiceVariazione = codiceVariazione;
        this.descVariazione = descVariazione;
        this.decorrenza = decorrenza;
        this.flagFabbricato = flagFabbricato;
        this.flagAreaFabbricabile = flagAreaFabbricabile;
        this.flagFabbricatoD = flagFabbricatoD;
        this.flagTerrenoAgricolo = flagTerrenoAgricolo;
        this.indirizzo = indirizzo;
        this.sezione = sezione;
        this.foglio = foglio;
        this.particella = particella;
        this.subalterno = subalterno;
        this.numeroProtocollo = numeroProtocollo;
        this.anno = anno;
        this.categoria = categoria;
        this.classe = classe;
        this.flagRenditaPresunta = flagRenditaPresunta;
        this.flagRenditaDefinitiva = flagRenditaDefinitiva;
        this.flagValoreVenale = flagValoreVenale;
        this.flagCostiContabili = flagCostiContabili;
        this.flagRedditoDomenicale = flagRedditoDomenicale;
        this.redditoEuro = redditoEuro;
        this.sezioneVar = sezioneVar;
        this.foglioVar = foglioVar;
        this.particellaVar = particellaVar;
        this.subalternoVar = subalternoVar;
        this.numeroProtocolloVar = numeroProtocolloVar;
        this.annoVar = annoVar;
        this.categoriaVar = categoriaVar;
        this.classeVar = classeVar;
        this.percentualePossesso = percentualePossesso;
        this.flagPossessoProprieta = flagPossessoProprieta;
        this.flagPossessoUsufrutto = flagPossessoUsufrutto;
        this.flagPossessoUso = flagPossessoUso;
        this.flagPossessoDirittoAbit = flagPossessoDirittoAbit;
        this.flagPossessoSuperficie = flagPossessoSuperficie;
        this.flagPossessoLeasing = flagPossessoLeasing;
        this.altroPossesso = altroPossesso;
        this.flagAbitPrincipale = flagAbitPrincipale;
        this.flagAbitPrincipaleNm = flagAbitPrincipaleNm;
        this.contitolariAbitPrincipale = contitolariAbitPrincipale;
        this.flagInagibile = flagInagibile;
        this.flagAgricolturaDiretta = flagAgricolturaDiretta;
        this.flagImmobileEscluso = flagImmobileEscluso;
        this.flagRiduzioneLocazione = flagRiduzioneLocazione;
        this.flagStorico = flagStorico;
        this.flagDetrazioneDelib = flagDetrazioneDelib;
        this.flagDetrazioneDelibNm = flagDetrazioneDelibNm;
        this.membriNucleoFamiliare = membriNucleoFamiliare;
        this.flagPensionato = flagPensionato;
        this.flagConiugePensionato = flagConiugePensionato;
        this.flagInvalido = flagInvalido;
        this.flagDisoccupato = flagDisoccupato;
        this.flagMobilita = flagMobilita;
        this.flagInterinale = flagInterinale;
        this.flagCococo = flagCococo;
        this.graffato = graffato;
    }
    

   
    // Property accessors

    public BigDecimal getIid() {
        return this.iid;
    }
    
    public void setIid(BigDecimal iid) {
        this.iid = iid;
    }

    public DocfaComunicazione getDocfaComunicazione() {
        return this.docfaComunicazione;
    }
    
    public void setDocfaComunicazione(DocfaComunicazione docfaComunicazione) {
        this.docfaComunicazione = docfaComunicazione;
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

    public String getCodiceVariazione() {
        return this.codiceVariazione;
    }
    
    public void setCodiceVariazione(String codiceVariazione) {
        this.codiceVariazione = codiceVariazione;
    }

    public String getDescVariazione() {
        return this.descVariazione;
    }
    
    public void setDescVariazione(String descVariazione) {
        this.descVariazione = descVariazione;
    }

    public Date getDecorrenza() {
        return this.decorrenza;
    }
    
    public void setDecorrenza(Date decorrenza) {
        this.decorrenza = decorrenza;
    }

    public Boolean getFlagFabbricato() {
        return this.flagFabbricato;
    }
    
    public void setFlagFabbricato(Boolean flagFabbricato) {
        this.flagFabbricato = flagFabbricato;
    }

    public Boolean getFlagAreaFabbricabile() {
        return this.flagAreaFabbricabile;
    }
    
    public void setFlagAreaFabbricabile(Boolean flagAreaFabbricabile) {
        this.flagAreaFabbricabile = flagAreaFabbricabile;
    }

    public Boolean getFlagFabbricatoD() {
        return this.flagFabbricatoD;
    }
    
    public void setFlagFabbricatoD(Boolean flagFabbricatoD) {
        this.flagFabbricatoD = flagFabbricatoD;
    }

    public Boolean getFlagTerrenoAgricolo() {
        return this.flagTerrenoAgricolo;
    }
    
    public void setFlagTerrenoAgricolo(Boolean flagTerrenoAgricolo) {
        this.flagTerrenoAgricolo = flagTerrenoAgricolo;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }
    
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getSezione() {
        return this.sezione;
    }
    
    public void setSezione(String sezione) {
        this.sezione = sezione;
    }

    public String getFoglio() {
        return this.foglio;
    }
    
    public void setFoglio(String foglio) {
        this.foglio = foglio;
    }

    public String getParticella() {
        return this.particella;
    }
    
    public void setParticella(String particella) {
        this.particella = particella;
    }

    public String getSubalterno() {
        return this.subalterno;
    }
    
    public void setSubalterno(String subalterno) {
        this.subalterno = subalterno;
    }

    public String getNumeroProtocollo() {
        return this.numeroProtocollo;
    }
    
    public void setNumeroProtocollo(String numeroProtocollo) {
        this.numeroProtocollo = numeroProtocollo;
    }

    public Date getAnno() {
        return this.anno;
    }
    
    public void setAnno(Date anno) {
        this.anno = anno;
    }

    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClasse() {
        return this.classe;
    }
    
    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Boolean getFlagRenditaPresunta() {
        return this.flagRenditaPresunta;
    }
    
    public void setFlagRenditaPresunta(Boolean flagRenditaPresunta) {
        this.flagRenditaPresunta = flagRenditaPresunta;
    }

    public Boolean getFlagRenditaDefinitiva() {
        return this.flagRenditaDefinitiva;
    }
    
    public void setFlagRenditaDefinitiva(Boolean flagRenditaDefinitiva) {
        this.flagRenditaDefinitiva = flagRenditaDefinitiva;
    }

    public Boolean getFlagValoreVenale() {
        return this.flagValoreVenale;
    }
    
    public void setFlagValoreVenale(Boolean flagValoreVenale) {
        this.flagValoreVenale = flagValoreVenale;
    }

    public Boolean getFlagCostiContabili() {
        return this.flagCostiContabili;
    }
    
    public void setFlagCostiContabili(Boolean flagCostiContabili) {
        this.flagCostiContabili = flagCostiContabili;
    }

    public Boolean getFlagRedditoDomenicale() {
        return this.flagRedditoDomenicale;
    }
    
    public void setFlagRedditoDomenicale(Boolean flagRedditoDomenicale) {
        this.flagRedditoDomenicale = flagRedditoDomenicale;
    }

    public BigDecimal getRedditoEuro() {
        return this.redditoEuro;
    }
    
    public void setRedditoEuro(BigDecimal redditoEuro) {
        this.redditoEuro = redditoEuro;
    }

    public String getSezioneVar() {
        return this.sezioneVar;
    }
    
    public void setSezioneVar(String sezioneVar) {
        this.sezioneVar = sezioneVar;
    }

    public String getFoglioVar() {
        return this.foglioVar;
    }
    
    public void setFoglioVar(String foglioVar) {
        this.foglioVar = foglioVar;
    }

    public String getParticellaVar() {
        return this.particellaVar;
    }
    
    public void setParticellaVar(String particellaVar) {
        this.particellaVar = particellaVar;
    }

    public String getSubalternoVar() {
        return this.subalternoVar;
    }
    
    public void setSubalternoVar(String subalternoVar) {
        this.subalternoVar = subalternoVar;
    }

    public String getNumeroProtocolloVar() {
        return this.numeroProtocolloVar;
    }
    
    public void setNumeroProtocolloVar(String numeroProtocolloVar) {
        this.numeroProtocolloVar = numeroProtocolloVar;
    }

    public Date getAnnoVar() {
        return this.annoVar;
    }
    
    public void setAnnoVar(Date annoVar) {
        this.annoVar = annoVar;
    }

    public String getCategoriaVar() {
        return this.categoriaVar;
    }
    
    public void setCategoriaVar(String categoriaVar) {
        this.categoriaVar = categoriaVar;
    }

    public String getClasseVar() {
        return this.classeVar;
    }
    
    public void setClasseVar(String classeVar) {
        this.classeVar = classeVar;
    }

    public BigDecimal getPercentualePossesso() {
        return this.percentualePossesso;
    }
    
    public void setPercentualePossesso(BigDecimal percentualePossesso) {
        this.percentualePossesso = percentualePossesso;
    }

    public Boolean getFlagPossessoProprieta() {
        return this.flagPossessoProprieta;
    }
    
    public void setFlagPossessoProprieta(Boolean flagPossessoProprieta) {
        this.flagPossessoProprieta = flagPossessoProprieta;
    }

    public Boolean getFlagPossessoUsufrutto() {
        return this.flagPossessoUsufrutto;
    }
    
    public void setFlagPossessoUsufrutto(Boolean flagPossessoUsufrutto) {
        this.flagPossessoUsufrutto = flagPossessoUsufrutto;
    }

    public Boolean getFlagPossessoUso() {
        return this.flagPossessoUso;
    }
    
    public void setFlagPossessoUso(Boolean flagPossessoUso) {
        this.flagPossessoUso = flagPossessoUso;
    }

    public Boolean getFlagPossessoDirittoAbit() {
        return this.flagPossessoDirittoAbit;
    }
    
    public void setFlagPossessoDirittoAbit(Boolean flagPossessoDirittoAbit) {
        this.flagPossessoDirittoAbit = flagPossessoDirittoAbit;
    }

    public Boolean getFlagPossessoSuperficie() {
        return this.flagPossessoSuperficie;
    }
    
    public void setFlagPossessoSuperficie(Boolean flagPossessoSuperficie) {
        this.flagPossessoSuperficie = flagPossessoSuperficie;
    }

    public Boolean getFlagPossessoLeasing() {
        return this.flagPossessoLeasing;
    }
    
    public void setFlagPossessoLeasing(Boolean flagPossessoLeasing) {
        this.flagPossessoLeasing = flagPossessoLeasing;
    }

    public String getAltroPossesso() {
        return this.altroPossesso;
    }
    
    public void setAltroPossesso(String altroPossesso) {
        this.altroPossesso = altroPossesso;
    }

    public Boolean getFlagAbitPrincipale() {
        return this.flagAbitPrincipale;
    }
    
    public void setFlagAbitPrincipale(Boolean flagAbitPrincipale) {
        this.flagAbitPrincipale = flagAbitPrincipale;
    }

    public Boolean getFlagAbitPrincipaleNm() {
        return this.flagAbitPrincipaleNm;
    }
    
    public void setFlagAbitPrincipaleNm(Boolean flagAbitPrincipaleNm) {
        this.flagAbitPrincipaleNm = flagAbitPrincipaleNm;
    }

    public Long getContitolariAbitPrincipale() {
        return this.contitolariAbitPrincipale;
    }
    
    public void setContitolariAbitPrincipale(Long contitolariAbitPrincipale) {
        this.contitolariAbitPrincipale = contitolariAbitPrincipale;
    }

    public Boolean getFlagInagibile() {
        return this.flagInagibile;
    }
    
    public void setFlagInagibile(Boolean flagInagibile) {
        this.flagInagibile = flagInagibile;
    }

    public Boolean getFlagAgricolturaDiretta() {
        return this.flagAgricolturaDiretta;
    }
    
    public void setFlagAgricolturaDiretta(Boolean flagAgricolturaDiretta) {
        this.flagAgricolturaDiretta = flagAgricolturaDiretta;
    }

    public Boolean getFlagImmobileEscluso() {
        return this.flagImmobileEscluso;
    }
    
    public void setFlagImmobileEscluso(Boolean flagImmobileEscluso) {
        this.flagImmobileEscluso = flagImmobileEscluso;
    }

    public Boolean getFlagRiduzioneLocazione() {
        return this.flagRiduzioneLocazione;
    }
    
    public void setFlagRiduzioneLocazione(Boolean flagRiduzioneLocazione) {
        this.flagRiduzioneLocazione = flagRiduzioneLocazione;
    }

    public Boolean getFlagStorico() {
        return this.flagStorico;
    }
    
    public void setFlagStorico(Boolean flagStorico) {
        this.flagStorico = flagStorico;
    }

    public Boolean getFlagDetrazioneDelib() {
        return this.flagDetrazioneDelib;
    }
    
    public void setFlagDetrazioneDelib(Boolean flagDetrazioneDelib) {
        this.flagDetrazioneDelib = flagDetrazioneDelib;
    }

    public Boolean getFlagDetrazioneDelibNm() {
        return this.flagDetrazioneDelibNm;
    }
    
    public void setFlagDetrazioneDelibNm(Boolean flagDetrazioneDelibNm) {
        this.flagDetrazioneDelibNm = flagDetrazioneDelibNm;
    }

    public Long getMembriNucleoFamiliare() {
        return this.membriNucleoFamiliare;
    }
    
    public void setMembriNucleoFamiliare(Long membriNucleoFamiliare) {
        this.membriNucleoFamiliare = membriNucleoFamiliare;
    }

    public Boolean getFlagPensionato() {
        return this.flagPensionato;
    }
    
    public void setFlagPensionato(Boolean flagPensionato) {
        this.flagPensionato = flagPensionato;
    }

    public Boolean getFlagConiugePensionato() {
        return this.flagConiugePensionato;
    }
    
    public void setFlagConiugePensionato(Boolean flagConiugePensionato) {
        this.flagConiugePensionato = flagConiugePensionato;
    }

    public Boolean getFlagInvalido() {
        return this.flagInvalido;
    }
    
    public void setFlagInvalido(Boolean flagInvalido) {
        this.flagInvalido = flagInvalido;
    }

    public Boolean getFlagDisoccupato() {
        return this.flagDisoccupato;
    }
    
    public void setFlagDisoccupato(Boolean flagDisoccupato) {
        this.flagDisoccupato = flagDisoccupato;
    }

    public Boolean getFlagMobilita() {
        return this.flagMobilita;
    }
    
    public void setFlagMobilita(Boolean flagMobilita) {
        this.flagMobilita = flagMobilita;
    }

    public Boolean getFlagInterinale() {
        return this.flagInterinale;
    }
    
    public void setFlagInterinale(Boolean flagInterinale) {
        this.flagInterinale = flagInterinale;
    }

    public Boolean getFlagCococo() {
        return this.flagCococo;
    }
    
    public void setFlagCococo(Boolean flagCococo) {
        this.flagCococo = flagCococo;
    }

    public String getGraffato() {
        return this.graffato;
    }
    
    public void setGraffato(String graffato) {
        this.graffato = graffato;
    }
   








}
