//package logic;
//import gui.LoginScreen;
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStreamReader;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.Scanner;
//
//import JsonClasses.AuthUser;
//import JsonClasses.CreateCalendar;
//import JsonClasses.QOTD;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import shared.*;
//import config.Configurations;
//
//public class TCPClient {
//	public static void main(String[] args) throws Exception {
//		
//		// 1: Connect til server
//		/*
//		Socket clientSocket = new Socket("localhost", 8888);
//		DataOutputStream outToServer = new DataOutputStream(
//				clientSocket.getOutputStream());
//		
//		// 2: Authenticate user
//		// Spørg om brugernavn + password pa den ene eller anden måde
//		// User user = new User(brugernavn, password);
//		outToServer.write("login", "", "");
//		outToServer.
//		*/
//		
//		
//		LoginScreen entry; 
//		entry = new LoginScreen(); 
//		entry.run(); 
//		
//		
//		Configurations cf = new Configurations();
//
//		
//		String modifiedSentence;
//		Gson gson = new GsonBuilder().create();
//		CreateCalendar CC = new CreateCalendar();
//		encryptionAES aes = new encryptionAES();
//		AuthUser authUser = new AuthUser();
//		Scanner userInput = new Scanner(System.in);
//		boolean userAuthenticated = false;
//		
//		
//		
//		authUser.setAuthUserEmail("test");
//		authUser.setAuthUserIsAdmin(false);
//		authUser.setAuthUserPassword("cbs");
//		authUser.setAuthenticated(true);
//		
//		String objtoserv = gson.toJson(authUser);
//		
//					
//			
//		System.out.println("Indtast brugernavn/mail");
//		String brugernavn = userInput.nextLine();		
//		
//		//Her oprettes objekt der skal sendes til server.
//		authUser.setAuthUserEmail(brugernavn);
//		
//		System.out.println("Indtast dit password");
//		String password = aes.encrypt(userInput.nextLine());
//
//		System.out.println(cf.getServerhost());
//		authUser.setAuthUserPassword(password);
//		
//		
//		String gsonString = gson.toJson(authUser);
//		
//		// printer objekt for at se om det er rigtigt. printer i json format.
//		System.out.println(authUser);
//		System.out.println(gsonString);
//				
//		//cf.getHost, cf.getPort		
//		
//		Socket clientSocket = new Socket("localhost", Integer.parseInt(cf.getServerhost()));
//		
//		
//		//Eksempel på at sende et objekt uden brug af JSON
//		ObjectOutputStream objToServer = new ObjectOutputStream(
//				clientSocket.getOutputStream());
//		
//		//Eksempel på at modtage java objekter fra server uden brug af JSON
//		ObjectInputStream objFromServer = new ObjectInputStream(clientSocket.getInputStream());
//		
//		// vi sender authUser til serveren.
//		objToServer.writeObject(authUser);
//				
//		
//		// Vi forventer svar fra serveren
//		authUser = (AuthUser) objFromServer.readObject();
//		
//		
//		DataOutputStream outToServer = new DataOutputStream(
//				clientSocket.getOutputStream());
//		byte[] input = gsonString.getBytes();
//		byte key = (byte) Double.parseDouble(cf.getFfcryptkey());
//		byte[] encrypted = input;
//		for (int i = 0; i < encrypted.length; i++)
//			encrypted[i] = (byte) (encrypted[i] ^ key);
//		
//		System.out.println(encrypted);
//		outToServer.write(encrypted);
//		
//		
//		
//		//eksempel på at skrive fra client til server
//	//	outToServer.writeObject(authUser);
//		
//		
//		outToServer.flush();
//		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
//				clientSocket.getInputStream()));
//		modifiedSentence = inFromServer.readLine();
//		System.out.println(modifiedSentence);
//		System.out.println("FROM SERVER: " + modifiedSentence);
//		
//		// send forespørgsel
//		
//		QOTD test = new QOTD(gsonString, gsonString, gsonString);
//		
//		
//		
//		// Lukker forbindelsen til server
//		clientSocket.close();
//		
//		
//		
//		
//	}
//}

package logic;

import java.net.*;
import java.util.Scanner;
import java.io.*;

import JsonClasses.AuthUser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import config.Configurations;


public class TCPClient {
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		AuthUser AU = new AuthUser();
		//Ny auth
		

		Gson gson = new GsonBuilder().create();
		
		
		
		AU.setAuthUserEmail("test");
		AU.setAuthUserIsAdmin(false);
		
		AU.setAuthUserPassword("123");
		String objecttilserver = gson.toJson(AU);
		
		
		Configurations cf = new Configurations();
		
		
		Socket clientSocket = new Socket("localhost", 8888);

		ObjectOutputStream outToServer = new ObjectOutputStream(
				clientSocket.getOutputStream());

		
		outToServer.writeObject(objecttilserver);
		outToServer.flush();
		
		
		ObjectInputStream infromserver = new ObjectInputStream(clientSocket.getInputStream());
		
		String svarfraserver = infromserver.readObject().toString();
		
		System.out.println("FROM SERVER: " + svarfraserver);
		
		clientSocket.close();
	}

}
