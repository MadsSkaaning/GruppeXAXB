package JsonClasses;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteEvent.
 */
public class DeleteEvent implements java.io.Serializable 
{
	
	/** The serial version uid. */
	private  final long serialVersionUID = 1L;
	
	/** The overall id. */
	private String overallID = "deleteEvent";
	
	/** The event id. */
	private String eventID;
	
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
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public String getEventID() {
		return eventID;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventID the new event id
	 */
	public void setEventID(String eventID) {
		this.eventID = eventID;
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
