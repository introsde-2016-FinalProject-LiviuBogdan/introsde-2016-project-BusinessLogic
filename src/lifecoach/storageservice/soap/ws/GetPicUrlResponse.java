
package lifecoach.storageservice.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getPicUrlResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPicUrlResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="picurl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPicUrlResponse", propOrder = {
    "picurl"
})
public class GetPicUrlResponse {

    protected String picurl;

    /**
     * Gets the value of the picurl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * Sets the value of the picurl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPicurl(String value) {
        this.picurl = value;
    }

}
