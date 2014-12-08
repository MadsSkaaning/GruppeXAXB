import java.net.ServerSocket;
import java.net.Socket;

import model.database.DatabaseInit;
import GUI.GUILogic;
import config.Configurations;

// TODO: Auto-generated Javadoc
/**
 * The Class TCPServer.
 */
class TCPServer{    
	
	/**
	 * The main method.
	 *
	 * @param argv the arguments
	 * @throws Exception the exception
	 */
	public static void main(String argv[]) throws Exception       {

		//Creates a socket to send and recieve messages
		Configurations cf = new Configurations();
		ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(cf.getServersocket()));
		System.out.println("Server listens on port " + cf.getServersocket());
		
		DatabaseInit launchdb = new DatabaseInit();
		launchdb.go();
		GUILogic logic = new GUILogic();
		logic.run();
		
		//While something is true
		try {
			while(true){
				//Creates a socket and a buffered reader which recieves some sort of input from somewhere around the internet!
				Socket connectionSocket = welcomeSocket.accept();
				ClientWorker client= new ClientWorker(connectionSocket);
				Thread thread = new Thread(client, "client");
				System.out.println("IP: " + connectionSocket.getLocalAddress() + " has connected to the server");
				thread.start();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong establishing a connection between the server and client.\n See Errorlog below.");
			e.printStackTrace();
			System.out.println("ERROR LOG DONE \n \n");
		}
	}
}