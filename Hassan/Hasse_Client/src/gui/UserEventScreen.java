package gui;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;

public class UserEventScreen extends JPanel {
	private JTable table;
	private JButton btnReturn = new JButton("Return to Main Menu");

	public UserEventScreen() {
		setLayout(null);
		
		JLabel lblYourEvents = new JLabel("Your Events");
		lblYourEvents.setBounds(39, 128, 200, 50);
		add(lblYourEvents);
		
		table = new JTable();
		table.setBounds(108, 508, 407, -173);
		add(table);
		
		btnReturn.setBounds(25, 57, 133, 23);
		add(btnReturn);

	}
	
	public JButton getReturn(){
		
		return btnReturn;
	}
	
	public void AddActionListener(ActionListener l){
		
		btnReturn.addActionListener(l);
	}
	
}
