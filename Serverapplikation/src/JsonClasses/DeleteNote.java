package JsonClasses;

public class DeleteNote {
	
	private  final long serialVersionUID = 1L;
	private String overallID = "deleteNote";
	private String noteID;
	private String eventID;
	private String createdby;
	
	
	
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
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
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
	
	
	
	

}
