/*
 * 
 */
package gui;

// Fig. 28.32: AdminAddUser.java
// A simple address book
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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import logic.AddUserLogic;


// TODO: Auto-generated Javadoc
/**
 * The Class AdminAddUser.
 */
public class AdminAddUser extends JPanel
{

	/** The btcl label. */
	private JLabel btclLabel;

	/** The btc text field. */
	public JTextField btcTextField;

	/** The first name label. */
	private JLabel firstNameLabel;

	/** The first name text field. */
	public JTextField firstNameTextField;

	/** The id label. */
	private JLabel idLabel;

	/** The id text field. */
	public JTextField idTextField;

	/** The last name label. */
	private JLabel lastNameLabel;

	/** The last name text field. */
	public JTextField lastNameTextField;

	/** The phone label. */
	private JLabel phoneLabel;

	/** The phone text field. */
	public JTextField phoneTextField;

	/** The display panel. */
	JPanel displayPanel;

	/** The insert button. */
	private JButton insertButton;

	/** The label adress. */
	private JLabel labelAdress;

	/** The adresstext field. */
	public JTextField adresstextField;

	/** The ziplabel. */
	private JLabel ziplabel;

	/** The ziptext field. */
	public JTextField ziptextField;

	/** The agelabel. */
	private JLabel agelabel;

	/** The agetext field. */
	public JTextField agetextField;

	/** The passlabel. */
	private JLabel passlabel;

	/** The passtext field. */
	public JTextField passtextField;

	/** The lbl new label. */
	private JLabel lblNewLabel;

	/** The lbllogo. */
	private JLabel lbllogo;

	/** The btn home. */
	private JButton btnHome;

	/** The screenchanger. */
	Eventhandler screenchanger;

	/** The add userr panel. */
	JPanel addUserrPanel;

	/** The Admin add user panel. */
	private JPanel AdminAddUserPanel;

	/** The screen. */
	public AdminScreen screen;

	/** The label. */
	private JLabel label;

	/** The lbl is admin. */
	private JLabel lblIsAdmin;

	/** The is admin check box. */
	private JCheckBox isAdminCheckBox;

