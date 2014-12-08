package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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
 * The Class AddCalendar.
 */
public class AddCalendar extends JPanel {

	/** The text field_ name. */
	private JTextField textField_Name;

	/** The btn submit. */
	private JButton btnSubmit;

	/** The btn logout. */
	private JButton btnLogout;

	/** The lbl cb slogo. */
	private JLabel lblCBSlogo;

	/** The btn main menu. */
	private JButton btnMainMenu;

	/** The lbl user info. */
	private JLabel lblUserInfo;

	/** The btn cancel. */
	private JButton btnCancel;
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

		textField_Name = new JTextField();
		textField_Name.setForeground(new Color(105, 105, 105));
		textField_Name.setName("");
		textField_Name.setBounds(696, 272, 120, 34);
		add(textField_Name);
		textField_Name.setColumns(10);

		JLabel lblUserID = new JLabel("Calendar name");
		lblUserID.setForeground(new Color(255, 255, 255));
		lblUserID.setFont(new Font("Arial", Font.BOLD, 26));
		lblUserID.setBounds(424, 272, 186, 30);
		add(lblUserID);

		JLabel lblEmail = new JLabel("Calendars will be public.");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 26));
		lblEmail.setBounds(444, 354, 354, 59);
		add(lblEmail);
		textField_Name.hashCode();

		btnSubmit = new JButton("Create Calendar");
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Submit changes to databases
			}
		}
				);
		btnSubmit.setBounds(480, 491, 300, 43);
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

		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 30));
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnCancel.setBounds(533, 602, 171, 41);
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
	 * Gets the text field_ name.
	 *
	 * @return the text field_ name
	 */
	public JTextField getTextField_Name() {
		return textField_Name;
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
	public JButton getBtnCancel(){
		return btnCancel;
	}
}
