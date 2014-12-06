package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class Screen.
 */
public class Screen extends JFrame {

	/** The login screen. */
	private LoginScreen loginScreen = new LoginScreen();

	/** The calendar screen. */
	private CalendarScreen calendarScreen = new CalendarScreen();

	/** The front screen. */
	private FrontScreen frontScreen = new FrontScreen();

	/** The event screen. */
	private UserEventScreen eventScreen = new UserEventScreen();

	/** The content pane. */
	private JPanel contentPane;

	/** The changecards. */
	private CardLayout changecards = new CardLayout();


	/**
	 * Instantiates a new screen.
	 */
	public Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
		contentPane = new JPanel();
		getContentPane();
		setContentPane(contentPane);
		contentPane.setLayout(changecards);
		setResizable(false);




		contentPane.add(loginScreen, "loginScreen");
		contentPane.add(calendarScreen, "calendarScreen");
		contentPane.add(eventScreen, "eventScreen");
		contentPane.add(frontScreen, "frontScreen");

	}

	/**
	 * Show.
	 *
	 * @param card the card
	 */
	public void show (String card) {
		changecards.show(getContentPane(),  card);
	}

	/**
	 * Gets the login screen.
	 *
	 * @return the login screen
	 */
	public LoginScreen getLoginScreen(){
		return loginScreen;

	}

	/**
	 * Gets the calendar screen.
	 *
	 * @return the calendar screen
	 */
	public CalendarScreen getCalendarScreen(){

		return calendarScreen;
	}

	/**
	 * Gets the front screen.
	 *
	 * @return the front screen
	 */
	public FrontScreen getFrontScreen(){

		return frontScreen;
	}

	/**
	 * Gets the event screen.
	 *
	 * @return the event screen
	 */
	public UserEventScreen getEventScreen(){

		return eventScreen;
	}

}
