package logic;

import java.net.*;
import java.io.*;


public class TcpClient {
	
	 String request;
	public  String serverComm(String request) throws Exception {
		
		this.request = request;
		
		
		Configurations cf = new Configurations();		
		Socket clientSocket = new Socket(cf.getHost(), Integer.parseInt(cf.getServerhost()));

		ObjectOutputStream outToServer = new ObjectOutputStream(
				clientSocket.getOutputStream());

		outToServer.writeObject(request);
		outToServer.flush();
		
		
		ObjectInputStream infromserver = new ObjectInputStream(clientSocket.getInputStream());
		
		String serverReply = infromserver.readObject().toString().trim();
		
		System.out.println("FROM SERVER: " + serverReply);
		
		
		clientSocket.close();
		
		return serverReply;
	}
	
	

}
