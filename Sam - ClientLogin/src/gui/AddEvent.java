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
public class AddEvent extends JPanel {

	// Klassens variabler instantieres.
	private JTextField txtEventname;
	private JLabel createevent;
	private JButton btnLogOut;
	private JButton btnHome;
	private JLabel baggrund;
	private JButton btnCreate;
	private JTextField txtLocation;
	private JTextField txtDescription;
	private JTextField txtStart;
	private JTextField txtEnd;
	private JTextField txtCalendarid;
	private JTextField txtCreatedby;



	// Konstruktoer.
	public AddEvent() {
		setLayout(null);
		setBounds(0,0,1024,768);


		btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setBounds(6, 72, 119, 45);
		add(btnLogOut);

		txtEventname = new JTextField();
		txtEventname.setHorizontalAlignment(SwingConstants.CENTER);
		txtEventname.setText("Enter Eventname:");
		txtEventname.setToolTipText("Enter Eventname");
		txtEventname.setBounds(320, 252, 383, 50);
		txtEventname.setColumns(10);
		add(txtEventname);

		txtLocation = new JTextField();
		txtLocation.setToolTipText("");
		txtLocation.setText("Enter location:");
		txtLocation.setHorizontalAlignment(SwingConstants.CENTER);
		txtLocation.setColumns(10);
		txtLocation.setBounds(320, 317, 383, 50);
		add(txtLocation);

		txtCalendarid = new JTextField();
		txtCalendarid.setToolTipText("");
		txtCalendarid.setText("Enter CalendarID");
		txtCalendarid.setHorizontalAlignment(SwingConstants.CENTER);
		txtCalendarid.setColumns(10);
		txtCalendarid.setBounds(320, 565, 383, 50);
		add(txtCalendarid);

		txtCreatedby = new JTextField();
		txtCreatedby.setToolTipText("");
		txtCreatedby.setText("Enter your userID");
		txtCreatedby.setHorizontalAlignment(SwingConstants.CENTER);
		txtCreatedby.setColumns(10);
		txtCreatedby.setBounds(320, 628, 383, 50);
		add(txtCreatedby);

		txtDescription = new JTextField();
		txtDescription.setToolTipText("");
		txtDescription.setText("Enter event description\n");
		txtDescription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescription.setColumns(10);
		txtDescription.setBounds(320, 379, 383, 50);
		add(txtDescription);

		txtEnd = new JTextField();
		txtEnd.setToolTipText("");
		txtEnd.setText("Enter end time:  ex. date: xxxx-xx-xx time: xx:xx:xx\n");
		txtEnd.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnd.setColumns(10);
		txtEnd.setBounds(320, 503, 383, 50);
		add(txtEnd);

		txtStart = new JTextField();
		txtStart.setToolTipText("");
		txtStart.setText("Enter start time:  ex. date: xxxx-xx-xx time: xx:xx:xx\n");
		txtStart.setHorizontalAlignment(SwingConstants.CENTER);
		txtStart.setColumns(10);
		txtStart.setBounds(320, 441, 383, 50);
		add(txtStart);


		createevent = new JLabel("Create Event");
		createevent.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 30));
		createevent.setHorizontalAlignment(SwingConstants.CENTER);
		createevent.setBounds(337, 175, 350, 65);
		add(createevent);


		//adding a btn to refer to home
		btnHome = new JButton("Home");
		btnHome.setBounds(26, 6, 64, 65);
		btnHome.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/home-button.png")));
		add(btnHome);


		btnCreate = new JButton("CREATE");
		btnCreate.setBounds(821, 271, 157, 298);
		add(btnCreate);


		baggrund = new JLabel("");
		baggrund.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/sam-bg.png")));
		baggrund.setBounds(0, 0, 1024, 768);
		add(baggrund);

	}

	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnHome.addActionListener(l);
		btnCreate.addActionListener(l);  //Husk at lav selve denne metode!


	}
	public JButton getbtnLogOut() {
		return btnLogOut;
	}

	public JButton getbtnHome() {
		return btnHome;

	}
	public JButton getbtnCreate() {
		return btnCreate;
	}



	public JTextField getTxtEventname() {
		return txtEventname;
	}

	public JTextField getTxtLocation() {
		return txtLocation;
	}

	public JTextField getTxtDescription() {
		return txtDescription;
	}

	public JTextField getTxtStart() {
		return txtStart;
	}

	public JTextField getTxtEnd() {
		return txtEnd;
	}

	public JTextField getTxtCalendarid() {
		return txtCalendarid;
	}

	public JTextField getTxtCreatedby() {
		return txtCreatedby;
	}




}
