package gui;

//importerer.
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.UIManager;

import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.JCheckBox;


//Klassen extender JPanel.
public class Events extends JPanel {

	// Variablerne i klassen bliver instantieret.
	private JTextField textField;
	private JLabel events;
	private JButton btnLogOut;
	private JButton btnHome;
	private JLabel baggrund;
	private JButton btnNewEvent;
	private JButton btnDeleteEvent;
	private JButton btnNotes;

	// Konstruktoer.
	public Events() {
		setLayout(null);
		setBounds(0,0,1024,768);


		// Der oprettes endnu en JButton, som logger brugeren ud af programmet
		// og tilbage til login
		btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setBounds(6, 72, 119, 45);
		add(btnLogOut);

		textField = new JTextField();
		textField.setBounds(104, 275, 796, 269);
		textField.setColumns(10);
		add(textField);


		events = new JLabel("Events");
		events.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 30));
		events.setHorizontalAlignment(SwingConstants.CENTER);
		events.setBounds(337, 175, 350, 65);
		add(events);

		btnNotes = new JButton("Notes");
		btnNotes.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		btnNotes.setBounds(317, 571, 389, 65);
		add(btnNotes);

		//adding a btn to refer to home

		btnHome = new JButton("Home");
		btnHome.setBounds(26, 6, 64, 65);
		btnHome.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/home-button.png")));
		add(btnHome);

		btnNewEvent = new JButton("New Event");
		btnNewEvent.setBounds(901, 287, 117, 36);
		add(btnNewEvent);


		//Har endnu ikke lavet noget til denne button!
		btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.setBounds(901, 338, 117, 36);
		add(btnDeleteEvent);

		baggrund = new JLabel("");
		baggrund.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/sam-bg.png")));
		baggrund.setBounds(0, 0, 1024, 768);
		add(baggrund);

	}

	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnHome.addActionListener(l);
		btnNewEvent.addActionListener(l);
		btnDeleteEvent.addActionListener(l);
		btnNotes.addActionListener(l);

	}
	public JButton getbtnLogOut() {
		return btnLogOut;
	}

	public JButton getbtnHome() {
		return btnHome;

	}
	public JButton getbtnNewEvent() {
		return btnNewEvent;
	}
	public JButton getbtnNotes() {
		return btnNotes;
	}
}
