package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class Screen extends JFrame {

	public static final String LOGIN = "screenlogin";
	public static final String MAINMENU = "screenmainMenu";
	public static final String USERINFO = "screenuserInfo";
	public static final String ADDUSERGUI = "screenaddUser";
	public static final String NOTELIST = "screennoteList";
	public static final String USERLIST = "screenuserList";
	public static final String EVENTLIST = "screeneventList";
	public static final String ADDEVENTGUI = "screenaddEventGUI";
	public static final String ADDUSER = "screenaddUser";
	public static final String CALENDARLIST = "screencalendarList";
	
	private JPanel contentPane;
	private final Login login = new Login();
	private final MainMenu mainMenu = new MainMenu();
	private final UserInfo userInfo = new UserInfo();
	private final NoteList noteList = new NoteList();
	private final UserList userlist = new UserList();
	private final CalendarList calendarList = new CalendarList();
	private final EventList eventList = new EventList();
	private AddEventGUI addEventGUI;
	private final AddUser addUser = new AddUser();
	CardLayout c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Screen() {
		setTitle("CBS Calendar Extra");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		addEventGUI = new AddEventGUI();
		contentPane.add(addEventGUI, "screenaddEventGUI");
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
		
		
		c = (CardLayout) getContentPane().getLayout();
	}
	
	public Login getLogin() {
		return login;
	}
	
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	public NoteList getNoteList() {
		return noteList;
	}
	public UserList getUserList() {
		return userlist;
	}
	public void show(String card) {
		c.show(getContentPane(),  card);
	}
	public EventList getEventlist() {
		return eventList;
	}
	public AddEventGUI getAddEventGUI() {
		return addEventGUI;
	}
	public AddUser getAddUser() {
		return addUser;
	}
	public CalendarList getCalendarList(){
		return calendarList;
	}
	
}
