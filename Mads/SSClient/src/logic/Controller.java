package logic;


// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller {

	/** The clientconnection. */
	public TcpClient clientconnection = new TcpClient();

	/** The obj creator. */
	public ObjectCreator objCreator = new ObjectCreator();

	/** The choice. */
	public String choice;


	/**
	 * User controls.
	 *
	 * @param choice the choice
	 * @return the string
	 */
	
	
	// Creating the user controls with the switch "choice".
	public String userControls (String choice){

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


			// Example of a call: Calling qotd from the ObjectTranslater.

		case "qotd":

			try {
				//Request the QOTD from the server
				dothis = clientconnection.serverComm(objCreator.getQOTD());

			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;

		case "getWeather":


			try {

				dothis = clientconnection.serverComm(objCreator.getWeather());

			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;



		case "getEvent":
			try {

				dothis = clientconnection.serverComm(objCreator.getEvent());

			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;



			//CC doesnt quite work all the way

		case "createCalendar":


			try {

				dothis = clientconnection.serverComm(objCreator.createCalendar());

			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;


		case "createNote":


			try {

				dothis = clientconnection.serverComm(objCreator.createNote());

			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;

		case "createEvent":


			try {

				dothis = clientconnection.serverComm(objCreator.createEvent());

			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;


		case "deleteEvent":


			try {

				dothis = clientconnection.serverComm(objCreator.deleteEvent());

			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;


		case "deleteCalendar":


			try {

				dothis = clientconnection.serverComm(objCreator.deleteCalendar());

			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;


		case "deleteNote":


			try {

				dothis = clientconnection.serverComm(objCreator.deleteNote());

			} catch (Exception e) {

				System.out.println("fail");
			} 
			break;


			// Does this per default.
		default: System.out.println("failed");

		}


		return dothis;

	}





}
