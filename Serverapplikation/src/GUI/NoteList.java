package GUI;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

import model.QueryBuild.QueryBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class NoteList.
 */
public class NoteList extends JPanel {

	/** The table. */
	private JTable table;

	/** The lbl background. */
	private final JLabel lblBackground = new JLabel("");

	/** The lbl header. */
	private JLabel lblHeader;

	/** The btn delete. */
	private JButton btnDelete;

	/** The btn main menu. */
	private JButton btnMainMenu;

	/** The btn logout. */
	private JButton btnLogout;

	/** The label. */
	private JLabel label;

	/** The rs. */
	private ResultSet rs;

	/** The delete notepanel. */
	private JPanel deleteNotepanel;

	/** The lbl enter the note. */
	private JLabel lblEnterTheNote;

	/** The text field. */
	private JTextField textField;

	/** The btn cancel. */
	private JButton btnCancel;

	/** The btn delete note. */
	private JButton btnDeleteNote;

	/** The lbl active. */
	private JLabel lblActive;

	/** The Enabledisabletext field. */
	private JTextField EnabledisabletextField;



	/**
	 * Create the panel.
	 */
	public NoteList() {
		setSize(new Dimension(1024, 768));
		setLayout(null);



		//Laver tabellen inde i Eventlisten.
		String[] columnNames = { "Note ID", "Event ID", "Created By", "Note", "Create Time", "Active" };

		Object[][] data = new Object[getNoteCount()][6];

		try {
			QueryBuilder qb = new QueryBuilder();
			rs = qb.selectFrom("notes").all().ExecuteQuery();

			int count = 0;
			while (rs.next()) {

				data[count][0] = rs.getString("noteid");
				data[count][1] = rs.getString("eventid");
				data[count][2] = rs.getString("createdby");
				data[count][3] = rs.getString("note");
				data[count][4] = rs.getString("datetime");
				data[count][5] = rs.getString("active");


				count++;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		final JTable table = new JTable(data, columnNames);
		table.setSurrendersFocusOnKeystroke(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);

		// Create the scroll pane and add the table to it.
		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
						new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
						null));
		scrollPane.setBounds(96, 240, 693, 370);

		// Add the scroll pane to this panel.
		add(scrollPane);

		lblHeader = new JLabel("NoteList");
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Arial", Font.BOLD, 78));
		lblHeader.setBounds(365, 138, 368, 90);
		add(lblHeader);

		btnDelete = new JButton("Edit");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteNotepanel.setVisible(true);
				scrollPane.setVisible(false);
			}
		});
		btnDelete.setOpaque(true);
		btnDelete.setForeground(new Color(0, 0, 205));
		btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnDelete.setBounds(856, 377, 118, 29);
		add(btnDelete);

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

		label = new JLabel("");
		label.setIcon(new ImageIcon(NoteList.class.getResource("/Images/CBSLogo3.png")));
		label.setBounds(10, 698, 250, 59);
		add(label);

		deleteNotepanel = new JPanel();
		deleteNotepanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		deleteNotepanel.setBounds(365, 250, 369, 359);
		add(deleteNotepanel);
		deleteNotepanel.setLayout(null);


		// Hiding the delete calendar panel unless btn delete is clicked
		deleteNotepanel.setVisible(false);

		lblEnterTheNote = new JLabel("Enter the ID of the note you want to edit.");
		lblEnterTheNote.setBounds(66, 54, 235, 44);
		deleteNotepanel.add(lblEnterTheNote);

		textField = new JTextField();
		textField.setBounds(110, 122, 140, 29);
		deleteNotepanel.add(textField);
		textField.setColumns(10);

		btnDeleteNote = new JButton("Edit");
		btnDeleteNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteNotepanel.setVisible(false);
				scrollPane.setVisible(true);
			}
		});
		btnDeleteNote.setBounds(212, 227, 89, 23);
		deleteNotepanel.add(btnDeleteNote);

		btnCancel = new JButton("Cancel");

		btnCancel.setBounds(66, 227, 89, 23);
		deleteNotepanel.add(btnCancel);

		lblActive = new JLabel("Active = 1, Inactive = 2");
		lblActive.setBounds(110, 162, 140, 23);
		deleteNotepanel.add(lblActive);

		EnabledisabletextField = new JTextField();
		EnabledisabletextField.setBounds(110, 187, 140, 29);
		deleteNotepanel.add(EnabledisabletextField);
		EnabledisabletextField.setColumns(10);



		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				deleteNotepanel.setVisible(false);
				scrollPane.setVisible(true);
			}
		});
		lblBackground.setIcon(new ImageIcon(NoteList.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);

		add(lblBackground);
		lblBackground.setIcon(new ImageIcon(NoteList.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);

	}

	/**
	 * Adds the action listener.
	 *
	 * @param l the l
	 */
	public void addActionListener(ActionListener l) {
		btnDelete.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnDeleteNote.addActionListener(l);

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
	 * Gets the btn delete note.
	 *
	 * @return the btn delete note
	 */
	public JButton getBtnDeleteNote() {
		return btnDeleteNote;
	}


	/**
	 * Gets the enabledisabletext field.
	 *
	 * @return the enabledisabletext field
	 */
	public JTextField getEnabledisabletextField() {
		return EnabledisabletextField;
	}


	/**
	 * Gets the note count.
	 *
	 * @return the note count
	 */
	public int getNoteCount(){

		int count = 0;

		QueryBuilder qb2 = new QueryBuilder();
		try {
			rs = qb2.selectFrom("notes").all().ExecuteQuery();
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
