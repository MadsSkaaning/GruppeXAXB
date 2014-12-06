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

public class AddEvent extends JPanel {
	
	private final JLabel lblBackground = new JLabel("");
	private JLabel label;
	private JButton btnHome;
	private JLabel lblLoggedin;
	private JLabel labelUser;
	private JLabel lblPublicPrivate;
	private JLabel lblEnterEventName;
	private JLabel lblEvent;
	private JButton btnAdd;
	private JButton btnCancel;
	private JTextField txtEventName;
	private JTextField txtPublicPrivate;
	private JLabel lblStart;
	private JLabel lblEnd;
	private JTextField txtStart;
	private JTextField txtEnd;
	private JLabel lblExample;
	private JLabel lblExample2;
	private JLabel lblDescription;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AddEvent() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);
		
		btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(Calendar.class.getResource("/img/home-button.png")));
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(0, 0, 96, 76);
		add(btnHome);
		
		lblEvent = new JLabel("Create Event");
		lblEvent.setForeground(Color.LIGHT_GRAY);
		lblEvent.setFont(new Font("Arial", Font.BOLD, 78));
		lblEvent.setBounds(259, 132, 505, 90);
		add(lblEvent);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(326, 622, 206, 53);
		add(btnAdd);
		
		lblLoggedin = new JLabel("Logged in as:");
		lblLoggedin.setBounds(846, 49, 98, 16);
		add(lblLoggedin);
		
		txtEventName = new JTextField();
		txtEventName.setBounds(514, 219, 206, 53);
		add(txtEventName);
		txtEventName.setColumns(40);
		
		lblPublicPrivate = new JLabel("1 = Public, 0 = Private");
		lblPublicPrivate.setForeground(Color.LIGHT_GRAY);
		lblPublicPrivate.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblPublicPrivate.setBounds(236, 297, 221, 38);
		add(lblPublicPrivate);
		
		lblEnterEventName = new JLabel("Enter Event Name");
		lblEnterEventName.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblEnterEventName.setForeground(Color.LIGHT_GRAY);
		lblEnterEventName.setBounds(235, 234, 177, 29);
		add(lblEnterEventName);
		
		labelUser = new JLabel("");
		labelUser.setBounds(846, 70, 132, 29);
		add(labelUser);
		
		lblStart = new JLabel("Enter start time");
		lblStart.setForeground(Color.LIGHT_GRAY);
		lblStart.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblStart.setBounds(236, 364, 159, 29);
		add(lblStart);
		
		txtPublicPrivate = new JTextField();
		txtPublicPrivate.setColumns(10);
		txtPublicPrivate.setBounds(514, 293, 206, 53);
		add(txtPublicPrivate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(558, 622, 206, 53);
		add(btnCancel);
		
		lblEnd = new JLabel("Enter End time");
		lblEnd.setForeground(Color.LIGHT_GRAY);
		lblEnd.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblEnd.setBounds(245, 445, 142, 29);
		add(lblEnd);
		
		txtStart = new JTextField();
		txtStart.setBounds(514, 364, 203, 45);
		add(txtStart);
		txtStart.setColumns(10);
		
		txtEnd = new JTextField();
		txtEnd.setColumns(10);
		txtEnd.setBounds(514, 443, 206, 45);
		add(txtEnd);
		
		lblExample = new JLabel("(YYYY-MM-DD HH:MM:SS)");
		lblExample.setForeground(Color.LIGHT_GRAY);
		lblExample.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblExample.setBounds(235, 388, 177, 16);
		add(lblExample);
		
		lblExample2 = new JLabel("(YYYY-MM-DD HH:MM:SS)");
		lblExample2.setForeground(Color.LIGHT_GRAY);
		lblExample2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblExample2.setBounds(236, 472, 177, 16);
		add(lblExample2);
		
		lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.LIGHT_GRAY);
		lblDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblDescription.setBounds(246, 500, 106, 45);
		add(lblDescription);
		
		textField = new JTextField();
		textField.setColumns(40);
		textField.setBounds(514, 500, 206, 76);
		add(textField);
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
		return txtEventName;
	}


	public JTextField getTxtPublicPrivate() {
		return txtPublicPrivate;
	}
}
