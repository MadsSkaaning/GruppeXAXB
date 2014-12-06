package model.calendar;

import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Calendar.
 */
public class Calendar {

	/** The calendarid. */
	private String calendarid;

	/** The title. */
	private String title;

	/** The createdby. */
	private String createdby;

	/** The Private public. */
	private String PrivatePublic;

	/** The active. */
	private String active;

	// Settere og gettere for Event objektet 

	/**
	 * Sets the calendarid.
	 *
	 * @param calendarid the new calendarid
	 */
	public void setCalendarid(String calendarid){
		this.calendarid = calendarid;
	}

	/**
	 * Gets the calendarid.
	 *
	 * @return the calendarid
	 */
	public String getCalendarid(){
		return calendarid;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle(){
		return title;
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

	/**
	 * Gets the private public.
	 *
	 * @return the private public
	 */
	public String getPrivatePublic() {
		return PrivatePublic;
	}

	/**
	 * Sets the private public.
	 *
	 * @param privatepublic the new private public
	 */
	public void setPrivatePublic(String privatepublic) {
		PrivatePublic = privatepublic;
	}

	/**
	 * Instantiates a new calendar.
	 *
	 * @param calendarid the calendarid
	 * @param title the title
	 * @param createdby the createdby
	 * @param privatepublic the privatepublic
	 * @param active the active
	 */
	public Calendar(String calendarid, String title,
			String createdby, String privatepublic, String active) {

		super();
		this.calendarid = calendarid;
		this.title = title;
		this.createdby = createdby;
	}



}
