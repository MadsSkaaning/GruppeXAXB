package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class Screen extends JFrame {

	public static final String LOGIN = "name_276091497157488";
	public static final String MAINMENU = "name_276416022878030";
	public static final String PROFILE = "name_277892826656058";
	public static final String CALENDAR = "name_278522430661848";
	public static final String EVENTS = "name_534038022095149";

	
	private JPanel contentPane;
	private final Login login = new Login();
	private final MainMenu mainMenu = new MainMenu();
	private final Profile profile = new Profile();
	private final Calendar calendar = new Calendar();
	private final Events events = new Events();
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
		setTitle("CBS Calendar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		login.getBtnLogIn().setContentAreaFilled(false);
		
		contentPane.add(login, "name_276091497157488");
		
		contentPane.add(mainMenu, "name_276416022878030");
		
		contentPane.add(profile, "name_277892826656058");
		
		contentPane.add(calendar, "name_278522430661848");
		
		contentPane.add(events, "name_534038022095149");
		
		c = (CardLayout) getContentPane().getLayout();
	}
	
	public Login getLogin() {
		return login;
	}
	
	public MainMenu getMainMenu() {
		return mainMenu;
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
	
	public void show(String card) {
		c.show(getContentPane(),  card);
	}


}
