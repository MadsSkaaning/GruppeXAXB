package model.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.QueryBuild.QueryBuilder;

public class Calendars {
	 ArrayList<Calendar> calendars = new ArrayList<Calendar>();

	    public ArrayList<Calendar> getCalendars() {
	    	QueryBuilder qb = new QueryBuilder();
	    	try {
				ResultSet rs = qb.selectFrom("calendars").all().ExecuteQuery();
				while (rs.next())
				{
					//String values from SQL database (must be created)
					int CalendarID = rs.getInt("calendarid");
					String name = rs.getString("name");
					int createdby = rs.getInt("createdby");
					int privatepublic = rs.getInt("privatepublic");
					int active = rs.getInt("active");
					String stringCalendarID = String.valueOf(CalendarID);
					String stringtitle = String.valueOf(name);
					String stringcreatedby = String.valueOf(createdby);
					String stringprivatepublic = String.valueOf(privatepublic);
					String stringActive = String.valueOf(active);
					
					calendars.add(new Calendar(stringCalendarID, stringtitle, stringcreatedby, stringprivatepublic, stringActive));				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	return calendars;
	    }

	    public void setCalendar(ArrayList<Calendar> calendar) {
	        this.calendars = calendar;
	    }
	    
	    // Konverterer array events til en tekst streng
	    @Override
	    public String toString() {
	        return Arrays.toString(calendars.toArray());
	    }
	    
	    public static void main(String []args){
	    	Calendars Goddav = new Calendars();
	    	
	    	Goddav.getCalendars();
	    	System.out.println(Goddav.toString());
	    }
}
