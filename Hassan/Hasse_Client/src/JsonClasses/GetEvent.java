package JsonClasses;

public class GetEvent implements java.io.Serializable
{//Alle JSON klasser indenholder getters og setters for, hvad de best�r af hver is�r

	private  final long serialVersionUID = 1L;
	private String overallID = "getEvent";
	private String eventID;

	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public long getSerialVersionUID() {
		return serialVersionUID;
		
		
	}
}	
	
	
	
	
