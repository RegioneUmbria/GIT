//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.12.01 at 10:44:17 AM CET 
//


package it.webred.ct.service.jaxb.verificaCoordinate.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for tipoCatasto.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoCatasto">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Terreni"/>
 *     &lt;enumeration value="Fabbricati"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TipoCatasto {

    @XmlEnumValue("Fabbricati")
    FABBRICATI("Fabbricati"),
    @XmlEnumValue("Terreni")
    TERRENI("Terreni");
    private final String value;

    TipoCatasto(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoCatasto fromValue(String v) {
        for (TipoCatasto c: TipoCatasto.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
