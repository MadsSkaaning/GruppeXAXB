package gui;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class UserEventScreen extends JPanel {
	private JTable table;
	private JButton btnHome = new JButton("");
	private JLabel lblBackground;
	private JLabel lblEvents;

	public UserEventScreen() {
		setLayout(null);
		setBounds(0,0,1024,768);
		
		table = new JTable();
		table.setBounds(108, 508, 407, -173);
		add(table);
		btnHome.setIcon(new ImageIcon(UserEventScreen.class.getResource("/images/home-button.png")));
		btnHome.setBounds(10, 11, 64, 64);
		add(btnHome);
		
		lblEvents = new JLabel("New label");
		lblEvents.setIcon(new ImageIcon(UserEventScreen.class.getResource("/images/eventbtn.png")));
		lblEvents.setBounds(412, 77, 153, 41);
		add(lblEvents);
		
		lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(UserEventScreen.class.getResource("/images/login-mainframe.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);

	}
	
	public JButton getReturn(){
		
		return btnHome;
	}
	
	public void AddActionListener(ActionListener l){
		
		btnHome.addActionListener(l);
	}
	
}