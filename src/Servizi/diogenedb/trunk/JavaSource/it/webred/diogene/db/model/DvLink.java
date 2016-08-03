package it.webred.diogene.db.model;
// Generated 22-nov-2007 11.42.27 by Hibernate Tools 3.1.0.beta4

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * DvLink generated by hbm2java
 */

public class DvLink  implements java.io.Serializable {


    // Fields    

     private Long id;
     private DcEntityRel dcEntityRel;
     private Date elaborationDate;
     private Set dvKeyPairs = new HashSet(0);
     private Set dvLinkClasses = new HashSet(0);


    // Constructors

    /** default constructor */
    public DvLink() {
    }

	/** minimal constructor */
    public DvLink(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public DvLink(Long id, DcEntityRel dcEntityRel, Date elaborationDate, Set dvKeyPairs, Set dvLinkClasses) {
        this.id = id;
        this.dcEntityRel = dcEntityRel;
        this.elaborationDate = elaborationDate;
        this.dvKeyPairs = dvKeyPairs;
        this.dvLinkClasses = dvLinkClasses;
    }
    

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public DcEntityRel getDcEntityRel() {
        return this.dcEntityRel;
    }
    
    public void setDcEntityRel(DcEntityRel dcEntityRel) {
        this.dcEntityRel = dcEntityRel;
    }

    public Date getElaborationDate() {
        return this.elaborationDate;
    }
    
    public void setElaborationDate(Date elaborationDate) {
        this.elaborationDate = elaborationDate;
    }

    public Set getDvKeyPairs() {
        return this.dvKeyPairs;
    }
    
    public void setDvKeyPairs(Set dvKeyPairs) {
        this.dvKeyPairs = dvKeyPairs;
    }

    public Set getDvLinkClasses() {
        return this.dvLinkClasses;
    }
    
    public void setDvLinkClasses(Set dvLinkClasses) {
        this.dvLinkClasses = dvLinkClasses;
    }
   








}