package model.note;

import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class NoteModel.
 */
public class NoteModel {

	/** The note id. */
	private int noteID;

	/** The text. */
	private String text;

	/** The date time. */
	private String dateTime;

	/** The created by. */
	private String createdBy;

	/** The is active. */
	private int isActive;

	/** The event id. */
	private int eventID;

	/**
	 * Instantiates a new note model.
	 *
	 * @param noteID the note id
	 * @param text the text
	 * @param dateTime the date time
	 * @param createdBy the created by
	 * @param isActive the is active
	 * @param eventID the event id
	 */
	public NoteModel(int noteID, String text, String dateTime, String createdBy, int isActive, int eventID) {
		super();
		this.noteID = noteID;
		this.text = text;
		this.dateTime = dateTime;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.eventID = eventID;


	}

	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public int getEventID() {
		return eventID;
	}


	/**
	 * Sets the event id.
	 *
	 * @param eventID the new event id
	 */
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}


	/**
	 * Checks if is active.
	 *
	 * @return the int
	 */
	public int isActive() {
		return isActive;
	}


	/**
	 * Sets the active.
	 *
	 * @param isActive the new active
	 */
	public void setActive(int isActive) {
		this.isActive = isActive;
	}


	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}


	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	/**
	 * Gets the note id.
	 *
	 * @return the note id
	 */
	public int getNoteID() {
		return noteID;
	}

	/**
	 * Sets the note id.
	 *
	 * @param noteID the new note id
	 */
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the date time.
	 *
	 * @return the date time
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the date time.
	 *
	 * @param dateTime the new date time
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
