package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

public class Screen extends JFrame {

	private LoginScreen loginScreen = new LoginScreen();
	private CalendarScreen calendarScreen = new CalendarScreen();
	private FrontScreen frontScreen = new FrontScreen();
	private UserEventScreen eventScreen = new UserEventScreen();
	private JPanel contentPane;
	private CardLayout changecards = new CardLayout();
	

	public Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
		contentPane = new JPanel();
		getContentPane();
		setContentPane(contentPane);
		contentPane.setLayout(changecards);
		setResizable(false);
		
		
		//Her adder jeg de forskellige panels til MainScreen
		contentPane.add(loginScreen, "loginScreen");
		contentPane.add(calendarScreen, "calendarScreen");
		contentPane.add(eventScreen, "eventScreen");
		contentPane.add(frontScreen, "frontScreen");
		
	}
	
	public void show (String card) {
		changecards.show(getContentPane(),  card);
	}
		
	public LoginScreen getLoginScreen(){
		return loginScreen;
	
	}
	
	public CalendarScreen getCalendarScreen(){
		
		return calendarScreen;
	}
	
	public FrontScreen getFrontScreen(){
		
		return frontScreen;
	}
	
	public UserEventScreen getEventScreen(){
		
		return eventScreen;
	}

}
