package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

public class Screen extends JFrame {

	public static final String LOGIN = "login";
	public static final String MAINMENU = "mainmenu";
	public static final String PROFILE = "profile";
	public static final String CALENDAR = "calendar";
	public static final String EVENTS = "events";
	public static final String ADDCALENDAR = "addcalendar";
	public static final String ADDEVENT = "addevent";
	
	private Login login = new Login();
	private MainMenu mainmenu = new MainMenu();
	private Profile profile = new Profile();
	private Calendar calendar = new Calendar();
	private Events events = new Events();
	private AddCalendar addcalendar = new AddCalendar();
	private AddEvent addevent = new AddEvent();
	private CardLayout changecards = new CardLayout();
	private JPanel contentPane;
	
	CardLayout c;
	
	/**
	 * Launch the application.
	 */
	

	public Screen() {
		setTitle("CBS Calendar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0,0));
		
		login.getBtnLogIn().setContentAreaFilled(false);
		
		
		contentPane.add(login, "login");
		
		contentPane.add(mainmenu, "mainmenu");
		
		contentPane.add(profile, "profile");
		
		contentPane.add(calendar, "calendar");
		
		contentPane.add(events, "events");
		
		contentPane.add(addcalendar, "addcalendar");
		
		contentPane.add(addevent, "addevent");
		
		c = (CardLayout) getContentPane().getLayout();
		
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
	
	public AddCalendar getAddCalendar() {
		return addcalendar;
		
	}
	
	public AddEvent getAddEvent() {
		return addevent;
		
	}
	
	public void show(String card) {
		c.show(getContentPane(),  card);
	}
	
	public Login getLogin() {
		return login;
	}
	


}
