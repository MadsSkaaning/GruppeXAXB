package logic;

import java.net.*;
import java.io.*;


public class TCPClient {
	
	 String request;
	encryption decryptserver = new encryption();
	 Configurations cf = new Configurations();
	 
	 
	
	public  String serverComm(String request) throws Exception {
		
		this.request = request;
		
		Socket clientSocket = new Socket(cf.getHost(), Integer.parseInt(cf.getServerhost()));

		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		
		
		outToServer.write(decryptserver.decrypt(request.getBytes()).getBytes());
		outToServer.flush();
		
		
		DataInputStream infromserver = new DataInputStream(clientSocket.getInputStream());
		
		byte[] b = new byte[500000];
		
		infromserver.read(b);
		
		String svarfraserver = decryptserver.decrypt(b);
		
		System.out.println("FROM SERVER: " + svarfraserver);
		
		clientSocket.close();
		
		return svarfraserver;
	}
	
	

}
