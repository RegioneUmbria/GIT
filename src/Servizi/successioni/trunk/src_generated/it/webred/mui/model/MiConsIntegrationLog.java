package it.webred.mui.model;
// Generated 1-apr-2009 13.23.57 by Hibernate Tools 3.1.0.beta4



/**
 * MiConsIntegrationLog generated by hbm2java
 */

public class MiConsIntegrationLog  implements java.io.Serializable {


    // Fields    

     private long iid;
     private MiConsComunicazione miConsComunicazione;
     private String tabellaRecord;
     private String colonnaRegolaInfranta;
     private String codiceRegolaInfranta;
     private String note;
     private MiConsOggetto miConsOggetto;
     private MiDupFornitura miDupFornitura;


    // Constructors

    /** default constructor */
    public MiConsIntegrationLog() {
    }

	/** minimal constructor */
    public MiConsIntegrationLog(MiConsComunicazione miConsComunicazione, MiDupFornitura miDupFornitura) {
        this.miConsComunicazione = miConsComunicazione;
        this.miDupFornitura = miDupFornitura;
    }
    
    /** full constructor */
    public MiConsIntegrationLog(MiConsComunicazione miConsComunicazione, String tabellaRecord, String colonnaRegolaInfranta, String codiceRegolaInfranta, String note, MiConsOggetto miConsOggetto, MiDupFornitura miDupFornitura) {
        this.miConsComunicazione = miConsComunicazione;
        this.tabellaRecord = tabellaRecord;
        this.colonnaRegolaInfranta = colonnaRegolaInfranta;
        this.codiceRegolaInfranta = codiceRegolaInfranta;
        this.note = note;
        this.miConsOggetto = miConsOggetto;
        this.miDupFornitura = miDupFornitura;
    }
    

   
    // Property accessors

    public long getIid() {
        return this.iid;
    }
    
    public void setIid(long iid) {
        this.iid = iid;
    }

    public MiConsComunicazione getMiConsComunicazione() {
        return this.miConsComunicazione;
    }
    
    public void setMiConsComunicazione(MiConsComunicazione miConsComunicazione) {
        this.miConsComunicazione = miConsComunicazione;
    }

    public String getTabellaRecord() {
        return this.tabellaRecord;
    }
    
    public void setTabellaRecord(String tabellaRecord) {
        this.tabellaRecord = tabellaRecord;
    }

    public String getColonnaRegolaInfranta() {
        return this.colonnaRegolaInfranta;
    }
    
    public void setColonnaRegolaInfranta(String colonnaRegolaInfranta) {
        this.colonnaRegolaInfranta = colonnaRegolaInfranta;
    }

    public String getCodiceRegolaInfranta() {
        return this.codiceRegolaInfranta;
    }
    
    public void setCodiceRegolaInfranta(String codiceRegolaInfranta) {
        this.codiceRegolaInfranta = codiceRegolaInfranta;
    }

    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }

    public MiConsOggetto getMiConsOggetto() {
        return this.miConsOggetto;
    }
    
    public void setMiConsOggetto(MiConsOggetto miConsOggetto) {
        this.miConsOggetto = miConsOggetto;
    }

    public MiDupFornitura getMiDupFornitura() {
        return this.miDupFornitura;
    }
    
    public void setMiDupFornitura(MiDupFornitura miDupFornitura) {
        this.miDupFornitura = miDupFornitura;
    }
   








}
