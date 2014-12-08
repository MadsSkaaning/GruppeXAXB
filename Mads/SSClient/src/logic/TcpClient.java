package logic;

import java.net.*;
import java.io.*;


// TODO: Auto-generated Javadoc
/**
 * The Class TcpClient.
 */
public class TcpClient {

	/** The request. */
	String request;
	
	Encryption decryptClass = new Encryption();
	Configurations cf = new Configurations();		


	/**
	 * Server comm.
	 *
	 * @param request the request
	 * @return the string
	 * @throws Exception the exception
	 */
	public  String serverComm(String request) throws Exception {

		this.request = request;


		Socket clientSocket = new Socket(cf.getHost(), Integer.parseInt(cf.getServerhost()));

		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());

		
		outToServer.write(decryptClass.decrypt(request.getBytes()).getBytes());
		outToServer.flush();


		DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());

		
		byte[] b = new byte[250000];
		
		inFromServer.read(b);
		
		String serverReply = decryptClass.decrypt(b);
		
		System.out.println("FROM SERVER: " + serverReply);


		clientSocket.close();

		return serverReply;
	}



}
