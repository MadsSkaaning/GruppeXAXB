package logic;

import java.net.*;
import java.io.*;


public class TcpClient {

	String request;

encryption Encryption = new encryption();

Configurations config = new Configurations();


	public  String serverComm(String request) throws Exception {

		this.request = request;

		Socket clientSocket = new Socket(config.getHost(),Integer.parseInt(config.getServersocket()));

		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());


		outToServer.write(Encryption.decrypt(request.getBytes()).getBytes());
		outToServer.flush();


		DataInputStream infromserver = new DataInputStream(clientSocket.getInputStream());
		
		byte [] b = new byte[20000];
		
		infromserver.read(b);

		String svarfraserver = Encryption.decrypt(b);

		System.out.println("FROM SERVER: " + svarfraserver);


		clientSocket.close();

		return svarfraserver;
	}



}
