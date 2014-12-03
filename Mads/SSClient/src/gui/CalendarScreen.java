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

public class CalendarScreen extends JPanel {

	
	
	private JButton btnHome = new JButton("");
	private JTable calendarTable;
	private JTextField textField;
	private JTextField textField_1;
	
	public CalendarScreen() {
		setLayout(null);
		setBounds(0, 0, 1024, 768);
		
		
		// Opretter et panel her der skal være 
		final JPanel addEventPanel = new JPanel();
		addEventPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		addEventPanel.setBounds(159,159,600,450);
		addEventPanel.setVisible(false);
		addEventPanel.setLayout(null);
		
		JButton btntest = new JButton("Close");
		btntest.setBounds(241, 173, 73, 23);
		addEventPanel.add(btntest);
		
		JTextField input1 = new JTextField(20);
		input1.setBounds(152, 9, 166, 20);
		JTextField input2 = new JTextField(20);
		input2.setBounds(152, 37, 166, 20);
		
		JLabel label_3 = new JLabel("Field 1");
		label_3.setBounds(116, 12, 31, 14);
		addEventPanel.add(label_3);
		addEventPanel.add(input1);
		JLabel label = new JLabel("Field 2");
		label.setBounds(116, 40, 31, 14);
		addEventPanel.add(label);
		addEventPanel.add(input2);		
		
		JLabel label_1 = new JLabel("Field 2");
		label_1.setBounds(530, 12, 31, 14);
		addEventPanel.add(label_1);
		
		textField = new JTextField(20);
		textField.setBounds(152, 96, 166, 20);
		addEventPanel.add(textField);
		
		JLabel label_2 = new JLabel("Field 2");
		label_2.setBounds(116, 68, 31, 14);
		addEventPanel.add(label_2);
		
		textField_1 = new JTextField(20);
		textField_1.setBounds(152, 65, 166, 20);
		addEventPanel.add(textField_1);
		addEventPanel.setVisible(false);
		add(addEventPanel);
		btnHome.setIcon(new ImageIcon(CalendarScreen.class.getResource("/images/home-button.png")));
		btnHome.setBounds(10, 17, 64, 64);
		add(btnHome);
		
		JLabel lblHerKommerDer = new JLabel("HER KOMMER DER EN CALENDER");
		lblHerKommerDer.setBounds(322, 31, 217, 50);
		add(lblHerKommerDer);
		
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
		
		JButton btnAdd = new JButton("Add Event");
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
				

				
			}
		});
		
		btntest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEventPanel.setVisible(false);
				scrollPane_1.setVisible(true);
				
				
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
