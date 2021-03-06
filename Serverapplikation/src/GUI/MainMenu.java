package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class MainMenu.
 */
public class MainMenu extends JPanel {
	
	/** The label. */
	private JLabel label;
	
	/** The lbl main menu. */
	private JLabel lblMainMenu;
	
	/** The btn log out. */
	private JButton btnLogOut;
	
	/** The btn userlist. */
	private JButton btnUserlist;
	
	/** The btn userlist_1. */
	private JButton btnUserlist_1;
	
	/** The btn eventlist. */
	private JButton btnEventlist;
	
	/** The btn notelist. */
	private JButton btnNotelist;
	
	/** The btn calendar list. */
	private JButton btnCalendarList;
	
	/**
	 * Instantiates a new main menu.
	 */
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
		btnEventlist.setBounds(439, 506, 153, 41);
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
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/Logout.png")));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(18, 68, 153, 41);
		add(btnLogOut);
		
		btnCalendarList = new JButton("");
		btnCalendarList.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/calendarbtn.png")));
		btnCalendarList.setForeground(Color.WHITE);
		btnCalendarList.setFont(new Font("Arial", Font.BOLD, 30));
		btnCalendarList.setContentAreaFilled(false);
		btnCalendarList.setBorder(null);
		btnCalendarList.setBackground(Color.WHITE);
		btnCalendarList.setBounds(439, 563, 153, 41);
		add(btnCalendarList);
		
		btnCalendarList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);

	}
	
	/**
	 * Adds the action listener.
	 *
	 * @param l the l
	 */
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnEventlist.addActionListener(l);
		btnNotelist.addActionListener(l);
		btnUserlist_1.addActionListener(l);
		btnCalendarList.addActionListener(l);
		
		
	}
	
	/**
	 * Gets the btn userlist.
	 *
	 * @return the btn userlist
	 */
	public JButton getBtnUserlist() {
		return btnUserlist_1;
	}
	
	/**
	 * Gets the btn eventlist.
	 *
	 * @return the btn eventlist
	 */
	public JButton getBtnEventlist() {
		return btnEventlist;
	}
	
	/**
	 * Gets the btn notelist.
	 *
	 * @return the btn notelist
	 */
	public JButton getBtnNotelist() {
		return btnNotelist;
	}
	
	/**
	 * Gets the btn log out.
	 *
	 * @return the btn log out
	 */
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	
	/**
	 * Gets the btn calendar list.
	 *
	 * @return the btn calendar list
	 */
	public JButton getBtnCalendarList() {
		return btnCalendarList;
	}
	
}
