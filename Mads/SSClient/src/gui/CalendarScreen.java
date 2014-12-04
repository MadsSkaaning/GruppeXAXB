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

public class CalendarScreen extends JPanel {

	
	
	private JButton btnHome = new JButton("");
	private JTable calendarTable;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldUserName;
	private JTextField txtInviteUsernames;
	private JTextField input1;
	
	public CalendarScreen() {
		setLayout(null);
		setBounds(0, 0, 1024, 768);
		btnHome.setIcon(new ImageIcon(CalendarScreen.class.getResource("/images/home-button.png")));
		btnHome.setBounds(10, 17, 64, 64);
		add(btnHome);
		
		
		// Opretter et panel her der skal være 
		final JPanel addEventPanel = new JPanel();
		addEventPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		addEventPanel.setBounds(159,159,600,450);
		addEventPanel.setVisible(false);
		addEventPanel.setLayout(null);
		
		JButton btntest = new JButton("Close");
		btntest.setBounds(124, 285, 73, 23);
		addEventPanel.add(btntest);
		
		input1 = new JTextField(20);
		input1.setBounds(160, 124, 166, 20);
		
		JLabel lblCalendarName = new JLabel("Calendar Name");
		lblCalendarName.setBounds(21, 127, 134, 14);
		addEventPanel.add(lblCalendarName);
		addEventPanel.add(input1);
		JLabel lblPublicOrPrivate = new JLabel("Set Calendar as private");
		lblPublicOrPrivate.setBounds(21, 155, 134, 14);
		addEventPanel.add(lblPublicOrPrivate);
		
		JLabel label_1 = new JLabel("Field 2");
		label_1.setBounds(21, 214, 134, 14);
		addEventPanel.add(label_1);
		
		textField = new JTextField(20);
		textField.setBounds(160, 211, 166, 20);
		addEventPanel.add(textField);
		
		JLabel label_2 = new JLabel("Field 2");
		label_2.setBounds(21, 183, 134, 14);
		addEventPanel.add(label_2);
		
		textField_1 = new JTextField(20);
		textField_1.setBounds(160, 180, 166, 20);
		
		 java.util.Date date= new java.util.Date();

		
		textField_1.setText("" + date);
		addEventPanel.add(textField_1);
		addEventPanel.setVisible(false);
		add(addEventPanel);
		
		JLabel lblAddNewCalendar = new JLabel("Add New Calendar");
		lblAddNewCalendar.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblAddNewCalendar.setBounds(160, 46, 166, 37);
		addEventPanel.add(lblAddNewCalendar);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(380, 154, 166, 20);
		addEventPanel.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JButton btnClickMe = new JButton("Private:");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtInviteUsernames.setVisible(true);
				textFieldUserName.setVisible(true);
				
			}
		});
		btnClickMe.setBounds(160, 151, 89, 23);
		addEventPanel.add(btnClickMe);
		
		txtInviteUsernames = new JTextField();
		txtInviteUsernames.setText("Invite usernames");
		txtInviteUsernames.setBounds(262, 155, 108, 20);
		addEventPanel.add(txtInviteUsernames);
		txtInviteUsernames.setColumns(10);
		
		JButton btnAddCalendar = new JButton("Add Calendar");
		btnAddCalendar.setBounds(241, 285, 108, 23);
		addEventPanel.add(btnAddCalendar);
		
		
		//hiding these variables hehe
		
		textFieldUserName.setVisible(false);
		txtInviteUsernames.setVisible(false);
		
		
		
		

		
		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 161, 940, 532);
		add(scrollPane_1);
		
		
		
		
		calendarTable = new JTable();
		calendarTable.setBorder(null);
		calendarTable.setFillsViewportHeight(true);
		calendarTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"08:00", null, "", "", null, "", null, null},
				{"09:00", null, null, null, null, null, null, null},
				{"10:00", null, null, null, null, null, null, null},
				{"11:00", null, null, null, null, null, null, null},
				{"12:00", null, null, null, null, null, null, null},
				{"13:00", null, null, null, null, null, null, null},
				{"14:00", null, null, null, null, null, null, null},
				{"15:00", null, null, null, null, null, null, null},
				{"16:00", null, null, null, null, null, null, null},
				{"17:00", null, null, null, null, null, null, null},
				{"18:00", null, null, null, null, null, null, null},
				{"19:00", null, null, null, null, null, null, null},
				{"20:00", null, null, null, null, null, null, null},
				{"21:00", null, null, null, null, null, null, null},
				{"22:00", null, null, null, null, null, null, null},
				{"23:00", null, null, null, null, null, null, null},
				{"24:00", null, null, null, null, null, null, null},
			},
			new String[] {
				"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
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
		btnAdd.setLocation(121, 6);
		btnAdd.setSize(100, 100);
		add(btnAdd);
		
		
		
				
				JLabel lblBackground = new JLabel("");
				lblBackground.setIcon(new ImageIcon(CalendarScreen.class.getResource("/images/login-mainframe.jpg")));
				lblBackground.setBounds(0, 0, 1024, 768);
				add(lblBackground);
		
				
				
				
				
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showConfirmDialog(null, "the game is rigged.");
				
				//JOptionPane.showConfirmDialog(testfield, testfield2);
				
				
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
	
	
	public void addActionListener (ActionListener l){
		
		btnHome.addActionListener(l);
		
	}
	
	public JButton getReturn(){
		
		return btnHome;
	}
}
