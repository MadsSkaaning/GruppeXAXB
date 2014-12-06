package logic;


import gui.*;




public class Controller {
	
	TcpClient clientconnection = new TcpClient();
	private GuiLogic gui;
	ObjectCreator objCreator = new ObjectCreator();
	String choice;

	
	public String userControlls (String choice){
		
		this.choice = choice;
		
		String dothis = "";
		
		switch(choice){
		
		
		case "login":
			
			try {
			if(clientconnection.serverComm(objCreator.authenticateUser()).equals("0")){
				
				dothis = "login";
			}
				
			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;
			
			
			default: System.out.println("failed");
			
			
		
			}
		
		return dothis;
		
		}


	public GuiLogic getGui() {
		return gui;
	}


	public void setGui(GuiLogic gui) {
		this.gui = gui;
	}	
		
		
	

}
