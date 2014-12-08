package gui;

//Impoterer
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import logic.JsonObjektCreator;

import javax.swing.UIManager;

import java.awt.Color;

//Denne klasse extender JPanel
public class Login extends JPanel {

	// Her instatieres klassens variabler	
	private JButton loginbtn;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JButton exitbutton;
	private JLabel logintext;
	private JLabel baggrund;


	// Konstruktoer.
	public Login() {
		setLayout(null);
		setBounds(0,0,1024,768);



		loginbtn = new JButton("Login");
		loginbtn.setForeground(UIManager.getColor("List.selectionBackground"));
		loginbtn.setBounds(408, 361, 171, 43);
		add(loginbtn);


		//
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setToolTipText("");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(391, 239, 204, 37);
		txtUsername.setColumns(15);
		add(txtUsername);


		// Her oprettes en JPasswordField til indtastning af kodeord.
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(391, 288, 204, 37);
		add(passwordField);


		exitbutton = new JButton("Exit");
		exitbutton.setForeground(Color.BLACK);
		exitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		exitbutton.setForeground(UIManager.getColor("List.selectionBackground"));
		exitbutton.setBounds(352, 562, 316, 43);
		add(exitbutton);

		logintext = new JLabel("Please enter username and password:\n");
		logintext.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		logintext.setHorizontalAlignment(SwingConstants.CENTER);
		logintext.setBounds(329, 170, 328, 23);
		add(logintext);

		baggrund = new JLabel("");
		baggrund.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/sam-bg.png")));
		baggrund.setBounds(0, 0, 1024, 768);
		add(baggrund);

	}
	public void addActionListener(ActionListener l) {
		exitbutton.addActionListener(l);
		loginbtn.addActionListener(l);


	}
	public JButton getexitbutton() {
		return exitbutton;
	}
	public JButton getloginbtn() {
		return loginbtn;
	}
	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}




}
