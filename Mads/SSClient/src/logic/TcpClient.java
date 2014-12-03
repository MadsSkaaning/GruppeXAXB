package logic;

import java.net.*;
import java.io.*;


public class TcpClient {
	
	 String request;
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
