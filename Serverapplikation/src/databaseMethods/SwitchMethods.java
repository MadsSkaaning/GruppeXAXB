package databaseMethods;
import java.sql.SQLException;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;

public class SwitchMethods extends Model
{
	private static final String String = null;
	QueryBuilder qb = new QueryBuilder();
	QOTDModel qm = new QOTDModel();

	/**
	 * Allows the client to create a new calendar
	 * @param userName
	 * @param calendarName
	 * @param privatePublic
	 * @return
	 * @throws SQLException
	 */

	public String createNewCalendar (String createdby, String calendarName, int privatePublic) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		if(authenticateNewCalendar(calendarName) == false)
		{
			addNewCalendar(calendarName, createdby, privatePublic);
			stringToBeReturned = "The new calendar has been created!";
		}
		else
		{
			stringToBeReturned = "The new calendar has not been created!";
		}
		
		
		return stringToBeReturned;
	}
	
	public boolean authenticateNewCalendar(String newCalendarName) throws SQLException
	{
		getConn();
		boolean authenticate = false;
		
		resultSet= qb.selectFrom("calendar").where("name", "=", newCalendarName).ExecuteQuery();
				
				//("select * from test.calendar where Name = '"+newCalendarName+"';");
		while(resultSet.next())
		{
			authenticate = true;
		}
		return authenticate;
	}
	
	public void addNewCalendar (String newCalendarName, String createdby, int publicOrPrivate) throws SQLException
	{
		String [] keys = {"Name","CreatedBy","PrivatePublic", "active"};
		String [] values = {newCalendarName, createdby, Integer.toString(publicOrPrivate),"1"};
		qb.insertInto("calendar", keys).values(values).Execute();
		
//		doUpdate("insert into test.calendar (Name, Active, CreatedBy, PrivatePublic) VALUES ('"+newCalendarName+"', '1', '"+userName+"', '"+publicOrPrivate+"');");
	}
	
	
	
	
	/**
	 * Allows the client to delete a calendar
	 * @param createdby
	 * @param calendarName
	 * @return
	 */
	public String deleteCalendar (String createdby, String calendarName) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeCalendar(createdby, calendarName);

		return stringToBeReturned;
	}
	
	public String removeCalendar (String createdby, String calendarName) throws SQLException
	{
		String stringToBeReturend = "";
		String usernameOfCreator ="";
		String calendarExists = "";
		resultSet = qb.selectFrom("Calendar").where("Name", "=", calendarName).ExecuteQuery();
				
//				("select * from calendar where Name = '"+calendarName+"';");
		while(resultSet.next())
		{
			calendarExists = resultSet.toString();
		}
		if(!calendarExists.equals(""))
		{
			String [] value = {"CreatedBy"};
			resultSet = qb.selectFrom(value, "Calendar").where("Name", "=", calendarName).ExecuteQuery();
			while(resultSet.next())
			{
				usernameOfCreator = resultSet.toString();
				System.out.println(usernameOfCreator);
			}
			if(!usernameOfCreator.equals(createdby))
			{
				stringToBeReturend = "Only the creator of the calendar is able to delete it.";
			}
			else
			{
				String [] keys = {"Active"};
				String [] values = {"2"};
				qb.update("Calendar", keys, values).where("Name", "=", calendarName).Execute();
				stringToBeReturend = "Calendar has been set inactive";
			}
			stringToBeReturend = resultSet.toString();
		}
		else
		{
			stringToBeReturend = "The calendar you are trying to delete, does not exists.";
		}
		
		return stringToBeReturend;
	}
	
	
	
	
	
	
	
	public String getCalendar (String createdby, String calendarName) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = fetchCalendar(createdby, calendarName);

		return stringToBeReturned;
	}
	
	public String fetchCalendar (String createdby, String calendarName) throws SQLException
	{
		
		String stringToBeReturend = "";
		String usernameOfCreator ="";
		String calendarExists = "";
		resultSet = qb.selectFrom("Calendar").where("Name", "=", calendarName).ExecuteQuery();
				
		while(resultSet.next())
		{
			calendarExists = resultSet.toString();
		}
		if(!calendarExists.equals("")) {
			stringToBeReturend = "You don't have access to this calendar or it does not exist";
		}
		else	
			{
				stringToBeReturend = "Your selected calendar";
				String [] getkeys = {"calendarid","Name","createdby", "privatepublic", "active"};
				resultSet = qb.selectFrom("Calendar").where("Name", "=", calendarName).ExecuteQuery();
				
			}	
			stringToBeReturend = resultSet.toString();
			
		return stringToBeReturend;
	}	
	
	
	
	
	// Metoden faar email og password fra switchen (udtrukket fra en json) samt en boolean der skal saettes til true hvis det er serveren der logger paa, og false hvis det er en klient
	/**
	 * Allows the client to log in
	 * @param email
	 * @param password
	 * @param isAdmin
	 * @return
	 * @throws Exception
	 */
	public String authenticate(String email, String password) throws Exception {

		// Old working string. String[] keys = {"userid", "email", "active", "password", "isAdmin"};

		String[] keys = {"userid", "email", "active", "password"};
		
		
		qb = new QueryBuilder();

		// Henter info om bruger fra database via querybuilder
		resultSet = qb.selectFrom(keys, "users").where("email", "=", email).ExecuteQuery();

		// Hvis en bruger med forespurgt email findes
		if (resultSet.next()){

			// Hvis brugeren er aktiv
			if(resultSet.getInt("active")==1)
			{					
				// Hvis passwords matcher
				if(resultSet.getString("password").equals(password))
				{
					int userID = resultSet.getInt("userid");

					String[] key = {"type"};

					resultSet = qb.selectFrom(key, "roles").where("userid", "=", new Integer(userID).toString()).ExecuteQuery();

					// Hvis brugeren baade logger ind og er registreret som admin, eller hvis brugeren baade logger ind og er registreret som bruger
					if(resultSet.next() && (resultSet.getString("type").equals("admin")) || (resultSet.getString("type").equals("user")))
					{
						return "0"; // returnerer "0" hvis bruger/admin er godkendt
					} else {
						return "4"; // returnerer fejlkoden "4" hvis brugertype ikke stemmer overens med loginplatform
					}
				} else {
					return "3"; // returnerer fejlkoden "3" hvis password ikke matcher
				}
			} else {
				return "2"; // returnerer fejlkoden "2" hvis bruger er sat som inaktiv
			}
		} else {
			return "1"; // returnerer fejlkoden "1" hvis email ikke findes
		}
	}
	
	public String createNewEvent (String createdby, String eventname, String start, String end, String location, String description, String calendarid) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();

			try {
				addNewEvent(location, createdby, start, end, eventname, description, calendarid);
				stringToBeReturned = "The new event has been created!";
			} catch (Exception e) {
				stringToBeReturned = ("Something went wrong.");
				e.printStackTrace();
			}
		
		return stringToBeReturned;
	}
	
	
	public void addNewEvent (String createdby, String eventname, String start, String end, String location, String description, String calendarid) throws SQLException
	{
		String [] keys = {"location","createdby","start","end", "eventname", "description", "calendarid", "active"};
		String [] values = {location, createdby, start, end, eventname, description, calendarid, "1"};
		qb.insertInto("events", keys).values(values).Execute();
		
//		doUpdate("insert into test.calendar (Name, Active, CreatedBy, PrivatePublic) VALUES ('"+newCalendarName+"', '1', '"+userName+"', '"+publicOrPrivate+"');");
	}
	
	public String deleteEvent (String createdby, String eventname) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeCalendar(createdby, eventname);

		return stringToBeReturned;
	}
	
	public String removeEvent (String createdby, String eventname) throws SQLException
	{
		String stringToBeReturend = "";
		String usernameOfCreator ="";
		String eventExists = "";
		resultSet = qb.selectFrom("events").where("eventname", "=", eventname).ExecuteQuery();
				
//				("select * from events where eventname = '"+eventname+"';");
		while(resultSet.next())
		{
			eventExists = resultSet.toString();
		}
		if(!eventExists.equals(""))
		{
			String [] value = {"createdby"};
			resultSet = qb.selectFrom(value, "events").where("eventname", "=", eventname).ExecuteQuery();
			while(resultSet.next())
			{
				usernameOfCreator = resultSet.toString();
				System.out.println(usernameOfCreator);
			}
			if(!usernameOfCreator.equals(createdby))
			{
				stringToBeReturend = "Only the creator of the event is able to delete it.";
			}
			else
			{
				String [] keys = {"Active"};
				String [] values = {"2"};
				qb.update("events", keys, values).where("eventname", "=", eventname).Execute();
				stringToBeReturend = "Event has been deleted";
			}
			stringToBeReturend = resultSet.toString();
		}
		else
		{
			stringToBeReturend = "The event you are trying to delete, does not exists.";
		}
		
		return stringToBeReturend;
	}
	
	
	public String createNewNote  (String eventid, String createdby, String note, String datetime, String calendarid) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();

			try {
				addNewNote(eventid, createdby, note, datetime, calendarid);
				stringToBeReturned = "The new note has been created!";
			} catch (Exception e) {
				stringToBeReturned = ("Something went wrong.");
				e.printStackTrace();
			}
		
		return stringToBeReturned;
	}
	
	public void addNewNote (String eventid, String createdby, String note, String datetime, String calendarid) throws SQLException
	{
		String [] keys = {"eventid","createdby","note","datetime", "caledarid", "active"};
		String [] values = {eventid, createdby, note, datetime, calendarid, "1",};
		qb.insertInto("notes", keys).values(values).Execute();
		
//		doUpdate("insert into test.calendar (Name, Active, CreatedBy, PrivatePublic) VALUES ('"+newCalendarName+"', '1', '"+userName+"', '"+publicOrPrivate+"');");
	}
	
	
	public String deleteNote (String createdby, String noteid) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeNote(createdby, noteid);

		return stringToBeReturned;
	}
	
	public String removeNote (String createdby, String noteid) throws SQLException
	{
		String stringToBeReturend = "";
		String usernameOfCreator ="";
		String noteExists = "";
		resultSet = qb.selectFrom("notes").where("noteid", "=", noteid).ExecuteQuery();
				
//				("select * from events where noteid = '"+nteid+"';");
		while(resultSet.next())
		{
			noteExists = resultSet.toString();
		}
		if(!noteExists.equals(""))
		{
			String [] value = {"createdby"};
			resultSet = qb.selectFrom(value, "notes").where("noteid", "=", noteid).ExecuteQuery();
			while(resultSet.next())
			{
				usernameOfCreator = resultSet.toString();
				System.out.println(usernameOfCreator);
			}
			if(!usernameOfCreator.equals(createdby))
			{
				stringToBeReturend = "Only the creator of the event is able to delete it.";
			}
			else
			{
				String [] keys = {"Active"};
				String [] values = {"2"};
				qb.update("notes", keys, values).where("noteid", "=", noteid).Execute();
				stringToBeReturend = "Note has been deleted";
			}
			stringToBeReturend = resultSet.toString();
		}
		else
		{
			stringToBeReturend = "The note you are trying to delete, does not exists.";
		}
		
		return stringToBeReturend;
	}
	
	
	
	
}
