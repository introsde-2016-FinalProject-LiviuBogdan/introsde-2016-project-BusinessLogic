
package lifecoach.storageservice.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import lifecoach.localdb.soap.ws.HealthMeasureHistory;


/**
 * <p>Java class for updatePersonHistoryMeasure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updatePersonHistoryMeasure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="measureHistory" type="{http://ws.soap.localdb.lifecoach/}healthMeasureHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePersonHistoryMeasure", propOrder = {
    "personId",
    "measureHistory"
})
public class UpdatePersonHistoryMeasure {

    protected long personId;
    protected HealthMeasureHistory measureHistory;

    /**
     * Gets the value of the personId property.
     * 
     */
    public long getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     */
    public void setPersonId(long value) {
        this.personId = value;
    }

    /**
     * Gets the value of the measureHistory property.
     * 
     * @return
     *     possible object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public HealthMeasureHistory getMeasureHistory() {
        return measureHistory;
    }

    /**
     * Sets the value of the measureHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public void setMeasureHistory(HealthMeasureHistory value) {
        this.measureHistory = value;
    }

}
