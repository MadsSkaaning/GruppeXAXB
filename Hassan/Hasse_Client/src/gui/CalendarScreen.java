package gui;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
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


//Denne screen er et Jpanel, der indenholder min "kalendeer", der desværre ikke blev færdig. Det skulle helst være sådan, at brugeren her kunne vælge at få vist en specifik kaldener, der viste tilknyttede events.
//Derudover indenholder denne klasse en længere række af getters for de elementer den består er, så de kan tilgås og ændres fra andre klasser.
//Til sidst indenholder klassen en metode, der kan lave en calendar, denne funktion virker fuldt ud.


public class CalendarScreen extends JPanel {

	
	private JPanel addUserPanel = new JPanel ();
	private JButton btnReturn = new JButton("Return to Main Menu");
	private JTable calendarTable;
	private JButton btnCreateCalendar = new JButton("Create Calendar");
	private  JTextField setCalendarName = new JTextField(10);
	private JTextField setCalendarCreatedby = new JTextField(10);
	private JTextField setCalendarPublicPrivate = new JTextField(10);
	private JPanel createCalendar = new JPanel();
	private JButton btnGetCalendar = new JButton("Get Calendar");
	public CalendarScreen() {
		setLayout(null);
		setBounds(100, 100, 1020, 768);

		createCalendar.add(setCalendarCreatedby);
		createCalendar.add(setCalendarName);
		createCalendar.add(setCalendarPublicPrivate);
		
		
		
		
		
		
		btnReturn.setBounds(27, 31, 133, 23);
		add(btnReturn);
		
		JLabel lblHerKommerDer = new JLabel("HER KOMMER DER EN CALENDER");
		lblHerKommerDer.setBounds(322, 31, 217, 50);
		add(lblHerKommerDer);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 161, 940, 304);
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
		
		
		btnCreateCalendar.setBounds(450, 548, 111, 23);
		add(btnCreateCalendar);
		
		
		btnGetCalendar.setBounds(450, 599, 111, 23);
		add(btnGetCalendar);

	}
	
	public void addActionListenerReturn (ActionListener l){
		
		btnReturn.addActionListener(l);
		
	}
	
	public void addActionListenerCreateCal(ActionListener l){
		
		btnCreateCalendar.addActionListener(l);
	}
	
	public void addActionListenerGetCalendar(ActionListener l){
		
		btnGetCalendar.addActionListener(l);
	}
	
	public JButton getReturn(){
		
		return btnReturn;
	}
	
	public JButton getCreateCalenderBtn(){
		
		
		return btnCreateCalendar;
	}
	
	public JPanel getCreateCalendarPanel(){
		
		return createCalendar;
	}
	
	public JTextField getSetCalendarNameTxt(){
		
		return setCalendarName;
	}
	
	
//	Denne metode viser en JOptionPane der har til formål at læse brugerens inputs, for at kunne oprette et event
	
	public String setCreateCalendarFields(){
		
		
		int ifokay = JOptionPane.showConfirmDialog(new JFrame(), createCalendar , "Indtast dit bruger id, efterfulgt af navnet på kalenderen og indstast herefter enten 1 eller 2, for henholdsvis public or private", JOptionPane.OK_CANCEL_OPTION);			
		
		if(ifokay == JOptionPane.OK_OPTION){
			
			
			return "true";
		
		
		}else{return "false";}
		
	}
	
//	Metode der henter en specifik kalender fra serverens database, via bruger inputs fra en JOptionPane
	
	public String getCalendarUserinputs(){
		
		String calendarname = JOptionPane.showInputDialog(new JFrame(), "Indtast navnet på kalenderen du vil hente");
		
		return calendarname;
		
	}
	
	public String getCreateEventName(){
		
		return setCalendarName.getText();
	}
	
	public String getCreatedBy(){
		
		return setCalendarCreatedby.getText();
	}
	
	public int getCalendarPublicPricate(){
		
		return Integer.parseInt(setCalendarPublicPrivate.getText());
	}
	
	public JButton getCalendarBtn(){
		
		return btnGetCalendar;
	}

	
}
