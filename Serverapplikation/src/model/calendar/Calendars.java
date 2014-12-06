package model.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import model.QueryBuild.QueryBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class Calendars.
 */
public class Calendars {
	
	/** The calendars. */
	ArrayList<Calendar> calendars = new ArrayList<Calendar>();

	/**
	 * Gets the calendars.
	 *
	 * @return the calendars
	 */
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

	/**
	 * Sets the calendar.
	 *
	 * @param calendar the new calendar
	 */
	public void setCalendar(ArrayList<Calendar> calendar) {
		this.calendars = calendar;
	}

	// Konverterer array events til en tekst streng
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Arrays.toString(calendars.toArray());
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String []args){
		Calendars Goddav = new Calendars();

		Goddav.getCalendars();
		System.out.println(Goddav.toString());
	}
}
