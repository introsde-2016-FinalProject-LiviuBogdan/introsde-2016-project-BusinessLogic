
package lifecoach.storageservice.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteAchievementResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteAchievementResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="achievementId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteAchievementResponse", propOrder = {
    "achievementId"
})
public class DeleteAchievementResponse {

    protected long achievementId;

    /**
     * Gets the value of the achievementId property.
     * 
     */
    public long getAchievementId() {
        return achievementId;
    }

    /**
     * Sets the value of the achievementId property.
     * 
     */
    public void setAchievementId(long value) {
        this.achievementId = value;
    }

}
