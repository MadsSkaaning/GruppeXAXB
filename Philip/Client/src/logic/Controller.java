package logic;


import GUI.*;




public class Controller {
	
	TCPClient clientconnection = new TCPClient();
	
	private GUILogic gui;
	
	ObjectCreator objectCreator = new ObjectCreator();
	
	String choice;
	
	
	public String userControlls (String choice){
		
		this.choice = choice;
		
		String dothis = "";
		
		switch(choice){
		
		
		case "login":
			
			try {
			if(clientconnection.serverComm(objectCreator.authenticateUser()).equals("0")){
				
				dothis = "login";
			}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			
		case "qotd":
			try {
					
					dothis = (clientconnection.serverComm(objectCreator.getQuote()));
				
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;
				
		case "weather":
			try {
					
					dothis = (clientconnection.serverComm(objectCreator.getWeather()));
				
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;
		
		case "calendar":
			try {
					
					dothis = (clientconnection.serverComm(objectCreator.CalendarInfo()));
				
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;
			
		case "getEvents":
			try {
					
					dothis = (clientconnection.serverComm(objectCreator.getEvent()));
				
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;
			
			default: System.out.println("failed");
			
			
		
			}
		
		return dothis;
		
		}

		

	public GUILogic getGui() {
		return gui;
	}

		
		
	

}
