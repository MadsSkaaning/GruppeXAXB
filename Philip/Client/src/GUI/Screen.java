package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

public class Screen extends JFrame {

	private Login login = new Login();
	private MainMenu mainmenu = new MainMenu();
	private Profile profile = new Profile();
	private Calendar calendar = new Calendar();
	private Events events = new Events();
	private CardLayout changecards = new CardLayout();
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	

	public Screen() {
		setTitle("CBS Calendar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane();
		setContentPane(contentPane);
		contentPane.setLayout(changecards);
		
		login.getBtnLogIn().setContentAreaFilled(false);
		
		contentPane.add(login, "login");
		
		contentPane.add(mainmenu, "mainmenu");
		
		contentPane.add(profile, "profile");
		
		contentPane.add(calendar, "calendar");
		
		contentPane.add(events, "events");
		
	}
	
	public void show (String card) {
		changecards.show(getContentPane(),  card);
	}
	
	public Login getLogin() {
		return login;
	}
	
	public MainMenu getMainMenu() {
		return mainmenu;
	}
	public Profile getProfile() {
		return profile;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}

	public Events getEvents() {
		return events;
	}
	


}
