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
 * The Class AddUser.
 */
public class AddUser extends JPanel {

	/** The text field_ email. */
	private JTextField textField_Email;

	/** The text field_ type. */
	private JTextField textField_Type;

	/** The text field_ password. */
	private JTextField textField_Password;

	/** The btn submit. */
	private JButton btnSubmit;

	/** The btn logout. */
	private JButton btnLogout;

	/** The btn main menu. */
	private JButton btnMainMenu;

	/** The lbl user info. */
	private JLabel lblUserInfo;

	/** The btn cancel. */
	private JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public AddUser() {
		setPreferredSize(new Dimension(1024, 768));
		setSize(new Dimension(1024, 768));
		setLayout(null);


		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(AddUser.class.getResource("/Images/Logout.png")));
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

		JLabel lblUserID = new JLabel("Email");
		lblUserID.setForeground(new Color(255, 255, 255));
		lblUserID.setFont(new Font("Arial", Font.BOLD, 26));
		lblUserID.setBounds(424, 272, 104, 30);
		add(lblUserID);

		textField_Type = new JTextField();
		textField_Type.setForeground(new Color(105, 105, 105));
		textField_Type.setColumns(10);
		textField_Type.setBounds(696, 320, 120, 34);
		add(textField_Type);

		JLabel lblEmail = new JLabel("Type");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 26));
		lblEmail.setBounds(424, 318, 109, 30);
		add(lblEmail);

		textField_Password = new JTextField();
		textField_Password.setForeground(new Color(105, 105, 105));
		textField_Password.setColumns(10);
		textField_Password.setBounds(696, 366, 120, 34);
		textField_Email.hashCode();
		add(textField_Password);

		JLabel lblTeam = new JLabel("Password");
		lblTeam.setFont(new Font("Arial", Font.BOLD, 26));
		lblTeam.setForeground(new Color(255, 255, 255));
		lblTeam.setBounds(424, 364, 127, 30);
		add(lblTeam);

		btnSubmit = new JButton("");
		btnSubmit.setIcon(new ImageIcon(AddUser.class.getResource("/Images/add_user.png")));
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorder(null);
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Submit changes to databases
				//hvad sker der n�r �ndringer ved en bruger submittes
			}
		}
				);
		btnSubmit.setBounds(557, 489, 153, 41);
		add(btnSubmit);



		btnMainMenu = new JButton("");
		btnMainMenu.setIcon(new ImageIcon(AddUser.class.getResource("/Images/homebtn.png")));
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBorder(null);
		btnMainMenu.setBounds(22, 11, 153, 41);
		add(btnMainMenu);

		lblUserInfo = new JLabel("Create user");
		lblUserInfo.setForeground(Color.WHITE);
		lblUserInfo.setFont(new Font("Arial", Font.BOLD, 78));
		lblUserInfo.setBounds(392, 151, 464, 90);
		add(lblUserInfo);

		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 30));
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnCancel.setBounds(551, 574, 171, 41);
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
	 * Gets the text field_ email.
	 *
	 * @return the text field_ email
	 */
	public JTextField getTextField_Email() {
		return textField_Email;
	}

	/**
	 * Gets the text field_ type.
	 *
	 * @return the text field_ type
	 */
	public JTextField getTextField_Type() {
		return textField_Type;
	}

	/**
	 * Gets the text field_ password.
	 *
	 * @return the text field_ password
	 */
	public JTextField getTextField_Password() {
		return textField_Password;
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
