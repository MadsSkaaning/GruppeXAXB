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

import logic.Controller;

//import model.QueryBuild.QueryBuilder;


	public class Events extends JPanel {
		private JButton btnHome;
		private final JLabel lblBackground = new JLabel("");
		private JLabel lblEvents;
		private JLabel lblLoggedin;
		private JLabel labelUser;
		private JButton btnAdd;
		private JLabel lblEventsHeader;
		
		public Events() {
			setBounds(0, 0, 1024, 768);
			setLayout(null);

			Controller mycont = new Controller();
			
			btnAdd = new JButton("Add");
			btnAdd.setBounds(738, 173, 206, 53);
			add(btnAdd);

			lblEventsHeader = new JLabel("Events");
			lblEventsHeader.setForeground(Color.LIGHT_GRAY);
			lblEventsHeader.setFont(new Font("Arial", Font.BOLD, 78));
			lblEventsHeader.setBounds(328, 132, 368, 90);
			add(lblEventsHeader);

			
			btnHome = new JButton("Home");
			btnHome.setIcon(new ImageIcon(Calendar.class.getResource("/img/home-button.png")));
			btnHome.setOpaque(false);
			btnHome.setContentAreaFilled(false);
			btnHome.setBorderPainted(false);
			btnHome.setBounds(0, 0, 96, 76);
			add(btnHome);
			
			String events = mycont.userControlls("getEvent");
			
			lblEvents = new JLabel();
			lblEvents.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblEvents.setForeground(Color.LIGHT_GRAY);
			events = events.replace("activityid", "<br/> <br/>");
			lblEvents.setText("<html>" + events + "</html>");
			lblEvents.setBounds(22, 249, 956, 413);
			add(lblEvents);
	
			
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
		
	}

