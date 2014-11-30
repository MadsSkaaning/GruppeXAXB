package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class CalendarScreen extends JPanel {
	
	private static final long serialVersionUID = 1L;

	//Creating Jpanel for class.
	JPanel calendarPanel;
	private JPanel userCalendarPanel;
	
	private JButton btnCalendar;
	
	private JLabel backgroundLabel;
	
	
	//JTextfields
	JTextField texteksempel;
	
	//Jbuttons
	JButton btnHome;
	
	Eventhandler screenchanger;
	private CustomerScreen screen;
	
	
	public CalendarScreen(CustomerScreen screen) {
		this.screen = screen;
		
		//setting layout of jPanel
		calendarPanel = new JPanel();
		calendarPanel.setBounds(0, 0, 1024, 768);
		calendarPanel.setLayout(null);
		
		userCalendarPanel = new JPanel();
		userCalendarPanel.setBounds(0, 0, 1024, 768);
		userCalendarPanel.setLayout(null);
		
		
		// adding panel2 to main calendarPanel
		calendarPanel.add(userCalendarPanel);
		
		
		//adding a btn to refer to home
		btnHome = new JButton("");
		btnHome.setBounds(0, 0, 64, 64);
		userCalendarPanel.add(btnHome);
		btnHome.setIcon(new ImageIcon(CalendarScreen.class.getResource("/shared/img/home-button.png")));
		
		
		btnCalendar = new JButton("");
		btnCalendar.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/calendarbtn.png")));
		btnCalendar.setBounds(404, 60, 153, 41);
		userCalendarPanel.add(btnCalendar);
		
		JPanel CalendarPanel = new JPanel();
		CalendarPanel.setBackground(Color.GRAY);
		CalendarPanel.setBounds(205, 158, 595, 480);
		userCalendarPanel.add(CalendarPanel);
		
		backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 1024, 740);
		userCalendarPanel.add(backgroundLabel);
		backgroundLabel.setIcon(new ImageIcon(CustomerScreen.class.getResource("/shared/img/mainframe-bg2.jpg")));
		btnHome.setVisible(true);
		
		
		
		//inject addActionListeners
		btnHome.addActionListener(new Eventhandler());

		
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
