package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;

	JButton btnLogin = new JButton("Login");
	
	
	public LoginScreen() {
		setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(481, 290, 200, 26);
		add(usernameField);
		usernameField.setColumns(10);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		
		btnLogin.setBounds(592, 414, 89, 23);
		add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(414, 293, 58, 20);
		add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(481, 339, 200, 23);
		add(passwordField);
		
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
	
	@SuppressWarnings("deprecation")
	public  String getPassword(){
		
		String pass = passwordField.getText();
		
		return pass;
	}
	
	public String getUsername(){
		
		String username = usernameField.getText();
		
		return username;
	}
}
