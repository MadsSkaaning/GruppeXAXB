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
/**
 * @author Sam
 *
 */
public class AddCalendar extends JPanel {

	// Klassens variabler instantieres.
	private JTextField txtcalendarname;
	private JLabel addcalendar;
	private JButton btnLogOut;
	private JButton btnHome;
	private JLabel baggrund;
	private JButton btnCreate;
	private JTextField txtcreatedby;



	// Konstruktoer.
	public AddCalendar() {
		setLayout(null);
		setBounds(0,0,1024,768);


		btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setBounds(6, 72, 119, 45);
		add(btnLogOut);

		txtcalendarname = new JTextField();
		txtcalendarname.setHorizontalAlignment(SwingConstants.CENTER);
		txtcalendarname.setText("Enter Calendarname");
		txtcalendarname.setToolTipText("");
		txtcalendarname.setBounds(320, 283, 383, 50);
		txtcalendarname.setColumns(10);
		add(txtcalendarname);

		txtcreatedby = new JTextField();
		txtcreatedby.setToolTipText("");
		txtcreatedby.setText("Enter createdby (user or admin)");
		txtcreatedby.setHorizontalAlignment(SwingConstants.CENTER);
		txtcreatedby.setColumns(10);
		txtcreatedby.setBounds(320, 345, 383, 50);
		add(txtcreatedby);


		addcalendar = new JLabel("CreateCalendar");
		addcalendar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 30));
		addcalendar.setHorizontalAlignment(SwingConstants.CENTER);
		addcalendar.setBounds(337, 175, 350, 65);
		add(addcalendar);


		//adding a btn to refer to home
		btnHome = new JButton("Home");
		btnHome.setBounds(26, 6, 64, 65);
		btnHome.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/home-button.png")));
		add(btnHome);


		btnCreate = new JButton("CREATE");
		btnCreate.setBounds(433, 442, 157, 90);
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

	public JTextField getTxtcalendarname() {
		return txtcalendarname;
	}

	public JTextField getTxtcreatedby() {
		return txtcreatedby;
	}


}
