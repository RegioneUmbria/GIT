package it.webred.mui.model;
// Generated 1-apr-2009 13.23.53 by Hibernate Tools 3.1.0.beta4



/**
 * MiDupFornituraInfo generated by hbm2java
 */

public class MiDupFornituraInfo  implements java.io.Serializable {


    // Fields    

     private long iid;
     private MiDupFornitura miDupFornitura;
     private String recordScritti;
     private String note;
     private String noteRegistrate;
     private String noteScartate;
     private String immobiliTrattati;
     private String particelle;
     private String fabbricati;


    // Constructors

    /** default constructor */
    public MiDupFornituraInfo() {
    }

	/** minimal constructor */
    public MiDupFornituraInfo(MiDupFornitura miDupFornitura) {
        this.miDupFornitura = miDupFornitura;
    }
    
    /** full constructor */
    public MiDupFornituraInfo(MiDupFornitura miDupFornitura, String recordScritti, String note, String noteRegistrate, String noteScartate, String immobiliTrattati, String particelle, String fabbricati) {
        this.miDupFornitura = miDupFornitura;
        this.recordScritti = recordScritti;
        this.note = note;
        this.noteRegistrate = noteRegistrate;
        this.noteScartate = noteScartate;
        this.immobiliTrattati = immobiliTrattati;
        this.particelle = particelle;
        this.fabbricati = fabbricati;
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

    public String getRecordScritti() {
        return this.recordScritti;
    }
    
    public void setRecordScritti(String recordScritti) {
        this.recordScritti = recordScritti;
    }

    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }

    public String getNoteRegistrate() {
        return this.noteRegistrate;
    }
    
    public void setNoteRegistrate(String noteRegistrate) {
        this.noteRegistrate = noteRegistrate;
    }

    public String getNoteScartate() {
        return this.noteScartate;
    }
    
    public void setNoteScartate(String noteScartate) {
        this.noteScartate = noteScartate;
    }

    public String getImmobiliTrattati() {
        return this.immobiliTrattati;
    }
    
    public void setImmobiliTrattati(String immobiliTrattati) {
        this.immobiliTrattati = immobiliTrattati;
    }

    public String getParticelle() {
        return this.particelle;
    }
    
    public void setParticelle(String particelle) {
        this.particelle = particelle;
    }

    public String getFabbricati() {
        return this.fabbricati;
    }
    
    public void setFabbricati(String fabbricati) {
        this.fabbricati = fabbricati;
    }
   








}
