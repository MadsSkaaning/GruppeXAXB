import java.sql.SQLException;
import java.util.ArrayList;

import model.Forecast.Forecast;
import model.Forecast.ForecastModel;
import model.QOTD.QOTDModel;
import model.calendar.Event;
import model.note.Note;
import JsonClasses.AuthUser;
import JsonClasses.CalendarInfo;
import JsonClasses.CreateCalendar;
import JsonClasses.CreateEvent;
import JsonClasses.CreateNote;
import JsonClasses.DeleteCalendar;
import JsonClasses.DeleteEvent;
import JsonClasses.DeleteNote;
import JsonClasses.GetCalendar;
import JsonClasses.GetEvent;
import JsonClasses.GetNote;

import com.google.gson.*;

import databaseMethods.SwitchMethods;

public class GiantSwitch {
	
	
	
	public String GiantSwitchMethod(String jsonString) throws SQLException {

		//Events eventsKlasse = new Events(0, 0, 0, jsonString, jsonString, jsonString, jsonString, jsonString);

		Note noteKlasse = new Note();
		ForecastModel forecastKlasse = new ForecastModel();
		QOTDModel QOTDKlasse = new QOTDModel();
		SwitchMethods SW = new SwitchMethods();
		
		Gson gson = new GsonBuilder().create();
		String answer = "";	
		//Creates a switch which determines which method should be used. Methods will be applied later on
		switch (Determine(jsonString)) {
		//If the Json String contains one of the keywords below, run the relevant method.

		/************
		 ** COURSES **
		 ************/

		case "importCalendar":
			System.out.println("Recieved importCourse");
			break;

		/**********
		 ** LOGIN **
		 **********/
		case "logIn":
			AuthUser AU = (AuthUser)gson.fromJson(jsonString, AuthUser.class);
			System.out.println("Recieved logIn");
			
			System.out.println("Det her printer den hvis den bruger metoden");
			try {
				answer = SW.authenticate(AU.getAuthUserEmail(), AU.getAuthUserPassword());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "logOut":
			System.out.println("Recieved logOut");
			break;
 
		/*************
		 ** CALENDAR **
		 *************/
		case "createCalendar":
			CreateCalendar CC = (CreateCalendar)gson.fromJson(jsonString, CreateCalendar.class);
			System.out.println(CC.getCalendarName()+ "Den har lagt det nye ind i klassen");
			answer = SW.createNewCalendar(CC.getCalendarName(), CC.getCreatedby(), CC.getPublicOrPrivate());
			break;
		
		case "deleteCalendar":
			DeleteCalendar DC = (DeleteCalendar)gson.fromJson(jsonString, DeleteCalendar.class);
			System.out.println(DC.getCalendarName()+ "Has been deleted");
			answer = SW.deleteCalendar(DC.getCreatedby(), DC.getCalendarName());
			break;
		
		case "saveImportedCalendar":
			
			break;
			
		case "getCalendar":
			GetCalendar gC = (GetCalendar)gson.fromJson(jsonString, GetCalendar.class);
			System.out.println("Recieved getCalendar");
			answer = SW.getCalendar(gC.getCalendarName());
			break;

		case "getEvent":
			GetEvent gE = (GetEvent)gson.fromJson(jsonString, GetEvent.class);
			System.out.println("Recieved getEvent");
			answer = SW.getEvent(gE.getEventID());
			break;

		case "createEvent":
			CreateEvent CE = (CreateEvent)gson.fromJson(jsonString, CreateEvent.class);
			System.out.println("Recieved saveEvent");
			answer = SW.createNewEvent(CE.getCreatedby(), CE.getEventName(), CE.getStart(), CE.getEnd(), CE.getLocation(), CE.getDescription(), CE.getCalendarID());
			break;

		case "getEventInfo":
			System.out.println("Recieved getEventInfo");
			break;
			
		case "deleteEvent":
			DeleteEvent DE = (DeleteEvent)gson.fromJson(jsonString, DeleteEvent.class);
			System.out.println(DE.getEventID()+ "Has been deleted");
			answer = SW.deleteEvent(DE.getCreatedby(), DE.getEventID());
			break;
		
		case "createNote":
			CreateNote CN = (CreateNote)gson.fromJson(jsonString, CreateNote.class);
			System.out.println("Note Created!");
			answer = SW.createNewNote(CN.getEventID(), CN.getCreatedby(), CN.getNote(), CN.getDatetime());
			break;

		case "getNote":
			GetNote gN = (GetNote)gson.fromJson(jsonString, GetNote.class);
			System.out.println("Recieved getNote");
			answer = SW.getNote(gN.getNoteID());
			break;
			
		case "deleteNote":
			DeleteNote DN = (DeleteNote)gson.fromJson(jsonString, DeleteNote.class);
			System.out.println(DN.getNoteID()+ "Has been deleted");
			answer = SW.deleteNote(DN.getCreatedby(), DN.getNoteID());
			break;

		/**********
		 ** QUOTE **
		 **********/
		case "getQuote":
			QOTDKlasse.saveQuote();
			answer = QOTDKlasse.getQuote();
			System.out.println("Received Quote Request");
			
			//answer = "skerder Hassan";
			
			break;

		/************
		 ** WEATHER **
		 ************/

		case "getClientForecast":
			ForecastModel fm = new ForecastModel();
	        
	        ArrayList<Forecast> forecastList = fm.requestForecast();
	        
	        for (int i = 0; i < forecastList.size(); i++) {
	        	System.out.println(forecastList.get(i).toString());
			}
			
			System.out.println("Recieved getClientForecast");
			break;
		
		default:
			System.out.println("Error");
			break;
		}
		return answer;
		
	}

	//Creates a loooong else if statement, which checks the JSon string which keyword it contains, and returns the following 
	//keyword if
	public String Determine(String ID) {

		if (ID.contains("getEvent")) {
			return "getEvent";
		} else if (ID.contains("getEventInfo")) {
			return "getEventInfo";
		} else if (ID.contains("saveNote")) {
			return "saveNote";
		} else if (ID.contains("getNote")) {
			return "getNote";
		} else if (ID.contains("deleteNote")){
			return "deleteNote";
		}else if  (ID.contains("deleteCalendar")){
			return "deleteCalendar";
		} else if (ID.contains("getClientForecast")) {
			return "getClientForecast";
		} else if (ID.contains("saveImportedCalendar")) {
			return "saveImportedCalendar";
		}else if (ID.contains("importCourse")) {
			return "importCourse";
		} else if (ID.contains("exportCourse")) {
			return "exportCourse";
		} else if (ID.contains("getQuote")) {
			return "getQuote";
		} else if (ID.contains("logIn")) {
			return "logIn";
		} else if (ID.contains("logOut")) {
			return "logOut";
		} else if (ID.contains("getCalendar")) {
			return "getCalendar";
		} else if (ID.contains("createEvent")) {
			return "createEvent";
		} else if (ID.contains("deleteEvent")) {
			return "deleteEvent"; 
		} else if (ID.contains("createCalendar")) {
			return "createCalendar";
		}
		  else if (ID.contains("createNote")) {
			return "createNote";
		}

		else
			return "error";
	}
}
