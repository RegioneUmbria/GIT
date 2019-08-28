package it.webred.diogene.db.model;
// Generated 22-nov-2007 11.42.26 by Hibernate Tools 3.1.0.beta4



/**
 * DcSchemaEntity generated by hbm2java
 */

public class DcSchemaEntity  implements java.io.Serializable {


    // Fields    

     private Long id;
     private DcEntity dcEntity;
     private String sqlName;


    // Constructors

    /** default constructor */
    public DcSchemaEntity() {
    }

	/** minimal constructor */
    public DcSchemaEntity(Long id, String sqlName) {
        this.id = id;
        this.sqlName = sqlName;
    }
    
    /** full constructor */
    public DcSchemaEntity(Long id, DcEntity dcEntity, String sqlName) {
        this.id = id;
        this.dcEntity = dcEntity;
        this.sqlName = sqlName;
    }
    

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public DcEntity getDcEntity() {
        return this.dcEntity;
    }
    
    public void setDcEntity(DcEntity dcEntity) {
        this.dcEntity = dcEntity;
    }

    public String getSqlName() {
        return this.sqlName;
    }
    
    public void setSqlName(String sqlName) {
        this.sqlName = sqlName;
    }
   








}
