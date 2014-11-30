/*
 * 
 */
package logic;

import gui.LoginScreen;

import javax.swing.JOptionPane;

import database.DatabaseConnect;
import database.User;

// TODO: Auto-generated Javadoc
/**
 * The Class authenticateUser.
 */
public class AuthenticateUser {

	/** The id. */
	private String id;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new authenticate user.
	 *
	 * @param id the id
	 * @param password the password
	 */
	public AuthenticateUser(String id, String password){

		this.id = id;
		this.password = password;

	}

	/**
	 * Authenticate.
	 *
	 * @return true, if successful
	 */
	public boolean authenticate() {

		//Opret forbindelse til db
		DatabaseConnect dbconnect = new DatabaseConnect();

		//Hent userById
		User user = dbconnect.getUserByID(id);

		//Er password=password?
		try {
			if (password.equals(user.getPassword())){

				User.currentUser = user;
				//return true, hvis ja
				return true;

			};
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Incorrect login, please check your ID and/or password.");	
			return false;
		}

		return false;

	}
}
