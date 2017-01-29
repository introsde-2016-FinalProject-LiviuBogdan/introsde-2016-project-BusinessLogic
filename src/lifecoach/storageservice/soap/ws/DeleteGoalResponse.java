
package lifecoach.storageservice.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteGoalResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteGoalResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="goalId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteGoalResponse", propOrder = {
    "goalId"
})
public class DeleteGoalResponse {

    protected long goalId;

    /**
     * Gets the value of the goalId property.
     * 
     */
    public long getGoalId() {
        return goalId;
    }

    /**
     * Sets the value of the goalId property.
     * 
     */
    public void setGoalId(long value) {
        this.goalId = value;
    }

}
