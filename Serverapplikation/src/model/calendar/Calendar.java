package model.calendar;

import java.util.ArrayList;


public class Calendar {

    private String calendarid;
    private String type;
    private String title;
    private String events;

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
    
    
	public Calendar(String calendarid, String type, String title,
			String events) {
		
		super();
		this.calendarid = calendarid;
		this.type = type;
		this.title = title;
		this.events = events;
	}
    
    

}
