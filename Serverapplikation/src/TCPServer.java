import java.io.*;
import java.net.*;

import model.database.DatabaseInit;
import JsonClasses.CalendarInfo;

import com.google.gson.stream.JsonReader;
import com.mysql.jdbc.Connection;

import config.Configurations;

// TODO: Auto-generated Javadoc
/**
 * The Class TCPServer.
 */
class TCPServer{    
	
	/**
	 * The main method.
	 *
	 * @param argv the arguments
	 * @throws Exception the exception
	 */
	public static void main(String argv[]) throws Exception       {

		//Creates a socket to send and recieve messages in port 8888
		Configurations cf = new Configurations();
		ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(cf.getServersocket()));
		System.out.println("Server listens on port " + cf.getServersocket());
		
		DatabaseInit launchdb = new DatabaseInit();
		launchdb.go();
		
		//While something is true
		while(true){
			//Creates a socket and a buffered reader which recieves some sort of input from somewhere around the internet!
			Socket connectionSocket = welcomeSocket.accept();
			ClientWorker client= new ClientWorker(connectionSocket);
			Thread thread = new Thread(client, "client");
			System.out.println("IP: " + connectionSocket.getLocalAddress() + " has connected to the server");
			thread.start();
		}
	}
}