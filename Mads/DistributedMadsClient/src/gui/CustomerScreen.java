package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.BoxLayout;

import database.DatabaseConnect;
import database.User;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerScreen.
 */
public class CustomerScreen extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The changecards. */
	CardLayout changecards = new CardLayout();
	
	/** The content pane. */
	JPanel contentPane;

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

	/** The menu panel. */
	JPanel menuPanel;

	/** The profile. */
	public ProfileScreen profile;
	
	/** The calendar. */
	public CalendarScreen calendar;
	
	/** The events. */
	public EventsScreen events;

	/** The lbl welcome. */
	private JLabel lblWelcome;

	/** The lbl id. */
	private JLabel lblID;

	/** The lbl you are logged. */
	private JLabel lblYouAreLogged;

	/** The closeconnection. */
	private DatabaseConnect closeconnection;
	
	/** The btn events. */
	private JButton btnEvents;
	
	
	/**
	 * Runcustomerscreen.
	 */
	public void runcustomerscreen() {
		try {
			CustomerScreen frame = new CustomerScreen();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public CustomerScreen() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closeconnection = new DatabaseConnect();
				closeconnection.close();
			}
		});
		
		
		
		//Creates object of every linkable card class.
		profile = new ProfileScreen(this);
		calendar = new CalendarScreen(this);
		events = new EventsScreen(this);
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(changecards);


		menuPanel = new JPanel();
		
		//instantiate the contenpanes to be added
		contentPane.add(menuPanel, "menuPanel");
		contentPane.add(profile.profilePanel, "profilePanel");
		contentPane.add(calendar.calendarPanel, "calendarPanel");
		contentPane.add(events.eventsPanel, "eventsPanel");
		
	
		menuPanel.setVisible(true);
		menuPanel.setLayout(null);
				
		btnCalendar = new JButton("");
		btnCalendar.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/calendarbtn.png")));
		btnCalendar.setBounds(264, 59, 153, 41);
		menuPanel.add(btnCalendar);
				
		btnEvents = new JButton("");
		btnEvents.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/eventbtn.png")));
		btnEvents.setBounds(427, 59, 153, 41);
		menuPanel.add(btnEvents);
			
		btnEditProfile = new JButton("");
		btnEditProfile.setSelectedIcon(null);
		btnEditProfile.setBounds(590, 59, 153, 41);
		menuPanel.add(btnEditProfile);
		btnEditProfile.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/profile.png")));

		lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblWelcome.setBounds(427, 176, 146, 14);
		menuPanel.add(lblWelcome);

		lblID = new JLabel();
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblID.setText(User.currentUser.getfirstName() + " " + User.currentUser.getLastName());
		lblID.setBounds(529, 176, 228, 14);
		menuPanel.add(lblID);

		lblYouAreLogged = new JLabel("You are logged in as: Admin");
		lblYouAreLogged.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblYouAreLogged.setForeground(Color.WHITE);
		lblYouAreLogged.setText("Your ID is:  " + User.currentUser.getIDMail());
		lblYouAreLogged.setBounds(437, 159, 358, 19);
		menuPanel.add(lblYouAreLogged);

		btnLogOut = new JButton("");
		btnLogOut.setBounds(10, 11, 153, 41);
		btnLogOut.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/Logout.png")));
		btnLogOut.setVisible(true);
		menuPanel.add(btnLogOut);


		btnExit = new JButton("");
		btnExit.setBounds(10, 59, 153, 41);
		btnExit.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/exit.png")));
		menuPanel.add(btnExit);
		
				
		backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 1024, 740);
		menuPanel.add(backgroundLabel);
		backgroundLabel.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/mainframe-bg2.jpg")));
		
		
		
		
		
		
		
		
		
		
		// Event handlers for every linked button to cards
		
		//Profile button
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				changecards.show(contentPane, "profilePanel");						
				
			}
		});
		
		//Exit program button
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnExit){

					dispose();
				}

			}
		});
		
		//Calendar button
		btnCalendar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			changecards.show(contentPane, "calendarPanel");	
								
			}
		});
		//Events button
		
		btnEvents.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			changecards.show(contentPane, "eventsPanel");	
								
			}
		});
		//Log out to login frame.
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == btnLogOut){

					logout = new LoginScreen();
					setVisible(false);
					logout.run();
				}
			}
		});
		
	}
}
