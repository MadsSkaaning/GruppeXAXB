/*
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.User;
import logic.UpdateUserLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileScreen.
 */
public class ProfileScreen extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The profile panel. */
	JPanel profilePanel;

	/** The lbl grafik. */
	private JLabel lblGrafik;

	/** The btn save. */
	private JButton btnSave;

	/** The User profile panel. */
	private JPanel UserProfilePanel;

	/** The lbl background. */
	private JLabel lblBackground;

	/** The btn home. */
	private JButton btnHome;

	/** The screen. */
	private CustomerScreen screen;

	/** The screenchanger. */
	Eventhandler screenchanger;

	/** The label id mail. */
	private JLabel labelIDMail;

	/** The ID mailtext field. */
	private JTextField IDMailtextField;

	/** The First nametext field. */
	private JTextField FirstNametextField;

	/** The label first name. */
	private JLabel labelFirstName;

	/** The label last name. */
	private JLabel labelLastName;

	/** The Last nametext field. */
	private JTextField LastNametextField;

	/** The Adresstext field. */
	private JTextField AdresstextField;

	/** The label adress. */
	private JLabel labelAdress;

	/** The label zip. */
	private JLabel labelZip;

	/** The ziptext field. */
	private JTextField ziptextField;

	/** The agetext field. */
	private JTextField agetextField;

	/** The label age. */
	private JLabel labelAge;

	/** The label phone. */
	private JLabel labelPhone;

	/** The phonetext field. */
	private JTextField phonetextField;

	/** The BTC balancetext field. */
	public JTextField BTCBalancetextField;

	/** The label btc balance. */
	private JLabel labelBTCBalance;

	/** The label password. */
	private JLabel labelPassword;

	/** The passwordtext field. */
	private JTextField passwordtextField;

	/** The is admin check box. */
	private JCheckBox isAdminCheckBox;

	/**
	 * Instantiates a new profile screen.
	 *
	 * @param screen the screen
	 */
	public ProfileScreen(CustomerScreen screen) {
		this.screen = screen;

		profilePanel = new JPanel();
		profilePanel.setBounds(0, 0, 1024, 768);
		profilePanel.setLayout(null);

		UserProfilePanel = new JPanel();
		UserProfilePanel.setBounds(308, 143, 388, 470);
		profilePanel.add(UserProfilePanel);
		UserProfilePanel.setLayout(null);

		lblGrafik = new JLabel("New label");
		lblGrafik.setBounds(120, 11, 151, 43);
		UserProfilePanel.add(lblGrafik);
		lblGrafik.setIcon(new ImageIcon(ProfileScreen.class.getResource("/shared/img/profile.png")));

		btnSave = new JButton("Insert New Entry");
		btnSave.setBounds(230, 415, 100, 27);
		UserProfilePanel.add(btnSave);
		btnSave.setIcon(new ImageIcon(ProfileScreen.class.getResource("/shared/img/save.png")));

		labelIDMail = new JLabel();
		labelIDMail.setText("ID Mail:");
		labelIDMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelIDMail.setBounds(71, 77, 146, 20);
		UserProfilePanel.add(labelIDMail);

		IDMailtextField = new JTextField(10);
		IDMailtextField.setBounds(227, 77, 103, 20);

		IDMailtextField.setText("" + User.currentUser.getIDMail());
		IDMailtextField.setEditable(true);
		IDMailtextField.setEditable(false);
		UserProfilePanel.add(IDMailtextField);

		FirstNametextField = new JTextField(10);
		FirstNametextField.setBounds(227, 101, 103, 20);
		FirstNametextField.setText("" + User.currentUser.getfirstName());
		FirstNametextField.setEditable(false);
		UserProfilePanel.add(FirstNametextField);

		labelFirstName = new JLabel();
		labelFirstName.setText("First Name:");
		labelFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelFirstName.setBounds(71, 101, 146, 20);
		UserProfilePanel.add(labelFirstName);

		labelLastName = new JLabel();
		labelLastName.setText("Last Name:");
		labelLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelLastName.setBounds(71, 125, 146, 20);
		UserProfilePanel.add(labelLastName);

		LastNametextField = new JTextField(10);
		LastNametextField.setBounds(227, 125, 103, 20);
		LastNametextField.setText("" + User.currentUser.getLastName());
		LastNametextField.setEditable(false);
		UserProfilePanel.add(LastNametextField);

		AdresstextField = new JTextField(10);
		AdresstextField.setBounds(227, 154, 103, 20);
		AdresstextField.setText("" + User.currentUser.getuserAdress());
		UserProfilePanel.add(AdresstextField);

		labelAdress = new JLabel();
		labelAdress.setText("Adress:");
		labelAdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAdress.setBounds(71, 154, 146, 20);
		UserProfilePanel.add(labelAdress);

		labelZip = new JLabel();
		labelZip.setText("Zip code:");
		labelZip.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelZip.setBounds(71, 181, 146, 20);
		UserProfilePanel.add(labelZip);

		ziptextField = new JTextField(10);
		ziptextField.setBounds(227, 181, 103, 20);
		ziptextField.setText("" + User.currentUser.getzipCode());
		UserProfilePanel.add(ziptextField);

		agetextField = new JTextField(10);
		agetextField.setBounds(227, 209, 103, 20);
		agetextField.setText("" + User.currentUser.getuserAge());
		UserProfilePanel.add(agetextField);

		labelAge = new JLabel();
		labelAge.setText("Age: ");
		labelAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAge.setBounds(71, 209, 146, 20);
		UserProfilePanel.add(labelAge);

		labelPhone = new JLabel();
		labelPhone.setText("Phone Number:");
		labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPhone.setBounds(71, 240, 146, 20);
		UserProfilePanel.add(labelPhone);

		phonetextField = new JTextField(10);
		phonetextField.setBounds(227, 240, 103, 20);
		phonetextField.setText("" + User.currentUser.getuserPhone());
		UserProfilePanel.add(phonetextField);

		BTCBalancetextField = new JTextField(10);
		BTCBalancetextField.setBounds(227, 270, 103, 20);
		BTCBalancetextField.setText("" + User.currentUser.getuserBTCBalance());
		BTCBalancetextField.setEditable(false);
		UserProfilePanel.add(BTCBalancetextField);

		labelBTCBalance = new JLabel();
		labelBTCBalance.setText("BTC Balance:");
		labelBTCBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelBTCBalance.setBounds(71, 270, 146, 20);
		UserProfilePanel.add(labelBTCBalance);

		labelPassword = new JLabel();
		labelPassword.setText("Password:");
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPassword.setBounds(71, 294, 146, 20);
		UserProfilePanel.add(labelPassword);

		passwordtextField = new JPasswordField(10);
		passwordtextField.setBounds(227, 294, 103, 20);
		passwordtextField.setText("" + User.currentUser.getPassword());
		UserProfilePanel.add(passwordtextField);

		isAdminCheckBox = new JCheckBox("");
		isAdminCheckBox.setBounds(6, 447, 97, 23);
		isAdminCheckBox.setVisible(false);
		UserProfilePanel.add(isAdminCheckBox);
		
				btnHome = new JButton("");
				btnHome.setIcon(new ImageIcon(ProfileScreen.class.getResource("/shared/img/home-button.png")));
				btnHome.setBounds(0, 0, 64, 64);
				profilePanel.add(btnHome);
				btnHome.addActionListener(new Eventhandler());

		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ProfileScreen.class.getResource("/shared/img/mainframe-bg2.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		profilePanel.add(lblBackground);

		btnSave.addActionListener(new UpdateUserLogic(this));

	}



	// show message
	/**
	 * Show mesage.
	 *
	 * @param title the title
	 * @param mes the mes
	 */
	public void showMesage(String title, String mes) {
		JOptionPane.showMessageDialog( this, mes,
				title, JOptionPane.PLAIN_MESSAGE );
	}


	/**
	 * Gets the ID mailtext field.
	 *
	 * @return the ID mailtext field
	 */
	public String getIDMailtextField() {
		return IDMailtextField.getText();
	}

	/**
	 * Sets the id mail textfield.
	 *
	 * @param val the new id mail textfield
	 */
	public void setIdMailTextfield(String val) {
		IDMailtextField.setText(val);
	}

	/**
	 * Gets the first name text field.
	 *
	 * @return the first name text field
	 */
	public String getFirstNameTextField() {
		return FirstNametextField.getText();
	}

	/**
	 * Sets the first name text field.
	 *
	 * @param val the new first name text field
	 */
	public void setFirstNameTextField(String val) {
		FirstNametextField.setText(val);
	}

	/**
	 * Gets the last name text field.
	 *
	 * @return the last name text field
	 */
	public String getLastNameTextField() {
		return LastNametextField.getText();
	}

	/**
	 * Sets the last name text field.
	 *
	 * @param val the new last name text field
	 */
	public void setLastNameTextField(String val) {
		LastNametextField.setText(val);
	}

	/**
	 * Gets the adress text field.
	 *
	 * @return the adress text field
	 */
	public String getAdressTextField() {
		return AdresstextField.getText();
	}

	/**
	 * Sets the adress text field.
	 *
	 * @param val the new adress text field
	 */
	public void setAdressTextField(String val) {
		AdresstextField.setText(val);
	}

	/**
	 * Gets the zip text field.
	 *
	 * @return the zip text field
	 */
	public String getzipTextField() {
		return ziptextField.getText();
	}

	/**
	 * Sets the zip text field.
	 *
	 * @param val the new zip text field
	 */
	public void setzipTextField(String val) {
		ziptextField.setText(val);

	}

	/**
	 * Gets the age text field.
	 *
	 * @return the age text field
	 */
	public String getageTextField() {
		return agetextField.getText();
	}

	/**
	 * Sets the age text field.
	 *
	 * @param val the new age text field
	 */
	public void setageTextField(String val) {
		agetextField.setText(val);
	}

	/**
	 * Gets the phone text field.
	 *
	 * @return the phone text field
	 */
	public String getphoneTextField() {
		return phonetextField.getText();
	}

	/**
	 * Sets the phone text field.
	 *
	 * @param val the new phone text field
	 */
	public void setphoneTextField(String val) {
		phonetextField.setText(val);
	}

	/**
	 * Gets the btc text field.
	 *
	 * @return the btc text field
	 */
	public String getbtcTextField() {
		return BTCBalancetextField.getText();
	}

	/**
	 * Sets the btc text field.
	 *
	 * @param val the new btc text field
	 */
	public void setbtcTextField(String val) {
		BTCBalancetextField.setText(val);
	}

	/**
	 * Gets the pass text field.
	 *
	 * @return the pass text field
	 */
	public String getpassTextField() {
		return passwordtextField.getText();
	}

	/**
	 * Sets the pass text field.
	 *
	 * @param val the new pass text field
	 */
	public void setpassTextField(String val) {
		passwordtextField.setText(val);
	}

	/**
	 * Gets the checks if is admintext field.
	 *
	 * @return the checks if is admintext field
	 */
	public Boolean getisAdmintextField() {
		return isAdminCheckBox.isSelected();
	}

	/**
	 * Sets the checks if is admin checkbox.
	 *
	 * @param val the new checks if is admin checkbox
	 */
	public void setisAdminCheckbox(String val) {
		isAdminCheckBox.setText(val);
	}




	/**
	 * The Class Eventhandler.
	 */
	public class Eventhandler implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {

			//CustomerScreen screen = new CustomerScreen();

			screen.changecards.show(screen.contentPane,"menuPanel");

		}


	}
}
