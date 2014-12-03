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

public class Profile extends JPanel {

	private JButton btnHome;
	private JLabel lblLoggedin;
	private JLabel labelUser;
	private JLabel lblProfile;
	
	/**
	 * Create the panel.
	 */
	public Profile() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);

		
		lblLoggedin = new JLabel("Logged in as:");
		lblLoggedin.setBounds(846, 49, 98, 16);
		add(lblLoggedin);
		
		labelUser = new JLabel("");
		labelUser.setBounds(846, 70, 132, 29);
		add(labelUser);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setFont(new Font("Arial", Font.BOLD, 78));
		lblProfile.setBounds(328, 132, 368, 90);
		add(lblProfile);
				
		btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(Calendar.class.getResource("/img/home-button.png")));
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(0, 0, 96, 76);
		add(btnHome);
				
		JLabel lblBackground = new JLabel("");
		lblBackground.setSize(new Dimension(1366, 768));
		lblBackground.setIcon(new ImageIcon(Profile.class.getResource("/img/philip-bg.png")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);
	}
	
	public void addActionListener(ActionListener l) {
		btnHome.addActionListener(l);
	}

	public JButton getBtnHome() {
		return btnHome;
	}
	
}