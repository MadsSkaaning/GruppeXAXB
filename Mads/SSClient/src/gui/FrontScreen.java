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

import logic.Controller;


public class FrontScreen extends JPanel {
	
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
	private final JLabel lblQotd = new JLabel("QOTD");
	private final JLabel lblQotdFrame = new JLabel("");
	private JTextField textField;
	public FrontScreen() {
		setLayout(null);
		setBounds(0, 0, 1024, 768);
		
		
		Controller mycontroller = new Controller();
		

		
		JLabel lblNewLabel = new JLabel("quote");
		lblNewLabel.setBounds(131, 41, 102, 50);
		add(lblNewLabel);
		
		JLabel lblLoggedInAs = new JLabel("Logged in as");
		lblLoggedInAs.setBounds(722, 41, 200, 50);
		add(lblLoggedInAs);
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
		lblQotd.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblQotd.setBounds(821, 151, 153, 50);
		
		add(lblQotd);
		lblQotdFrame.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/CBS baggrund_20.png")));
		lblQotdFrame.setBounds(781, 151, 212, 304);		
		add(lblQotdFrame);
		
		textField = new JTextField();
		textField.setBounds(550, 277, 193, 178);
		
		
		textField.setText(mycontroller.userControlls("qotd"));
		
		
		String quoteOfTheDay = (mycontroller.userControlls("qotd"));
		String[] strs = quoteOfTheDay.split(",");
		quoteOfTheDay = quoteOfTheDay.replace("{", "");
		
		for (String s : strs) {
					
					s.replace("quote", "fucker");
			      System.out.println(s);
		}
		
		
		
		add(textField);
		textField.setColumns(10);
		
		
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
