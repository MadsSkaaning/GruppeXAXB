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
    
   private String textMenu1;
   private String textMenu2;
   private String textMenu3;
   private String textMenu4;
   private String textMenu5;

  
   
   
    // FFkey is used in Encryption.java
    private String ffcryptkey;

    
     
    
    
    public Configurations() {
    	
    	ReadFile();
    }
    
    
    // All variables for menus - in comment will be the current text
    
    
    // text home example
    public String getTextMenu1() {
		return textMenu1;
	}

	public String getTextMenu2() {
		return textMenu2;
	}

	public String getTextMenu3() {
		return textMenu3;
	}

	public String getTextMenu4() {
		return textMenu4;
	}

	public String getTextMenu5() {
		return textMenu5;
	}

	public void setTextMenu5(String textMenu5) {
		this.textMenu5 = textMenu5;
	}

	public void setTextMenu4(String textMenu4) {
		this.textMenu4 = textMenu4;
	}

	public void setTextMenu3(String textMenu3) {
		this.textMenu3 = textMenu3;
	}

	public void setTextMenu2(String textMenu2) {
		this.textMenu2 = textMenu2;
	}

	public void setTextMenu1(String textMenu1) {
		this.textMenu1 = textMenu1;
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
            
            // getting json values menu variables
            setTextMenu1((String) jsonObject.get("menutext1"));
            setTextMenu2((String) jsonObject.get("menutext2"));
            setTextMenu3((String) jsonObject.get("menutext3"));
            setTextMenu4((String) jsonObject.get("menutext4"));


            // Getting json values for SQL variables and DB
            setHost((String) jsonObject.get("host"));
            setPort((String) jsonObject.get("port"));
            setUsername((String) jsonObject.get("username"));
            setDbname((String) jsonObject.get("dbname"));
            setPassword((String) jsonObject.get("password"));

            // Getting json values for KEY variables
            setFfcryptkey((String) jsonObject.get("ffcryptkey"));
            


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
    	System.out.println(cf.textMenu1);
    	System.out.println(cf.textMenu2);
    	
    	
    	
    }
    
}
