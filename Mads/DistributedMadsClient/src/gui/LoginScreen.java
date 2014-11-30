/*
 * 
 */
package gui;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.DatabaseConnect;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import logic.LoginVerificationLogic;


// TODO: Auto-generated Javadoc
/**
 * The Class LoginScreen.
 */
public class LoginScreen extends JFrame {


	/** The connecter. */
	DatabaseConnect connecter = new DatabaseConnect();



	/** The content pane. */
	private JPanel contentPane;

	/** The password field. */
	public JPasswordField passwordField;

	/** The txt enter cbs email. */
	public JTextField txtEnterCbsEmail;

	/** The lbl welcome to bcbs. */
	private JLabel lblWelcomeToCalendar;

	/** The btn log me in. */
	public JButton btnLogMeIn;

	/** The lbl please enter you. */
	private JLabel lblPleaseEnterYou;

	/** The lbl background. */
	private JLabel lblBackground;

	/**
	 * Run.
	 */
	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Instantiates a new login screen.
	 */
	public LoginScreen() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {

				connecter.close();
			}
		});


		setTitle("BitCoin - Copenhagen Business School 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 696);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter password");
		passwordField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		passwordField.setBounds(396, 392, 170, 30);
		contentPane.add(passwordField);


		txtEnterCbsEmail = new JTextField();
		txtEnterCbsEmail.setToolTipText("Your ID is the same as your CBS email.");
		txtEnterCbsEmail.setText("Enter ID");
		txtEnterCbsEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		txtEnterCbsEmail.setBounds(396, 336, 170, 30);

		// Use this to make select all text when clicking the Login name field
		txtEnterCbsEmail.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent fEvt) {
				JTextField tField = (JTextField)fEvt.getSource();
				tField.selectAll();
			}
		});



		contentPane.add(txtEnterCbsEmail);
		txtEnterCbsEmail.setColumns(10);

		lblWelcomeToCalendar = new JLabel("Welcome to CBS Calendar +");
		lblWelcomeToCalendar.setFont(new Font("Impact", Font.PLAIN, 28));
		lblWelcomeToCalendar.setBounds(334, 82, 342, 46);
		contentPane.add(lblWelcomeToCalendar);

		btnLogMeIn = new JButton("");
		btnLogMeIn.setIcon(new ImageIcon(LoginScreen.class.getResource("/shared/img/Login-Button.png")));

		btnLogMeIn.addActionListener(new LoginVerificationLogic(this));
		btnLogMeIn.setBounds(414, 450, 140, 30);
		contentPane.add(btnLogMeIn);

		lblPleaseEnterYou = new JLabel("Please enter you login info below!");
		lblPleaseEnterYou.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPleaseEnterYou.setBounds(371, 284, 227, 19);
		contentPane.add(lblPleaseEnterYou);
		
				lblBackground = new JLabel("New label");
				lblBackground.setIcon(new ImageIcon(LoginScreen.class.getResource("/shared/img/login-mainframe.jpg")));
				lblBackground.setBounds(0, 0, 1024, 768);
				contentPane.add(lblBackground);
	}
}
