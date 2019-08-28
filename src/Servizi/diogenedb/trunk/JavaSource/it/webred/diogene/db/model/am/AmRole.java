package it.webred.diogene.db.model.am;
// Generated 22-nov-2007 11.42.36 by Hibernate Tools 3.1.0.beta4

import java.util.HashSet;
import java.util.Set;


/**
 * AmRole generated by hbm2java
 */

public class AmRole  implements java.io.Serializable {


    // Fields    

     private String name;
     private Set amItemRoles = new HashSet(0);


    // Constructors

    /** default constructor */
    public AmRole() {
    }

	/** minimal constructor */
    public AmRole(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public AmRole(String name, Set amItemRoles) {
        this.name = name;
        this.amItemRoles = amItemRoles;
    }
    

   
    // Property accessors

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getAmItemRoles() {
        return this.amItemRoles;
    }
    
    public void setAmItemRoles(Set amItemRoles) {
        this.amItemRoles = amItemRoles;
    }
   








}
