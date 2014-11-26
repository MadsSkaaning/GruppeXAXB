package config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Importing json packages
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Configurations {
    private String host;
    private String port;
    private String username;
    private String dbname;
    private String password;
    private String serverhost;
   
   
   
    // FFkey is used in Encryption.java
    private String ffcryptkey;
    
    public Configurations() {
    	
    	ReadFile();
    }
    

	public String getServerhost() {
		return serverhost;
	}


	public void setServerhost(String serverhost) {
		this.serverhost = serverhost;
	}


	public String getHost() {
        return host;
    }

    public void setHost(String host) {
    	
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
    	
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getFfcryptkey() {
        return ffcryptkey;
    }

    public void setFfcryptkey(String ffcryptkey) {
        this.ffcryptkey = ffcryptkey;
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
            
            // Getting json values for server host
            setServerhost((String) jsonObject.get("serverhost"));
            

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
    
    
    public static void main (String [] args ){
    	
    	Configurations cf = new Configurations();
    	
    	System.out.println(cf.ffcryptkey);

    	
    	
    	
    }
    
}
