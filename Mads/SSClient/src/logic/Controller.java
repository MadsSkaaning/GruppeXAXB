package logic;


public class Controller {
	
	TcpClient clientconnection = new TcpClient();
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
			
			
			// Jeg opretter her det jeg gerne vil kalde, f.eks QOTD
			//navnet her bestemmer jeg selv.?
		case "qotd":
			
			//Sæt her authenticateuser til den metode du har oprettet i din object creatoren
			
			try {
			
				dothis = clientconnection.serverComm(objCreator.getQOTD());
				
			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;
			
		case "getWeather":
			
			//Sæt her authenticateuser til den metode du har oprettet i din object creatoren
			
			try {
			
				dothis = clientconnection.serverComm(objCreator.getWeather());
				
			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;
			
		case "createCalendar":
			
			//Sæt her authenticateuser til den metode du har oprettet i din object creatoren
			
			try {
			
				dothis = clientconnection.serverComm(objCreator.createCalendar());
				
			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;
			
			
			

			default: System.out.println("failed");
			
			}
		
		
		
		
		
		
		return dothis;
		
		}



	

}
