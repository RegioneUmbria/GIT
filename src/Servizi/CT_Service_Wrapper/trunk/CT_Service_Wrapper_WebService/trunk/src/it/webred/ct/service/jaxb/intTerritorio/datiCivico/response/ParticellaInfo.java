//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.11.04 at 03:21:54 PM CET 
//


package it.webred.ct.service.jaxb.intTerritorio.datiCivico.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for particellaInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="particellaInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="particella" type="{}particellaKey" minOccurs="0"/>
 *         &lt;element name="subalterni" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="indirizzi" type="{}indirizzo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="infoPerCategoria" type="{}infoPerCategoria" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "particellaInfo", propOrder = {
    "particella",
    "subalterni",
    "indirizzi",
    "infoPerCategoria"
})
public class ParticellaInfo
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    protected ParticellaKey particella;
    @XmlElement(required = true)
    protected List<String> subalterni;
    @XmlElement(required = true)
    protected List<Indirizzo> indirizzi;
    @XmlElement(required = true)
    protected List<InfoPerCategoria> infoPerCategoria;

    /**
     * Gets the value of the particella property.
     * 
     * @return
     *     possible object is
     *     {@link ParticellaKey }
     *     
     */
    public ParticellaKey getParticella() {
        return particella;
    }

    /**
     * Sets the value of the particella property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticellaKey }
     *     
     */
    public void setParticella(ParticellaKey value) {
        this.particella = value;
    }

    public boolean isSetParticella() {
        return (this.particella!= null);
    }

    /**
     * Gets the value of the subalterni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subalterni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubalterni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSubalterni() {
        if (subalterni == null) {
            subalterni = new ArrayList<String>();
        }
        return this.subalterni;
    }

    public boolean isSetSubalterni() {
        return ((this.subalterni!= null)&&(!this.subalterni.isEmpty()));
    }

    public void unsetSubalterni() {
        this.subalterni = null;
    }

    /**
     * Gets the value of the indirizzi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indirizzi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndirizzi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Indirizzo }
     * 
     * 
     */
    public List<Indirizzo> getIndirizzi() {
        if (indirizzi == null) {
            indirizzi = new ArrayList<Indirizzo>();
        }
        return this.indirizzi;
    }

    public boolean isSetIndirizzi() {
        return ((this.indirizzi!= null)&&(!this.indirizzi.isEmpty()));
    }

    public void unsetIndirizzi() {
        this.indirizzi = null;
    }

    /**
     * Gets the value of the infoPerCategoria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infoPerCategoria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoPerCategoria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfoPerCategoria }
     * 
     * 
     */
    public List<InfoPerCategoria> getInfoPerCategoria() {
        if (infoPerCategoria == null) {
            infoPerCategoria = new ArrayList<InfoPerCategoria>();
        }
        return this.infoPerCategoria;
    }

    public boolean isSetInfoPerCategoria() {
        return ((this.infoPerCategoria!= null)&&(!this.infoPerCategoria.isEmpty()));
    }

    public void unsetInfoPerCategoria() {
        this.infoPerCategoria = null;
    }

}
