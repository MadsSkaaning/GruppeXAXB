package databaseMethods;
import java.sql.SQLException;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;

public class SwitchMethods extends Model
{
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

	public String createNewCalendar (String userName, String calendarName, int privatePublic) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		if(authenticateNewCalendar(calendarName) == false)
		{
			addNewCalendar(calendarName, userName, privatePublic);
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
	
	public void addNewCalendar (String newCalendarName, String userName, int publicOrPrivate) throws SQLException
	{
		String [] keys = {"Name","active","CreatedBy","PrivatePublic"};
		String [] values = {newCalendarName,"1",userName, Integer.toString(publicOrPrivate)};
		qb.insertInto("calendar", keys).values(values).Execute();
		
//		doUpdate("insert into test.calendar (Name, Active, CreatedBy, PrivatePublic) VALUES ('"+newCalendarName+"', '1', '"+userName+"', '"+publicOrPrivate+"');");
	}
	
	
	
	
	/**
	 * Allows the client to delete a calendar
	 * @param userName
	 * @param calendarName
	 * @return
	 */
	public String deleteCalendar (String userName, String calendarName) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeCalendar(userName, calendarName);

		return stringToBeReturned;
	}
	
	public String removeCalendar (String userName, String calendarName) throws SQLException
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
			if(!usernameOfCreator.equals(userName))
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
						return "0 - Du er nu logget ind"; // returnerer "0" hvis bruger/admin er godkendt
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
}
