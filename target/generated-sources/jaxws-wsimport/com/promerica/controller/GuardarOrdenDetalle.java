
package com.promerica.controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for guardarOrdenDetalle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guardarOrdenDetalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="detalle" type="{http://controller.promerica.com/}detalleOrden" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guardarOrdenDetalle", propOrder = {
    "detalle"
})
public class GuardarOrdenDetalle {

    protected DetalleOrden detalle;

    /**
     * Gets the value of the detalle property.
     * 
     * @return
     *     possible object is
     *     {@link DetalleOrden }
     *     
     */
    public DetalleOrden getDetalle() {
        return detalle;
    }

    /**
     * Sets the value of the detalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetalleOrden }
     *     
     */
    public void setDetalle(DetalleOrden value) {
        this.detalle = value;
    }

}
