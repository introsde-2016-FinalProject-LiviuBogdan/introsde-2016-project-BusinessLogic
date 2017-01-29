
package lifecoach.storageservice.soap.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import lifecoach.localdb.soap.ws.Goal;


/**
 * <p>Java class for readGoalListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readGoalListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="goals" type="{http://ws.soap.localdb.lifecoach/}goal" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readGoalListResponse", propOrder = {
    "goals"
})
public class ReadGoalListResponse {

    protected List<Goal> goals;

    /**
     * Gets the value of the goals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the goals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGoals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Goal }
     * 
     * 
     */
    public List<Goal> getGoals() {
        if (goals == null) {
            goals = new ArrayList<Goal>();
        }
        return this.goals;
    }

}
