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

public class LoginScreen extends JPanel {
	 private JTextField usernameField;
	 private JPasswordField passwordField;
	 private JButton btnLogin = new JButton();
	 private JLabel lblUsername;
	 private JLabel lblPassword;
	 private AuthUser user;
	
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
		
		System.out.println("here (GUI CLASS)");

	}
	
	public void addActionListener(ActionListener l) {
		btnLogin.addActionListener(l);
	}
	
	public JButton getbtnLogic(){
		
		return btnLogin;
	}
	
	
public JTextField getUsernameField(){
		
		return usernameField;
	}

public JPasswordField getPasswordField(){
	
	return passwordField;
}	



}
