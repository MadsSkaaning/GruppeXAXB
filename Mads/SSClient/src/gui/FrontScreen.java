package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import JsonClasses.AuthUser;

import java.awt.Font;


public class FrontScreen extends JPanel {
	private JTextField forecastField;
	
	/**
	 * Create the panel.
	 */
	
	private JButton btnCalendar = new JButton("");
	private JButton btnEventlist = new JButton("");
	private JButton btnNewButton = new JButton("");
	private JButton btnExit = new JButton("");
	private final JLabel lblBackground = new JLabel("");
	private final JLabel lblWelcomeToCbs = new JLabel("Welcome to CBS Calendar.");
	private final JLabel lblgetUserName = new JLabel("");
	public FrontScreen() {
		setLayout(null);
		setBounds(0, 0, 1024, 768);
		
		
		
		
		JLabel lblNewLabel = new JLabel("quote");
		lblNewLabel.setBounds(131, 41, 102, 50);
		add(lblNewLabel);
		
		JLabel lblLoggedInAs = new JLabel("Logged in as");
		lblLoggedInAs.setBounds(722, 41, 200, 50);
		add(lblLoggedInAs);
		
		forecastField = new JTextField();
		forecastField.setBounds(380, 327, 293, 133);
		forecastField.setEditable(false);
		add(forecastField);
		forecastField.setColumns(10);
		btnCalendar.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/calendarbtn.png")));
		btnCalendar.setBounds(342, 74, 153, 41);
		add(btnCalendar);
		btnEventlist.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/eventbtn.png")));
		btnEventlist.setBounds(550, 74, 153, 41);
		add(btnEventlist);
		btnNewButton.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/Logout.png")));
		btnNewButton.setBounds(10, 22, 153, 41);
		add(btnNewButton);
		btnExit.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/exit.png")));
		btnExit.setBounds(10, 74, 153, 41);
		add(btnExit);
		lblWelcomeToCbs.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblWelcomeToCbs.setBounds(373, 142, 398, 68);
		
		add(lblWelcomeToCbs);
		lblgetUserName.setBounds(821, 59, 76, 14);
		System.out.println();
		
		add(lblgetUserName);
		
		
		lblBackground.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/login-mainframe.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		
		add(lblBackground);

	}
	
	public void addActionListener(ActionListener l) {
		btnCalendar.addActionListener(l);
		btnEventlist.addActionListener(l);
		
	}
	
	public JButton getCalendar(){
		
		return btnCalendar;
	}
	
	public JButton getEvenList(){
		
		return btnEventlist;
	}
	
	public JButton getExit(){
		
		return btnExit;
	}
}
