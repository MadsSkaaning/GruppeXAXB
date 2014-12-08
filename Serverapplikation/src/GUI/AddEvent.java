package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class AddEvent.
 */
public class AddEvent extends JPanel {
	
	/** The text field_ location. */
	private JTextField textField_Location;
	
	/** The text field_ createdby. */
	private JTextField textField_Createdby;
	
	/** The text field_ start. */
	private JTextField textField_Start;
	
	/** The btn submit. */
	private JButton btnSubmit;
	
	/** The btn logout. */
	private JButton btnLogout;
	
	/** The btn main menu. */
	private JButton btnMainMenu;
	
	/** The lbl user info. */
	private JLabel lblUserInfo;
	
	/** The lbl end. */
	private JLabel lblEnd;
	
	/** The lbl name. */
	private JLabel lblName;
	
	/** The lbl text. */
	private JLabel lblText;
	
	/** The text field_ end. */
	private JTextField textField_End;
	
	/** The text field_ name. */
	private JTextField textField_Name;
	
	/** The text field_ text. */
	private JTextField textField_Text;
	
	/** The btn cancel. */
	private JButton btnCancel;

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
		textField_Location.setText("1");
		textField_Location.setEditable(false);
		
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
								
								btnCancel = new JButton("Cancel");
								btnCancel.setForeground(Color.WHITE);
								btnCancel.setFont(new Font("Arial", Font.BOLD, 30));
								btnCancel.setContentAreaFilled(false);
								btnCancel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
								btnCancel.setBounds(365, 627, 171, 41);
								add(btnCancel);
								
																
																JLabel lblBackground = new JLabel("");
																lblBackground.setSize(new Dimension(1024, 768));
																lblBackground.setIcon(new ImageIcon(UserInfo.class.getResource("/Images/MetalBackground.jpg")));
																lblBackground.setBounds(0, 0, 1024, 768);
																add(lblBackground);
		
		

	}
	
	/**
	 * Adds the action listener.
	 *
	 * @param l the l
	 */
	public void addActionListener(ActionListener l) {
		btnSubmit.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnCancel.addActionListener(l);
	}

	
	/**
	 * Gets the text field_ location.
	 *
	 * @return the text field_ location
	 */
	public JTextField getTextField_Location() {
		return textField_Location;
	}

	/**
	 * Gets the text field_ createdby.
	 *
	 * @return the text field_ createdby
	 */
	public JTextField getTextField_Createdby() {
		return textField_Createdby;
	}

	/**
	 * Gets the text field_ start.
	 *
	 * @return the text field_ start
	 */
	public JTextField getTextField_Start() {
		return textField_Start;
	}

	/**
	 * Gets the text field_ end.
	 *
	 * @return the text field_ end
	 */
	public JTextField getTextField_End() {
		return textField_End;
	}

	/**
	 * Gets the text field_ name.
	 *
	 * @return the text field_ name
	 */
	public JTextField getTextField_Name() {
		return textField_Name;
	}

	/**
	 * Gets the text field_ text.
	 *
	 * @return the text field_ text
	 */
	public JTextField getTextField_Text() {
		return textField_Text;
	}
	

	/**
	 * Gets the btn submit.
	 *
	 * @return the btn submit
	 */
	public JButton getBtnSubmit() {
		return btnSubmit;
	}
	
	/**
	 * Gets the btn main menu.
	 *
	 * @return the btn main menu
	 */
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	
	/**
	 * Gets the btn logout.
	 *
	 * @return the btn logout
	 */
	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	/**
	 * Gets the btn cancel.
	 *
	 * @return the btn cancel
	 */
	public JButton getBtnCancel() {
		return btnCancel;
	}
	
}