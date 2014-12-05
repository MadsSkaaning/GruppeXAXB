package model.calendar;

import java.util.ArrayList;

/**
 * Created by jesperbruun on 10/10/14.
 * Til hver specifik event bliver de defineret saaledes.
 */
public class Event {
    private String eventid;
    private String description;
    private String location;
    private String createdby;
    private ArrayList<String> start;
    private ArrayList<String> end;
    private String calendarId;
    private String active;
    private String eventName;
    private String customEvent;
    
    

    // Settere og gettere for Event objektet 

    public void setEventid(String eventid){
        this.eventid = eventid;
    }
    public String getEventid(){
        return eventid;
    }


    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }

    public void setCreatedby(String createdby){
        this.createdby = createdby;
    }
    public String getCreatedby(){
        return createdby;
    }
    
    public void setStart(ArrayList<String> start){
        this.start = start;
    }
    public ArrayList<String> getStart(){
        return start;
    }

    public void setEnd(ArrayList<String> end){
        this.end = end;
    }
    public ArrayList<String> getEnd(){
        return end;
    }
	public Event(String eventid, String eventName,
			String description, String location, String createdby,
			 String calendarId, String active, String customEvent, ArrayList<String> start, ArrayList<String> end) {
		super();
		this.eventid = eventid;
		this.eventName = eventName;
		this.description = description;
		this.location = location;
		this.createdby = createdby;
		this.start = start;
		this.end = end;
		this.calendarId = calendarId;
		this.active = active;
		this.customEvent = customEvent;
		
	}
	public String getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getCustomEvent() {
		return customEvent;
	}
	public void setCustomEvent(String customEvent) {
		this.customEvent = customEvent;
	}
    
    

}
