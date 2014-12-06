package GUI;

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

	/** The Constant LOGIN. */
	public static final String LOGIN = "screenlogin";
	
	/** The Constant MAINMENU. */
	public static final String MAINMENU = "screenmainMenu";
	
	/** The Constant USERINFO. */
	public static final String USERINFO = "screenuserInfo";
	
	/** The Constant ADDUSERGUI. */
	public static final String ADDUSERGUI = "screenaddUser";
	
	/** The Constant NOTELIST. */
	public static final String NOTELIST = "screennoteList";
	
	/** The Constant USERLIST. */
	public static final String USERLIST = "screenuserList";
	
	/** The Constant EVENTLIST. */
	public static final String EVENTLIST = "screeneventList";
	
	/** The Constant ADDEVENT. */
	public static final String ADDEVENT = "screenaddEvent";
	
	/** The Constant ADDUSER. */
	public static final String ADDUSER = "screenaddUser";
	
	/** The Constant CALENDARLIST. */
	public static final String CALENDARLIST = "screencalendarList";
	
	/** The Constant ADDCALENDAR. */
	public static final String ADDCALENDAR = "screenaddCalendar";
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The login. */
	private final Login login = new Login();
	
	/** The main menu. */
	private final MainMenu mainMenu = new MainMenu();
	
	/** The user info. */
	private final UserInfo userInfo = new UserInfo();
	
	/** The note list. */
	private final NoteList noteList = new NoteList();
	
	/** The userlist. */
	private final UserList userlist = new UserList();
	
	/** The calendar list. */
	private final CalendarList calendarList = new CalendarList();
	
	/** The event list. */
	private final EventList eventList = new EventList();
	
	/** The add event. */
	private AddEvent addEvent;
	
	/** The add user. */
	private final AddUser addUser = new AddUser();
	
	/** The add calendar. */
	private final AddCalendar addCalendar = new AddCalendar();
	
	/** The c. */
	CardLayout c;


	/**
	 * Instantiates a new screen.
	 */
	public Screen() {
		setTitle("CBS Calendar Extra");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		addEvent = new AddEvent();
		contentPane.add(addEvent, "screenaddEvent");
		login.getBtnLogIn().setContentAreaFilled(false);
		login.getBtnForgotLogIn().setContentAreaFilled(false);
		
		contentPane.add(addUser, "screenaddUser");
		
		contentPane.add(login, "screenlogin");
		
		contentPane.add(mainMenu, "screenmainMenu");
		
		contentPane.add(userInfo, "screenuserInfo");
		
		contentPane.add(noteList, "screennoteList");
		
		contentPane.add(eventList, "screeneventList");
		
		contentPane.add(userlist, "screenuserList");
		
		contentPane.add(calendarList, "screencalendarList");
		
		contentPane.add(addCalendar, "screenaddCalendar");
		
		
		c = (CardLayout) getContentPane().getLayout();
	}
	
	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public Login getLogin() {
		System.out.println("hey");
		return login;
	}
	
	/**
	 * Gets the main menu.
	 *
	 * @return the main menu
	 */
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	
	/**
	 * Gets the user info.
	 *
	 * @return the user info
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	/**
	 * Gets the note list.
	 *
	 * @return the note list
	 */
	public NoteList getNoteList() {
		return noteList;
	}
	
	/**
	 * Gets the user list.
	 *
	 * @return the user list
	 */
	public UserList getUserList() {
		return userlist;
	}
	
	/**
	 * Show.
	 *
	 * @param card the card
	 */
	public void show(String card) {
		c.show(getContentPane(),  card);
	}
	
	/**
	 * Gets the eventlist.
	 *
	 * @return the eventlist
	 */
	public EventList getEventlist() {
		return eventList;
	}
	
	/**
	 * Gets the adds the event gui.
	 *
	 * @return the adds the event gui
	 */
	public AddEvent getAddEventGUI() {
		return addEvent;
	}
	
	/**
	 * Gets the adds the user.
	 *
	 * @return the adds the user
	 */
	public AddUser getAddUser() {
		return addUser;
	}
	
	/**
	 * Gets the calendar list.
	 *
	 * @return the calendar list
	 */
	public CalendarList getCalendarList(){
		return calendarList;
	}
	
	/**
	 * Gets the adds the calendar.
	 *
	 * @return the adds the calendar
	 */
	public AddCalendar getAddCalendar(){
		return addCalendar;
	}
	
}
