package logic;

import JsonClasses.AuthUser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gui.LoginScreen;

public class ObjectCreator {
	
	private LoginScreen login;
	private Gson gson = new GsonBuilder().create();
	private AuthUser AU = new AuthUser();
	
	public String authenticateUser(){
		
		
//		String user = login.getUsernameField().getText();
//		String password = login.getPasswordField().getText();
//		
//		System.out.println(user);
//		System.out.println(password);
//		
//		System.out.println(login.getUsernameField().getText());
//		System.out.println(login.getPasswordField().getText());
//		
//		AU.setAuthUserEmail(user);
//		AU.setAuthUserPassword(password);
//		AU.setAuthUserIsAdmin(false);
		
		AU.getAuthUserEmail();
		System.out.println("");
		
		
		AU.setAuthUserEmail("user");
		AU.setAuthUserPassword("user");
		AU.setAuthUserIsAdmin(false);
		
		System.out.println(AU.getAuthUserEmail());
		System.out.println(AU.getAuthUserPassword());
		
		String objecttilserver = gson.toJson(AU);
		
		return objecttilserver;
		
	}
}
