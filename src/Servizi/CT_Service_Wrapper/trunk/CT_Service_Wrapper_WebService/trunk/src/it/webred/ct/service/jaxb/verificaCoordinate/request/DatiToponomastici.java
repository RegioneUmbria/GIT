//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.12.01 at 10:44:17 AM CET 
//


package it.webred.ct.service.jaxb.verificaCoordinate.request;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for datiToponomastici complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="datiToponomastici">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeVia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="civico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="esponente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceVia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datiToponomastici", propOrder = {
    "tipoArea",
    "nomeVia",
    "civico",
    "esponente",
    "codiceVia"
})
public class DatiToponomastici
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    protected String tipoArea;
    protected String nomeVia;
    protected String civico;
    protected String esponente;
    protected String codiceVia;

    /**
     * Gets the value of the tipoArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoArea() {
        return tipoArea;
    }

    /**
     * Sets the value of the tipoArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoArea(String value) {
        this.tipoArea = value;
    }

    public boolean isSetTipoArea() {
        return (this.tipoArea!= null);
    }

    /**
     * Gets the value of the nomeVia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeVia() {
        return nomeVia;
    }

    /**
     * Sets the value of the nomeVia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeVia(String value) {
        this.nomeVia = value;
    }

    public boolean isSetNomeVia() {
        return (this.nomeVia!= null);
    }

    /**
     * Gets the value of the civico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCivico() {
        return civico;
    }

    /**
     * Sets the value of the civico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCivico(String value) {
        this.civico = value;
    }

    public boolean isSetCivico() {
        return (this.civico!= null);
    }

    /**
     * Gets the value of the esponente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsponente() {
        return esponente;
    }

    /**
     * Sets the value of the esponente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsponente(String value) {
        this.esponente = value;
    }

    public boolean isSetEsponente() {
        return (this.esponente!= null);
    }

    /**
     * Gets the value of the codiceVia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceVia() {
        return codiceVia;
    }

    /**
     * Sets the value of the codiceVia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceVia(String value) {
        this.codiceVia = value;
    }

    public boolean isSetCodiceVia() {
        return (this.codiceVia!= null);
    }

}
