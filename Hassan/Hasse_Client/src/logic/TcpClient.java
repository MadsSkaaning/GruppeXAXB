package logic;

import java.net.*;
import java.io.*;


public class TcpClient {
	
	 String request;
	 EncryptionFromServer decryptserver = new EncryptionFromServer();
	 Configurations cf = new Configurations();
	 //Klienten opretter forbindelsen til serveren gennem en metode.
	 
	 
	 //Metoden tager en string som parameter, denne string er en pakket JSOON klasse - Stringen indenholder et ID svarende til det der forventes i GiantSwitchen til den tilsvarende case.
	 //Efter at være blevet kaldt retunerer metoden en String svarende til serveres svar. 
	//Metoden lukker forbindelsen efter hver gang den bliver kaldt for at spare ressourcer.
	 
	
	
	public  String serverComm(String request) throws Exception {
		
		this.request = request;
		
		Socket clientSocket = new Socket(cf.getHost(), Integer.parseInt(cf.getPort()));

		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		
		
		outToServer.write(decryptserver.decrypt(request.getBytes()).getBytes());
		outToServer.flush();
		
		
		DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
		
		
		byte[] b = new byte[500000];
		
		inFromServer.read(b);
		
	
		
		String svarfraserver = decryptserver.decrypt(b);
		
		
		
		System.out.println("FROM SERVER: " + svarfraserver);
		
		
		clientSocket.close();
		
		return svarfraserver;
	}
	
	

}
