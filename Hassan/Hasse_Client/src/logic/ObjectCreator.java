package logic;

import JsonClasses.AuthUser;
import JsonClasses.CreateCalendar;
import JsonClasses.CreateEvent;
import JsonClasses.GetCalendar;
import JsonClasses.GetEvent;
import JsonClasses.QOTD;
import JsonClasses.WeatherInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gui.LoginScreen;

public class ObjectCreator {
	
	private LoginScreen login = new LoginScreen();
	
	private Gson gson = new GsonBuilder().create();
	
	private AuthUser AU = new AuthUser();
	
	private WeatherInfo WE = new WeatherInfo();
	
	private QOTD quote = new QOTD(null, null, null);
	
	private CreateCalendar CC = new CreateCalendar();
	
	private CreateEvent CE = new CreateEvent();
	
	private GetCalendar gC = new GetCalendar();
	
	private GetEvent gE = new GetEvent();
	
	
	public String authenticateUser(){
		
		
		AU.setAuthUserEmail("test");

		System.out.println(login.getUsername());
		AU.setAuthUserIsAdmin(false);
		AU.setAuthUserPassword("123");
		System.out.println(login.getPassword());
				
		String logintilserver = gson.toJson(AU);
		
		
		return logintilserver;
				
		
	}
	
	public String getWeather(){
		
		
		
		String weatherRequest = gson.toJson(WE);
		
		return weatherRequest;
		
		
	}
	
	
	
	public String getQuote(){
		
		String quoteRequest = gson.toJson(quote);
		
		return quoteRequest;
	}
	
	public String createCalendar(){
		
		CC.setCalendarName("Fuckalting");
		CC.setCreatedby("1");
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
		
		
		
		
		String createCalendarRequest = gson.toJson(CE);
		
		return createCalendarRequest;
	}
	
	
public String getCalendar(){
			
			
			gC.setCalendarName("Fuckalting");
			
			String getCalendarRequest = gson.toJson(gC);
			return getCalendarRequest;
	
	
	
}

public String getEvent(){
	
	
	
	gE.setEventID("1");
	
	String getEventRequest = gson.toJson(gE);
	return getEventRequest;



}

}
