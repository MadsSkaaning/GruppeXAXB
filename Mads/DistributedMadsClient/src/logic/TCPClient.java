//package logic;
//import gui.LoginScreen;
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStreamReader;
//import java.net.Socket;
//import java.util.Scanner;
//
//import shared.encryptionAES;
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
//		Configurations cf = new Configurations();
//
//		
//		String modifiedSentence;
//		Gson gson = new GsonBuilder().create();
//		CreateCalendar CC = new CreateCalendar();
//		encryptionAES aes = new encryptionAES();
//		AuthUser authUser = new AuthUser();
//		Scanner userInput = new Scanner(System.in);
//		
//		System.out.println("Indtast brugernavn/mail");
//		String brugernavn = userInput.nextLine();		
//		authUser.setAuthUserEmail(brugernavn);
//		
//		System.out.println("Indtast dit password");
//		String password = aes.encrypt(userInput.nextLine());
//
//		System.out.println(cf.getServerhost());
//		
//		authUser.setAuthUserPassword(password);
//		String gsonString = gson.toJson(authUser);
//		System.out.println(authUser);
//		System.out.println(gsonString);
//				
//		//cf.getHost, cf.getPort		
//		
//		Socket clientSocket = new Socket("localhost", Integer.parseInt(cf.getServerhost()));
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
//		outToServer.flush();
//		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
//				clientSocket.getInputStream()));
//		modifiedSentence = inFromServer.readLine();
//		
//		
//		System.out.println(modifiedSentence);
//		System.out.println("FROM SERVER: " + modifiedSentence);
//		clientSocket.close();
//	}
//}