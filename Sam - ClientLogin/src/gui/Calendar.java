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
public class Calendar extends JPanel {

	// Klassens variabler instantieres.
	private JTextField textField;
	private JLabel calendar;
	private JButton btnLogOut;
	private JButton btnHome;
	private JLabel baggrund;
	private JButton btnNewCalendar;
	private JButton btnDeleteCalendar;



	// Konstruktoer.
	public Calendar() {
		setLayout(null);
		setBounds(0,0,1024,768);


		btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setBounds(6, 72, 119, 45);
		add(btnLogOut);

		textField = new JTextField();
		textField.setBounds(104, 275, 796, 269);
		textField.setColumns(10);
		add(textField);


		calendar = new JLabel("Calendar");
		calendar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 30));
		calendar.setHorizontalAlignment(SwingConstants.CENTER);
		calendar.setBounds(337, 175, 350, 65);
		add(calendar);


		//adding a btn to refer to home
		btnHome = new JButton("Home");
		btnHome.setBounds(26, 6, 64, 65);
		btnHome.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/home-button.png")));
		add(btnHome);

		btnNewCalendar = new JButton("New Calendar");
		btnNewCalendar.setBounds(901, 287, 117, 36);
		add(btnNewCalendar);


		//Har endnu ikke lavet noget til denne button!
		btnDeleteCalendar = new JButton("Delete Calendar");
		btnDeleteCalendar.setBounds(901, 338, 117, 36);
		add(btnDeleteCalendar);


		baggrund = new JLabel("");
		baggrund.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/sam-bg.png")));
		baggrund.setBounds(0, 0, 1024, 768);
		add(baggrund);

	}

	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnHome.addActionListener(l);
		btnNewCalendar.addActionListener(l);
		btnDeleteCalendar.addActionListener(l);

	}
	public JButton getbtnLogOut() {
		return btnLogOut;
	}

	public JButton getbtnHome() {
		return btnHome;

	}
	public JButton getbtnNewCalendar() {
		return btnNewCalendar;

	}

}
