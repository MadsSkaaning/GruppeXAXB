package gui;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBox;

// TODO: Auto-generated Javadoc
/**
 * The Class CalendarScreen.
 */
public class CalendarScreen extends JPanel {

	/** The btn home. */
	private JButton btnHome = new JButton("");

	/** The calendar table. */
	private JTable calendarTable;

	/** The text field user name. */
	private JTextField textFieldUserName;

	/** The txt invite usernames. */
	private JLabel txtInviteUsernames;

	/** The input1. */
	private JTextField input1;

	/** The btn create test event. */
	private JButton btnCreateTestEvent;

	/**
	 * Instantiates a new calendar screen.
	 */
	public CalendarScreen() {
		setLayout(null);
		setBounds(0, 0, 1024, 768);
		btnHome.setIcon(new ImageIcon(CalendarScreen.class
				.getResource("/images/home-button.png")));
		btnHome.setBounds(10, 17, 64, 64);
		add(btnHome);

		// Creating all the panels in the Calendar Screen.
		final JPanel addEventPanel = new JPanel();
		addEventPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		addEventPanel.setBounds(159, 159, 600, 450);
		addEventPanel.setVisible(false);
		addEventPanel.setLayout(null);

		JButton btntest = new JButton("Close");
		btntest.setBounds(135, 291, 73, 23);
		addEventPanel.add(btntest);

		input1 = new JTextField(20);
		input1.setBounds(160, 124, 166, 20);

		JLabel lblCalendarName = new JLabel("Calendar Name");
		lblCalendarName.setBounds(21, 127, 134, 14);
		addEventPanel.add(lblCalendarName);
		addEventPanel.add(input1);
		JLabel lblPublicOrPrivate = new JLabel(
				"Click to set calendar private. Otherwise it will be public per default.");
		lblPublicOrPrivate.setBounds(31, 152, 499, 28);
		addEventPanel.add(lblPublicOrPrivate);

		addEventPanel.setVisible(false);
		add(addEventPanel);

		JLabel lblAddNewCalendar = new JLabel("Add New Calendar");
		lblAddNewCalendar.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblAddNewCalendar.setBounds(160, 46, 166, 37);
		addEventPanel.add(lblAddNewCalendar);

		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(295, 191, 166, 20);
		addEventPanel.add(textFieldUserName);
		textFieldUserName.setColumns(10);

		JButton btnClickMe = new JButton("Private:");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtInviteUsernames.setVisible(true);
				textFieldUserName.setVisible(true);

			}
		});
		btnClickMe.setBounds(41, 190, 89, 23);
		addEventPanel.add(btnClickMe);

		txtInviteUsernames = new JLabel();
		txtInviteUsernames.setText("Invite userid");
		txtInviteUsernames.setBounds(177, 191, 108, 20);
		addEventPanel.add(txtInviteUsernames);

		JButton btnAddCalendar = new JButton("Add Calendar");
		btnAddCalendar.setBounds(252, 291, 108, 23);
		addEventPanel.add(btnAddCalendar);

		// hiding these variables per default
		textFieldUserName.setVisible(false);

		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 161, 940, 532);
		add(scrollPane_1);

		calendarTable = new JTable();
		calendarTable.setBorder(null);
		calendarTable.setFillsViewportHeight(true);
		calendarTable.setModel(new DefaultTableModel(new Object[][] {
				{ "08:00", null, "", "", null, "", null, null },
				{ "09:00", null, null, null, null, null, null, null },
				{ "10:00", null, null, null, null, null, null, null },
				{ "11:00", null, null, null, null, null, null, null },
				{ "12:00", null, null, null, null, null, null, null },
				{ "13:00", null, null, null, null, null, null, null },
				{ "14:00", null, null, null, null, null, null, null },
				{ "15:00", null, null, null, null, null, null, null },
				{ "16:00", null, null, null, null, null, null, null },
				{ "17:00", null, null, null, null, null, null, null },
				{ "18:00", null, null, null, null, null, null, null },
				{ "19:00", null, null, null, null, null, null, null },
				{ "20:00", null, null, null, null, null, null, null },
				{ "21:00", null, null, null, null, null, null, null },
				{ "22:00", null, null, null, null, null, null, null },
				{ "23:00", null, null, null, null, null, null, null },
				{ "24:00", null, null, null, null, null, null, null }, },
				new String[] { "Time", "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday", "Sunday" }) {
			Class[] columnTypes = new Class[] { String.class, Object.class,
					Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		calendarTable.getColumnModel().getColumn(0).setResizable(false);
		calendarTable.getColumnModel().getColumn(1).setResizable(false);
		calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		calendarTable.setCellSelectionEnabled(true);
		scrollPane_1.setViewportView(calendarTable);

		final JTextField testfield = new JTextField();
		testfield.setText("yeah");
		add(testfield);

		final JTextField testfield2 = new JTextField();
		testfield.setText("yeah2");
		add(testfield2);

		JButton btnAdd = new JButton("Add Calendar");
		btnAdd.setLocation(98, 47);
		btnAdd.setSize(173, 34);
		add(btnAdd);

		btnCreateTestEvent = new JButton("Create Test Event");
		btnCreateTestEvent.setBounds(749, 53, 163, 28);
		add(btnCreateTestEvent);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(CalendarScreen.class
				.getResource("/images/login-mainframe.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEventPanel.setVisible(true);
				scrollPane_1.setVisible(false);

				txtInviteUsernames.setVisible(false);
				textFieldUserName.setVisible(false);

			}
		});

		btntest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEventPanel.setVisible(false);
				scrollPane_1.setVisible(true);

				textFieldUserName.setText("");
				input1.setText("");

			}
		});

	}

	/**
	 * Adds the action listener.
	 *
	 * @param l the l
	 */
	public void addActionListener(ActionListener l) {

		btnHome.addActionListener(l);
		btnCreateTestEvent.addActionListener(l);
	}

	/**
	 * Gets the return.
	 *
	 * @return the return
	 */
	public JButton getReturn() {
		return btnHome;
	}

	/**
	 * Gets the btn create test event.
	 *
	 * @return the btn create test event
	 */
	public JButton getBtnCreateTestEvent() {
		return btnCreateTestEvent;
	}

}
