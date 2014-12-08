package logic;

import JsonClasses.AuthUser;
import JsonClasses.CreateCalendar;
import JsonClasses.CreateEvent;
import JsonClasses.CreateNote;
import JsonClasses.DeleteCalendar;
import JsonClasses.DeleteEvent;
import JsonClasses.DeleteNote;
import JsonClasses.GetCalendar;
import JsonClasses.GetEvent;
import JsonClasses.GetFromCBS;
import JsonClasses.GetNote;
import JsonClasses.QOTD;
import JsonClasses.WeatherInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gui.LoginScreen;

public class ObjectCreator {
	
	
	//Denne klasse bruges til at oprette JSON Objekter, der kan sendes til serveren.
	//Hver metode pakker en JSON klasse til en Streng ved brug GSON API'et.
	// Metoden kan så kaldes for at retunere en Streng af objektet.
	
	private Gson gson = new GsonBuilder().create();
	
	private AuthUser AU = new AuthUser();
	
	private WeatherInfo WE = new WeatherInfo();
	
	private QOTD quote = new QOTD(null, null, null);
	
	private CreateCalendar CC = new CreateCalendar();
	
	private CreateEvent CE = new CreateEvent();
	
	private CreateNote CN = new CreateNote();
	
	private GetCalendar gC = new GetCalendar();
	
	private GetEvent gE = new GetEvent();
	
	private GetNote gN = new GetNote();
	
	private DeleteEvent DE = new DeleteEvent();
	
	private DeleteCalendar DC = new DeleteCalendar();
	
	private DeleteNote DN = new DeleteNote();
	
	private GetFromCBS getCBS = new GetFromCBS();
	

	
	private String createcalendarname;
	
	private String createdBy;
	
	private int publicprivate;
	private String getcalendarname;
	
	//Grundet at mit loginScreen af UFORKLARLIGE årsager ikke kan hente texten fra textfields, har jeg været nødsaget til at hardcode loginet for en bruger...
	//Det havde ellers skulle fungerer som f.eks. Create Calendar hvor den setter værdierne for den tilsvarende JSON klasse vha. værdierne fra tekstfelterne.
	
	public String authenticateUser(){
		
		
		AU.setAuthUserEmail("user");
		AU.setAuthUserIsAdmin(false);
		AU.setAuthUserPassword("user");
				
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
	
	public String createCalendar(String createcalendarname, String createdBy, int publicprivate){
		
		this.createcalendarname = createcalendarname;
		this.createdBy = createdBy;
		this.publicprivate = publicprivate;
		
		CC.setCalendarName(createcalendarname);
		CC.setCreatedby(createdBy);
		CC.setPublicOrPrivate(publicprivate);
		
		
		
		String createCalendarRequest = gson.toJson(CC);
		
		return createCalendarRequest;
		
	}
	
public String createEvent(){
		
		
		CE.setCreatedby(1);
		CE.setLocation("1");
		CE.setStart("01-01-01 02:01:00");
		CE.setEnd("02-02-02 00:01:02");
		CE.setEventName("Bï¿½gse");
		CE.setDescription("dette er flot");
		CE.setCalendarID("1");
		
		
		
		
		String createCalendarRequest = gson.toJson(CE);
		
		return createCalendarRequest;
	}
	
	
public String getCalendar(String getcalendarname ){
			
			this.getcalendarname = getcalendarname;
			gC.setCalendarName(getcalendarname);
			
			String getCalendarRequest = gson.toJson(gC);
			return getCalendarRequest;
			
				
}			
			
public String deleteCalendar(){
				
				
				
				DC.setCreatedby("1");
				DC.setCalendarName("Fuckalting");
				
				String getDeleteCalendar = gson.toJson(DC);
				return getDeleteCalendar;



			}

public String getEvent(){
	
	
	
	gE.setEventID("1");
	
	String getEventRequest = gson.toJson(gE);
	return getEventRequest;



}

public String deleteEvent(){
	
	
	
	DE.setCreatedby("1");
	DE.setEventID("1");
	
	String getDeleteEvent = gson.toJson(DE);
	return getDeleteEvent;



}

public String createNote(){
	
	
	CN.setEventID("1");
	CN.setCreatedby("1");
	CN.setNote("Dette er en hardcodet note, til at se om det egentlig virker!");
	CN.setDatetime("2011-11-11 11:11:11");
	
	
	
	String createNoteRequest = gson.toJson(CN);
	return createNoteRequest;
}


public String getNote(){
	
	
	
	gN.setNoteID("1");
	
	String getNoteRequest = gson.toJson(gN);
	return getNoteRequest;



}

public String deleteNote(){
	
	
	
	DN.setCreatedby("1");
	DN.setNoteID("1");
	
	String getDeleteNote = gson.toJson(DN);
	return getDeleteNote;



}

public String getCBSData(){
	
	String getCBSData = gson.toJson(getCBS);
	
	return getCBSData;
}

}
