package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login extends JPanel {
	
	/** The lbl welcome. */
	private final JLabel lblWelcome = new JLabel("Welcome");
	
	/** The lbl username. */
	private final JLabel lblUsername = new JLabel("Username");
	
	/** The lbl password. */
	private final JLabel lblPassword = new JLabel("Password");
	
	/** The btn log in. */
	private final JButton btnLogIn = new JButton("");
	
	/** The btn forgot log in. */
	private final JButton btnForgotLogIn = new JButton("Enter username and password.");
	
	/** The text field username. */
	private final JTextField textFieldUsername = new JTextField();
	
	/** The lbl background. */
	private final JLabel lblBackground = new JLabel("");
	
	/** The text field password. */
	private final JPasswordField textFieldPassword = new JPasswordField();
	


	/**
	 * Create the panel.
	 */
	public Login() {
		setSize(new Dimension(1024, 768));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(105, 105, 105));
		setLayout(null);
		lblWelcome.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 78));
		lblWelcome.setBounds(358, 136, 346, 107);
		
		add(lblWelcome);
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Arial", Font.BOLD, 26));
		lblUsername.setBounds(347, 334, 125, 30);
		
		add(lblUsername);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 26));
		lblPassword.setBounds(347, 377, 123, 30);
		
		add(lblPassword);
		btnLogIn.setIcon(new ImageIcon(Login.class.getResource("/Images/Login-Button.png")));
		btnLogIn.setContentAreaFilled(false);
		btnLogIn.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBackground(Color.WHITE);
		btnLogIn.setBorder(null);

		textFieldUsername.setOpaque(false);
		textFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsername.setForeground(Color.BLACK);
		textFieldUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldUsername.setColumns(10);
		textFieldUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255)));
		textFieldUsername.setBounds(553, 333, 164, 37);
		
		add(textFieldUsername);
		btnLogIn.setBounds(551, 444, 153, 41);
		
		add(btnLogIn);
		btnForgotLogIn.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnForgotLogIn.setBorder(BorderFactory.createLineBorder(Color.black));
		btnForgotLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showInputDialog("Bad Luck!");
			}
		});
		btnForgotLogIn.setContentAreaFilled(false);
		btnForgotLogIn.setForeground(new Color(255, 255, 255));
		btnForgotLogIn.setBorderPainted(false);
		btnForgotLogIn.setBounds(315, 244, 403, 41);
		
		add(btnForgotLogIn);
		
		setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldPassword.setOpaque(false);
		textFieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255)));
		textFieldPassword.setBounds(553, 371, 164, 37);
		
		add(textFieldPassword);
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setSize(new Dimension(1024, 768));
		lblBackground.setBounds(0, 0, 1024, 768);
		
		add(lblBackground);

	}
	
	/**
	 * Adds the action listener.
	 *
	 * @param l the l
	 */
	public void addActionListener(ActionListener l) {
		btnLogIn.addActionListener(l);
		btnForgotLogIn.addActionListener(l);
}
	

	/**
	 * Gets the text field.
	 *
	 * @return the text field
	 */
	public JTextField getTextField() {
		return textFieldUsername;
	}


	/**
	 * Gets the btn log in.
	 *
	 * @return the btn log in
	 */
	public JButton getBtnLogIn() {
				
		return btnLogIn;
	}

	/**
	 * Gets the btn forgot log in.
	 *
	 * @return the btn forgot log in
	 */
	public JButton getBtnForgotLogIn() {
		return btnForgotLogIn;
	}


	/**
	 * Gets the text field username.
	 *
	 * @return the text field username
	 */
	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	/**
	 * Gets the text field password.
	 *
	 * @return the text field password
	 */
	public JPasswordField getTextFieldPassword() {
		return textFieldPassword;
	}

	

	}