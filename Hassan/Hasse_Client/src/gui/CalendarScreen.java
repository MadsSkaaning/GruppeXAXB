package gui;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CalendarScreen extends JPanel {

	
	
	private JButton btnReturn = new JButton("Return to Main Menu");
	private JTable calendarTable;
	
	public CalendarScreen() {
		setLayout(null);
		
		
		btnReturn.setBounds(27, 31, 133, 23);
		add(btnReturn);
		
		JLabel lblHerKommerDer = new JLabel("HER KOMMER DER EN CALENDER");
		lblHerKommerDer.setBounds(322, 31, 217, 50);
		add(lblHerKommerDer);
		
		JScrollPane scrollPane_1 = new JScrollPane();
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

	}
	
	public void addActionListener (ActionListener l){
		
		btnReturn.addActionListener(l);
		
	}
	
	public JButton getReturn(){
		
		return btnReturn;
	}
}
