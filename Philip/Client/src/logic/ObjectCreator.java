package logic;

import JsonClasses.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import GUI.Login;

public class ObjectCreator {
	
	private Login login;
	
	private Gson gson = new GsonBuilder().create();//
	
	private AuthUser AU = new AuthUser();//
	
	private CalendarInfo CI = new CalendarInfo();//
	
	private CreateCalendar CC = new CreateCalendar();//
	
	private CreateEvent CE = new CreateEvent();//
	
	private CreateNote CN = new CreateNote();//
	
	private DeleteCalendar DC = new DeleteCalendar();//
	
	private DeleteEvent DE = new DeleteEvent();//
	
	private DeleteNote DN = new DeleteNote();//
	
	private Eventsinfo EI = new Eventsinfo();//
	
	private GetCalendar GC = new GetCalendar();
	
	private GetEvent GE = new GetEvent();
	
	private GetNote GN = new GetNote();
	
	private QOTD qotd = new QOTD(null, null, null);//
	
	private WeatherInfo WE = new WeatherInfo();//
	

	

	
	
	
	public String authenticateUser(){
		
		
		AU.setAuthUserEmail("user");
		AU.setAuthUserPassword("user");
		AU.setAuthUserIsAdmin(false);

		
		String objecttilserver = gson.toJson(AU);
		
		
		return objecttilserver;
				
		
	}
	
	public String getWeather(){
		
		
		
		String weatherRequest = gson.toJson(WE);
		
		return weatherRequest;
		
		
	}
	
	
	
	public String getQuote(){
		
		String quoteRequest = gson.toJson(qotd);
		
		return quoteRequest;
	}
	
	public String createCalendar(){
		
		CC.setCalendarName("");
		CC.setCreatedby("");
		CC.setPublicOrPrivate(1);
		
		
		
		String createCalendarRequest = gson.toJson(CC);
		
		return createCalendarRequest;
		
	}
	
	public String createEvent(){
		
		
		CE.setCreatedby(1);
		CE.setLocation("1");
		CE.setStart("01-01-01 02:01:00");
		CE.setEnd("02-02-02 00:01:02");
		CE.setEventName("B�gse");
		CE.setDescription("dette er flot");
		CE.setCalendarID("1");
		
		
		
		
		String createEventRequest = gson.toJson(CE);
		
		return createEventRequest;
	
}
	
	public String createNote(){
		
		
		CN.setCreatedby("");
		CN.setNoteID("");
		CN.setEventID("");
		CN.setDatetime("");
		CN.setNote("");
		CN.setActive("1");
		
		String createNoteRequest = gson.toJson(CN);
		
		return createNoteRequest;
	}
	
	public String deleteCalendar(){
		
		DC.setCalendarName("");
		DC.setCreatedby("");
		DC.setActive("0");
		
		String deleteCalendarRequest = gson.toJson(DC);
		
		return deleteCalendarRequest;
	}
	
	public String deleteEvent(){
		
		DE.setEventID("");
		DE.setCreatedby("");
		DE.setActive("0");
		
		String deleteEventRequest = gson.toJson(DE);
		
		return deleteEventRequest;
	}
	
	public String deleteNote(){
		
		DN.setNoteID("");
		DN.setEventID("");
		DN.setCreatedby("");
		DN.setActive("0");
		
		String deleteNoteRequest = gson.toJson(DN);
		
		return deleteNoteRequest;
	}
	
	public String CalendarInfo(){
//		
//		CI.setCalendarID("");
//		CI.setCalendarName("");
//		CI.setCreatedby("");
//		CI.setPublicOrPrivate(1);
//		CI.setActive("");
		
		
		String calendarInfoRequest = gson.toJson(CI);
		
		return calendarInfoRequest;
		
	}
	
	public String EventsInfo(){
		
		String eventsInfoRequest = gson.toJson(EI);
		
		return eventsInfoRequest;
	}
	
	public String getEvent(){
		
		String getEventRequest = gson.toJson(GE);
		
		return getEventRequest;
		
		
	}
	
	
}
