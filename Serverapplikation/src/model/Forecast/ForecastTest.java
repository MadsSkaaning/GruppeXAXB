package model.Forecast;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ForecastTest.
 */
public class ForecastTest {

	// Main metode til at koere en test af vejrudsigt funktionen
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws SQLException the SQL exception
	 */
	public static void main(String[] args) throws SQLException {

		ForecastModel fm = new ForecastModel();

		ArrayList<Forecast> forecastList = fm.requestForecast();

		for (int i = 0; i < forecastList.size(); i++) {
			System.out.println(forecastList.get(i).toString());
		}

	}

}
