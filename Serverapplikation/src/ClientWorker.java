import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import config.Configurations;
import GUI.GUILogic;
import JsonClasses.AuthUser;
import JsonClasses.CalendarInfo;


// TODO: Auto-generated Javadoc
//Når serveren starter - kører denne klasse.

/**
 * The Class ClientWorker.
 */
public class ClientWorker implements  Runnable{
	
	/** The connection socket conected. */
	private Socket connectionSocketConected;
	
	/** The ci. */
	private CalendarInfo CI = new CalendarInfo();
	
	/** The gs. */
	private GiantSwitch GS = new GiantSwitch();
	
	/** The cryp. */
	private encryption cryp = new encryption();
	
	/** The incoming json. */
	private String incomingJson;
	
	/** The cf. */
	private Configurations cf = new Configurations();
	
	/** The gson. */
	Gson gson = new GsonBuilder().create();
	
	/**
	 * Instantiates a new client worker.
	 *
	 * @param connectionSocket the connection socket
	 */
	ClientWorker(Socket connectionSocket){
		this.connectionSocketConected = connectionSocket;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run(){
		try{
			System.out.println("forbindelse Oprettet!");
			
			ObjectInputStream inFromClient = new ObjectInputStream(connectionSocketConected.getInputStream());
			
			ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocketConected.getOutputStream());
			System.out.println("Outtoclient oprettet!");
			//Sets client sentence equals input from client
			//incomingJson = inFromClient.readLine();			
			
			
			
			System.out.println("Besked modtaget!");
			System.out.println("Received: ");
			
			
			String input = (String) inFromClient.readObject();
			String svar = GS.GiantSwitchMethod(input);
			outToClient.writeObject(svar);
			
			
			System.out.println("svar sendt");
			
			
		}catch(Exception exception){
			System.err.print(exception);
		}
	}


}
