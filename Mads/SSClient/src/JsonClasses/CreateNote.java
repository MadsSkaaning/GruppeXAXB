package JsonClasses;

public class CreateNote {
	
	private  final long serialVersionUID = 1L;
	private String overallID = "createNote";
	private String noteID;
	private String createdby;
	private String EventID;
	private String active;
	private String note;
	private String datetime;
	
	
	
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

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
	public String getNoteID() {
		return noteID;
	}
	public void setNoteID(String noteID) {
		this.noteID = noteID;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getEventID() {
		return EventID;
	}
	public void setEventID(String eventID) {
		EventID = eventID;
	}

	
	
	
	

}
