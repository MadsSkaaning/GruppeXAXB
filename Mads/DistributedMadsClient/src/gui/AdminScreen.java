/*
 * 
 */
package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.DatabaseConnect;
import database.User;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminScreen.
 */
public class AdminScreen extends JFrame {

	/** The lbl background. */
	private JLabel lblBackground;

	/** The changecards. */
	CardLayout changecards = new CardLayout();

	/** The content pane. */
	JPanel contentPane;

	/** The lbl logo. */
	private JLabel lblLogo;

	/** The btn add userss. */
	private JButton btnAddUserss;

	/** The btn view users. */
	private JButton btnViewUsers;

	/** The btn edit user. */
	private JButton btnEditUser;

	/** The btn logout. */
	private JButton btnLogout;

	/** The btn exit. */
	private JButton btnExit;

	/** The Admin panel. */
	private JPanel AdminPanel;


	/** The logout. */
	private LoginScreen logout;

	/** The view user. */
	private AdminViewUserScreen viewUser;

	/** The edit user. */
	private AdminEditUserScreen editUser;

	/** The add userr. */
	private AdminAddUser addUserr;

	/** The lbl welcome. */
	private JLabel lblWelcome;

	/** The lbl id. */
	private JLabel lblID;

	/** The lbl you are logged. */
	private JLabel lblYouAreLogged;

	/** The closeconnection. */
	private DatabaseConnect closeconnection;


	/**
	 * Create the panel.
	 */

	public void run() {
		try {
			AdminScreen frame = new AdminScreen();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Instantiates a new admin screen.
	 */
	public AdminScreen() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {

				closeconnection.close();


			}
		});
		viewUser = new AdminViewUserScreen(this);
		editUser = new AdminEditUserScreen(this);
		addUserr = new AdminAddUser(this);

		setBounds(100, 100, 480, 640);
		setResizable(false);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(changecards);

		AdminPanel = new JPanel();
		AdminPanel.setBounds(128, 168, 252, 393);

		contentPane.add(AdminPanel, "AdminPanel");
		contentPane.add(viewUser.viewUserPanel, "viewUser");
		contentPane.add(editUser.editUserPanel, "editUser");
		contentPane.add(addUserr.displayPanel, "addUserr");

		AdminPanel.setVisible(true);
		AdminPanel.setLayout(null);

		btnAddUserss = new JButton("");
		btnAddUserss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changecards.show(getContentPane(), "addUserr");
			}

		});
		btnAddUserss.setIcon(new ImageIcon(AdminScreen.class.getResource("/shared/img/add_user.png")));
		btnAddUserss.setBounds(163, 178, 153, 41);
		AdminPanel.add(btnAddUserss);


		btnViewUsers = new JButton("");
		btnViewUsers.setIcon(new ImageIcon(AdminScreen.class.getResource("/shared/img/view_user.png")));
		btnViewUsers.setBounds(163, 230, 153, 41);
		AdminPanel.add(btnViewUsers);

		btnViewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				changecards.show(getContentPane(), "viewUser");


			}
		});

		btnEditUser = new JButton("");
		btnEditUser.setIcon(new ImageIcon(AdminScreen.class.getResource("/shared/img/edit_user.png")));
		btnEditUser.setBounds(163, 282, 153, 41);
		AdminPanel.add(btnEditUser);

		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				changecards.show(getContentPane(),"editUser");

			}
		});


		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(AdminScreen.class.getResource("/shared/img/Logout.png")));
		btnLogout.setBounds(163, 390, 153, 41);
		AdminPanel.add(btnLogout);


		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == btnLogout){

					logout = new LoginScreen();
					setVisible(false);
					logout.run();

				}
			}
		});


		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(AdminScreen.class.getResource("/shared/img/exit.png")));
		btnExit.setBounds(163, 442, 153, 41);
		AdminPanel.add(btnExit);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == btnExit){

					closeconnection.close();
					dispose();

				}

			}
		});

		lblLogo = new JLabel("");
		AdminPanel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(AdminScreen.class.getResource("/shared/img/BCBS.png")));
		lblLogo.setBounds(107, 30, 252, 66);

		lblBackground = new JLabel("");
		AdminPanel.add(lblBackground);
		lblBackground.setBounds(0, -75, 793, 768);
		lblBackground.setIcon(new ImageIcon(AdminScreen.class.getResource("/shared/img/CBS baggrund_20.png")));

		lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setBounds(162, 101, 61, 14);
		AdminPanel.add(lblWelcome);

		lblID = new JLabel();
		lblID.setText(User.currentUser.getfirstName() + " " + User.currentUser.getLastName());
		lblID.setBounds(221, 101, 138, 14);
		AdminPanel.add(lblID);

		lblYouAreLogged = new JLabel("You are logged in as: Admin");
		lblYouAreLogged.setText("Your ID is:  " + User.currentUser.getIDMail());
		lblYouAreLogged.setBounds(162, 84, 283, 14);
		AdminPanel.add(lblYouAreLogged);

	}


}
