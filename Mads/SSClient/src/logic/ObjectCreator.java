package logic;


import JsonClasses.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gui.LoginScreen;

public class ObjectCreator {
	
	private Gson gson = new GsonBuilder().create();
	private AuthUser AU = new AuthUser();
	private QOTD quote = new QOTD(null, null, null);
	private WeatherInfo weather = new WeatherInfo();
	private CreateCalendar createCal = new CreateCalendar();
	
	//unused but called methods to retrieve info to client
	
	private CalendarInfo CI = new CalendarInfo();
	private CreateEvent CE = new CreateEvent();
	private CreateNote CN = new CreateNote();
	private DeleteCalendar DC = new DeleteCalendar();
	private DeleteEvent DE = new DeleteEvent();
	private DeleteNote DN = new DeleteNote();
	private Eventsinfo EI = new Eventsinfo();
	private GetCalendar GC = new GetCalendar();
	private GetEvent GE = new GetEvent();
	private GetNote GN = new GetNote();
		
	
	
	
	//Det her er en metode der opretter authenticate user og sender til esrveren.
	public String authenticateUser(){
		
		AU.setAuthUserEmail("user");
		AU.setAuthUserPassword("user");
		AU.setAuthUserIsAdmin(false);
		
		String objecttilserver = gson.toJson(AU);
		return objecttilserver;
		
	}

	// ALa den her metode opretter jeg denne.
	public String getQOTD() {
		String qotdToServer = gson.toJson(quote);
		return qotdToServer;
	}

	public String getWeather() {
		String weatherToServer = gson.toJson(weather);
		return weatherToServer;
	}

	public String createCalendar() {
		String createCalendar = gson.toJson(createCal);
		
		createCal.setCalendarName("Testname");
		createCal.setCreatedby("1");
		createCal.setPublicOrPrivate(0);
		createCal.setActive("1");
		
		return createCalendar;
	}
	
	
	public String getEvent(){
		
		String getEvent = gson.toJson(GE);
		return getEvent;
		
	}

	public String createNote() {
		
		String createNote = gson.toJson(CN);
		return createNote;
	}

	public String createEvent() {

		String createEvent = gson.toJson(CE);
		return createEvent;
		
	}

	public String deleteEvent() {

		String deleteEvent = gson.toJson(DE);
		return deleteEvent;
	}

	public String deleteCalendar() {
		String deleteCalendar = gson.toJson(DC);
		return deleteCalendar;
	}

	public String deleteNote() {
		String deleteNote = gson.toJson(DN);
		return deleteNote;
		
	}
	
	
}
