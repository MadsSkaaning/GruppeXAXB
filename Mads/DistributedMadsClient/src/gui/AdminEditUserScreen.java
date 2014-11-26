/*
 * 
 */
package gui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;







import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

import logic.EditUserLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminEditUserScreen.
 */
public class AdminEditUserScreen extends JPanel {

	/** The lbl new label. */
	private JLabel lblNewLabel;

	/** The edit user panel. */
	JPanel editUserPanel;

	/** The Admin edit user panel. */
	private JPanel AdminEditUserPanel;

	/** The lbl logo. */
	private JLabel lblLogo;

	/** The lbl background. */
	private JLabel lblBackground;

	/** The btn home. */
	private JButton btnHome;

	/** The screen. */
	private AdminScreen screen;

	/** The screenchanger. */
	Eventhandler screenchanger;

	/** The table model. */
	private EditUserLogic tableModel;

	/** The user table. */
	JTable userTable;

	/** The delete row button. */
	JButton deleteRowButton;

	/**
	 * Instantiates a new admin edit user screen.
	 *
	 * @param screen the screen
	 */
	public AdminEditUserScreen(AdminScreen screen) {
		this.screen = screen;
		editUserPanel = new JPanel();
		editUserPanel.setBounds(41, 102, 480, 620);
		editUserPanel.setVisible(true);
		editUserPanel.setLayout(null);
		try {
			tableModel = new EditUserLogic();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		userTable = new JTable( tableModel );
		userTable.setLocation(18, 33);
		AdminEditUserPanel = new JPanel();
		AdminEditUserPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		AdminEditUserPanel.setBounds(50, 106, 388, 470);
		editUserPanel.add(AdminEditUserPanel);
		AdminEditUserPanel.setLayout(null);

		deleteRowButton = new JButton( "Delete row" );
		deleteRowButton.addActionListener( 

				new ActionListener() 
				{
					// pass query to table model
					public void actionPerformed( ActionEvent event ) {
						// get row index in JTable
						int rowIndex = userTable.getSelectedRow();
						if (rowIndex != -1)
							try {
								tableModel.deleteRow(rowIndex);
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(AdminEditUserScreen.this, "Cannot delete row");
							}

					} // end actionPerformed
				}  // end ActionListener inner class          
				); // end call to addActionListener
		AdminEditUserPanel.add(deleteRowButton);
		deleteRowButton.setLocation(277, 357);
		deleteRowButton.setSize(101, 23);
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane( userTable );
		scrollPane.setLocation(10, 4);
		scrollPane.setSize(368, 346);
		AdminEditUserPanel.add( scrollPane);

		final TableRowSorter< TableModel > sorter = 
				new TableRowSorter< TableModel >( tableModel );
		userTable.setRowSorter( sorter );
		userTable.setSize( 360, 470 ); // set window size
		userTable.setVisible( true ); // display window

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AdminEditUserScreen.class.getResource("/shared/img/BCBS.png")));
		lblLogo.setBounds(118, 34, 250, 48);
		editUserPanel.add(lblLogo);

		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(AdminEditUserScreen.class.getResource("/shared/img/CBS baggrund_20.png")));
		lblBackground.setBounds(0, 0, 480, 640);
		editUserPanel.add(lblBackground);

		btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(AdminEditUserScreen.class.getResource("/shared/img/home-button.png")));
		btnHome.setBounds(0, 0, 64, 64);
		editUserPanel.add(btnHome);
		btnHome.addActionListener(new Eventhandler());

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 464, 601);
		add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Mads\\Dropbox\\Gruppearbejde\\BCBS v2.0\\Grafik\\CBS baggrund_20.png"));

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

			screen.changecards.show(screen.contentPane,"AdminPanel");

		}

	}
}
