package it.webred.mui.model;
// Generated 1-apr-2009 13.23.58 by Hibernate Tools 3.1.0.beta4



/**
 * MiDupUserRole generated by hbm2java
 */

public class MiDupUserRole  implements java.io.Serializable {


    // Fields    

     private long iid;
     private MiDupUser miDupUser;
     private String rolename;


    // Constructors

    /** default constructor */
    public MiDupUserRole() {
    }

    
    /** full constructor */
    public MiDupUserRole(MiDupUser miDupUser, String rolename) {
        this.miDupUser = miDupUser;
        this.rolename = rolename;
    }
    

   
    // Property accessors

    public long getIid() {
        return this.iid;
    }
    
    public void setIid(long iid) {
        this.iid = iid;
    }

    public MiDupUser getMiDupUser() {
        return this.miDupUser;
    }
    
    public void setMiDupUser(MiDupUser miDupUser) {
        this.miDupUser = miDupUser;
    }

    public String getRolename() {
        return this.rolename;
    }
    
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
   








}
