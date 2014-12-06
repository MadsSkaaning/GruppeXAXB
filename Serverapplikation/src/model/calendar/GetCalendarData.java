package model.calendar;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONObject;

/**
 * Created by jesperbruun on 13/10/14.
 */
public class GetCalendarData {
	Events cbsevents = new Events();
	EncryptUserID e = new EncryptUserID();

	//henter data fra URL og l??er ind til en string
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
     * @throws Exception
     */
    public void getDataFromCalendar() throws Exception {

        /**
         * Get URL From calendar.cbs.dk -> Subscribe -> change URL to end with .json
         * Encrypt hash from
         */
    	String userID = "haje13ac";
        String json = readUrl("http://calendar.cbs.dk/events.php/"+userID+"/"+e.getKey()+".json");
        
        System.out.println(json);
        

        Gson gson = new Gson();
        
       ArrayList<Event> sup = gson.fromJson(json, Events.class).getEvents();
        
       cbsevents.setEvents(sup);
       
       System.out.println(cbsevents.toString());
     
        

        
    }
}
