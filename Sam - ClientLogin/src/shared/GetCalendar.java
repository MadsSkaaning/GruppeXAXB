package shared;

public class GetCalendar implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "getCalendar";
	private String calendarName;
	

	
	public String getCalendarName() {
		return calendarName;
	}
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	public long getSerialVersionUID() {
		return serialVersionUID;
		
		
	}
}	
	
	
	
	
