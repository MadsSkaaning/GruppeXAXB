/*
 * 
 */
package logic;

import gui.ProfileScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import database.DatabaseConnect;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateUserLogic.
 */
public final class UpdateUserLogic implements ActionListener {

	/** The profile screen. */
	private final ProfileScreen profileScreen;

	/**
	 * Instantiates a new update user logic.
	 *
	 * @param profileScreen the profile screen
	 */
	public UpdateUserLogic(ProfileScreen profileScreen) {
		this.profileScreen = profileScreen;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {



		case "Insert New Entry":
			DatabaseConnect connecter = new DatabaseConnect();
			int result;
			try {
				result = connecter.editPerson(
						this.profileScreen.getIDMailtextField(), 
						this.profileScreen.getFirstNameTextField(),
						this.profileScreen.getLastNameTextField(),
						this.profileScreen.getAdressTextField(),
						Integer.parseInt(this.profileScreen.getzipTextField()),
						Integer.parseInt(this.profileScreen.getageTextField()),
						this.profileScreen.getphoneTextField(),
						Double.parseDouble(this.profileScreen.getbtcTextField()),
						this.profileScreen.getpassTextField(),
						this.profileScreen.getisAdmintextField());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Invald input(s), please check if all your information is correct!");
				result = 0;
			}




			if ( result == 1 )
				this.profileScreen.showMesage( "User changed",  "User changed!");


			break;

		default:
			// enter in index textfield
		}

	}
}