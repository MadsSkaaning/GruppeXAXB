import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import config.Configurations;
import GUI.GUILogic;


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
			
			
			
			//Denne klase beskriver den info får når en client aktivt er forbundet til serveren.
			
			System.out.println("forbindelse Oprettet!");
			
			//Gets ip adress and displays it to server
			System.out.println("Client " + connectionSocketConected.getInetAddress() + " connected!");
			//BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			byte[] b = new byte[500000];
			int count = connectionSocketConected.getInputStream().read(b);
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			DataInputStream inFromClient = new DataInputStream(connectionSocketConected.getInputStream());		
			//Creates an object of the data which is to be send back to the client, via the connectionSocket
			DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());
			System.out.println("Outtoclient oprettet!");
			//Sets client sentence equals input from client
			//incomingJson = inFromClient.readLine();			
			
			String ny = cryp.decrypt(b) +"DETTE ER NY STRENG" ;
			System.out.println("Besked modtaget!");
			System.out.println("Received: " + ny);
			String jsonNy = gson.toJson(ny);
			
			
			
			String stringKey = cf.getFfcryptkey();
			
			double doubleKey = Double.parseDouble(stringKey);
			
			byte key = (byte) doubleKey;

			byte[] encrypted = jsonNy.getBytes();

			for (int i=0; i<encrypted.length; i++) encrypted[i] = (byte) (encrypted[i] ^ key);		
			
			outToClient.write(encrypted);
			
			System.out.println("svar sendt" + encrypted);
			
			
		}catch(Exception exception){
			System.err.print(exception);
		}
	}


}
