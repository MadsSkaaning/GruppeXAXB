package logic;

import JsonClasses.AuthUser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import GUI.Login;

public class Loginlogik {
	
	private Login login = new Login();
	
	private Gson gson = new GsonBuilder().create();
	
	private AuthUser AU = new AuthUser();
	
//	String loginfo = Login.getTextFieldUsername()().getText();
	
	//String loginfo = login.getTextFieldUsername()().getText();
	
	public String authenticateUser(){
		
		
		AU.setAuthUserEmail(login.getUsername());
		System.out.println(login.getUsername());
		AU.setAuthUserIsAdmin(false);
//		AU.setAuthUserPassword(login.getPassword());
//		System.out.println(login.getPassword());
		AU.setAuthUserEmail("philip");
		AU.setAuthUserPassword("1234");
//		System.out.println(loginfo);
		
		String objecttilserver = gson.toJson(AU);
		
		
		return objecttilserver;
				
		
	}
}
