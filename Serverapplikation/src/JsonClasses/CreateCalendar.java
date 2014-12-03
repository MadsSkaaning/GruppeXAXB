package JsonClasses;

public class CreateCalendar implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "createCalendar";
	private String calendarID;
	private String createdby;
	private String calendarName;
	
	
	
	public String getCalendarName() {
		return calendarName;
	}
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}
	private int publicOrPrivate;
	
	
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getCalendarID() {
		return calendarID;
	}
	public void setCalendarID(String calendarID) {
		this.calendarID = calendarID;
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
