package logic;


import gui.*;




public class Controller {
	
	TcpClient clientconnection = new TcpClient();
	
	GuiLogic gui = new GuiLogic();
	
	Login login = new Login();
	
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
			
			
			default: System.out.println("failed");
			
			
		
			}
		
		return dothis;
		
		}	
		
		
	

}
