package JsonClasses;

public class GetNote {
	//Alle JSON klasser indenholder getters og setters for, hvad de best�r af hver is�r

	private  final long serialVersionUID = 1L;
	private String overallID = "getNote";
	private String noteID;
	private String eventID;
	
	
	
	
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
	public long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
	
	
	
}
