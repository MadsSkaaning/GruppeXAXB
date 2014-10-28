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
	 * @param calenderName
	 * @param privatePublic
	 * @return
	 * @throws SQLException
	 */

	public String createNewCalender (String userName, String calenderName, int privatePublic) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		if(authenticateNewCalender(calenderName) == false)
		{
			addNewCalender(calenderName, userName, privatePublic);
			stringToBeReturned = "The new calender has been created!";
		}
		else
		{
			stringToBeReturned = "The new calender has not been created!";
		}
		
		
		return stringToBeReturned;
	}
	
	public boolean authenticateNewCalender(String newCalenderName) throws SQLException
	{
		getConn();
		boolean authenticate = false;
		
		resultSet= qb.selectFrom("calendar").where("name", "=", newCalenderName).ExecuteQuery();
				
				//("select * from test.calender where Name = '"+newCalenderName+"';");
		while(resultSet.next())
		{
			authenticate = true;
		}
		return authenticate;
	}
	
	public void addNewCalender (String newCalenderName, String userName, int publicOrPrivate) throws SQLException
	{
		String [] keys = {"Name","active","CreatedBy","PrivatePublic"};
		String [] values = {newCalenderName,"1",userName, Integer.toString(publicOrPrivate)};
		qb.update("calendar", keys, values).all().Execute();
		
//		doUpdate("insert into test.calender (Name, Active, CreatedBy, PrivatePublic) VALUES ('"+newCalenderName+"', '1', '"+userName+"', '"+publicOrPrivate+"');");
	}
	/**
	 * Allows the client to delete a calendar
	 * @param userName
	 * @param calenderName
	 * @return
	 */
	public String deleteCalender (String userName, String calenderName) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeCalender(userName, calenderName);

		return stringToBeReturned;
	}
	
	public String removeCalender (String userName, String calenderName) throws SQLException
	{
		String stringToBeReturend = "";
		String usernameOfCreator ="";
		String calenderExists = "";
		resultSet = qb.selectFrom("Calender").where("Name", "=", calenderName).ExecuteQuery();
				
//				("select * from calender where Name = '"+calenderName+"';");
		while(resultSet.next())
		{
			calenderExists = resultSet.toString();
		}
		if(!calenderExists.equals(""))
		{
			String [] value = {"CreatedBy"};
			resultSet = qb.selectFrom(value, "Calender").where("Name", "=", calenderName).ExecuteQuery();
			while(resultSet.next())
			{
				usernameOfCreator = resultSet.toString();
				System.out.println(usernameOfCreator);
			}
			if(!usernameOfCreator.equals(userName))
			{
				stringToBeReturend = "Only the creator of the calender is able to delete it.";
			}
			else
			{
				String [] keys = {"Active"};
				String [] values = {"2"};
				qb.update("Calendar", keys, values).where("Name", "=", calenderName).Execute();
				stringToBeReturend = "Calender has been set inactive";
			}
			stringToBeReturend = resultSet.toString();
		}
		else
		{
			stringToBeReturend = "The calender you are trying to delete, does not exists.";
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
	public String authenticate(String email, String password, boolean isAdmin) throws Exception {

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
					if((resultSet.getString("type").equals("admin") && isAdmin) || (resultSet.getString("type").equals("user") && !isAdmin))
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
}
