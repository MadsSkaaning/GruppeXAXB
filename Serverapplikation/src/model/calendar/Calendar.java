package model.calendar;

import java.util.ArrayList;


public class Calendar {

    private String calendarid;
    private String type;
    private String title;
    private String events;
    private String createdby;
    private String PrivatePublic;

    // Settere og gettere for Event objektet 

    public void setCalendarid(String calendarid){
        this.calendarid = calendarid;
    }
    public String getCalendarid(){
        return calendarid;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setEvents(String events){
        this.events = events;
    }
    public String getEvents(){
        return events;
	}
    
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getPrivatePublic() {
		return PrivatePublic;
	}
	public void setPrivatePublic(String privatepublic) {
		PrivatePublic = privatepublic;
	}
	public Calendar(String calendarid, String type, String title,
			String events, String createdby, String privatepublic) {
		
		super();
		this.calendarid = calendarid;
		this.type = type;
		this.title = title;
		this.events = events;
	}
    
    

}
