package logic;

import java.net.*;
import java.io.*;


public class TcpClient {
	
	 String request;
	 
	 //Klienten opretter forbindelsen til serveren gennem en metode.
	 
	 
	 //Metoden tager en string som parameter, denne string er en pakket JSOON klasse - Stringen indenholder et ID svarende til det der forventes i GiantSwitchen til den tilsvarende case.
	 //Efter at være blevet kaldt retunerer metoden en String svarende til serveres svar. 
	//Metoden lukker forbindelsen efter hver gang den bliver kaldt for at spare ressourcer.
	 
	 //Man kunne have lavet kryptering ved at kryptere den strengen fra constructeren inden den sendte den ud til serveren, og decryptere svaret inden metoden returnere svaret. (hvis altså serveren lavede samme kryptering)
	
	public  String serverComm(String request) throws Exception {
		
		this.request = request;
		
		Socket clientSocket = new Socket("localhost", 8888);

		ObjectOutputStream outToServer = new ObjectOutputStream(
				clientSocket.getOutputStream());
		
		
		outToServer.writeObject(request);
		outToServer.flush();
		
		
		ObjectInputStream infromserver = new ObjectInputStream(clientSocket.getInputStream());
		
		String svarfraserver = infromserver.readObject().toString().trim();
		
		System.out.println("FROM SERVER: " + svarfraserver);
		
		
		clientSocket.close();
		
		return svarfraserver;
	}
	
	

}
