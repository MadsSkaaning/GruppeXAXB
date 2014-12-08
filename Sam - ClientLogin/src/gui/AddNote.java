package gui;

//importerer.
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.UIManager;

import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.JCheckBox;


//Klassen extender JPanel.
public class AddNote extends JPanel {

	// Klassens variabler instantieres.
	private JTextField txtEventid;
	private JLabel createnote;
	private JButton btnLogOut;
	private JButton btnHome;
	private JLabel baggrund;
	private JButton btnCreate;
	private JTextField txtdatetime;
	private JTextField txtnote;
	private JTextField txtCreatedby;



	// Konstruktoer.
	public AddNote() {
		setLayout(null);
		setBounds(0,0,1024,768);


		btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setBounds(6, 72, 119, 45);
		add(btnLogOut);

		txtEventid = new JTextField();
		txtEventid.setHorizontalAlignment(SwingConstants.CENTER);
		txtEventid.setText("Enter Eventid");
		txtEventid.setToolTipText("Enter Eventname");
		txtEventid.setBounds(320, 252, 383, 50);
		txtEventid.setColumns(10);
		add(txtEventid);

		txtCreatedby = new JTextField();
		txtCreatedby.setToolTipText("");
		txtCreatedby.setText("User or Admin?");
		txtCreatedby.setHorizontalAlignment(SwingConstants.CENTER);
		txtCreatedby.setColumns(10);
		txtCreatedby.setBounds(320, 314, 383, 50);
		add(txtCreatedby);

		txtdatetime = new JTextField();
		txtdatetime.setToolTipText("");
		txtdatetime.setText("Enter datetime:  ex. 2014-12-12 10:13:37");
		txtdatetime.setHorizontalAlignment(SwingConstants.CENTER);
		txtdatetime.setColumns(10);
		txtdatetime.setBounds(320, 379, 383, 50);
		add(txtdatetime);

		txtnote = new JTextField();
		txtnote.setToolTipText("");
		txtnote.setText("Enter your note:");
		txtnote.setHorizontalAlignment(SwingConstants.CENTER);
		txtnote.setColumns(10);
		txtnote.setBounds(320, 441, 383, 232);
		add(txtnote);


		createnote = new JLabel("Create Note");
		createnote.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 30));
		createnote.setHorizontalAlignment(SwingConstants.CENTER);
		createnote.setBounds(337, 175, 350, 65);
		add(createnote);


		//adding a btn to refer to home
		btnHome = new JButton("Home");
		btnHome.setBounds(26, 6, 64, 65);
		btnHome.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/home-button.png")));
		add(btnHome);


		btnCreate = new JButton("CREATE");
		btnCreate.setBounds(820, 282, 157, 186);
		add(btnCreate);


		baggrund = new JLabel("");
		baggrund.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/sam-bg.png")));
		baggrund.setBounds(0, 0, 1024, 768);
		add(baggrund);

	}

	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnHome.addActionListener(l);
		btnCreate.addActionListener(l);


	}
	public JButton getbtnLogOut() {
		return btnLogOut;
	}

	public JButton getbtnHome() {
		return btnHome;

	}
	public JButton getbtnCreate() {
		return btnCreate;
	}


	public JTextField getTxtEventid() {
		return txtEventid;
	}


	public JTextField getTxtdatetime() {
		return txtdatetime;
	}

	public JTextField getTxtnote() {
		return txtnote;
	}

	public JTextField getTxtCreatedby() {
		return txtCreatedby;
	}




}
