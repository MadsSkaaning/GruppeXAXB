package model.calendar;

import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Event.
 */
public class Event {

	/** The activityid. */
	private String activityid;

	/** The eventid. */
	private String eventid;

	/** The type. */
	private String type;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The location. */
	private String location;

	/** The createdby. */
	private String createdby;

	/** The start. */
	private ArrayList<String> start;

	/** The end. */
	private ArrayList<String> end;

	// Settere og gettere for Event objektet
	/**
	 * Sets the activityid.
	 *
	 * @param activityid the new activityid
	 */
	public void setActivityid(String activityid) {
		this.activityid = activityid;
	}

	/**
	 * Gets the activityid.
	 *
	 * @return the activityid
	 */
	public String getActivityid() {
		return activityid;
	}

	/**
	 * Sets the eventid.
	 *
	 * @param eventid the new eventid
	 */
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	/**
	 * Gets the eventid.
	 *
	 * @return the eventid
	 */
	public String getEventid() {
		return eventid;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the createdby.
	 *
	 * @param createdby the new createdby
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
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
	 * Sets the start.
	 *
	 * @param start the new start
	 */
	public void setStart(ArrayList<String> start) {
		this.start = start;
	}

	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public ArrayList<String> getStart() {
		return start;
	}

	/**
	 * Sets the end.
	 *
	 * @param end the new end
	 */
	public void setEnd(ArrayList<String> end) {
		this.end = end;
	}

	/**
	 * Gets the end.
	 *
	 * @return the end
	 */
	public ArrayList<String> getEnd() {
		return end;
	}

	/**
	 * Instantiates a new event.
	 *
	 * @param activityid the activityid
	 * @param eventid the eventid
	 * @param type the type
	 * @param title the title
	 * @param description the description
	 * @param start the start
	 * @param end the end
	 * @param location the location
	 */
	public Event(String activityid, String eventid, String type, String title,
			String description,
			ArrayList<String> start, ArrayList<String> end, String location) {
		super();
		this.activityid = activityid;
		this.eventid = eventid;
		this.type = type;
		this.title = title;
		this.description = description;
		this.location = location;
		this.start = start;
		this.end = end;
	}
}