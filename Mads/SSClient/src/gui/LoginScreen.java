package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import JsonClasses.AuthUser;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginScreen.
 */
public class LoginScreen extends JPanel {

	/** The username field. */
	private JTextField usernameField;

	/** The password field. */
	private JPasswordField passwordField;

	/** The btn login. */
	private JButton btnLogin = new JButton();

	/** The lbl username. */
	private JLabel lblUsername;

	/** The lbl password. */
	private JLabel lblPassword;

	/** The user. */
	private AuthUser user;

	/** The lbl background. */
	private JLabel lblBackground;

	/** The lbl please enter you. */
	private JLabel lblPleaseEnterYou;

	/**
	 * Instantiates a new login screen.
	 */
	public LoginScreen() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);

		//Creating Labels
		lblPassword = new JLabel("Passsword:");
		lblPassword.setBounds(414, 342, 58, 20);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblPassword);

		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(414, 293, 58, 20);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblUsername);

		// Creating variables to the JTextFields
		usernameField = new JTextField();
		usernameField.setBounds(481, 290, 200, 26);
		usernameField.setColumns(10);
		add(usernameField);

		passwordField = new JPasswordField();
		passwordField.setBounds(481, 339, 200, 23);
		add(passwordField);


		//Creating buttons
		btnLogin.setIcon(new ImageIcon(LoginScreen.class.getResource("/images/Login-Button.png")));
		btnLogin.setBounds(533, 386, 153, 41);
		add(btnLogin);

		lblPleaseEnterYou = new JLabel("Please enter you login information below.");
		lblPleaseEnterYou.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblPleaseEnterYou.setBounds(329, 195, 465, 41);
		add(lblPleaseEnterYou);

		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(LoginScreen.class.getResource("/images/login-mainframe.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);

		System.out.println("here (GUI CLASS)");

	}

	/**
	 * Adds the action listener.
	 *
	 * @param l the l
	 */
	public void addActionListener(ActionListener l) {
		btnLogin.addActionListener(l);
	}

	/**
	 * Gets the btn logic.
	 *
	 * @return the btn logic
	 */
	public JButton getbtnLogic(){

		return btnLogin;
	}


	/**
	 * Gets the username field.
	 *
	 * @return the username field
	 */
	public JTextField getUsernameField(){

		return usernameField;
	}

	/**
	 * Gets the password field.
	 *
	 * @return the password field
	 */
	public JPasswordField getPasswordField(){

		return passwordField;
	}	



}