	// no-argument constructor
	/**
	 * Instantiates a new admin add user.
	 *
	 * @param screen the screen
	 */
	public AdminAddUser(AdminScreen screen) {
		this.screen = screen;

		addUserrPanel = new JPanel();
		addUserrPanel.setBounds(0, 0, 480, 620);
		addUserrPanel.setLayout(null);

		setBounds(0 ,0, 480, 640);
		displayPanel = new JPanel();
		displayPanel.setBounds(50, 106, 480, 620);
		displayPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		idLabel = new JLabel();
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idLabel.setBounds(67, 72, 146, 20);
		idTextField = new JTextField( 10 );
		idTextField.setBounds(223, 72, 103, 20);
		firstNameLabel = new JLabel();
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstNameLabel.setBounds(67, 96, 146, 20);
		firstNameTextField = new JTextField( 10 );
		firstNameTextField.setBounds(223, 96, 103, 20);
		lastNameLabel = new JLabel();
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastNameLabel.setBounds(67, 120, 146, 20);
		lastNameTextField = new JTextField( 10 );
		lastNameTextField.setBounds(223, 120, 103, 20);
		btclLabel = new JLabel();
		btclLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btclLabel.setBounds(67, 265, 146, 20);
		btcTextField = new JTextField( 10 );
		btcTextField.setBounds(223, 265, 103, 20);
		phoneLabel = new JLabel();
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneLabel.setBounds(67, 235, 146, 20);
		phoneTextField = new JTextField( 10 );
		phoneTextField.setBounds(223, 235, 103, 20);
		//  getContentPane().setLayout(null);
		displayPanel.setLayout(null);



		AdminAddUserPanel = new JPanel();
		AdminAddUserPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		AdminAddUserPanel.setBounds(50, 106, 388, 470);
		displayPanel.add(AdminAddUserPanel);
		AdminAddUserPanel.setLayout(null);



		idLabel.setText( "ID Mail:" );
		AdminAddUserPanel.add( idLabel );
		AdminAddUserPanel.add( idTextField );

		firstNameLabel.setText( "First Name:" );
		AdminAddUserPanel.add( firstNameLabel );
		AdminAddUserPanel.add( firstNameTextField );

		lastNameLabel.setText( "Last Name:" );
		AdminAddUserPanel.add( lastNameLabel );
		AdminAddUserPanel.add( lastNameTextField );

		btclLabel.setText( "BTC Balance:" );
		AdminAddUserPanel.add( btclLabel );
		AdminAddUserPanel.add( btcTextField );

		phoneLabel.setText( "Phone Number:" );
		AdminAddUserPanel.add( phoneLabel );
		AdminAddUserPanel.add( phoneTextField );
		//getContentPane().add( AdminAddUserPanel );

		labelAdress = new JLabel();
		labelAdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAdress.setText("Adress:");
		labelAdress.setBounds(67, 149, 146, 20);
		AdminAddUserPanel.add(labelAdress);

		adresstextField = new JTextField(10);
		adresstextField.setBounds(223, 149, 103, 20);
		AdminAddUserPanel.add(adresstextField);

		ziplabel = new JLabel();
		ziplabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ziplabel.setText("Zip code:");
		ziplabel.setBounds(67, 176, 146, 20);
		AdminAddUserPanel.add(ziplabel);

		ziptextField = new JTextField(10);
		ziptextField.setBounds(223, 176, 103, 20);
		AdminAddUserPanel.add(ziptextField);

		agelabel = new JLabel();
		agelabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		agelabel.setText("Age: ");
		agelabel.setBounds(67, 204, 146, 20);
		AdminAddUserPanel.add(agelabel);

		agetextField = new JTextField(10);
		agetextField.setBounds(223, 204, 103, 20);
		AdminAddUserPanel.add(agetextField);

		passlabel = new JLabel();
		passlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passlabel.setText("Password:");
		passlabel.setBounds(67, 289, 146, 20);
		AdminAddUserPanel.add(passlabel);

		passtextField = new JTextField(10);
		passtextField.setBounds(223, 289, 103, 20);
		AdminAddUserPanel.add(passtextField);
		insertButton = new JButton();
		insertButton.addActionListener(new AddUserLogic(this));
		insertButton.setBounds(211, 339, 115, 23);
		AdminAddUserPanel.add(insertButton);

		insertButton.setText( "Insert New Entry" );

		label = new JLabel("");
		label.setIcon(new ImageIcon(AdminAddUser.class.getResource("/shared/img/add_user.png")));
		label.setBounds(107, 8, 151, 43);
		AdminAddUserPanel.add(label);

		lblIsAdmin = new JLabel();
		lblIsAdmin.setText("is Admin?");
		lblIsAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIsAdmin.setBounds(66, 318, 146, 20);
		AdminAddUserPanel.add(lblIsAdmin);

		isAdminCheckBox = new JCheckBox("New check box");
		isAdminCheckBox.setBounds(221, 315, 97, 23);
		AdminAddUserPanel.add(isAdminCheckBox);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Mads\\Dropbox\\Gruppearbejde\\BCBS v2.0\\Grafik\\CBS baggrund_20.png"));
		lblNewLabel.setBounds(0, 0, 480, 640);
		//getContentPane().add(lblNewLabel);

		lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon("C:\\Users\\Mads\\Dropbox\\Gruppearbejde\\BCBS v2.0\\Grafik\\BCBS.png"));
		lbllogo.setBounds(115, 22, 250, 48);
		//getContentPane().add(lbllogo);




		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AdminViewUserScreen.class.getResource("/shared/img/BCBS.png")));
		lblLogo.setBounds(118, 34, 250, 48);
		displayPanel.add(lblLogo);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(AdminViewUserScreen.class.getResource("/shared/img/CBS baggrund_20.png")));
		lblBackground.setBounds(0, 0, 480, 640);
		displayPanel.add(lblBackground);


		btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(AdminViewUserScreen.class.getResource("/shared/img/home-button.png")));
		btnHome.setBounds(0, 0, 64, 64);
		displayPanel.add(btnHome);
		btnHome.addActionListener(new Eventhandler());
		setVisible( true );
	}

	// inject actionlistener





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
	 * Gets the id text field.
	 *
	 * @return the id text field
	 */
	public String getIdTextField() {
		return idTextField.getText();
	}

	/**
	 * Sets the id text field.
	 *
	 * @param val the new id text field
	 */
	public void setIdTextField(String val) {
		idTextField.setText(val);
	}

	/**
	 * Gets the first name text field.
	 *
	 * @return the first name text field
	 */
	public String getFirstNameTextField() {
		return firstNameTextField.getText();
	}

	/**
	 * Sets the first name text field.
	 *
	 * @param val the new first name text field
	 */
	public void setFirstNameTextField(String val) {
		firstNameTextField.setText(val);
	}

	/**
	 * Gets the last name text field.
	 *
	 * @return the last name text field
	 */
	public String getLastNameTextField() {
		return lastNameTextField.getText();
	}

	/**
	 * Sets the last name text field.
	 *
	 * @param val the new last name text field
	 */
	public void setLastNameTextField(String val) {
		lastNameTextField.setText(val);
	}

	/**
	 * Gets the adress text field.
	 *
	 * @return the adress text field
	 */
	public String getAdressTextField() {
		return adresstextField.getText();
	}

	/**
	 * Sets the adress text field.
	 *
	 * @param val the new adress text field
	 */
	public void setAdressTextField(String val) {
		adresstextField.setText(val);
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
		return phoneTextField.getText();
	}

	/**
	 * Sets the phone text field.
	 *
	 * @param val the new phone text field
	 */
	public void setphoneTextField(String val) {
		phoneTextField.setText(val);
	}

	/**
	 * Gets the btc text field.
	 *
	 * @return the btc text field
	 */
	public String getbtcTextField() {
		return btcTextField.getText();
	}

	/**
	 * Sets the btc text field.
	 *
	 * @param val the new btc text field
	 */
	public void setbtcTextField(String val) {
		btcTextField.setText(val);
	}

	/**
	 * Gets the pass text field.
	 *
	 * @return the pass text field
	 */
	public String getpassTextField() {
		return passtextField.getText();
	}

	/**
	 * Sets the pass text field.
	 *
	 * @param val the new pass text field
	 */
	public void setpassTextField(String val) {
		passtextField.setText(val);
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

			screen.changecards.show(screen.contentPane,"AdminPanel");
		}

	}
}// end class AdminAddUser



