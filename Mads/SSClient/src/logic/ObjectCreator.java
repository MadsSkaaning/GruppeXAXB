package logic;


import JsonClasses.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gui.LoginScreen;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectCreator.
 */

// This class is used to create the objects to be send to the server. 
// It is being packed in the JsonClasses
public class ObjectCreator {

	/** The gson. */
	private Gson gson = new GsonBuilder().create();

	/** The au. */
	private AuthUser AU = new AuthUser();

	/** The quote. */
	private QOTD quote = new QOTD(null, null, null);

	/** The weather. */
	private WeatherInfo weather = new WeatherInfo();

	/** The create cal. */
	private CreateCalendar createCal = new CreateCalendar();

	/** The Calendar Info. */
	private CalendarInfo CI = new CalendarInfo();

	/** The ce. */
	private CreateEvent CE = new CreateEvent();

	/** The cn. */
	private CreateNote CN = new CreateNote();

	/** The dc. */
	private DeleteCalendar DC = new DeleteCalendar();

	/** The de. */
	private DeleteEvent DE = new DeleteEvent();

	/** The dn. */
	private DeleteNote DN = new DeleteNote();

	/** The ei. */
	//This EventInfo isnt used yet, but is one of the methods on the GiantSwitch serverside.
	private Eventsinfo EI = new Eventsinfo();

	/** The gc. */
	private GetCalendar GC = new GetCalendar();

	/** The ge. */
	private GetEvent GE = new GetEvent();

	/** The gn. */
	private GetNote GN = new GetNote();
	
	private GetFromCBS GFCBS = new GetFromCBS();


	//Authenticates user and sends object to servers and expects server to send 
	//answer from GiantSwtich back after validating the Json String.

	/**
	 * Authenticate user.
	 *
	 * @return the string
	 */

	//This authenticates the user, by setting the values in the AuthUser object AU.
	public String authenticateUser(){


		//This is not meant to be hardcoded.
		AU.setAuthUserEmail("user");
		AU.setAuthUserPassword("user");
		AU.setAuthUserIsAdmin(false);

		/**The original idea was to call it straight from the GUI class, but after 5 hours of non completion, i've chosed
		to move on - somehow it cant connect with the 3 classes as supposed.

		This has to do with the creation of objects in both ObjectCreator, Controller class and the GuiLogic. Unfortunately.
		 */ 

		String objecttilserver = gson.toJson(AU);
		return objecttilserver;

	}



	/**
	 * Gets the qotd.
	 *
	 * @return the qotd
	 */
	public String getQOTD() {
		String qotdToServer = gson.toJson(quote);
		return qotdToServer;
	}

	/**
	 * Gets the weather.
	 *
	 * @return the weather
	 */
	public String getWeather() {
		String weatherToServer = gson.toJson(weather);
		return weatherToServer;
	}

	/**
	 * Creates the calendar.
	 *
	 * @return the string
	 */
	public String createCalendar() {
		String createCalendar = gson.toJson(createCal);

		createCal.setCalendarName("Testname");
		createCal.setCreatedby("1");
		createCal.setPublicOrPrivate(0);
		createCal.setActive("1");

		return createCalendar;
	}


	/**
	 * Gets the event.
	 *
	 * @return the event
	 */
	public String getEvent(){

		String getEventData = gson.toJson(GFCBS);
		return getEventData;

	}

	/**
	 * Creates the note.
	 *
	 * @return the string
	 */
	public String createNote() {

		String createNote = gson.toJson(CN);
		return createNote;
	}

	/**
	 * Creates the event.
	 *
	 * @return the string
	 */
	public String createEvent() {

		String createEvent = gson.toJson(CE);
		return createEvent;

	}

	/**
	 * Delete event.
	 *
	 * @return the string
	 */
	public String deleteEvent() {

		String deleteEvent = gson.toJson(DE);
		return deleteEvent;
	}

	/**
	 * Delete calendar.
	 *
	 * @return the string
	 */
	public String deleteCalendar() {
		String deleteCalendar = gson.toJson(DC);
		return deleteCalendar;
	}

	/**
	 * Delete note.
	 *
	 * @return the string
	 */
	public String deleteNote() {
		String deleteNote = gson.toJson(DN);
		return deleteNote;

	}


}
