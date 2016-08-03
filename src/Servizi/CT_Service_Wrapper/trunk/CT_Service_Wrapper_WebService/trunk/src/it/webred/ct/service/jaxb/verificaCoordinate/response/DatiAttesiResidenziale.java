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
 * <p>Java class for datiAttesiResidenziale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="datiAttesiResidenziale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classiMaxCategoria" type="{}classiMaxCategoria" minOccurs="0"/>
 *         &lt;element name="classamenti" type="{}classamenti" minOccurs="0"/>
 *         &lt;element name="valoreCommercialeMq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valoreCommerciale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="renditaMinima" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tariffaPerVano" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datiAttesiResidenziale", propOrder = {
    "classiMaxCategoria",
    "classamenti",
    "valoreCommercialeMq",
    "valoreCommerciale",
    "renditaMinima",
    "tariffaPerVano"
})
public class DatiAttesiResidenziale
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    protected ClassiMaxCategoria classiMaxCategoria;
    protected Classamenti classamenti;
    protected String valoreCommercialeMq;
    protected String valoreCommerciale;
    protected String renditaMinima;
    protected String tariffaPerVano;

    /**
     * Gets the value of the classiMaxCategoria property.
     * 
     * @return
     *     possible object is
     *     {@link ClassiMaxCategoria }
     *     
     */
    public ClassiMaxCategoria getClassiMaxCategoria() {
        return classiMaxCategoria;
    }

    /**
     * Sets the value of the classiMaxCategoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassiMaxCategoria }
     *     
     */
    public void setClassiMaxCategoria(ClassiMaxCategoria value) {
        this.classiMaxCategoria = value;
    }

    public boolean isSetClassiMaxCategoria() {
        return (this.classiMaxCategoria!= null);
    }

    /**
     * Gets the value of the classamenti property.
     * 
     * @return
     *     possible object is
     *     {@link Classamenti }
     *     
     */
    public Classamenti getClassamenti() {
        return classamenti;
    }

    /**
     * Sets the value of the classamenti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Classamenti }
     *     
     */
    public void setClassamenti(Classamenti value) {
        this.classamenti = value;
    }

    public boolean isSetClassamenti() {
        return (this.classamenti!= null);
    }

    /**
     * Gets the value of the valoreCommercialeMq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValoreCommercialeMq() {
        return valoreCommercialeMq;
    }

    /**
     * Sets the value of the valoreCommercialeMq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValoreCommercialeMq(String value) {
        this.valoreCommercialeMq = value;
    }

    public boolean isSetValoreCommercialeMq() {
        return (this.valoreCommercialeMq!= null);
    }

    /**
     * Gets the value of the valoreCommerciale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValoreCommerciale() {
        return valoreCommerciale;
    }

    /**
     * Sets the value of the valoreCommerciale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValoreCommerciale(String value) {
        this.valoreCommerciale = value;
    }

    public boolean isSetValoreCommerciale() {
        return (this.valoreCommerciale!= null);
    }

    /**
     * Gets the value of the renditaMinima property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenditaMinima() {
        return renditaMinima;
    }

    /**
     * Sets the value of the renditaMinima property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenditaMinima(String value) {
        this.renditaMinima = value;
    }

    public boolean isSetRenditaMinima() {
        return (this.renditaMinima!= null);
    }

    /**
     * Gets the value of the tariffaPerVano property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffaPerVano() {
        return tariffaPerVano;
    }

    /**
     * Sets the value of the tariffaPerVano property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffaPerVano(String value) {
        this.tariffaPerVano = value;
    }

    public boolean isSetTariffaPerVano() {
        return (this.tariffaPerVano!= null);
    }

}