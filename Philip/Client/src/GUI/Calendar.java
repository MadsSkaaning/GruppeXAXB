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

public class Calendar extends JPanel {
	
	private final JLabel lblBackground = new JLabel("");
	private JLabel label;
	private JButton btnHome;
	private JTextField txtCalendar;
	private JLabel lblLoggedin;
	private JLabel labelUser;
	private JLabel lblCalendar;
	private JButton btnAdd;
	
	String text;

	/**
	 * Create the panel.
	 */
	public Calendar() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);
		
		btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(Calendar.class.getResource("/img/home-button.png")));
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(0, 0, 96, 76);
		add(btnHome);
		
		lblCalendar = new JLabel("Calendar");
		lblCalendar.setForeground(Color.LIGHT_GRAY);
		lblCalendar.setFont(new Font("Arial", Font.BOLD, 78));
		lblCalendar.setBounds(328, 132, 368, 90);
		add(lblCalendar);
		
		txtCalendar = new JTextField();
		txtCalendar.setText("CALENDAR");
		txtCalendar.setBounds(100, 249, 521, 366);
		add(txtCalendar);
		txtCalendar.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(738, 325, 206, 53);
		add(btnAdd);
	    
		
		lblLoggedin = new JLabel("Logged in as:");
		lblLoggedin.setBounds(846, 49, 98, 16);
		add(lblLoggedin);
		
		labelUser = new JLabel("");
		labelUser.setBounds(846, 70, 132, 29);
		add(labelUser);
		lblBackground.setIcon(new ImageIcon(Calendar.class.getResource("/img/philip-bg.png")));
		lblBackground.setBounds(0, 0, 1024, 768);
		
		add(lblBackground);
	}
	
	public void addActionListener(ActionListener l) {
		btnHome.addActionListener(l);
		btnAdd.addActionListener(l);

	}

	public JButton getBtnHome() {
		return btnHome;
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public String getText() {
		return text;
	}
	
}
