import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
	private Encryption Encryption = new Encryption();
	
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
			System.out.println("Connection established!");
			DataInputStream inFromClient = new DataInputStream(connectionSocketConected.getInputStream());
			DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());
			System.out.println("Outtoclient established");
			System.out.println("Message received!");
			System.out.println("Received: ");
			
			byte[] b = new byte[50000000];
			
			inFromClient.read(b);

			String input = Encryption.decrypt(b);
			
			System.out.println(input);
			
			String svar = GS.GiantSwitchMethod(input);
			
			outToClient.write(Encryption.decrypt(svar.getBytes()).getBytes());
			
			System.out.println("Reply sent");
			
			
		}catch(Exception exception){
			System.err.print(exception);
		}
	}


}
