package it.webred.diogene.db.model;
// Generated 22-nov-2007 11.42.27 by Hibernate Tools 3.1.0.beta4

import java.util.HashSet;
import java.util.Set;


/**
 * DcTipoe generated by hbm2java
 */

public class DcTipoe  implements java.io.Serializable {


    // Fields    

     private Long id;
     private DvTema dvTema;
     private String name;
     private Set dcTipoeColumns = new HashSet(0);


    // Constructors

    /** default constructor */
    public DcTipoe() {
    }

	/** minimal constructor */
    public DcTipoe(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /** full constructor */
    public DcTipoe(Long id, DvTema dvTema, String name, Set dcTipoeColumns) {
        this.id = id;
        this.dvTema = dvTema;
        this.name = name;
        this.dcTipoeColumns = dcTipoeColumns;
    }
    

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public DvTema getDvTema() {
        return this.dvTema;
    }
    
    public void setDvTema(DvTema dvTema) {
        this.dvTema = dvTema;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getDcTipoeColumns() {
        return this.dcTipoeColumns;
    }
    
    public void setDcTipoeColumns(Set dcTipoeColumns) {
        this.dcTipoeColumns = dcTipoeColumns;
    }
   








}
