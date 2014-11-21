package logic;

import shared.*;
import java.util.Scanner;


public class Client {
	
	public static void main (String [] args){
		Scanner input = new Scanner(System.in);
		AuthUser userObj = new AuthUser();
		ObjectTranslator objTrans = new ObjectTranslator();
		
		System.out.println("Client running");
		boolean userAuthenticated = false;
		System.out.println("Log in.");
		
		while(!userAuthenticated){
			System.out.println("User Email");
			userObj.setAuthUserEmail(input.next());
			System.out.println("User Password");
			userObj.setAuthUserPassword(input.next());
			
			// objTrans.sendObject(userObj);
			// userObj = objTrans.receiveUserAuth();
		
			userObj.setAuthenticated(true);
			
			if(userObj.isAuthenticated()==true){
				userAuthenticated = true;
				System.out.println("Welcome to the server");
			}else{
				System.out.println("Something wrong.");
				
			}
		}
		System.out.println("You've exited the loop");
	}

}
