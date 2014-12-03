package logic;


import GUI.*;




public class Controller {
	
	TCPClient clientconnection = new TCPClient();
	
	GUILogic gui = new GUILogic();
	
	Loginlogik loginlogik = new Loginlogik();
	
	String choice;
	
	
	public String userControlls (String choice){
		
		this.choice = choice;
		
		String dothis = "";
		
		switch(choice){
		
		
		case "login":
			
			try {
			if(clientconnection.serverComm(loginlogik.authenticateUser()).equals("0")){
				
				dothis = "login";
			}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			
			
			default: System.out.println("failed");
			
			
		
			}
		
		return dothis;
		
		}	
		
		
	

}
