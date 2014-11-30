/*
 * 
 */
package logic;

// Fig. 28.25: ResultSetTableModel.java
// A TableModel that supplies ResultSet data to a JTable.
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * The Class EditUserLogic.
 */
public class EditUserLogic extends AbstractTableModel 
{

	/** The connection2. */
	private DatabaseConnect connection2;
	
	// query retrieves all data from authors table
	/** The Constant QUERY. */
	static final String QUERY = "SELECT IDMail, Password, userBTCbalance, isAdmin FROM user";

	// keep track of database connection status
	/** The connected to database. */
	private boolean connectedToDatabase = false;

	// constructor initializes resultSet and obtains its meta data object;
	// determines number of rows
	/**
	 * Instantiates a new edits the user logic.
	 *
	 * @throws SQLException the SQL exception
	 */
	public EditUserLogic() throws SQLException
	{         
		// connect to database
		connection2 = new DatabaseConnect();

		// create Statement to query database
		connection2.statement = connection2.connection.createStatement( 
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE );

		// update database connection status
		connectedToDatabase = true;

		// Populate JTable
		setQuery( QUERY );
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
			String className = connection2.metaData.getColumnClassName( column + 1 );

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
			return connection2.metaData.getColumnCount(); 
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
			return connection2.metaData.getColumnName( column + 1 );  
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

		return connection2.numberOfRows;
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
			connection2.resultSet.absolute( row + 1 );
			return connection2.resultSet.getObject( column + 1 );
		} // end try
		catch ( SQLException sqlException ) 
		{
			sqlException.printStackTrace();
		} // end catch

		return ""; // if problems, return empty string object
			} // end method getValueAt

	// set database query string
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
		connection2.resultSet = connection2.statement.executeQuery( query );

		// obtain meta data for ResultSet
		connection2.metaData = connection2.resultSet.getMetaData();

		// determine number of rows in ResultSet
		connection2.resultSet.last();                   // move to last row
		connection2.numberOfRows = connection2.resultSet.getRow();  // get row number      

		// notify JTable that model has changed
		fireTableStructureChanged();
			} // end method setQuery

	/*
	 * Don't need to implement this method unless your table's
	 * editable.
	 */
	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
	 */
	public boolean isCellEditable(int row, int col) {
		// Promary key column (1) cannot be edited.
		if (col < 1) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Don't need to implement this method unless your table's
	 * data can change.
	 */
	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object, int, int)
	 */
	public void setValueAt(Object value, int row, int col) {

		try {
			// position cursor  
			connection2.resultSet.absolute( row + 1 );

			// update column
			connection2.resultSet.updateObject(col+1, value);

			// write changes to resultSet
			connection2.resultSet.updateRow();

			setQuery(QUERY);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * Adds the row.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addRow() throws SQLException {

		connection2.resultSet.moveToInsertRow();
		for (int i = 1; i < connection2.metaData.getColumnCount(); i++) {
			// primary key column (1) is auto incremented and should not be updated
			connection2.resultSet.updateObject(i+1, "<value>");
		}
		connection2.resultSet.insertRow(); 

		// refresh JTable
		setQuery(QUERY);
	}

	/**
	 * Delete row.
	 *
	 * @param index the index
	 * @throws SQLException the SQL exception
	 */
	public void deleteRow(int index) throws SQLException {
		connection2.resultSet.absolute(index+1);
		connection2.resultSet.deleteRow();

		// refresh JTable
		setQuery(QUERY);
	}

	// close Statement and Connection               
	/**
	 * Disconnect from database.
	 */
	public void disconnectFromDatabase()            
	{                              

		// close Statement and Connection            
		try                                          
		{                                            
			connection2.resultSet.close();                        
			connection2.statement.close();                        
			connection2.connection.close();                       
		} // end try                                 
		catch ( SQLException sqlException )          
		{                                            
			sqlException.printStackTrace();           
		} // end catch                               
		finally  // update database connection status
		{                                            
			connectedToDatabase = false;              
		} // end finally                             

	} // end method disconnectFromDatabase          
}  // end class AuthorTableModel


