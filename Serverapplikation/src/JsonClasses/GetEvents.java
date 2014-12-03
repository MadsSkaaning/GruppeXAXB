package JsonClasses;

public class GetEvents implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "getEvents";
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
	public void setEventID(String EventID) {
		this.eventID = eventID;
	}
	public long getSerialVersionUID() {
		return serialVersionUID;
		
		
	}
}	
	
	
	
	
