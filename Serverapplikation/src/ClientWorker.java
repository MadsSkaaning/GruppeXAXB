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


//Når serveren starter - kører denne klasse.

public class ClientWorker implements  Runnable{
	private Socket connectionSocketConected;
	private CalendarInfo CI = new CalendarInfo();
	private GiantSwitch GS = new GiantSwitch();
	private encryption cryp = new encryption();
	private String incomingJson;
	private Configurations cf = new Configurations();
	
	Gson gson = new GsonBuilder().create();
	
	ClientWorker(Socket connectionSocket){
		this.connectionSocketConected = connectionSocket;
	}
	
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
