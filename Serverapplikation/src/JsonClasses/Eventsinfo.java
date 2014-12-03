package JsonClasses;

public class Eventsinfo {
	
	
	private  final long serialVersionUID = 1L;
	private String overallID = "EventsInfo";
	private String eventID;
	private String start;
	private String end;
	private String location;
	private String description;
	private String eventName;
	private String createdby;
	private int publicOrPrivate;
	private String active;
	
	
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public void setPublicOrPrivate(int publicOrPrivate) {
		this.publicOrPrivate = publicOrPrivate;
	}
	public long getSerialVersionUID() {
		return serialVersionUID;
	}

	
	
}
