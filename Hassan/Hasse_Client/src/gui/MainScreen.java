package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

public class MainScreen extends JFrame {

	private LoginScreen loginScreen = new LoginScreen();
	private CalendarScreen calendarScreen = new CalendarScreen();
	private FrontScreen frontScreen = new FrontScreen();
	private UserEventScreen eventScreen = new UserEventScreen();
	private JPanel contentPane;
	private CardLayout changecards = new CardLayout();
	

	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane();
		setContentPane(contentPane);
		contentPane.setLayout(changecards);
		
		
		
		
		//Her adder jeg de forskellige panels til MainScreen
		
		contentPane.add(loginScreen, "loginScreen");
		contentPane.add(calendarScreen, "calendarScreen");
		contentPane.add(eventScreen, "eventScreen");
		contentPane.add(frontScreen, "frontScreen");
		
		
		
		
		
		
		
	
		
		
		
		
	}
	
	
	//laver en metode der kan skifte mellem, hvilket JPanel der vises
	public void show (String card) {
		changecards.show(getContentPane(),  card);
	}
	
	//laver getters for de forskellige panels, som jeg vil bruge i en GUILogic klasse, der tager sig af tryk på knapper
	
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
