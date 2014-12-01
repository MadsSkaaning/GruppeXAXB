/*
 * 
 */
package logic;

import gui.CustomerScreen;
import gui.LoginScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.User;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginVerificationLogic.
 */
public final class LoginVerificationLogic implements ActionListener {

	/** The login screen. */
	private final LoginScreen loginScreen;

	/**
	 * Instantiates a new login verification logic.
	 *
	 * @param loginScreen the login screen
	 */
	public LoginVerificationLogic(LoginScreen loginScreen) {
		this.loginScreen = loginScreen;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.loginScreen.btnLogMeIn){

			String id = this.loginScreen.txtEnterCbsEmail.getText();
			@SuppressWarnings("deprecation")
			String pw = this.loginScreen.passwordField.getText();
			AuthenticateUser auth = new AuthenticateUser(id, pw);


			if(auth.authenticate()) {

				if(User.currentUser.getisAdmin()){
				
				}else{						
					
					CustomerScreen mainscreen = new CustomerScreen();
					this.loginScreen.setVisible(false);
					mainscreen.runcustomerscreen();
	
						
					}


				}
			}


		}
	}
