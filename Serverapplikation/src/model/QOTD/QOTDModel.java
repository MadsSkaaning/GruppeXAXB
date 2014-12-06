package model.QOTD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






import java.util.Date;

import model.Forecast.Forecast;
import model.QueryBuild.QueryBuilder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import config.Configurations;

// TODO: Auto-generated Javadoc
/**
 * The Class QOTDModel.
 */
public class QOTDModel {
	
	/** The cf. */
	Configurations cf = new Configurations();

	/** The qotdlist. */
	private ArrayList<QOTD> qotdlist = new ArrayList<>();

	/** The qotdlist2. */
	QOTD qotdlist2 = new QOTD(null, null, null);
	
	/** The qb. */
	QueryBuilder qb = new QueryBuilder();

	/** The result set. */
	private ResultSet resultSet;

	/**
	 * Read url.
	 *
	 * @param urlString the url string
	 * @return the string
	 * @throws Exception the exception
	 */ 
	public static String readUrl(String urlString) throws Exception {

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
	 * Save quote.
	 */
	public void saveQuote() {



		Configurations cf = new Configurations();

		/**
		 * getting text from website and putiing into string
		 * Making a new object of JSON, and prints out quote
		 */
		String json;
		try {
			json = readUrl(cf.getQotdlink());

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

			String quote = json;

			quote = quote.replace("'","''");

			String author = (String) jsonObject.get("author");
			String topic = (String) jsonObject.get("topic");


			String[] fields = {"qotd"};
			String[] values = {quote};


			qb.update("dailyupdate", fields, values).where("msg_type", "=", "1").Execute();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * Retrieve Quote from a website and put it into a String, 
	 * Afterwards we will make it into a json object so it can be printed out to the client.
	 *
	 * @return the quote
	 */
	public String getQuote(){
		String q = "";
		String[] key = {"qotd"};
		try {
			resultSet = qb.selectFrom("dailyupdate").all().ExecuteQuery();
			while(resultSet.next()) {
				q = resultSet.getString("qotd");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}


	/**
	 * Update quote.
	 */
	public void updateQuote(){
		Date date = new Date(); // Current date & time


		long maxTimeNoUpdate = Long.parseLong(cf.getQotdupdatetime());
		// Maximum one day with no update

		long date1 = date.getTime();
		long date2 = date.getTime() - maxTimeNoUpdate; // minus 1 hour -- should be fetched from database

		long timeSinceUpdate = date1 - date2; 

		// if more than 1 day ago, do update
		if(timeSinceUpdate > Long.parseLong(cf.getQotdupdatetime())){
			// return fresh weather data
			saveQuote();	
		} 
	}

}
