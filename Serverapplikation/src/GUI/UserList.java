package GUI;


import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import model.QueryBuild.QueryBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class UserList.
 */
public class UserList extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The btn add. */
	private JButton btnAdd;

	/** The btn delete. */
	private JButton btnDelete;

	/** The btn logout. */
	private JButton btnLogout;

	/** The btn main menu. */
	private JButton btnMainMenu;

	/** The rs. */
	private ResultSet rs;

	/** The deleteuserpanel. */
	private JPanel deleteuserpanel;

	/** The lbl enter the calendar. */
	private JLabel lblEnterTheCalendar;

	/** The text field. */
	private JTextField textField;

	/** The btn cancel. */
	private JButton btnCancel;

	/** The btn final delete user. */
	private JButton btnFinalDeleteUser;

	/** The lbl active. */
	private JLabel lblActive;

	/** The enabledisabletext field. */
	private JTextField enabledisabletextField;

	/**
	 * Instantiates a new user list.
	 */
	@SuppressWarnings("null")
	public UserList() {
		setSize(new Dimension(1024, 768));

		String[] columnNames = {"UserID",
				"Email",
				"Active",
				"Created",
		"Password"};



		Object[][] data = new Object[getUserCount()][5];



		try {
			QueryBuilder qb = new QueryBuilder();
			rs = qb.selectFrom("users").all().ExecuteQuery();

			int count = 0;
			while (rs.next()) {

				data[count][0] = rs.getString("userid");
				data[count][1] = rs.getString("email");
				data[count][2] = rs.getString("active");
				data[count][3] = rs.getString("created");
				data[count][4] = rs.getString("password");


				count++;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}


		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);


		setLayout(null);

		//Create the scroll pane and add the table to it.
		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255, 255), new Color(0, 0, 205), new Color(255, 255, 255)), new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255, 255), new Color(0, 0, 205), new Color(255, 255, 255)), null));

		scrollPane.setBounds(96, 240, 693, 370);



		//Add the scroll pane to this panel.
		add(scrollPane);

		btnAdd = new JButton("Add");
		btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnAdd.setForeground(new Color(0, 0, 205));
		btnAdd.setOpaque(true);
		btnAdd.setBounds(856, 343, 118, 29);
		add(btnAdd);

		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(UserList.class.getResource("/Images/Logout.png")));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(null);
		btnLogout.setBounds(18, 68, 153, 41);
		add(btnLogout);

		btnMainMenu = new JButton("");
		btnMainMenu.setIcon(new ImageIcon(UserList.class.getResource("/Images/homebtn.png")));
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBorder(null);
		btnMainMenu.setBounds(18, 15, 153, 41);
		add(btnMainMenu);

		btnDelete = new JButton("Edit");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(new Color(0, 0, 205));
		btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnDelete.setBounds(856, 377, 118, 29);
		add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				deleteuserpanel.setVisible(true);
				scrollPane.setVisible(false);


			}
		});

		JLabel lblUserlist = new JLabel("Userlist");
		lblUserlist.setForeground(Color.WHITE);
		lblUserlist.setFont(new Font("Arial", Font.BOLD, 78));
		lblUserlist.setBounds(365, 138, 368, 90);
		add(lblUserlist);

		deleteuserpanel = new JPanel();
		deleteuserpanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		deleteuserpanel.setBounds(365, 250, 369, 359);
		add(deleteuserpanel);
		deleteuserpanel.setLayout(null);


		// Hiding the delete calendar panel unless btn delete is clicked
		deleteuserpanel.setVisible(false);

		lblEnterTheCalendar = new JLabel("Enter the ID of the user you want to edit.");
		lblEnterTheCalendar.setBounds(65, 52, 281, 44);
		deleteuserpanel.add(lblEnterTheCalendar);

		textField = new JTextField();
		textField.setBounds(110, 122, 140, 29);
		deleteuserpanel.add(textField);
		textField.setColumns(10);

		btnFinalDeleteUser = new JButton("Edit!");
		btnFinalDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				scrollPane.setVisible(true);
				deleteuserpanel.setVisible(false);

			}
		});
		btnFinalDeleteUser.setBounds(212, 227, 89, 23);
		deleteuserpanel.add(btnFinalDeleteUser);

		btnCancel = new JButton("Cancel");

		btnCancel.setBounds(66, 227, 89, 23);
		deleteuserpanel.add(btnCancel);

		lblActive = new JLabel("Active = 1, Inactive = 0");
		lblActive.setBounds(105, 162, 254, 14);
		deleteuserpanel.add(lblActive);

		enabledisabletextField = new JTextField();
		enabledisabletextField.setBounds(110, 187, 140, 20);
		deleteuserpanel.add(enabledisabletextField);
		enabledisabletextField.setColumns(10);

		JLabel lblBackground = new JLabel("Background");
		lblBackground.setIcon(new ImageIcon(UserList.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setBackground(new Color(245, 245, 245));
		lblBackground.setForeground(new Color(245, 255, 250));
		lblBackground.setOpaque(true);
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);



		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				deleteuserpanel.setVisible(false);
				scrollPane.setVisible(true);
			}
		});

	}




	/**
	 * Adds the action listener.
	 *
	 * @param l the l
	 */
	public void addActionListener(ActionListener l) {
		btnAdd.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnFinalDeleteUser.addActionListener(l);

	}

	/**
	 * Gets the btn add.
	 *
	 * @return the btn add
	 */
	public JButton getBtnAdd() {
		return btnAdd;
	}

	/**
	 * Gets the btn delete.
	 *
	 * @return the btn delete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
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
	 * Gets the text field.
	 *
	 * @return the text field
	 */
	public JTextField getTextField() {
		return textField;
	}




	/**
	 * Sets the text field.
	 *
	 * @param textField the new text field
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}




	/**
	 * Gets the btn final delete user.
	 *
	 * @return the btn final delete user
	 */
	public JButton getBtnFinalDeleteUser() {
		return btnFinalDeleteUser;
	}



	/**
	 * Gets the enabledisabletext field.
	 *
	 * @return the enabledisabletext field
	 */
	public JTextField getEnabledisabletextField() {
		return enabledisabletextField;
	}




	/**
	 * Gets the user count.
	 *
	 * @return the user count
	 */
	public int getUserCount(){

		int count = 0;

		QueryBuilder qb2 = new QueryBuilder();
		try {
			rs = qb2.selectFrom("users").all().ExecuteQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while(rs.next()){

				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count; 
	}

}