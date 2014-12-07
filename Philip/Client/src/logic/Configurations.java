package logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Importing json packages
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// TODO: Auto-generated Javadoc
/**
 * The Class Configurations.
 */


// Using this class to prevent hardcoded variables for server.
// Can prove useful, if server changes its serversocket, port or host adress
public class Configurations {

	/** The host. */
	private String host;

	/** The port. */
	private String port;

	/** The serverhost. */
	private String serverhost;

	/** The ffcryptkey. */
	private String ffcryptkey;

	/**
	 * Instantiates a new configurations.
	 */
	public Configurations() {

		ReadFile();
	}


	/**
	 * Gets the serverhost socket port.
	 * Which is the port of the socket
	 * @return the serverhost
	 */
	public String getServerhost() {
		return serverhost;
	}


	/**
	 * Sets the serverhost.
	 *
	 * @param serverhost the new serverhost
	 */
	public void setServerhost(String serverhost) {
		this.serverhost = serverhost;
	}


	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Sets the host.
	 *
	 * @param host the new host
	 */
	public void setHost(String host) {

		this.host = host;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(String port) {
		this.port = port;
	}


	/**
	 * Gets the ffcryptkey.
	 *
	 * @return the ffcryptkey
	 */
	public String getFfcryptkey() {
		return ffcryptkey;
	}

	/**
	 * Sets the ffcryptkey.
	 *
	 * @param ffcryptkey the new ffcryptkey
	 */
	public void setFfcryptkey(String ffcryptkey) {
		this.ffcryptkey = ffcryptkey;
	}


	// Method to read files from jSON file
	/**
	 * Read file.
	 */
	public void ReadFile() {
		JSONParser jsonParser = new JSONParser();

		try {
			FileReader json = new FileReader("src/config.json");

			Object obj = jsonParser.parse(json);
			JSONObject jsonObject = (JSONObject) obj;

			// Getting json values for SQL variables and DB
			setHost((String) jsonObject.get("host"));
			setPort((String) jsonObject.get("port"));

			// Getting json values for KEY variables
			setFfcryptkey((String) jsonObject.get("ffcryptkey"));

			// Getting json values for server host
			setServerhost((String) jsonObject.get("serversocket"));


		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main (String [] args ){

		Configurations cf = new Configurations();

		System.out.println(cf.ffcryptkey);


	}

}