package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class AddCalendar extends JPanel {
	private JTextField textField_Email;
	private JButton btnSubmit;
	private JButton btnLogout;
	private JLabel lblCBSlogo;
	private JButton btnMainMenu;
	private JLabel lblUserInfo;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public AddCalendar() {
		setPreferredSize(new Dimension(1024, 768));
		setSize(new Dimension(1024, 768));
		setLayout(null);
		
		lblCBSlogo = new JLabel("");
		lblCBSlogo.setIcon(new ImageIcon(UserInfo.class.getResource("/Images/CBSLogo3.png")));
		lblCBSlogo.setBounds(10, 698, 250, 59);
		add(lblCBSlogo);
		

		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(AddCalendar.class.getResource("/Images/Logout.png")));
		btnLogout.setBorder(null);
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(21, 57, 153, 41);
		add(btnLogout);

		textField_Email = new JTextField();
		textField_Email.setForeground(new Color(105, 105, 105));
		textField_Email.setName("");
		textField_Email.setBounds(696, 272, 120, 34);
		add(textField_Email);
		textField_Email.setColumns(10);

		JLabel lblUserID = new JLabel("Calendar name");
		lblUserID.setForeground(new Color(255, 255, 255));
		lblUserID.setFont(new Font("Arial", Font.BOLD, 26));
		lblUserID.setBounds(424, 272, 186, 30);
		add(lblUserID);

		JLabel lblEmail = new JLabel("Private or public");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 26));
		lblEmail.setBounds(424, 318, 217, 30);
		add(lblEmail);
		textField_Email.hashCode();

		btnSubmit = new JButton("Create Calendar");
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//Submit changes to databases
			//hvad sker der n�r �ndringer ved en bruger submittes
			}
		}
		);
		btnSubmit.setBounds(486, 426, 300, 43);
		add(btnSubmit);

		
				
				btnMainMenu = new JButton("");
				btnMainMenu.setIcon(new ImageIcon(AddCalendar.class.getResource("/Images/homebtn.png")));
				btnMainMenu.setForeground(Color.WHITE);
				btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
				btnMainMenu.setContentAreaFilled(false);
				btnMainMenu.setBorder(null);
				btnMainMenu.setBounds(22, 11, 153, 41);
				add(btnMainMenu);
				
				lblUserInfo = new JLabel("Create Calendar");
				lblUserInfo.setForeground(Color.WHITE);
				lblUserInfo.setFont(new Font("Arial", Font.BOLD, 78));
				lblUserInfo.setBounds(285, 151, 638, 90);
				add(lblUserInfo);
				
				btnNewButton = new JButton("Click for private");
				btnNewButton.setBounds(696, 324, 120, 28);
				add(btnNewButton);
								
				JLabel lblBackground = new JLabel("");
				lblBackground.setSize(new Dimension(1024, 768));
				lblBackground.setIcon(new ImageIcon(UserInfo.class.getResource("/Images/MetalBackground.jpg")));
				lblBackground.setBounds(0, 0, 1024, 768);
				add(lblBackground);
		
		

	}
	
	public void addActionListener(ActionListener l) {
		btnSubmit.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
	}

	

	public JTextField getTextField_Email() {
		return textField_Email;
	}

	
	public JButton getBtnSubmit() {
		return btnSubmit;
	}
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	
	public JButton getBtnLogout() {
		return btnLogout;
	}
}
