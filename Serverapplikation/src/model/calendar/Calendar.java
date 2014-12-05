package model.calendar;

import java.util.ArrayList;


public class Calendar {

    private String calendarid;
    private String title;
    private String createdby;
    private String PrivatePublic;
    private String active;

    // Settere og gettere for Event objektet 

    public void setCalendarid(String calendarid){
        this.calendarid = calendarid;
    }
    public String getCalendarid(){
        return calendarid;
    }



    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
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
	public Calendar(String calendarid, String title,
		 String createdby, String privatepublic, String active) {
		
		super();
		this.calendarid = calendarid;
		this.title = title;
		this.createdby = createdby;
	}
    
    

}
