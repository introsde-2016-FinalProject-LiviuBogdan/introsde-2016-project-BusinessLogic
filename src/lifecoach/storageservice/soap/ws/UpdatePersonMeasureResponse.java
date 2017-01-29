
package lifecoach.storageservice.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import lifecoach.localdb.soap.ws.Measure;


/**
 * <p>Java class for updatePersonMeasureResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updatePersonMeasureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measureOut" type="{http://ws.soap.localdb.lifecoach/}measure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePersonMeasureResponse", propOrder = {
    "measureOut"
})
public class UpdatePersonMeasureResponse {

    protected Measure measureOut;

    /**
     * Gets the value of the measureOut property.
     * 
     * @return
     *     possible object is
     *     {@link Measure }
     *     
     */
    public Measure getMeasureOut() {
        return measureOut;
    }

    /**
     * Sets the value of the measureOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Measure }
     *     
     */
    public void setMeasureOut(Measure value) {
        this.measureOut = value;
    }

}
