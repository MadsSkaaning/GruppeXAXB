package JsonClasses;

public class DeleteCalendar implements java.io.Serializable 
{
	//Alle JSON klasser indenholder getters og setters for, hvad de består af hver især

	private  final long serialVersionUID = 1L;
	private String overallID = "deleteCalendar";
	private String calendarName;
	private String createdby;
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
	public String getCalendarName() {
		return calendarName;
	}
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

}
