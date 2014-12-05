package logic;
import gui.*;




public class Controller {
	
	TcpClient clientconnection = new TcpClient();
	
	GuiLogic gui = new GuiLogic();
	
	ObjectCreator login = new ObjectCreator();
	
	String choice;
	
	
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
		
			
			
		case "createCalendar":
			
			try {
				dothis = clientconnection.serverComm(login.createCalendar());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		case "createEvent":
			
			try {
				dothis = clientconnection.serverComm(login.createEvent());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
	case "getCalendar":
			
			try {
				dothis = clientconnection.serverComm(login.getCalendar());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
			
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
			
		default: System.out.println("ÆVVVV");
			
			
			
			}
		
		
			
		
		
		return dothis;
		
		}	
		
		
	

}
