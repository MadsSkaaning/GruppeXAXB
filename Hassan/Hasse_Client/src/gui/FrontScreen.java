package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

//Min mainmenu man rammer efter man har logget ind. Klassen består af en række af gui elementer, der også er lavet getters på, så de kan tilgås og ændres fra andre klasser

public class FrontScreen extends JPanel {
	private JTextArea forecastField;
	private JButton btnCalendar = new JButton("Calendar");
	private JButton btnEventlist = new JButton("Eventlist");
	private JButton btnNewButton = new JButton("Logout");
	private JButton btnExit = new JButton("Exit");
	private JTextArea quoteField = new JTextArea("");
	public FrontScreen() {
		setLayout(null);
		setBounds(100, 100, 1020, 768);
		quoteField.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		quoteField.setLineWrap(true);
		
		quoteField.setBounds(83, 41, 371, 56);
		add(quoteField);
		
		JLabel lblLoggedInAs = new JLabel("Logged in as");
		lblLoggedInAs.setBounds(722, 41, 200, 50);
		add(lblLoggedInAs);
		
		forecastField = new JTextArea();
		forecastField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		forecastField.setEditable(false);
		forecastField.setBounds(229, 157, 637, 173);
		forecastField.setLineWrap(true);
		add(forecastField);
		forecastField.setColumns(10);
		
		btnCalendar.setBounds(512, 368, 89, 39);
		add(btnCalendar);
		
		
		btnEventlist.setBounds(512, 444, 89, 39);
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
	
	public JTextArea getForecastfield(){
		
		return forecastField;
	}
	
	public JTextArea getQuoteField(){
		
		return quoteField;
	}
}
