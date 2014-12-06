package gui;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;

//Dette screen indenholder events for useren (desværre hardcoded på serveren. Her kan der godt viderudvikles...

public class UserEventScreen extends JPanel {
	private JButton btnReturn = new JButton("Return to Main Menu");
	JTextArea textEventArea = new JTextArea();

	public UserEventScreen() {
		setLayout(null);
		setBounds(100, 100, 1020, 768);

		JLabel lblYourEvents = new JLabel("Your Events:");
		lblYourEvents.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblYourEvents.setBounds(365, 43, 200, 50);
		add(lblYourEvents);
		
		btnReturn.setBounds(25, 57, 133, 23);
		add(btnReturn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(174, 108, 695, 430);
		add(scrollPane_1);
		textEventArea.setEditable(false);
		textEventArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollPane_1.setViewportView(textEventArea);
		
		
		textEventArea.setEnabled(false);

	}
	
	public JButton getReturn(){
		
		return btnReturn;
	}
	
	public JTextArea getEventsArea(){
		
		return textEventArea;
	}
	
	public void AddActionListener(ActionListener l){
		
		btnReturn.addActionListener(l);
	}
}
