package GUI;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;

public class AddCalendar extends JPanel {
	
	private final JLabel lblBackground = new JLabel("");
	private JLabel label;
	private JButton btnHome;
	private JLabel lblLoggedin;
	private JLabel labelUser;
	private JLabel lblPublicPrivate;
	private JLabel lblEnterCalendarName;
	private JLabel lblCalendar;
	private JButton btnAdd;
	private JButton btnCancel;
	private JTextField txtCalendarName;
	private JTextField txtPublicPrivate;
	
	String calendarname;
	String publicprivate;

	/**
	 * Create the panel.
	 */
	public AddCalendar() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);
		
		btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(Calendar.class.getResource("/img/home-button.png")));
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(0, 0, 96, 76);
		add(btnHome);
		
		lblCalendar = new JLabel("Create Calendar");
		lblCalendar.setForeground(Color.LIGHT_GRAY);
		lblCalendar.setFont(new Font("Arial", Font.BOLD, 78));
		lblCalendar.setBounds(166, 132, 679, 90);
		add(lblCalendar);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(363, 528, 206, 53);
		add(btnAdd);
		
		lblLoggedin = new JLabel("Logged in as:");
		lblLoggedin.setBounds(846, 49, 98, 16);
		add(lblLoggedin);
		
		txtCalendarName = new JTextField();
		txtCalendarName.setBounds(363, 299, 206, 53);
		add(txtCalendarName);
		txtCalendarName.setColumns(40);
		
		lblPublicPrivate = new JLabel("1 = Public, 0 = Private");
		lblPublicPrivate.setForeground(Color.LIGHT_GRAY);
		lblPublicPrivate.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblPublicPrivate.setBounds(363, 371, 221, 53);
		add(lblPublicPrivate);
		
		lblEnterCalendarName = new JLabel("Enter Calendar Name");
		lblEnterCalendarName.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblEnterCalendarName.setForeground(Color.LIGHT_GRAY);
		lblEnterCalendarName.setBounds(363, 234, 221, 53);
		add(lblEnterCalendarName);
		
		labelUser = new JLabel("");
		labelUser.setBounds(846, 70, 132, 29);
		add(labelUser);
		
		txtPublicPrivate = new JTextField();
		txtPublicPrivate.setColumns(10);
		txtPublicPrivate.setBounds(363, 436, 206, 53);
		add(txtPublicPrivate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(363, 616, 206, 53);
		add(btnCancel);
		lblBackground.setIcon(new ImageIcon(Calendar.class.getResource("/img/philip-bg.png")));
		lblBackground.setBounds(0, 0, 1024, 768);
		
		add(lblBackground);
	}
	
	public void addActionListener(ActionListener l) {
		btnHome.addActionListener(l);
		btnAdd.addActionListener(l);
		btnCancel.addActionListener(l);

	}

	public JButton getBtnHome() {
		return btnHome;
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JTextField getTxtCalendarName() {
		return txtCalendarName;
	}


	public JTextField getTxtPublicPrivate() {
		return txtPublicPrivate;
	}
	
	public String getCalendarName(){
		
		calendarname = txtCalendarName.getText();
		
		return calendarname;
	}
	
	public String getPublicPrivate(){
		
		publicprivate = txtPublicPrivate.getText();
		
		return publicprivate;
	}

	
	
}
