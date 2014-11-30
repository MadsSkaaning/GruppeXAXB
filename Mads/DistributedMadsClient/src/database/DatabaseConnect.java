/*
 * 
 */
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.Configurations;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseConnect.
 */
public class DatabaseConnect
{

	/** The connection. */
	public Connection connection;

	/** The statement. */
	public Statement statement;

	/** The result set. */
	public ResultSet resultSet;

	/** The meta data. */
	public ResultSetMetaData metaData;

	/** The number of rows. */
	public int numberOfRows;

	/** The get user by id. */
	private PreparedStatement getUserById = null;

	/** The edit person. */
	private PreparedStatement editPerson = null;

	/**
	 * Instantiates a new database connect.
	 */
	public DatabaseConnect()
	{
		
		Configurations cf = new Configurations();
		
		/** The Constant URL. */
		final String URL = "jdbc:mysql://" + cf.getHost() + ":" + cf.getPort() + "/bcbs_light";

		/** The Constant USERNAME. */
		final String USERNAME = cf.getUsername();

		/** The Constant PASSWORD. */
		final String PASSWORD = cf.getPassword();
		
		try 
		{
			connection = 
					DriverManager.getConnection( URL, USERNAME, PASSWORD );

			getUserById = 
					connection.prepareStatement( "SELECT * FROM user WHERE IDMail = ?" );

			// create an edit that edits a user in the database
			editPerson = connection.prepareStatement( "UPDATE user SET firstName = ?, lastName = ?, userAdress = ?, zipCode = ?,"
					+ " userAge = ?, userPhone = ?, userBTCBalance = ?, Password = ?, isAdmin = ? WHERE IDMail = ?");
		} 
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
			System.exit( 1 );
		} 
	} 

	public int editPerson( 
			String mail, String fname, String lname, String uadress, int uzip, 
			int uage, String uphone, double uBTCBalance, String upass, boolean admin)
	{
		int result = 0;

		try 
		{
			editPerson.setString( 1, fname );
			editPerson.setString( 2, lname );
			editPerson.setString( 3, uadress );
			editPerson.setInt( 4, uzip );
			editPerson.setInt( 5, uage );
			editPerson.setString( 6, uphone );
			editPerson.setDouble( 7, uBTCBalance );
			editPerson.setString( 8, upass );
			editPerson.setBoolean( 9, admin);
			editPerson.setString(10, mail );
			// insert the new entry; returns # of rows updated
			result = editPerson.executeUpdate(); 
		} // end try
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
			close();
		} // end catch

		return result;
	} // end method editPerson

	// close the database connection
	/**
	 * Close.
	 */
	public void close()
	{
		try 
		{
			connection.close();
		} // end try
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		} // end catch
	} // end method close

	/**
	 * Does user by id exist.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean doesUserByIDExist(String id) {
		ResultSet result;
		boolean hasRows = false;
		try
		{
			getUserById.setString(1, id);
			result = getUserById.executeQuery();
			while(result.next()) {
				hasRows = true;
			}

			if(!hasRows)
				return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			close();
			return false;
		}
		return true;
	}

	public User getUserByID(String id) {

		ResultSet result;
		User u = null;
		// set parameters, then execute getUserByID
		try 
		{
			getUserById.setString ( 1, id);

			// insert the new entry; returns # of rows updated
			result = getUserById.executeQuery(); 

			while (result.next()) {
				u = new User(result.getString("IDMail"), result.getString("firstName"), result.getString("lastName"), result.getString("userAdress"),
						result.getInt("zipCode"), result.getString("userPhone"), result.getInt("userAge")
						, result.getDouble("userBTCBalance"), result.getString("Password"), result.getBoolean("isAdmin") );
			}
		} // end try
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
			close();
		} // end catch

		return u;

		// TODO Auto-generated method stub

	}
} // end class DatabaseConnect

