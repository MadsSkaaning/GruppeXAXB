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

	public String createNewCalendar (String calendarName, String createdby, int privatePublic) throws SQLException
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
		
		resultSet= qb.selectFrom("calendar").where("calendarname", "=", newCalendarName).ExecuteQuery();
				
				//("select * from test.calendar where Name = '"+newCalendarName+"';");
		while(resultSet.next())
		{
			authenticate = true;
		}
		return authenticate;
	}
	
	public void addNewCalendar (String newCalendarName, String createdby, int publicOrPrivate) throws SQLException
	{
		String [] keys = {"calendarname","CreatedBy","PrivatePublic", "active"};
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
		String stringToBeReturned = "";
		String usernameOfCreator ="";
		String calendarExists = "";
		resultSet = qb.selectFrom("Calendar").where("calendarname", "=", calendarName).ExecuteQuery();
				
//				("select * from calendar where Name = '"+calendarName+"';");
		while(resultSet.next())
		{
			calendarExists = resultSet.toString();
		}
		if(!calendarExists.equals(""))
		{
			String [] value = {"CreatedBy"};
			resultSet = qb.selectFrom(value, "Calendar").where("createdby", "=", createdby).ExecuteQuery();
			while(resultSet.next())
			{
				usernameOfCreator = resultSet.toString();
				System.out.println(usernameOfCreator);
			}
			if(usernameOfCreator.equals(createdby))
			{
				stringToBeReturned = "Only the creator of the calendar is able to delete it.";
			}
			else
			{
				System.out.println("test5");
				String [] keys = {"active"};
				String [] values = {"0"};
				qb.update("Calendar", keys, values).where("calendarname", "=", calendarName).Execute();
				stringToBeReturned = "Calendar has been set inactive";
			}
			stringToBeReturned = resultSet.toString();
		}
		else
		{
			stringToBeReturned = "The calendar you are trying to delete, does not exists.";
		}
		
		return stringToBeReturned;
	}
	
	
	
	
	public String getCalendar (String calendarName) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = fetchCalendar(calendarName);

		return stringToBeReturned;
	}
	
	public String fetchCalendar (String calendarName) throws SQLException
	{
		
		String stringToBeReturned = "";
		String calendarExists = "";
		resultSet = qb.selectFrom("calendar").where("calendarname", "=", calendarName).ExecuteQuery();
	
		while(resultSet.next())
			
		{

			calendarExists = resultSet.toString();

		}
		if(!calendarExists.equals(calendarName)) {
			
			String [] getkeys = {"calendarid","calendarname","createdby", "privatepublic", "active"};
			resultSet = qb.selectFrom("calendar").where("calendarname", "=", calendarName).ExecuteQuery();
			
			stringToBeReturned = resultSet.toString();

		}
		else	
			{
			
				stringToBeReturned = "You don't have access to this calendar or it does not exist";
			
			}
		return stringToBeReturned;
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

					resultSet = qb.selectFrom(key, "users").where("userid", "=", new Integer(userID).toString()).ExecuteQuery();

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
	
	
	
	// Testing admin login.
	
	public String authenticateadmin(String email, String password) throws Exception {

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

					resultSet = qb.selectFrom(key, "users").where("userid", "=", new Integer(userID).toString()).ExecuteQuery();

					// Hvis brugeren baade logger ind og er registreret som admin, eller hvis brugeren baade logger ind og er registreret som bruger
					if(resultSet.next() && (resultSet.getString("type").equals("admin")))
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
	
	
	
	public String createNewEvent (int createdby, String eventname, String start, String end, String location, String description, String calendarid) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();

			try {
				addNewEvent( createdby, location, start, end, eventname, description, calendarid);
				stringToBeReturned = "The new event has been created!";
			} catch (Exception e) {
				stringToBeReturned = ("Something went wrong.");
				e.printStackTrace();
			}
		
		return stringToBeReturned;
	}
	
	
	public void addNewEvent (int createdby, String eventname, String start, String end, String location, String description, String calendarid) throws SQLException
	{
		String [] keys = {"createdby", "eventname", "start","end", "location", "description", "calendarid", "active"};
		String [] values = {Integer.toString(createdby), location, start, end, eventname, description, calendarid, "1"};
		qb.insertInto("events", keys).values(values).Execute();
		
//		doUpdate("insert into test.calendar (Name, Active, CreatedBy, PrivatePublic) VALUES ('"+newCalendarName+"', '1', '"+userName+"', '"+publicOrPrivate+"');");
	}
	
	public String deleteEvent (String createdby, String eventid) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeEvent(createdby, eventid);

		return stringToBeReturned;
	}
	
	public String removeEvent (String createdby, String eventid) throws SQLException
	{
		String stringToBeReturned = "";
		String usernameOfCreator ="";
		String eventExists = "";
		resultSet = qb.selectFrom("events").where("eventid", "=", eventid).ExecuteQuery();

				
//				("select * from events where eventid = '"+eventid+"';");
		while(resultSet.next())
		{
			eventExists = resultSet.toString();

		}
		//Husk at indsætte ! før eventExist når klient tilknyttes.
		if(!eventExists.equals(""))
		{
			String [] value = {"createdby"};
			resultSet = qb.selectFrom("events").where("createdby", "=", createdby).ExecuteQuery();

			{
				usernameOfCreator = resultSet.toString();
				System.out.println(usernameOfCreator);
			}
			//Husk at indsætte ! før usernameofcreator når klient tilknyttes.
			if(usernameOfCreator.equals(createdby))
			{
				stringToBeReturned = "Only the creator of the event is able to delete it.";
			}
			else
			{

				String [] keys = {"active"};
				String [] values = {"0"};
				qb.update("events", keys, values).where("eventid", "=", eventid).Execute();
				stringToBeReturned = "Event has been deleted";
			}
			stringToBeReturned = resultSet.toString();
		}
		

		else
		{
			stringToBeReturned = "The event you are trying to delete, does not exists.";
		}
		
		return stringToBeReturned;
	}
	
	
	
	
	public String getEvent (String eventid) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = fetchEvent(eventid);

		return stringToBeReturned;
	}
	
	public String fetchEvent (String eventid) throws SQLException
	{
		
		String stringToBeReturned = "";
		String eventExists = "";
		resultSet = qb.selectFrom("events").where("eventid", "=", eventid).ExecuteQuery();
	
		while(resultSet.next())
			
		{

			eventExists = resultSet.toString();

		}
		if(!eventExists.equals(eventid)) {
			
			String [] getkeys = {"eventid","location","createdby", "start", "end", "eventname", "description"};
			resultSet = qb.selectFrom("events").where("eventid", "=", eventid).ExecuteQuery();
			
			stringToBeReturned = resultSet.toString();

		}
		else	
			{
			
				stringToBeReturned = "You don't have access to this event or it does not exist";
			
			}
		return stringToBeReturned;
	}	
	
	
	
	
	
	
	public String createNewNote  (String eventid, String createdby, String note, String datetime) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();

			try {
				addNewNote(eventid, createdby, note, datetime);
				stringToBeReturned = "The new note has been created!";
			} catch (Exception e) {
				stringToBeReturned = ("Something went wrong.");
				e.printStackTrace();
			}
		
		return stringToBeReturned;
	}
	
	public void addNewNote (String eventid, String createdby, String note, String datetime) throws SQLException
	{
		String [] keys = {"eventid","createdby","note","datetime", "active"};
		String [] values = {eventid, createdby, note, datetime, "1",};
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
		String stringToBeReturned = "";
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
			resultSet = qb.selectFrom(value, "notes").where("createdby", "=", createdby).ExecuteQuery();
			while(resultSet.next())
			{
				usernameOfCreator = resultSet.toString();
				System.out.println(usernameOfCreator);
			}
			//Husk at tilføj ! foran username igen, når klienten kan genkende den der er logget ind // Samuel.
			if(usernameOfCreator.equals(createdby))
			{
				stringToBeReturned = "Only the creator of the event is able to delete it.";
			}
			else
			{
				String [] keys = {"active"};
				String [] values = {"0"};
				qb.update("notes", keys, values).where("noteid", "=", noteid).Execute();
				stringToBeReturned = "Note has been deleted";
			}
			stringToBeReturned = resultSet.toString();
		}
		else
		{
			stringToBeReturned = "The note you are trying to delete, does not exists.";
		}
		
		return stringToBeReturned;
	}
	
	public String getNote (String noteid) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = fetchNote(noteid);

		return stringToBeReturned;
	}
	
	public String fetchNote (String noteid) throws SQLException
	{
		
		String stringToBeReturned = "";
		String eventExists = "";
		resultSet = qb.selectFrom("notes").where("noteid", "=", noteid).ExecuteQuery();
	
		while(resultSet.next())
			
		{

			eventExists = resultSet.toString();

		}
		if(!eventExists.equals(noteid)) {
			
			String [] getkeys = {"noteid","createdby", "note", "datetime"};
			resultSet = qb.selectFrom("notes").where("noteid", "=", noteid).ExecuteQuery();
			System.out.println("test");
			stringToBeReturned = resultSet.toString();

		}
		else	
			{
			
				stringToBeReturned = "You don't have access to this event or it does not exist";
			
			}
		return stringToBeReturned;
	}	
	
	
	
	
	
}
