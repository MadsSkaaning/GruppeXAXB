package JsonClasses;

public class GetEvent implements java.io.Serializable
{
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
	
	
	
	
