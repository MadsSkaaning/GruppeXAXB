package logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Importing json packages
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//Klasser der l�ser configurations data fra en JSON fil. Skulle prim�rt v�ret blevet brugt til kryptering p� klienten, da der er f� hardcodede variable at finde her alligevel....
//Er her pga. mulig vider udvikling.

public class Configurations {
    private String host;
    private String port;
    private String username;
    private String dbname;
    private String password;

    // FFkey is used in Encryption.java
    private String ffcryptkey;

    // Weather variables
    private String weather_expiration_time;
    private String weather_lat;
    private String weather_lon;
    private String weather_future_in_days;

    public String getHost() {
    	ReadFile();
        return host;
    }

    public void setHost(String host) {
    	
        this.host = host;
    }

    public String getPort() {
    	ReadFile();
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
    	
    	ReadFile();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
    	ReadFile();
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbname() {
    	ReadFile();
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getFfcryptkey() {
    	ReadFile();
        return ffcryptkey;
    }

    public void setFfcryptkey(String ffcryptkey) {
        this.ffcryptkey = ffcryptkey;
    }


// Weather settrs and getters.

    public String getWeather_expiration_time() {
    	ReadFile();
        return weather_expiration_time;
    }

    public void setWeather_expiration_time(String weather_expiration_time) {
        this.weather_expiration_time = weather_expiration_time;
    }


    public String getWeather_lat() {
    	ReadFile();
        return weather_lat;
    }

    public void setWeather_lat(String weather_lat) {
        this.weather_lat = weather_lat;
    }


    public String getWeather_lon() {
    	ReadFile();
        return weather_lon;
    }

    public void setWeather_lon(String weather_lon) {
        this.weather_lon = weather_lon;
    }

    public String getWeather_future_in_days() {
    	ReadFile();
        return weather_future_in_days;
    }

    public void setWeather_future_in_days(String weather_future_in_days) {
        this.weather_future_in_days = weather_future_in_days;
    }


    // Method to read files from jSON file

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
