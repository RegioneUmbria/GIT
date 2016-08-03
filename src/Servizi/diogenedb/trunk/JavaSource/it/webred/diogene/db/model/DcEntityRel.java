package it.webred.diogene.db.model;
// Generated 22-nov-2007 11.42.27 by Hibernate Tools 3.1.0.beta4

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * DcEntityRel generated by hbm2java
 */

public class DcEntityRel  implements java.io.Serializable {


    // Fields    

     private Long id;
     private DcRel dcRel;
     private DcEntity dcEntityByFkDcEntity2;
     private DcEntity dcEntityByFkDcEntity1;
     private String userIns;
     private Date dtIns;
     private String userMod;
     private Date dtMod;
     private Set dvLinks = new HashSet(0);


    // Constructors

    /** default constructor */
    public DcEntityRel() {
    }

	/** minimal constructor */
    public DcEntityRel(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public DcEntityRel(Long id, DcRel dcRel, DcEntity dcEntityByFkDcEntity2, DcEntity dcEntityByFkDcEntity1, String userIns, Date dtIns, String userMod, Date dtMod, Set dvLinks) {
        this.id = id;
        this.dcRel = dcRel;
        this.dcEntityByFkDcEntity2 = dcEntityByFkDcEntity2;
        this.dcEntityByFkDcEntity1 = dcEntityByFkDcEntity1;
        this.userIns = userIns;
        this.dtIns = dtIns;
        this.userMod = userMod;
        this.dtMod = dtMod;
        this.dvLinks = dvLinks;
    }
    

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public DcRel getDcRel() {
        return this.dcRel;
    }
    
    public void setDcRel(DcRel dcRel) {
        this.dcRel = dcRel;
    }

    public DcEntity getDcEntityByFkDcEntity2() {
        return this.dcEntityByFkDcEntity2;
    }
    
    public void setDcEntityByFkDcEntity2(DcEntity dcEntityByFkDcEntity2) {
        this.dcEntityByFkDcEntity2 = dcEntityByFkDcEntity2;
    }

    public DcEntity getDcEntityByFkDcEntity1() {
        return this.dcEntityByFkDcEntity1;
    }
    
    public void setDcEntityByFkDcEntity1(DcEntity dcEntityByFkDcEntity1) {
        this.dcEntityByFkDcEntity1 = dcEntityByFkDcEntity1;
    }

    public String getUserIns() {
        return this.userIns;
    }
    
    public void setUserIns(String userIns) {
        this.userIns = userIns;
    }

    public Date getDtIns() {
        return this.dtIns;
    }
    
    public void setDtIns(Date dtIns) {
        this.dtIns = dtIns;
    }

    public String getUserMod() {
        return this.userMod;
    }
    
    public void setUserMod(String userMod) {
        this.userMod = userMod;
    }

    public Date getDtMod() {
        return this.dtMod;
    }
    
    public void setDtMod(Date dtMod) {
        this.dtMod = dtMod;
    }

    public Set getDvLinks() {
        return this.dvLinks;
    }
    
    public void setDvLinks(Set dvLinks) {
        this.dvLinks = dvLinks;
    }
   








}
