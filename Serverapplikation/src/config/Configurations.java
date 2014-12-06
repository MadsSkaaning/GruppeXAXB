package config;

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
public class Configurations {
    
    /** The host. */
    private String host;
    
    /** The port. */
    private String port;
    
    /** The username. */
    private String username;
    
    /** The dbname. */
    private String dbname;
    
    /** The password. */
    private String password;
    
    /** The serversocket. */
    private String serversocket;
    
    //QOTD variables
    /** The qotdlink. */
    private String qotdlink;
    
    /** The qotdupdatetime. */
    private String qotdupdatetime;

    // FFkey is used in Encryption.java
    /** The ffcryptkey. */
    private String ffcryptkey;

    // Weather variables
    /** The weather_expiration_time. */
    private String weather_expiration_time;
    
    /** The weather_lat. */
    private String weather_lat;
    
    /** The weather_lon. */
    private String weather_lon;
    
    /** The weather_future_in_days. */
    private String weather_future_in_days;

    /**
     * Instantiates a new configurations.
     */
    public Configurations() {
    	
    	ReadFile();
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
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
    	
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the dbname.
     *
     * @return the dbname
     */
    public String getDbname() {
        return dbname;
    }

    /**
     * Sets the dbname.
     *
     * @param dbname the new dbname
     */
    public void setDbname(String dbname) {
        this.dbname = dbname;
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
    
	/**
	 * Gets the serversocket.
	 *
	 * @return the serversocket
	 */
	public String getServersocket() {
		return serversocket;
	}

	/**
	 * Sets the serversocket.
	 *
	 * @param serversocket the new serversocket
	 */
	public void setServersocket(String serversocket) {
		this.serversocket = serversocket;
	}

    /**
     * Gets the qotdlink.
     *
     * @return the qotdlink
     */
    public String getQotdlink() {
		return qotdlink;
	}

	/**
	 * Sets the qotdlink.
	 *
	 * @param qotdlink the new qotdlink
	 */
	public void setQotdlink(String qotdlink) {
		this.qotdlink = qotdlink;
	}


	/**
	 * Gets the qotdupdatetime.
	 *
	 * @return the qotdupdatetime
	 */
	public String getQotdupdatetime() {
		return qotdupdatetime;
	}

	/**
	 * Sets the qotdupdatetime.
	 *
	 * @param qotdupdatetime the new qotdupdatetime
	 */
	public void setQotdupdatetime(String qotdupdatetime) {
		this.qotdupdatetime = qotdupdatetime;
	}

	/**
	 * Gets the weather_expiration_time.
	 *
	 * @return the weather_expiration_time
	 */
	public String getWeather_expiration_time() {
        return weather_expiration_time;
    }

    /**
     * Sets the weather_expiration_time.
     *
     * @param weather_expiration_time the new weather_expiration_time
     */
    public void setWeather_expiration_time(String weather_expiration_time) {
        this.weather_expiration_time = weather_expiration_time;
    }


    /**
     * Gets the weather_lat.
     *
     * @return the weather_lat
     */
    public String getWeather_lat() {
        return weather_lat;
    }

    /**
     * Sets the weather_lat.
     *
     * @param weather_lat the new weather_lat
     */
    public void setWeather_lat(String weather_lat) {
        this.weather_lat = weather_lat;
    }


    /**
     * Gets the weather_lon.
     *
     * @return the weather_lon
     */
    public String getWeather_lon() {
        return weather_lon;
    }

    /**
     * Sets the weather_lon.
     *
     * @param weather_lon the new weather_lon
     */
    public void setWeather_lon(String weather_lon) {
        this.weather_lon = weather_lon;
    }

    /**
     * Gets the weather_future_in_days.
     *
     * @return the weather_future_in_days
     */
    public String getWeather_future_in_days() {
        return weather_future_in_days;
    }

    /**
     * Sets the weather_future_in_days.
     *
     * @param weather_future_in_days the new weather_future_in_days
     */
    public void setWeather_future_in_days(String weather_future_in_days) {
        this.weather_future_in_days = weather_future_in_days;
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
            setUsername((String) jsonObject.get("username"));
            setDbname((String) jsonObject.get("dbname"));
            setPassword((String) jsonObject.get("password"));
            setServersocket((String) jsonObject.get("serversocket"));
            
            // QOTD variables
            setQotdlink((String) jsonObject.get("qotdlink"));
            setQotdupdatetime((String) jsonObject.get("qotdupdatetime"));

            // Getting json values for KEY variables
            setFfcryptkey((String) jsonObject.get("ffcryptkey"));

            // Getting json values for weather variables
            setWeather_expiration_time((String) jsonObject.get("weather_expiration_date"));
            setWeather_lat((String) jsonObject.get("weather_lat"));
            setWeather_lon((String) jsonObject.get("weather_lon"));
            setWeather_future_in_days((String) jsonObject.get("weather_future_in_days"));

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

}
