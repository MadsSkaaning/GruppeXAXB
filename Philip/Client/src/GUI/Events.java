	package GUI;

	import javax.swing.JPanel;

	import java.awt.Dimension;

	import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;

	import java.awt.Font;

	import javax.swing.SwingConstants;
import javax.swing.JButton;

	import java.awt.Color;

	import javax.swing.JScrollPane;

	import java.awt.Component;

	import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

//import model.QueryBuild.QueryBuilder;


	public class Events extends JPanel {
		private JButton btnHome;
		private final JLabel lblBackground = new JLabel("");
		private JComboBox DropdownList;
		private JTextField txtEvents;
		private JLabel lblLoggedin;
		private JLabel labelUser;
		private JButton btnAdd;
		
		public Events() {
			setBounds(0, 0, 1024, 768);
			setLayout(null);
			
			DropdownList = new JComboBox();
			DropdownList.setBackground(Color.WHITE);
			DropdownList.setModel(new DefaultComboBoxModel(new String[] {"Hold XA Calendar", "Hold XB Calendar", "OSV"}));
			DropdownList.setForeground(Color.BLACK);
			DropdownList.setBounds(728, 249, 216, 53);
			add(DropdownList);
			
			btnAdd = new JButton("Add");
			btnAdd.setBounds(738, 325, 206, 53);
			add(btnAdd);

			JLabel lblEvents = new JLabel("Events");
			lblEvents.setForeground(Color.WHITE);
			lblEvents.setFont(new Font("Arial", Font.BOLD, 78));
			lblEvents.setBounds(328, 132, 368, 90);
			add(lblEvents);

			
			btnHome = new JButton("Home");
			btnHome.setIcon(new ImageIcon(Calendar.class.getResource("/img/home-button.png")));
			btnHome.setOpaque(false);
			btnHome.setContentAreaFilled(false);
			btnHome.setBorderPainted(false);
			btnHome.setBounds(0, 0, 96, 76);
			add(btnHome);
			
			txtEvents = new JTextField();
			txtEvents.setText("EVENTS");
			txtEvents.setBounds(100, 249, 521, 366);
			add(txtEvents);
			txtEvents.setColumns(10);
	
			
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
			DropdownList.addActionListener(l);
			btnAdd.addActionListener(l);
		}

		public JComboBox getDropdownList() {
			return DropdownList;
		}

		public JButton getBtnHome() {
			return btnHome;
			
		}
		
		public JButton getBtnAdd() {
			return btnAdd;
		}
		
	}

