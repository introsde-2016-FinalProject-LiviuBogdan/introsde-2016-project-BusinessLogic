package lifecoach.businesslogic.soap.ws;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "message", "link" })
@XmlRootElement
public class Feedback {
	private String message;
	private String link;
	
	Feedback(){}

	public Feedback(String message, String link) {
		super();
		this.message = message;
		this.link = link;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "Feedback [message=" + message + ", link=" + link + "]";
	}
	

}
