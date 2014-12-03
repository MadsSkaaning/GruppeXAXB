package JsonClasses;

public class GetCalendar implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "getCalendar";
	private String calendarID;

	
	
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
	public long getSerialVersionUID() {
		return serialVersionUID;
		
		
	}
}	
	
	
	
	
