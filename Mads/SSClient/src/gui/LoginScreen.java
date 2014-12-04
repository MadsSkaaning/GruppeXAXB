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

public class LoginScreen extends JPanel {
	 private JTextField usernameField;
	 private JPasswordField passwordField;

	JButton btnLogin = new JButton("");
	String password;
	String username;
	public LoginScreen() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);
		usernameField = new JTextField();
		usernameField.setBounds(481, 290, 200, 26);
		add(usernameField);
		usernameField.setColumns(10);
		btnLogin.setIcon(new ImageIcon(LoginScreen.class.getResource("/images/Login-Button.png")));
		btnLogin.setBounds(533, 386, 153, 41);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(414, 293, 58, 20);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(481, 339, 200, 23);
		add(passwordField);
		
		
		usernameField.setText("user");
		passwordField.setText("cbs");
		
		
		JLabel lblPasssword = new JLabel("Passsword:");
		lblPasssword.setBounds(414, 342, 58, 20);
		lblPasssword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblPasssword);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setBounds(0, 0, 1024, 768);
		lblBackground.setIcon(new ImageIcon(LoginScreen.class.getResource("/images/login-mainframe.jpg")));
		add(lblBackground);

		

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
	
	public  String getPassword(){
		
		password = passwordField.getText();
		return password;
	}
	
	public String getUsername(){
		
		username = usernameField.getText();
		
		return username;
	}
	
	
	
}
