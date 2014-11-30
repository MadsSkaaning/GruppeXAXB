package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

public class MainMenu extends JPanel {
	private JLabel label;
	private JLabel lblMainMenu;
	private JButton btnLogOut;
	private JButton btnUserlist;
	private JButton btnUserlist_1;
	private JButton btnEventlist;
	private JButton btnNotelist;
	

	
	public MainMenu() {
		setSize(new Dimension(1024, 768));
		setLayout(null);
		
		lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setForeground(Color.WHITE);
		lblMainMenu.setFont(new Font("Arial", Font.BOLD, 78));
		lblMainMenu.setBounds(310, 158, 404, 90);
		add(lblMainMenu);
		
		btnUserlist = new JButton("Userlist");
		btnUserlist.setContentAreaFilled(false);
		btnUserlist_1 = new JButton("");
		btnUserlist_1.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/btnuserlist.png")));
		btnUserlist_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUserlist_1.setForeground(Color.WHITE);
		btnUserlist_1.setFont(new Font("Arial", Font.BOLD, 30));
		btnUserlist_1.setBorder(null);
		btnUserlist_1.setBackground(Color.WHITE);
		btnUserlist_1.setBounds(439, 438, 153, 41);
		add(btnUserlist_1);
		
		btnEventlist = new JButton("");
		btnEventlist.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/btneventlist.png")));
		btnEventlist.setContentAreaFilled(false);
		btnEventlist.setForeground(Color.WHITE);
		btnEventlist.setFont(new Font("Arial", Font.BOLD, 30));
		btnEventlist.setBorder(null);
		btnEventlist.setBackground(Color.WHITE);
		btnEventlist.setBounds(439, 490, 153, 41);
		add(btnEventlist);
		
		btnNotelist = new JButton("");
		btnNotelist.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/btnenotelist.png")));
		btnNotelist.setContentAreaFilled(false);
		btnNotelist.setForeground(Color.WHITE);
		btnNotelist.setFont(new Font("Arial", Font.BOLD, 30));
		btnNotelist.setBorder(null);
		btnNotelist.setBackground(Color.WHITE);
		btnNotelist.setBounds(439, 368, 153, 41);
		add(btnNotelist);
		
		btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/Logout.png")));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(439, 609, 153, 41);
		add(btnLogOut);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);

	}
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnEventlist.addActionListener(l);
		btnNotelist.addActionListener(l);
		btnUserlist_1.addActionListener(l);
		
		
	}
	public JButton getBtnUserlist() {
		return btnUserlist_1;
	}
	public JButton getBtnEventlist() {
		return btnEventlist;
	}
	public JButton getBtnNotelist() {
		return btnNotelist;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	
}
