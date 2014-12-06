package logic;
import gui.*;



//Klasse der indenholder en switch metoder, der benyttes til at bestemme, hvilke requests der skal sendes til serveren.

public class Controller {
	
	TcpClient clientconnection = new TcpClient();
	
	
	ObjectCreator login = new ObjectCreator();
	
	String choice;
	
	
	//Den primære switch metode.
	
	public String userControlls (String choice){
		
		this.choice = choice;
		
		String dothis = "";
		
		switch(choice){
		
		
		case "login":
			
			try {
			if(clientconnection.serverComm(login.authenticateUser()).equals("0")){
				
				dothis = "login";
			}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			
		case "forecast":
			
			try {
				
			dothis = clientconnection.serverComm(login.getWeather());
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "quote":
			
			
			try {
				dothis = clientconnection.serverComm(login.getQuote());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
		
			//Udkommenteret fordi denne metode ikke længere bliver kørt herfra, men igennem main logic.
//			 Den er her for at illustrere, at jeg gerne orginalt ville havet haft samlet alle kommandoer til serveren i denne klasse.
//			 Det var desværre ikke helt gennemtænkt, da opbygningen af min gui logic ummuligjorde det
//		case "createCalendar":
//			
//			try {
//				dothis = clientconnection.serverComm(login.createCalendar(dothis, dothis, 0));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
		case "createEvent":
			
			try {
				dothis = clientconnection.serverComm(login.createEvent());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
		
		case "createNote":
			
			try {
				dothis = clientconnection.serverComm(login.createNote());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;


			//Udkommenteret fordi denne metode ikke længere bliver kørt herfra, men igennem main logic.
//			 Den er her for at illustrere, at jeg gerne orginalt ville havet haft samlet alle kommandoer til serveren i denne klasse.
//			 Det var desværre ikke helt gennemtænkt, da opbygningen af min gui logic ummuligjorde det
			
//	case "getCalendar":
//			
//			try {
//				dothis = clientconnection.serverComm(login.getCalendar());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			break;
//			
			
	case "deleteCalendar":
		
		try {
			dothis = clientconnection.serverComm(login.deleteCalendar());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		break;
			
			
	case "getEvent":
		
		try {
			dothis = clientconnection.serverComm(login.getEvent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		break;
		
		
	case "deleteEvent":
		
		try {
			dothis = clientconnection.serverComm(login.deleteEvent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		break;
		
	case "deleteNote":
		
		try {
			dothis = clientconnection.serverComm(login.deleteNote());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		break;
		
	case "getNote":
		
		try {
			dothis = clientconnection.serverComm(login.getNote());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		break;
			
		default: System.out.println("Ã†VVVV");
			
		case "getCBS":
			
			
			try {
				dothis = clientconnection.serverComm(login.getCBSData());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			break;
			
			}
		
		
			
		
		
		return dothis;
		
		}	
		
		
	

}
