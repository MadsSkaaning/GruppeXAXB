package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Login screen, igen med getters og ActionListeners

public class LoginScreen extends JPanel {
	 private JTextField usernameField = new JTextField();
	 private JPasswordField passwordField = new JPasswordField();

	JButton btnLogin = new JButton("Login");
	
	public LoginScreen() {
		setLayout(null);
		setBounds(100, 100, 1020, 768);

		
		usernameField.setBounds(481, 290, 200, 26);
		add(usernameField);
	
		usernameField.setColumns(10);
		passwordField.setLocation(481, 339);
		passwordField.setSize(200, 26);

		
		add(passwordField);
		
		
		btnLogin.setBounds(592, 414, 89, 23);
		add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(414, 293, 58, 20);
		add(lblUsername);
		
		
		
		JLabel lblPasssword = new JLabel("Passsword:");
		lblPasssword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPasssword.setBounds(414, 342, 58, 20);
		add(lblPasssword);

		

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
	

	
	
	
}
