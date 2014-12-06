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

	/**
	 * Server comm.
	 *
	 * @param request the request
	 * @return the string
	 * @throws Exception the exception
	 */
	public  String serverComm(String request) throws Exception {

		this.request = request;


		Configurations cf = new Configurations();		
		Socket clientSocket = new Socket(cf.getHost(), Integer.parseInt(cf.getServerhost()));

		ObjectOutputStream outToServer = new ObjectOutputStream(
				clientSocket.getOutputStream());

		outToServer.writeObject(request);
		outToServer.flush();


		ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

		String serverReply = inFromServer.readObject().toString().trim();

		System.out.println("FROM SERVER: " + serverReply);


		clientSocket.close();

		return serverReply;
	}



}
