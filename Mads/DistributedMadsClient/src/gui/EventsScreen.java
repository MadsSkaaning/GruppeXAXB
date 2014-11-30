package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
public class EventsScreen extends JPanel {
	
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

	/** The logout. */
	private LoginScreen logout;

	/** The background label. */
	private JLabel backgroundLabel;
	private JTextField txtShowEventsIn;
	
	
	/**
	 * Instantiates a new events screen.
	 *
	 * @param screen the screen
	 */
	public EventsScreen(CustomerScreen screen) {
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
		
		txtShowEventsIn = new JTextField();
		txtShowEventsIn.setText("Show events in someway here. Use Calendar framework logic to implemnt?");
		txtShowEventsIn.setBounds(300, 300, 407, 83);
		userEventsPanel.add(txtShowEventsIn);
		txtShowEventsIn.setColumns(10);
		
		
		
		//adding a btn to refer to home
		btnHome = new JButton("");
		btnHome.setBounds(0, 0, 64, 64);
		userEventsPanel.add(btnHome);
		btnHome.setIcon(new ImageIcon(EventsScreen.class.getResource("/shared/img/home-button.png")));
		btnHome.setVisible(true);
		
		
		
		//inject addActionListeners
		btnHome.addActionListener(new Eventhandler());
				
		btnEvents = new JButton("");
		btnEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEvents.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/eventbtn.png")));
		btnEvents.setBounds(427, 60, 153, 41);
		userEventsPanel.add(btnEvents);
		
				
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
