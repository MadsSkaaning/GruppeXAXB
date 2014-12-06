package logic;


import JsonClasses.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gui.LoginScreen;

public class ObjectCreator {
	
	private LoginScreen login;
	private Gson gson = new GsonBuilder().create();
	private AuthUser AU = new AuthUser();
	private QOTD quote = new QOTD(null, null, null);
	
	
	//Det her er en metode der opretter authenticate user og sender til esrveren.
	public String authenticateUser(){
		
		AU.setAuthUserEmail("user");
		AU.setAuthUserPassword("user");
		AU.setAuthUserIsAdmin(false);
		
		String objecttilserver = gson.toJson(AU);
		return objecttilserver;
		
	}

	// ALa den her metode opretter jeg denne.
	public String getQOTD() {
		String objecttilserver = gson.toJson(quote);
		return objecttilserver;
	}
	
}
