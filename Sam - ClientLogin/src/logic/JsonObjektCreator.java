package logic;

import gui.AddCalendar;
import gui.AddEvent;
import gui.AddNote;
import gui.Login;
import shared.AuthUser;
import shared.CreateCalendar;
import shared.CreateEvent;
import shared.CreateNote;
import shared.DeleteCalendar;
import shared.DeleteEvent;
import shared.DeleteNote;
import shared.GetCalendar;
import shared.GetEvent;
import shared.GetNote;
import shared.QOTD;
import shared.WeatherInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class JsonObjektCreator {

	private Login login = new Login();

	private Gson gson = new GsonBuilder().create();

	private AuthUser AU = new AuthUser();

	private WeatherInfo WE = new WeatherInfo();

	private QOTD quote = new QOTD(null, null, null);

	private AddCalendar AC = new AddCalendar();
	private CreateCalendar jsonAC = new CreateCalendar();

	private AddEvent AE = new AddEvent();
	private CreateEvent jsonCE = new CreateEvent();

	private AddNote AN = new AddNote();
	private CreateNote jsonAN = new CreateNote();

	private GetCalendar gC = new GetCalendar();

	private GetEvent gE = new GetEvent();

	private GetNote gN = new GetNote();

	private DeleteEvent DE = new DeleteEvent();

	private DeleteCalendar DC = new DeleteCalendar();

	private DeleteNote DN = new DeleteNote();





	public String authenticateUser(){


		//		String email = login.getTxtUsername().getText();
		//		String password = login.getPasswordField().getText();


		AU.setAuthUserEmail("admin");
		AU.setAuthUserIsAdmin(true);
		AU.setAuthUserPassword("admin");

		String logmein = gson.toJson(AU);
		return logmein;


	}

	public String getWeather(){


		String weatherRequest = gson.toJson(WE);
		return weatherRequest;


	}

	public String getQuote(){


		String quoteRequest = gson.toJson(quote);
		return quoteRequest;
	}

	public String addCalendar(){

		jsonAC.setCalendarName(AC.getTxtcalendarname().getText());
		jsonAC.setCreatedby(AC.getTxtcreatedby().getText());
		jsonAC.setPublicOrPrivate(1);

		String createCalendarRequest = gson.toJson(AC);
		return createCalendarRequest;

	}

	public String addEvent(){


		jsonCE.setCreatedby(1);
		jsonCE.setLocation(AE.getTxtLocation().getText());
		jsonCE.setStart(AE.getTxtStart().getText());
		jsonCE.setEnd(AE.getTxtEnd().getText());
		jsonCE.setEventName(AE.getTxtEventname().getText());
		jsonCE.setDescription(AE.getTxtDescription().getText());
		jsonCE.setCalendarID(AE.getTxtCalendarid().getText());


		String createCalendarRequest = gson.toJson(AE);
		return createCalendarRequest;
	}


	public String getCalendar(){


		gC.setCalendarName("Fuckalting");

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

	public String addNote(){

		jsonAN.setNoteID(AN.getTxtEventid().getText());
		jsonAN.setCreatedby(AN.getTxtCreatedby().getText());
		jsonAN.setNote(AN.getTxtnote().getText());
		jsonAN.setDatetime(AN.getTxtdatetime().getText());

		String createNoteRequest = gson.toJson(AN);
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

}
