package JsonClasses;

public class CreateEvents implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "createEvents";
	private String eventName;
	private String calendarID;
	private String eventID;
	private String start;
	private String end;
	private String createdby;
	private int publicOrPrivate;
	
	
	//Getters and setters for everything, bitch
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public int getPublicOrPrivate() {
		return publicOrPrivate;
	}
	public void setPublicOrPrivate(int publicPrivate) {
		this.publicOrPrivate = publicPrivate;
	}
	public String getCalendarID() {
		return calendarID;
	}
	public void setCalendarID(String calendarID) {
		this.calendarID = calendarID;
	}
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public long getSerialVersionUID() {
		return serialVersionUID;
	}

}