//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.12.01 at 10:44:17 AM CET 
//


package it.webred.ct.service.jaxb.verificaCoordinate.request;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for residenziale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="residenziale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categoriaEdilizia" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Civile"/>
 *               &lt;enumeration value="Economica"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="tipoIntervento" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Ristrutturazione"/>
 *               &lt;enumeration value="Nuova Costruzione"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ascensoreOrMin3mFT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="S"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="consistenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="superficie" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "residenziale", propOrder = {
    "categoriaEdilizia",
    "tipoIntervento",
    "ascensoreOrMin3MFT",
    "consistenza",
    "superficie"
})
public class Residenziale
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    protected String categoriaEdilizia;
    protected String tipoIntervento;
    @XmlElement(name = "ascensoreOrMin3mFT")
    protected String ascensoreOrMin3MFT;
    protected BigDecimal consistenza;
    protected BigDecimal superficie;

    /**
     * Gets the value of the categoriaEdilizia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoriaEdilizia() {
        return categoriaEdilizia;
    }

    /**
     * Sets the value of the categoriaEdilizia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoriaEdilizia(String value) {
        this.categoriaEdilizia = value;
    }

    public boolean isSetCategoriaEdilizia() {
        return (this.categoriaEdilizia!= null);
    }

    /**
     * Gets the value of the tipoIntervento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoIntervento() {
        return tipoIntervento;
    }

    /**
     * Sets the value of the tipoIntervento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoIntervento(String value) {
        this.tipoIntervento = value;
    }

    public boolean isSetTipoIntervento() {
        return (this.tipoIntervento!= null);
    }

    /**
     * Gets the value of the ascensoreOrMin3MFT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAscensoreOrMin3MFT() {
        return ascensoreOrMin3MFT;
    }

    /**
     * Sets the value of the ascensoreOrMin3MFT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAscensoreOrMin3MFT(String value) {
        this.ascensoreOrMin3MFT = value;
    }

    public boolean isSetAscensoreOrMin3MFT() {
        return (this.ascensoreOrMin3MFT!= null);
    }

    /**
     * Gets the value of the consistenza property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getConsistenza() {
        return consistenza;
    }

    /**
     * Sets the value of the consistenza property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setConsistenza(BigDecimal value) {
        this.consistenza = value;
    }

    public boolean isSetConsistenza() {
        return (this.consistenza!= null);
    }

    /**
     * Gets the value of the superficie property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSuperficie() {
        return superficie;
    }

    /**
     * Sets the value of the superficie property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSuperficie(BigDecimal value) {
        this.superficie = value;
    }

    public boolean isSetSuperficie() {
        return (this.superficie!= null);
    }

}
