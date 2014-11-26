/*
 * 
 */
package logic;

import gui.AdminAddUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.DatabaseConnect;

// TODO: Auto-generated Javadoc
/**
 * The Class AddUserLogic.
 */
public final class AddUserLogic implements ActionListener {

	/** The admin add user. */
	private final AdminAddUser adminAddUser;

	/**
	 * Instantiates a new adds the user logic.
	 *
	 * @param adminAddUser the admin add user
	 */
	public AddUserLogic(AdminAddUser adminAddUser) {
		this.adminAddUser = adminAddUser;
	}

	/* (non-Javadoc)
	 * @see gui.BTCRateLogic#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {



		case "Insert New Entry":
			DatabaseConnect connecter = new DatabaseConnect();
			int result;
			try {
				result = connecter.addPerson(this.adminAddUser.getIdTextField(), 
						this.adminAddUser.getFirstNameTextField(),
						this.adminAddUser.getLastNameTextField(),
						this.adminAddUser.getAdressTextField(),
						Integer.parseInt(this.adminAddUser.getzipTextField()),
						Integer.parseInt(this.adminAddUser.getageTextField()),
						this.adminAddUser.getphoneTextField(),
						Double.parseDouble(this.adminAddUser.getbtcTextField()),
						this.adminAddUser.getpassTextField(),
						this.adminAddUser.getisAdmintextField());


				this.adminAddUser.idTextField.setText("");
				this.adminAddUser.firstNameTextField.setText("");
				this.adminAddUser.lastNameTextField.setText("");
				this.adminAddUser.adresstextField.setText("");
				this.adminAddUser.ziptextField.setText("");
				this.adminAddUser.agetextField.setText("");
				this.adminAddUser.btcTextField.setText("");
				this.adminAddUser.passtextField.setText("");
				this.adminAddUser.phoneTextField.setText("");
			} catch (NumberFormatException e1) {
				result = 0;
			}




			if ( result == 1 )
				this.adminAddUser.showMesage( "User added",  "User added! - You can add another one now.");



			else
				this.adminAddUser.showMesage( "Error",  "Invald input(s)! User not added!");

			break;

		default:
			// enter in index textfield
		}





	}
}