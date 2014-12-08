package model.database;

import java.io.IOException;
import java.sql.SQLException;

import model.Model;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseInit.
 */
public class DatabaseInit extends Model {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			new DatabaseInit().go();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Go.
	 *
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void go() throws SQLException, IOException {


		if (doesDatabaseExist()) {
			System.out.print("Database environment does exist");
		} else {
			System.out.print("Database environment does NOT exist");
			readfromSqlFile("src/SQLFiles/createDBscript.sql");
		}

	}
}
