package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontScreen extends JPanel {
	private JTextField forecastField;

	/**
	 * Create the panel.
	 */
	
	private JButton btnCalendar = new JButton("Calendar");
	private JButton btnEventlist = new JButton("Eventlist");
	private JButton btnNewButton = new JButton("Logout");
	private JButton btnExit = new JButton("Exit");
	public FrontScreen() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("quote");
		lblNewLabel.setBounds(131, 41, 102, 50);
		add(lblNewLabel);
		
		JLabel lblLoggedInAs = new JLabel("Logged in as");
		lblLoggedInAs.setBounds(722, 41, 200, 50);
		add(lblLoggedInAs);
		
		forecastField = new JTextField();
		forecastField.setEditable(false);
		forecastField.setBounds(410, 157, 293, 133);
		add(forecastField);
		forecastField.setColumns(10);
		
		btnCalendar.setBounds(512, 335, 89, 39);
		add(btnCalendar);
		
		
		btnEventlist.setBounds(512, 411, 89, 39);
		add(btnEventlist);
		
		
		btnNewButton.setBounds(512, 588, 102, 39);
		add(btnNewButton);
		
		
		btnExit.setBounds(512, 665, 102, 39);
		add(btnExit);

	}
	
	public void addActionListener(ActionListener l) {
		btnCalendar.addActionListener(l);
		btnEventlist.addActionListener(l);
		
	}
	
	public JButton getCalendar(){
		
		return btnCalendar;
	}
	
	public JButton getEvenList(){
		
		return btnEventlist;
	}
	
	public JButton getExit(){
		
		return btnExit;
	}
}
