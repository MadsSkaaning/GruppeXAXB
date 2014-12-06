package gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import JsonClasses.AuthUser;

import java.awt.Color;
import java.awt.Font;

import logic.Controller;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.border.Border;


public class FrontScreen extends JPanel {
	
	/**
	 * Create the panel.
	 */
	
	private JButton btnCalendar = new JButton("");
	private JButton btnEventlist = new JButton("");
	private JButton btnLogOut = new JButton("");
	private JButton btnExit = new JButton("");
	private final JLabel lblBackground = new JLabel("");
	private final JLabel lblWelcomeToCbs = new JLabel("Welcome to CBS Calendar.");
	private final JLabel lblgetUserName = new JLabel("");
	private final JLabel lblQotd = new JLabel("QOTD");
	private final JLabel lblgetQotd = new JLabel("");
	private final JLabel lblWeatherInfo = new JLabel("");
	private final JLabel lblNewLabel = new JLabel("Weather");
	
	
	public FrontScreen() {
		setLayout(null);
		setBounds(0, 0, 1024, 768);
		
		
		Controller mycontroller = new Controller();
		btnCalendar.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/calendarbtn.png")));
		btnCalendar.setBounds(342, 74, 153, 41);
		add(btnCalendar);
		btnEventlist.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/eventbtn.png")));
		btnEventlist.setBounds(550, 74, 153, 41);
		add(btnEventlist);
		btnLogOut.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/Logout.png")));
		btnLogOut.setBounds(10, 22, 153, 41);
		add(btnLogOut);
		btnExit.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/exit.png")));
		btnExit.setBounds(10, 74, 153, 41);
		add(btnExit);
		lblWelcomeToCbs.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblWelcomeToCbs.setBounds(340, 135, 318, 68);
		
		add(lblWelcomeToCbs);
		lblgetUserName.setBounds(821, 59, 76, 14);
		System.out.println();
		
		add(lblgetUserName);
		lblQotd.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblQotd.setBounds(82, 187, 153, 50);
		
		add(lblQotd);
		lblgetQotd.setBounds(10, 236, 298, 300);
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);

		lblgetQotd.setBorder(border);
		lblgetQotd.setText(mycontroller.userControlls("qotd"));
		
		add(lblgetQotd);
		lblWeatherInfo.setBounds(609, 248, 360, 300);
		//lblWeatherInfo.setText(mycontroller.userControlls("getWeather"));
		lblWeatherInfo.setBorder(border);
		add(lblWeatherInfo);
		
		
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblNewLabel.setBounds(724, 187, 141, 50);
		
		add(lblNewLabel);
		
		
		

		
		
		
//		String quoteOfTheDay = (mycontroller.userControlls("qotd"));
//		String[] strs = quoteOfTheDay.split(",");
//		quoteOfTheDay = quoteOfTheDay.replace("{", "");
//		
//		
//		for (String s : strs) {
//				s.replace("quote", "fucker");
//			    lblNewLabel_1.setText(s);
//		}
		
		
		
		
		lblBackground.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/login-mainframe.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		
		add(lblBackground);

	}
	
	public void addActionListener(ActionListener l) {
		btnCalendar.addActionListener(l);
		btnEventlist.addActionListener(l);
		btnLogOut.addActionListener(l);
		
	}
	
	public JButton getCalendar(){
		
		return btnCalendar;
	}
	
	public JButton getEvenList(){
		
		return btnEventlist;
	}
	
	public JButton getLogOut(){
		return btnLogOut;
	}
	
	
	public JButton getExit(){
		
		return btnExit;
	}
}
