//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.05 at 12:57:11 PM CEST 
//


package it.webred.ct.service.jaxb.verificaCoordinate.response;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for datiAttesiNonResidenziale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="datiAttesiNonResidenziale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classeMediaRiferimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datiAttesiNonResidenziale", propOrder = {
    "classeMediaRiferimento"
})
public class DatiAttesiNonResidenziale
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    protected String classeMediaRiferimento;

    /**
     * Gets the value of the classeMediaRiferimento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClasseMediaRiferimento() {
        return classeMediaRiferimento;
    }

    /**
     * Sets the value of the classeMediaRiferimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClasseMediaRiferimento(String value) {
        this.classeMediaRiferimento = value;
    }

    public boolean isSetClasseMediaRiferimento() {
        return (this.classeMediaRiferimento!= null);
    }

}
