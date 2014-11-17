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
					int type = rs.getInt("type");
					int title = rs.getInt("title");
					int events = rs.getInt("events");
					
					String nameEvent = rs.getString("name");
					String text = rs.getString("text");
					
					String stringCalendarID = String.valueOf(CalendarID);
					String stringType = String.valueOf(type);
					String stringtitle = String.valueOf(title);
					String stringevents = String.valueOf(events);

					
					calendars.add(new Calendar(stringCalendarID, stringType, stringtitle,stringevents));				
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
