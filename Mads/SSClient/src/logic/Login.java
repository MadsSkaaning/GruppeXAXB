package logic;

import JsonClasses.AuthUser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gui.LoginScreen;

public class Login {
	
	private LoginScreen login = new LoginScreen();
	
	private Gson gson = new GsonBuilder().create();
	
	private AuthUser AU = new AuthUser();
	
	String loginfo = login.getUsernameField().getText();
	
	public String authenticateUser(){
		
		String user = login.getUsernameField().getText();
		System.out.println(user);
		
		
		//AU.setAuthUserEmail(login.getUsername());
		System.out.println(login.getUsername());
		//AU.setAuthUserIsAdmin(false);
		//AU.setAuthUserPassword(login.getPassword());
		System.out.println(login.getPassword());
		
		System.out.println(loginfo);
		
		//Hardcoded variables
		//AU.setAuthUserEmail("user");
	//	AU.setAuthUserPassword("cbs");
	//	AU.setAuthUserIsAdmin(false);
		
		
		AU.setAuthUserEmail(login.getUsernameField().getText());
		AU.setAuthUserPassword(login.getPassword() +"");
		AU.setAuthUserIsAdmin(false);
		
		System.out.println(login.getUsername());
		
		
		String objecttilserver = gson.toJson(AU);
		
		return objecttilserver;
				
		
	}
	
	
	
	
	
	
	
	
	
	

}
