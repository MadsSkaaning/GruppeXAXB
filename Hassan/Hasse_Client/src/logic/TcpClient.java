package logic;

import java.net.*;
import java.util.Scanner;
import java.io.*;

import JsonClasses.AuthUser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gui.GuiLogic;
import gui.MainScreen;

public class TcpClient {
	
	
	
	public static void main(String[] args) throws Exception {
		
		GuiLogic gui = new GuiLogic();
		
		gui.run();
		
		AuthUser AU = new AuthUser();
		//Ny auth
		

		Gson gson = new GsonBuilder().create();
		
		
		
		
		
		AU.setAuthUserEmail("test");
		AU.setAuthUserIsAdmin(false);
		
		AU.setAuthUserPassword("123");
		String objecttilserver = gson.toJson(AU);
		
		
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
