package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

public class MainMenu extends JPanel {
	private JLabel label;
	private JButton btnLogOut;
	private JButton btnEvents;
	private JButton btnProfile;
	private JButton btnCalendar;
	private JLabel lblLoggedin;
	private JLabel labelUser;
	private JLabel lblGotd;
	private JTextField txtEvents;
	private JTextField txtWeather;
	private JTextField txtCalendar;
	

	
	public MainMenu() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);
		
		btnEvents = new JButton("Events");
		btnEvents.setContentAreaFilled(false);
		btnEvents.setForeground(Color.WHITE);
		btnEvents.setFont(new Font("Arial", Font.BOLD, 30));
		btnEvents.setBackground(Color.WHITE);
		btnEvents.setBounds(400, 70, 145, 50);
		btnEvents.setOpaque(false);
		btnEvents.setBorderPainted(false);
		add(btnEvents);
		
		btnProfile = new JButton("Profile");
		btnProfile.setContentAreaFilled(false);
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setFont(new Font("Arial", Font.BOLD, 30));
		btnProfile.setBackground(Color.WHITE);
		btnProfile.setOpaque(false);
		btnProfile.setBorderPainted(false);
		btnProfile.setBounds(644, 70, 145, 50);
		add(btnProfile);
		
		lblLoggedin = new JLabel("Logged in as:");
		lblLoggedin.setBounds(846, 49, 98, 16);
		add(lblLoggedin);
		
		labelUser = new JLabel("");
		labelUser.setBounds(846, 70, 132, 29);
		add(labelUser);
		
		lblGotd = new JLabel("GOTD");
		lblGotd.setBounds(46, 143, 284, 172);
		add(lblGotd);
		
		txtWeather = new JTextField();
		txtWeather.setText("WEATHER");
		txtWeather.setBounds(356, 143, 603, 141);
		add(txtWeather);
		txtWeather.setColumns(10);
		
		txtEvents = new JTextField();
		txtEvents.setText("EVENTS");
		txtEvents.setBounds(46, 363, 289, 263);
		add(txtEvents);
		txtEvents.setColumns(10);
		
		txtCalendar = new JTextField();
		txtCalendar.setText("CALENDAR");
		txtCalendar.setBounds(356, 315, 603, 311);
		add(txtCalendar);
		txtCalendar.setColumns(10);
		
		btnCalendar = new JButton("Calendar");
		btnCalendar.setForeground(Color.WHITE);
		btnCalendar.setFont(new Font("Arial", Font.BOLD, 30));
		btnCalendar.setBackground(Color.WHITE);
		btnCalendar.setBounds(140, 70, 190, 50);
		btnCalendar.setOpaque(false);
		btnCalendar.setContentAreaFilled(false);
		btnCalendar.setBorderPainted(false);
		add(btnCalendar);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(792, 654, 167, 44);
		btnLogOut.setOpaque(false);
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorderPainted(false);
		add(btnLogOut);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MainMenu.class.getResource("/img/philip-bg.png")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);

	}
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnProfile.addActionListener(l);
		btnCalendar.addActionListener(l);
		btnEvents.addActionListener(l);
		
		
	}
	public JButton getBtnProfile() {
		return btnProfile;
	}
	public JButton getBtnEvents() {
		return btnEvents;
	}
	public JButton getBtnCalendar() {
		return btnCalendar;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	
}
