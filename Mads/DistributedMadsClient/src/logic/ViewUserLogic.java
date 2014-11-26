/*
 * 
 */
package logic;

// Fig. 28.25: ResultSetTableModel.java
// A TableModel that supplies ResultSet data to a JTable.
import gui.AdminViewUserScreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

import database.DatabaseConnect;

// TODO: Auto-generated Javadoc
// ResultSet rows and columns are counted from 1 and JTable 
// rows and columns are counted from 0. When processing 
// ResultSet rows or columns for use in a JTable, it is 
// necessary to add 1 to the row or column number to manipulate
// the appropriate ResultSet column (i.e., JTable column 0 is 
// ResultSet column 1 and JTable row 0 is ResultSet row 1).
/**
 * The Class ViewUserLogic.
 */
public class ViewUserLogic extends AbstractTableModel 
{

	/** The connect. */
	private DatabaseConnect connect;

	/** The connection. */
	private Connection connection;

	/** The statement. */
	private Statement statement;

	/** The result set. */
	private ResultSet resultSet;

	/** The meta data. */
	private ResultSetMetaData metaData;

	/** The number of rows. */
	private int numberOfRows;

	// keep track of database connection status
	/** The connected to database. */
	private boolean connectedToDatabase = false;

	// constructor initializes resultSet and obtains its meta data object;
	// determines number of rows
	/**
	 * Instantiates a new view user logic.
	 *
	 * @param query the query
	 * @throws SQLException the SQL exception
	 */
	public ViewUserLogic( String query ) throws SQLException
	{         
		// connect to database
		connect = new DatabaseConnect();

		// create Statement to query database
		statement = connect.connection.createStatement( 
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		// ResultSet.CONCUR_READ_ONLY );

		// update database connection status
		connectedToDatabase = true;

		// set query and execute it
		setQuery( query );
	} // end constructor ResultSetTableModel


	// get class that represents column type
	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	public Class getColumnClass( int column ) throws IllegalStateException
	{
		// ensure database connection is available
		if ( !connectedToDatabase ) 
			throw new IllegalStateException( "Not Connected to Database" );

		// determine Java class of column
		try 
		{
			String className = metaData.getColumnClassName( column + 1 );

			// return Class object that represents className
			return Class.forName( className );
		} // end try
		catch ( Exception exception ) 
		{
			exception.printStackTrace();
		} // end catch

		return Object.class; // if problems occur above, assume type Object
	} // end method getColumnClass

	// get number of columns in ResultSet
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() throws IllegalStateException
	{   
		// ensure database connection is available
		if ( !connectedToDatabase ) 
			throw new IllegalStateException( "Not Connected to Database" );

		// determine number of columns
		try 
		{
			return metaData.getColumnCount(); 
		} // end try
		catch ( SQLException sqlException ) 
		{
			sqlException.printStackTrace();
		} // end catch

		return 0; // if problems occur above, return 0 for number of columns
	} // end method getColumnCount

	// get name of a particular column in ResultSet



	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	public String getColumnName( int column ) throws IllegalStateException
	{    
		// ensure database connection is available
		if ( !connectedToDatabase ) 
			throw new IllegalStateException( "Not Connected to Database" );

		// determine column name
		try 
		{
			return metaData.getColumnName( column + 1 );  
		} // end try
		catch ( SQLException sqlException ) 
		{
			sqlException.printStackTrace();
		} // end catch

		return ""; // if problems, return empty string for column name
	} // end method getColumnName

	// return number of rows in ResultSet
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() throws IllegalStateException
	{      
		// ensure database connection is available
		if ( !connectedToDatabase ) 
			throw new IllegalStateException( "Not Connected to Database" );

		return numberOfRows;
	} // end method getRowCount

	// obtain value in particular row and column
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt( int row, int column ) 
			throws IllegalStateException
			{
		// ensure database connection is available
		if ( !connectedToDatabase ) 
			throw new IllegalStateException( "Not Connected to Database" );

		// obtain a value at specified ResultSet row and column
		try 
		{
			resultSet.absolute( row + 1 );
			return resultSet.getObject( column + 1 );
		} // end try
		catch ( SQLException sqlException ) 
		{
			sqlException.printStackTrace();
		} // end catch

		return ""; // if problems, return empty string object
			} // end method getValueAt

	// set new database query string
	/**
	 * Sets the query.
	 *
	 * @param query the new query
	 * @throws SQLException the SQL exception
	 * @throws IllegalStateException the illegal state exception
	 */
	public void setQuery( String query ) 
			throws SQLException, IllegalStateException 
			{
		// ensure database connection is available
		if ( !connectedToDatabase ) 
			throw new IllegalStateException( "Not Connected to Database" );

		// specify query and execute it
		resultSet = statement.executeQuery( query );

		// obtain meta data for ResultSet
		metaData = resultSet.getMetaData();

		// determine number of rows in ResultSet
		resultSet.last();                   // move to last row
		numberOfRows = resultSet.getRow();  // get row number      

		// notify JTable that model has changed
		fireTableStructureChanged();
			} // end method setQuery


	/**
	 * Gets the table.
	 *
	 * @param adminViewUserScreen the admin view user screen
	 * @return the table
	 */
	public void getTable(AdminViewUserScreen adminViewUserScreen)
	{        
		try 
		{
			int selection = adminViewUserScreen.inputQuery.getSelectedIndex();
			String query = null;

			// execute predefined query
			switch ( selection ) 
			{
			case 0:
				query = "SELECT IDMail, firstName, lastName, userBTCBalance FROM user";
				break;
			case 1:
				query = "SELECT * FROM user";
				break;
			case 2:
				query = "SELECT * from user WHERE user.IDMail = '" +
						adminViewUserScreen.input.getText() + "' ORDER BY user.IDMail, " +
						"user.firstName ASC";
				break;
			} // end switch

			setQuery( query );
		} // end try
		catch ( SQLException sqlex ) 
		{
			sqlex.printStackTrace();

			// recover from invalid query by executing default query
			try 
			{
				setQuery( AdminViewUserScreen.DEFAULT_QUERY );
				adminViewUserScreen.inputQuery.setSelectedIndex( 0 );
			} // end try
			catch ( SQLException sqlException2 ) 
			{
				sqlException2.printStackTrace();
				;
				System.exit( 1 ); // terminate application
			} // end inner catch                   
		} // end catch
	}

}  // end class ResultSetTableModel