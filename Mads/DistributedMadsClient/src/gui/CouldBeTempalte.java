package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.AdminAddUser.Eventhandler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.User;

// TODO: Auto-generated Javadoc
/**
 * The Class EventsScreen.
 */
public class CouldBeTempalte extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	//Creating Jpanel for class.
	/** The events panel. */
	JPanel eventsPanel;
	
	/** The user events panel. */
	private JPanel userEventsPanel;
	
	//Jbuttons
	/** The btn home. */
	JButton btnHome;
	
	/** The screenchanger. */
	Eventhandler screenchanger;
	
	/** The screen. */
	private CustomerScreen screen;
	
	/** The btn events. */
	private JButton btnEvents;
	
	/** The btn log out. */
	private JButton btnLogOut;

	/** The btn exit. */
	private JButton btnExit;
	
	/** The btn calendar. */
	private JButton btnCalendar;

	/** The btn edit profile. */
	private JButton btnEditProfile;

	/** The logout. */
	private LoginScreen logout;

	/** The background label. */
	private JLabel backgroundLabel;
	
	/** The lbl welcome. */
	private JLabel lblWelcome;
	
	
	/**
	 * Instantiates a new events screen.
	 *
	 * @param screen the screen
	 */
	public CouldBeTempalte(CustomerScreen screen) {
		this.screen = screen;
		
		//setting layout of jPanel
		eventsPanel = new JPanel();
		eventsPanel.setBounds(0, 0, 1024, 768);
		eventsPanel.setLayout(null);
		
		userEventsPanel = new JPanel();
		userEventsPanel.setBounds(0, 0, 1024, 768);
		userEventsPanel.setLayout(null);
		
		
		// adding panel2 to main calendarPanel
		eventsPanel.add(userEventsPanel);
		
		
		
		//adding a btn to refer to home
		btnHome = new JButton("");
		btnHome.setBounds(0, 0, 64, 64);
		userEventsPanel.add(btnHome);
		btnHome.setIcon(new ImageIcon(CouldBeTempalte.class.getResource("/shared/img/home-button.png")));
		btnHome.setVisible(true);
		
		
		
		//inject addActionListeners
		btnHome.addActionListener(new Eventhandler());
		
		//Adding from customerScreen
		
		btnCalendar = new JButton("");
		btnCalendar.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/calendarbtn.png")));
		btnCalendar.setBounds(264, 59, 153, 41);
		userEventsPanel.add(btnCalendar);
				
		btnEvents = new JButton("");
		btnEvents.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/eventbtn.png")));
		btnEvents.setBounds(427, 59, 153, 41);
		userEventsPanel.add(btnEvents);
			
		btnEditProfile = new JButton("");
		btnEditProfile.setSelectedIcon(null);
		btnEditProfile.setBounds(590, 59, 153, 41);
		userEventsPanel.add(btnEditProfile);
		btnEditProfile.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/profile.png")));

		lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblWelcome.setBounds(427, 176, 146, 14);
		userEventsPanel.add(lblWelcome);

		btnLogOut = new JButton("");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogOut.setBounds(89, 11, 153, 41);
		btnLogOut.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/Logout.png")));
		btnLogOut.setVisible(true);
		userEventsPanel.add(btnLogOut);


		btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExit.setBounds(89, 59, 153, 41);
		btnExit.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/exit.png")));
		userEventsPanel.add(btnExit);
		
				
		backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 1024, 740);
		userEventsPanel.add(backgroundLabel);
		backgroundLabel.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/mainframe-bg2.jpg")));
		
		
		
		
		
}
	
	/**
	 * The Class Eventhandler.
	 */
	public class Eventhandler implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {

			//CustomerScreen screen = new CustomerScreen();

			screen.changecards.show(screen.contentPane,"menuPanel");

		}


	}
	
}
