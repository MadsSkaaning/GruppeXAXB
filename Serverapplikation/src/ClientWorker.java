import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import JsonClasses.CalendarInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import config.Configurations;


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
