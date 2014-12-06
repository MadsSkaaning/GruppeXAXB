package model.calendar;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONObject;


// TODO: Auto-generated Javadoc
/**
 * The Class GetCalendarData.
 */
public class GetCalendarData {
	
	/** The cbsevents. */
	Events cbsevents = new Events();
	
	/** The e. */
	EncryptUserID e = new EncryptUserID();

	//Fetches DATA from Url and convers to String
	/**
	 * Read url.
	 *
	 * @param urlString the url string
	 * @return the string
	 * @throws Exception the exception
	 */
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}




	/**
	 * Allows client to retrieve CBS's calendar and then access it.
	 *
	 * @return the data from calendar
	 * @throws Exception the exception
	 */
	public String getDataFromCalendar() throws Exception {

		/**
		 * Get URL From calendar.cbs.dk -> Subscribe -> change URL to end with .json
		 * Encrypt hash from
		 */
		String userID = "haje13ac";
		String json = readUrl("http://calendar.cbs.dk/events.php/"+userID+"/"+e.getKey()+".json");

		return json;






	}
}
