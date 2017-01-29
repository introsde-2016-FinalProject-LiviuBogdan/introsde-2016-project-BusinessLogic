
package lifecoach.storageservice.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import lifecoach.localdb.soap.ws.HealthMeasureHistory;


/**
 * <p>Java class for readPersonMeasureResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonMeasureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="healthHistory" type="{http://ws.soap.localdb.lifecoach/}healthMeasureHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonMeasureResponse", propOrder = {
    "healthHistory"
})
public class ReadPersonMeasureResponse {

    protected HealthMeasureHistory healthHistory;

    /**
     * Gets the value of the healthHistory property.
     * 
     * @return
     *     possible object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public HealthMeasureHistory getHealthHistory() {
        return healthHistory;
    }

    /**
     * Sets the value of the healthHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public void setHealthHistory(HealthMeasureHistory value) {
        this.healthHistory = value;
    }

}
