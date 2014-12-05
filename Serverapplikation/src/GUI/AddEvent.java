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

public class AddEvent extends JPanel {
	private JTextField textField_Location;
	private JTextField textField_Createdby;
	private JTextField textField_Start;
	private JButton btnSubmit;
	private JButton btnLogout;
	private JButton btnMainMenu;
	private JLabel lblUserInfo;
	private JLabel lblEnd;
	private JLabel lblName;
	private JLabel lblText;
	private JTextField textField_End;
	private JTextField textField_Name;
	private JTextField textField_Text;

	/**
	 * Create the panel.
	 */
	public AddEvent() {
		setPreferredSize(new Dimension(1024, 768));
		setSize(new Dimension(1024, 768));
		setLayout(null);
		

        btnLogout = new JButton("");
        btnLogout.setIcon(new ImageIcon(UserList.class.getResource("/Images/Logout.png")));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
        btnLogout.setContentAreaFilled(false);
        btnLogout.setBorder(null);
        btnLogout.setBounds(18, 68, 153, 41);
        add(btnLogout);

		textField_Location = new JTextField();
		textField_Location.setForeground(new Color(105, 105, 105));
		textField_Location.setColumns(10);
		textField_Location.setBounds(532, 209, 120, 34);
		add(textField_Location);

		JLabel lblEmail = new JLabel("Location");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 26));
		lblEmail.setBounds(260, 213, 109, 30);
		add(lblEmail);

		textField_Createdby = new JTextField();
		textField_Createdby.setForeground(new Color(105, 105, 105));
		textField_Createdby.setColumns(10);
		textField_Createdby.setBounds(532, 256, 120, 34);
		add(textField_Createdby);

		JLabel lblTeam = new JLabel("Created by");
		lblTeam.setFont(new Font("Arial", Font.BOLD, 26));
		lblTeam.setForeground(new Color(255, 255, 255));
		lblTeam.setBounds(260, 260, 233, 31);
		add(lblTeam);

		textField_Start = new JTextField();
		textField_Start.setForeground(new Color(105, 105, 105));
		textField_Start.setColumns(10);
		textField_Start.setBounds(532, 303, 120, 34);
		add(textField_Start);

		JLabel lblCreateddate = new JLabel("Start");
		lblCreateddate.setForeground(new Color(255, 255, 255));
		lblCreateddate.setFont(new Font("Arial", Font.BOLD, 26));
		lblCreateddate.setBounds(260, 306, 159, 31);
		add(lblCreateddate);

		btnSubmit = new JButton("Create event");
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
		btnSubmit.setBounds(330, 562, 239, 43);
		add(btnSubmit);

		
				
        btnMainMenu = new JButton("");
        btnMainMenu.setIcon(new ImageIcon(UserList.class.getResource("/Images/homebtn.png")));
        btnMainMenu.setForeground(Color.WHITE);
        btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
        btnMainMenu.setContentAreaFilled(false);
        btnMainMenu.setBorder(null);
        btnMainMenu.setBounds(18, 15, 153, 41);
        add(btnMainMenu);
				
				lblUserInfo = new JLabel("Create event");
				lblUserInfo.setForeground(Color.WHITE);
				lblUserInfo.setFont(new Font("Arial", Font.BOLD, 78));
				lblUserInfo.setBounds(228, 133, 466, 91);
				add(lblUserInfo);
						
						lblEnd = new JLabel("End");
						lblEnd.setForeground(Color.WHITE);
						lblEnd.setFont(new Font("Arial", Font.BOLD, 26));
						lblEnd.setBounds(260, 355, 159, 31);
						add(lblEnd);
						
						lblName = new JLabel("Name");
						lblName.setForeground(Color.WHITE);
						lblName.setFont(new Font("Arial", Font.BOLD, 26));
						lblName.setBounds(260, 397, 159, 31);
						add(lblName);
								
								lblText = new JLabel("Description");
								lblText.setForeground(Color.WHITE);
								lblText.setFont(new Font("Arial", Font.BOLD, 26));
								lblText.setBounds(260, 447, 195, 31);
								add(lblText);
								
								textField_End = new JTextField();
								textField_End.setForeground(SystemColor.controlDkShadow);
								textField_End.setColumns(10);
								textField_End.setBounds(532, 350, 120, 34);
								add(textField_End);
								
								textField_Name = new JTextField();
								textField_Name.setForeground(SystemColor.controlDkShadow);
								textField_Name.setColumns(10);
								textField_Name.setBounds(532, 397, 120, 34);
								add(textField_Name);
								
								textField_Text = new JTextField();
								textField_Text.setForeground(SystemColor.controlDkShadow);
								textField_Text.setColumns(10);
								textField_Text.setBounds(532, 444, 120, 34);
								add(textField_Text);

								
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

	
	public JTextField getTextField_Location() {
		return textField_Location;
	}

	public JTextField getTextField_Createdby() {
		return textField_Createdby;
	}

	public JTextField getTextField_Start() {
		return textField_Start;
	}

	public JTextField getTextField_End() {
		return textField_End;
	}

	public JTextField getTextField_Name() {
		return textField_Name;
	}

	public JTextField getTextField_Text() {
		return textField_Text;
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