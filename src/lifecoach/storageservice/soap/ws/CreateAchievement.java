
package lifecoach.storageservice.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import lifecoach.localdb.soap.ws.Achievement;


/**
 * <p>Java class for createAchievement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createAchievement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Achievement" type="{http://ws.soap.localdb.lifecoach/}achievement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createAchievement", propOrder = {
    "achievement"
})
public class CreateAchievement {

    @XmlElement(name = "Achievement")
    protected Achievement achievement;

    /**
     * Gets the value of the achievement property.
     * 
     * @return
     *     possible object is
     *     {@link Achievement }
     *     
     */
    public Achievement getAchievement() {
        return achievement;
    }

    /**
     * Sets the value of the achievement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Achievement }
     *     
     */
    public void setAchievement(Achievement value) {
        this.achievement = value;
    }

}
