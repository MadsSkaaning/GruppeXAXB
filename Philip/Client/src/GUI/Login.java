package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;

import java.awt.Cursor;

import javax.swing.SwingConstants;

import java.awt.Dimension;

import javax.swing.JPasswordField;

import logic.Controller;

public class Login extends JPanel {
	private final JLabel lblWelcome = new JLabel("Welcome to CBS Calendar");
	private final JLabel lblUsername = new JLabel("Username:");
	private final JLabel lblPassword = new JLabel("Password:");
	public final JButton btnLogIn = new JButton("Log In");
	private JTextField textFieldUsername = new JTextField();
	private final JLabel lblBackground = new JLabel("");
	private final JPasswordField textFieldPassword = new JPasswordField();

	String password;
	String username;
	

	/**
	 * Create the panel.
	 */
	public Login() {
		setBounds(0, 0, 1024, 768);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(105, 105, 105));
		setLayout(null);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		lblWelcome.setForeground(Color.LIGHT_GRAY);
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 22));
		lblWelcome.setBounds(339, 90, 346, 107);
		
		add(lblWelcome);
		
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 26));
		lblUsername.setBounds(442, 209, 139, 30);
		
		add(lblUsername);
		
		
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 26));
		lblPassword.setBounds(442, 300, 139, 30);
		
		add(lblPassword);
		
		textFieldUsername.setOpaque(false);
		textFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsername.setForeground(Color.BLACK);
		textFieldUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldUsername.setColumns(10);
		textFieldUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255)));
		textFieldUsername.setBounds(430, 251, 164, 37);
		
		add(textFieldUsername);

		
		
		setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldPassword.setOpaque(false);
		textFieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255)));
		textFieldPassword.setBounds(430, 348, 164, 37);
		
		add(textFieldPassword);
		
		btnLogIn.setContentAreaFilled(false);
		btnLogIn.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogIn.setForeground(Color.LIGHT_GRAY);
		btnLogIn.setBackground(Color.WHITE);
		btnLogIn.setOpaque(false);
		btnLogIn.setBorderPainted(false);
		btnLogIn.setBounds(401, 449, 222, 51);
		add(btnLogIn);
		
		
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/img/philip-bg.png")));
		lblBackground.setBounds(0, 0, 1024, 768);
		
		add(lblBackground);

	}

		


	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}




	public void setTextFieldUsername(JTextField textFieldUsername) {
		this.textFieldUsername = textFieldUsername;
	}




//	public String getPassword() {
//		return password;
//	}
//
//
//
//
//	public void setPassword(String password) {
//		this.password = password;
//	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public JButton getBtnLogIn() {
		return btnLogIn;
	}




	public JPasswordField getTextFieldPassword() {
		return textFieldPassword;
	}




	public void addActionListener(ActionListener l) {
		btnLogIn.addActionListener(l);
		System.out.println(getTextFieldUsername().getText());
		System.out.println(getTextFieldPassword().getText());
}

	}