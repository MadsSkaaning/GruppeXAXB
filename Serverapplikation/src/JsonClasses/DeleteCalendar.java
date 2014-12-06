package JsonClasses;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteCalendar.
 */
public class DeleteCalendar implements java.io.Serializable 
{
	
	/** The serial version uid. */
	private  final long serialVersionUID = 1L;
	
	/** The overall id. */
	private String overallID = "deleteCalendar";
	
	/** The calendar name. */
	private String calendarName;
	
	/** The createdby. */
	private String createdby;
	
	/** The active. */
	private String active;
	
	
	
	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * Gets the overall id.
	 *
	 * @return the overall id
	 */
	public String getOverallID() {
		return overallID;
	}
	
	/**
	 * Sets the overall id.
	 *
	 * @param overallID the new overall id
	 */
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	/**
	 * Gets the calendar name.
	 *
	 * @return the calendar name
	 */
	public String getCalendarName() {
		return calendarName;
	}
	
	/**
	 * Sets the calendar name.
	 *
	 * @param calendarName the new calendar name
	 */
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	/**
	 * Gets the createdby.
	 *
	 * @return the createdby
	 */
	public String getCreatedby() {
		return createdby;
	}

	/**
	 * Sets the createdby.
	 *
	 * @param createdby the new createdby
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

}
