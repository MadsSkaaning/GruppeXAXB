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
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import model.QueryBuild.QueryBuilder;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


	public class CalendarList extends JPanel {

		/**
		 * Create the panel.
		 */
		
		
		private JButton btnAdd;
		private JButton btnDelete;
		private JButton btnLogout;
		private JButton btnMainMenu;
		private final JLabel lblBackground = new JLabel("");
		private ResultSet rs;
		private JPanel deletecalpanel;
		private JLabel lblEnterTheCalendar;
		private JTextField textField;
		private JButton btnCancel;
		private JButton btnfinaldelete;
		private JScrollPane scrollPane;
		private JLabel lblEnterTo;
		private JTextField enabledisabletextField;
		
		
		public CalendarList() {
			setSize(new Dimension(1024, 768));
			setLayout(null);

			JLabel lblEvents = new JLabel("Calendar list");
			lblEvents.setForeground(Color.WHITE);
			lblEvents.setFont(new Font("Arial", Font.BOLD, 78));
			lblEvents.setBounds(365, 138, 567, 90);
			add(lblEvents);

			
			//Laver tabellen inde i Calendar listen.
			String[] columnNames = { "calendarid","calendarname", "createdby", "privatepublic", "active" };

			Object[][] data = new Object[getEventCount()][5];
	        
		    
	        try {
				QueryBuilder qb = new QueryBuilder();
				rs = qb.selectFrom("calendar").all().ExecuteQuery();
				
		        int count = 0;
		        while (rs.next()) {
		        	data[count][0] = rs.getString("calendarid");
		        	data[count][1] = rs.getString("calendarname");
		        	data[count][2] = rs.getString("createdby");
		        	data[count][3] = rs.getString("privatepublic");
		        	data[count][4] = rs.getString("active");

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
				public void actionPerformed(ActionEvent arg0) {
					
					deletecalpanel.setVisible(true);
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
			btnMainMenu.setIcon(new ImageIcon(CalendarList.class.getResource("/Images/homebtn.png")));
			btnMainMenu.setForeground(Color.WHITE);
			btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
			btnMainMenu.setContentAreaFilled(false);
			btnMainMenu.setBorder(null);
			btnMainMenu.setBounds(10, 11, 153, 41);
			add(btnMainMenu);
			
			btnLogout = new JButton("");
			btnLogout.setIcon(new ImageIcon(CalendarList.class.getResource("/Images/Logout.png")));
			btnLogout.setForeground(Color.WHITE);
			btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
			btnLogout.setContentAreaFilled(false);
			btnLogout.setBorder(null);
			btnLogout.setBounds(10, 63, 153, 41);
			add(btnLogout);
			
			deletecalpanel = new JPanel();
			deletecalpanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			deletecalpanel.setBounds(365, 250, 369, 359);
			add(deletecalpanel);
			deletecalpanel.setLayout(null);
			
			
			// Hiding the delete calendar panel unless btn delete is clicked
			deletecalpanel.setVisible(false);
			
			lblEnterTheCalendar = new JLabel("Enter the ID of the calendar you want to edit.");
			lblEnterTheCalendar.setBounds(66, 52, 350, 44);
			deletecalpanel.add(lblEnterTheCalendar);
			
			textField = new JTextField();
			textField.setBounds(110, 122, 140, 29);
			deletecalpanel.add(textField);
			textField.setColumns(10);
			
			btnfinaldelete = new JButton("Delete!");
			btnfinaldelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					deletecalpanel.setVisible(false);
					scrollPane.setVisible(true);
					
				}
			});
			btnfinaldelete.setBounds(212, 227, 89, 23);
			deletecalpanel.add(btnfinaldelete);
			
			btnCancel = new JButton("Cancel");
			
						btnCancel.setBounds(66, 227, 89, 23);
						deletecalpanel.add(btnCancel);
						
						lblEnterTo = new JLabel("Enter 0 to disable and 1 to enable");
						lblEnterTo.setBounds(77, 162, 403, 29);
						deletecalpanel.add(lblEnterTo);
						
						enabledisabletextField = new JTextField();
						enabledisabletextField.setBounds(131, 196, 86, 20);
						deletecalpanel.add(enabledisabletextField);
						enabledisabletextField.setColumns(10);
						lblBackground.setBounds(0, 0, 1024, 768);
						add(lblBackground);
						lblBackground.setIcon(new ImageIcon(NoteList.class.getResource("/Images/MetalBackground.jpg")));
						
								
								
								btnCancel.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										
										deletecalpanel.setVisible(false);
										scrollPane.setVisible(true);
									}
								});

		}
		
		public void addActionListener(ActionListener l) {
			btnAdd.addActionListener(l);
			btnDelete.addActionListener(l);
			btnLogout.addActionListener(l);
			btnMainMenu.addActionListener(l);
			btnfinaldelete.addActionListener(l);
			
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
		
		public JButton getBtnfinaldelete(){
			return btnfinaldelete;
		}
		
		public JTextField getTextField() {
			return textField;
		}
		
		public JTextField getEnabledisabletextField() {
			return enabledisabletextField;
		}



		public int getEventCount(){
			
			int count = 0;
			
			QueryBuilder qb2 = new QueryBuilder();
			try {
				rs = qb2.selectFrom("calendar").all().ExecuteQuery();
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

