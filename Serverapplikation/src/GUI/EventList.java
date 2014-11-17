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

import model.QueryBuild.QueryBuilder;


	public class EventList extends JPanel {

		/**
		 * Create the panel.
		 */
		
		private JButton btnAdd;
		private JButton btnDelete;
		private JButton btnLogout;
		private JButton btnMainMenu;
		private JLabel label;
		private final JLabel lblBackground = new JLabel("");
		private JComboBox DropdownList;
		private ResultSet rs;
		
		
		public EventList() {
			setSize(new Dimension(1366, 768));
			setLayout(null);
			
			DropdownList = new JComboBox();
			DropdownList.setBackground(Color.WHITE);
			DropdownList.setModel(new DefaultComboBoxModel(new String[] {"Hold XA Calendar", "Hold XB Calendar", "Custom Events"}));
			DropdownList.setForeground(Color.BLACK);
			DropdownList.setBounds(950, 120, 137, 29);
			add(DropdownList);

			JLabel lblEvents = new JLabel("Eventlist");
			lblEvents.setForeground(Color.WHITE);
			lblEvents.setFont(new Font("Arial", Font.BOLD, 78));
			lblEvents.setBounds(514, 83, 368, 90);
			add(lblEvents);

			
			//Laver tabellen inde i Eventlisten.
			String[] columnNames = { "Event ID","Name", "Start Date", "Note", "Created By" };

			Object[][] data = new Object[getEventCount()][5];
	        
			
		    
	        try {
				QueryBuilder qb = new QueryBuilder();
				rs = qb.selectFrom("events").all().ExecuteQuery();
				
		        int count = 0;
		        while (rs.next()) {
		        	data[count][0] = rs.getString("eventid");
		        	data[count][1] = rs.getString("name");
		        	data[count][2] = rs.getString("start");
		        	data[count][3] = rs.getString("text");
		        	data[count][4] = rs.getString("createdby");

		        	count++;
		        }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			final JTable table = new JTable(data, columnNames);
			table.setSurrendersFocusOnKeystroke(true);
			table.setPreferredScrollableViewportSize(new Dimension(500, 100));
			table.setFillsViewportHeight(true);
			table.setRowSelectionAllowed(true);

			// Create the scroll pane and add the table to it.
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
							255), new Color(0, 0, 205), new Color(255, 255, 255)),
					new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
			scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
							255), new Color(0, 0, 205), new Color(255, 255, 255)),
					null));
			scrollPane.setBounds(387, 194, 591, 361);

			// Add the scroll pane to this panel.
			add(scrollPane);
			
			btnDelete = new JButton("Delete");
			btnDelete.setOpaque(true);
			btnDelete.setForeground(new Color(0, 0, 205));
			btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
			btnDelete.setBounds(1222, 227, 118, 29);
			add(btnDelete);
			
			btnAdd = new JButton("Add");
			btnAdd.setOpaque(true);
			btnAdd.setForeground(new Color(0, 0, 205));
			btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
			btnAdd.setBounds(1222, 193, 118, 29);
			add(btnAdd);
			
			btnMainMenu = new JButton("Main Menu");
			btnMainMenu.setForeground(Color.WHITE);
			btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
			btnMainMenu.setContentAreaFilled(false);
			btnMainMenu.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
			btnMainMenu.setBounds(601, 553, 163, 43);
			add(btnMainMenu);
			
			btnLogout = new JButton("Log out");
			btnLogout.setForeground(Color.WHITE);
			btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
			btnLogout.setContentAreaFilled(false);
			btnLogout.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
			btnLogout.setBounds(624, 627, 117, 43);
			add(btnLogout);
			
			label = new JLabel("");
			label.setIcon(new ImageIcon(NoteList.class.getResource("/Images/CBSLogo3.png")));
			label.setBounds(10, 698, 250, 59);
			add(label);
			lblBackground.setIcon(new ImageIcon(NoteList.class.getResource("/Images/MetalBackground.jpg")));
			lblBackground.setBounds(0, 0, 1366, 768);
			add(lblBackground);
	

		}
		
		public void addActionListener(ActionListener l) {
			btnAdd.addActionListener(l);
			btnDelete.addActionListener(l);
			btnLogout.addActionListener(l);
			btnMainMenu.addActionListener(l);
			DropdownList.addActionListener(l);
		}

		public JButton getBtnAdd() {
			return btnAdd;
		}

		public JComboBox getDropdownList() {
			return DropdownList;
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

