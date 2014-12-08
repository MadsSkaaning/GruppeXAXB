package gui;

//Importerer
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


//Mainframe extender Jframe
public class MainFrame extends JFrame {

	// Her instantieres de forskellige screens/panels i Mainframe klassen.

	public static final String LOGIN = "login_panel";
	public static final String MAINMENU = "mainMenu_panel";
	public static final String CALENDAR = "calendar_panel";
	public static final String EVENTS = "events_panel";
	public static final String ADDCALENDAR = "addCalendar_panel";
	public static final String ADDEVENT = "addevent_panel";
	public static final String NOTES = "notes_panel";
	public static final String ADDNOTE = "addnote_panel";

	private JPanel contentPane;
	private final Login login = new Login();
	private final MainMenu mainMenu = new MainMenu();
	private final Calendar calendar = new Calendar();
	private final Events events = new Events();
	private final AddCalendar addCalendar = new AddCalendar();
	private final AddEvent addEvent = new AddEvent();
	private final Notes notes = new Notes();
	private final AddNote addnote = new AddNote();

	CardLayout c;


	// Konstruktoer.
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		// Her oprettes de forskellige paneler i Mainframe.


		contentPane.add(login, "login_panel");
		contentPane.add(mainMenu, "mainMenu_panel");
		contentPane.add(calendar, "calendar_panel");
		contentPane.add(events, "events_panel");
		contentPane.add(addCalendar, "addCalendar_panel");
		contentPane.add(addEvent, "addevent_panel");
		contentPane.add(notes, "notes_panel");
		contentPane.add(addnote, "addnote_panel");


		c = (CardLayout) getContentPane().getLayout();
	}

	public Login getLogin() {
		return login;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public void show(String card) {
		c.show(getContentPane(),  card);
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public Events getEvents() {
		return events;
	}
	public AddCalendar getAddCalendar() {
		return addCalendar;
	}
	public AddEvent getAddEvent() {
		return addEvent;
	}
	public Notes getNotes() {
		return notes;
	}
	public AddNote getAddNote() {
		return addnote;
	}

}