package model.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.QueryBuild.QueryBuilder;

/**
 * Created by jesperbruun on 10/10/14.
 * Den laver selve arrayet af alle generede Event
 */
public class Events {
    ArrayList<Event> events = new ArrayList<Event>();

    public ArrayList<Event> getEvents() {
    	QueryBuilder qb = new QueryBuilder();
    	try {
			ResultSet rs = qb.selectFrom("events").all().ExecuteQuery();
			while (rs.next())
			{
				//String values from SQL database (must be created)
				int eventID = rs.getInt("eventid");
				int location = rs.getInt("location");
				int createdby = rs.getInt("createdby");
				
				Date startDate = rs.getDate("start");
				Time startTime = rs.getTime("start");
				
				Date endDate = rs.getDate("end");
				Time endTime = rs.getTime("end");
				
				String nameEvent = rs.getString("eventname");
				String description = rs.getString("description");
				int calendarId = rs.getInt("calendarid");
				int active= rs.getInt("active");
				int customevent = rs.getInt("customnevent");
				
				String stringEventID = String.valueOf(eventID);
				String stringLocation = String.valueOf(location);
				String stringCreatedby = String.valueOf(createdby);
				String stringStartDate = String.valueOf(startDate);
				String stringStartTime = String.valueOf(startTime);				
				String stringEndDate = String.valueOf(endDate);
				String stringEndTime = String.valueOf(endTime);
				ArrayList<String> alStart = new ArrayList<String>();
				alStart.add(stringStartDate + "" + stringStartTime);
				ArrayList<String> alEnd = new ArrayList<String>();
				alEnd.add(stringEndDate + "" + stringEndTime);
				String stringNameEvent = String.valueOf(nameEvent);
				String stringDescription = String.valueOf(description);
				String stringCalendarId = String.valueOf(calendarId);
				String stringActive = String.valueOf(active);
				String stringCustomevent = String.valueOf(customevent);
				
								
				events.add(new Event(stringEventID, stringLocation, stringCreatedby, stringNameEvent, stringDescription, stringCalendarId , stringActive, stringCustomevent, alStart, alEnd));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return events;
    }

    public void setEvents(ArrayList<Event> event) {
        this.events = event;
    }
    
    // Konverterer array events til en tekst streng
    @Override
    public String toString() {
        return Arrays.toString(events.toArray());
    }
    
}