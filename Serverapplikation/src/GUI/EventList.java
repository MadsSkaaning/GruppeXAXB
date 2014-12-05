	package GUI;

	import javax.swing.JPanel;

	import java.awt.Dimension;
import java.awt.ScrollPane;

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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import model.QueryBuild.QueryBuilder;


	public class EventList extends JPanel {

		/**
		 * Create the panel.
		 */
		
		private JButton btnAdd;
		private JButton btnDelete;
		private JButton btnLogout;
		private JButton btnMainMenu;
		private final JLabel lblBackground = new JLabel("");
		private ResultSet rs;
		private JPanel deleteEventpanel;
		private JLabel lblEnterTheEvent;
		private JTextField textField;
		private JButton btnCancel;
		private JButton btnDeleteEvent;
		private JTextField EnabledisabletextField;
		private JLabel lblActiveInactive;
		
		
		public EventList() {
			setSize(new Dimension(1024, 768));
			setLayout(null);

			JLabel lblEvents = new JLabel("Eventlist");
			lblEvents.setForeground(Color.WHITE);
			lblEvents.setFont(new Font("Arial", Font.BOLD, 78));
			lblEvents.setBounds(365, 138, 368, 90);
			add(lblEvents);

			
			//Laver tabellen inde i Eventlisten.
			String[] columnNames = { "Event ID", "Location", "Created by", "Start", "End", "Name", "Description", "Calendar ID", "Active", "CustomEvent" };

			Object[][] data = new Object[getEventCount()][10];
	        
			
		    
	        try {
				QueryBuilder qb = new QueryBuilder();
				rs = qb.selectFrom("events").all().ExecuteQuery();
				
		        int count = 0;
		        while (rs.next()) {
		        	data[count][0] = rs.getString("eventid");
		        	data[count][1] = rs.getString("location");
		        	data[count][2] = rs.getString("createdby");
		        	data[count][3] = rs.getString("start");
		        	data[count][4] = rs.getString("end");
		        	data[count][5] = rs.getString("eventname");
		        	data[count][6] = rs.getString("description");
		        	data[count][7] = rs.getString("calendarid");
		        	data[count][8] = rs.getString("active");
		        	data[count][9] = rs.getString("customevent");



		        	count++;
		        }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			final JTable table = new JTable(data, columnNames);
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
			table.setSurrendersFocusOnKeystroke(true);
			table.setPreferredScrollableViewportSize(new Dimension(500, 100));
			table.setFillsViewportHeight(true);
			table.setRowSelectionAllowed(true);

			// Create the scroll pane and add the table to it.
			final JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
							255), new Color(0, 0, 205), new Color(255, 255, 255)),
					new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
			scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
							255), new Color(0, 0, 205), new Color(255, 255, 255)),
					null));
			scrollPane.setBounds(96, 240, 693, 370);

			// Add the scroll pane to this panel.
			add(scrollPane);
			
			btnDelete = new JButton("Edit");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteEventpanel.setVisible(true);
					scrollPane.setVisible(false);
				}
			});
			btnDelete.setOpaque(true);
			btnDelete.setForeground(new Color(0, 0, 205));
			btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
			btnDelete.setBounds(856, 377, 118, 29);
			add(btnDelete);
			
			
			btnAdd = new JButton("Add");
			btnAdd.setOpaque(true);
			btnAdd.setForeground(new Color(0, 0, 205));
			btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
			btnAdd.setBounds(856, 343, 118, 29);
			add(btnAdd);
			
			btnMainMenu = new JButton("");
			btnMainMenu.setIcon(new ImageIcon(EventList.class.getResource("/Images/homebtn.png")));
			btnMainMenu.setForeground(Color.WHITE);
			btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
			btnMainMenu.setContentAreaFilled(false);
			btnMainMenu.setBorder(null);
			btnMainMenu.setBounds(10, 11, 153, 41);
			add(btnMainMenu);
			
			btnLogout = new JButton("");
			btnLogout.setIcon(new ImageIcon(EventList.class.getResource("/Images/Logout.png")));
			btnLogout.setForeground(Color.WHITE);
			btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
			btnLogout.setContentAreaFilled(false);
			btnLogout.setBorder(null);
			btnLogout.setBounds(10, 63, 153, 41);
			add(btnLogout);
			
			deleteEventpanel = new JPanel();
			deleteEventpanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			deleteEventpanel.setBounds(365, 250, 369, 359);
			add(deleteEventpanel);
			deleteEventpanel.setLayout(null);
			
			
			// Hiding the delete calendar panel unless btn delete is clicked
			deleteEventpanel.setVisible(false);
			
			lblEnterTheEvent = new JLabel("Enter the ID of the event you want to delete.");
			lblEnterTheEvent.setBounds(51, 52, 293, 44);
			deleteEventpanel.add(lblEnterTheEvent);
			
			textField = new JTextField();
			textField.setBounds(110, 122, 140, 29);
			deleteEventpanel.add(textField);
			textField.setColumns(10);
			
			btnDeleteEvent = new JButton("Edit!");
			btnDeleteEvent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				scrollPane.setVisible(true);
				deleteEventpanel.setVisible(false);
				}
			});
			btnDeleteEvent.setBounds(212, 227, 89, 23);
			deleteEventpanel.add(btnDeleteEvent);
			
			btnCancel = new JButton("Cancel");
			
						btnCancel.setBounds(66, 227, 89, 23);
						deleteEventpanel.add(btnCancel);
						
						EnabledisabletextField = new JTextField();
						EnabledisabletextField.setBounds(110, 187, 140, 29);
						deleteEventpanel.add(EnabledisabletextField);
						EnabledisabletextField.setColumns(10);
						
						lblActiveInactive = new JLabel("Active =1, Inactive = 0");
						lblActiveInactive.setBounds(120, 162, 152, 14);
						deleteEventpanel.add(lblActiveInactive);
						
								
								
								btnCancel.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										
										deleteEventpanel.setVisible(false);
										scrollPane.setVisible(true);
									}
								});
			lblBackground.setIcon(new ImageIcon(NoteList.class.getResource("/Images/MetalBackground.jpg")));
			lblBackground.setBounds(0, 0, 1024, 768);
			add(lblBackground);
	

		}
		
		public void addActionListener(ActionListener l) {
			btnAdd.addActionListener(l);
			btnDelete.addActionListener(l);
			btnLogout.addActionListener(l);
			btnMainMenu.addActionListener(l);
			btnDeleteEvent.addActionListener(l);
		}

		public JButton getBtnAdd() {
			return btnAdd;
		}



		public JButton getBtnDelete() {
			return btnDelete;
		}

		public JButton getBtnLogout() {
			return btnLogout;
		}

		public JButton getBtnMainMenu() {
			return btnMainMenu;
			
		}

		public JTextField getTextField() {
			return textField;
		}

		public void setTextField(JTextField textField) {
			this.textField = textField;
		}

		public JButton getBtnCancel() {
			return btnCancel;
		}

		public void setBtnCancel(JButton btnCancel) {
			this.btnCancel = btnCancel;
		}

		public JButton getBtnDeleteEvent() {
			return btnDeleteEvent;
		}

		public void setBtnDeleteEvent(JButton btnDeleteEvent) {
			this.btnDeleteEvent = btnDeleteEvent;
		}
		
		public JTextField getEnabledisabletextField() {
			return EnabledisabletextField;
		}


		public int getEventCount(){
			
			int count = 0;
			
			QueryBuilder qb2 = new QueryBuilder();
			try {
				rs = qb2.selectFrom("events").all().ExecuteQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while(rs.next()){
					
					count++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count; 
		}
	}

