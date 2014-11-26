/*
 * 
 */
package gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import logic.ViewUserLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminViewUserScreen.
 */
public class AdminViewUserScreen extends JPanel {


	/** The Constant DEFAULT_QUERY. */
	public static final String DEFAULT_QUERY = "SELECT * FROM user";

	/** The view user panel. */
	JPanel viewUserPanel;

	/** The lbl view user. */
	private JLabel lblViewUser;

	/** The Admin view user panel. */
	private JPanel AdminViewUserPanel;

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

	/** The label. */
	private JLabel label;

	/** The table model. */
	private ViewUserLogic tableModel;

	/** The table. */
	private JTable table;

	/** The input query. */
	public JComboBox inputQuery;

	/** The submit query. */
	private JButton submitQuery;

	/** The input. */
	public JTextField input;

	/** The lbl search specific id. */
	private JLabel lblSearchSpecificId;


	/**
	 * Instantiates a new admin view user screen.
	 *
	 * @param screen the screen
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdminViewUserScreen(AdminScreen screen) {
		this.screen = screen;

		try 
		{
			tableModel = new ViewUserLogic( DEFAULT_QUERY );
		} 
		catch ( SQLException sqlex ) 
		{
			System.err.println( "Unable to connect" );
			sqlex.printStackTrace();
			System.exit( 1 );  
		} 

		String names[] = { "Basic information", 
				"All information", "A specific ID Mail" };

		inputQuery = new JComboBox( names );
		inputQuery.setBounds(6, 89, 190, 25);
		submitQuery = new JButton( "Search!" );
		submitQuery.setBounds(215, 88, 149, 26);
		submitQuery.setBackground(UIManager.getColor("Button.darkShadow"));
		submitQuery.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed( ActionEvent e ) 
					{
						getTable();
					} 
				} 
				); 

		viewUserPanel = new JPanel();
		viewUserPanel.setBounds(0, 0, 480, 620);
		viewUserPanel.setLayout(null);

		AdminViewUserPanel = new JPanel();
		AdminViewUserPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		AdminViewUserPanel.setBounds(50, 106, 388, 470);
		viewUserPanel.add(AdminViewUserPanel);
		AdminViewUserPanel.setLayout(null);

		input = new JTextField( 20 );
		input.setBounds(197, 5, 100, 20);
		input.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed( ActionEvent e )
					{
						try 
						{
							String query = input.getText();
							tableModel.setQuery( query );
						} 
						catch ( SQLException sqlex ) 
						{
							sqlex.printStackTrace();
						} 
					} 
				}
				); 

		JPanel centerPanel = new JPanel();
		centerPanel.setBounds(45, 48, 301, 30);
		centerPanel.setLayout(null);
		JLabel label;
		lblSearchSpecificId = new JLabel( "Search specific ID" );
		lblSearchSpecificId.setBounds(10, 7, 132, 16);
		centerPanel.add( lblSearchSpecificId );
		centerPanel.add( input );
		AdminViewUserPanel.setLayout(null);
		AdminViewUserPanel.add( inputQuery );
		AdminViewUserPanel.add( centerPanel );
		AdminViewUserPanel.add( submitQuery );
		setLayout(null);
		add( viewUserPanel );

		table = new JTable( tableModel );
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(6, 125, 378, 335);
		AdminViewUserPanel.add(scrollPane);
		scrollPane.setViewportBorder(null);
		getTable();
		setSize( 480, 640 );
		setVisible( true );

		lblViewUser = new JLabel("New label");
		lblViewUser.setBounds(128, 11, 151, 43);
		AdminViewUserPanel.add(lblViewUser);
		lblViewUser.setIcon(new ImageIcon(AdminViewUserScreen.class.getResource("/shared/img/view_user.png")));

		label = new JLabel("");
		label.setIcon(new ImageIcon(AdminViewUserScreen.class.getResource("/shared/img/confirm.png")));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(215, 419, 151, 41);
		AdminViewUserPanel.add(label);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AdminViewUserScreen.class.getResource("/shared/img/BCBS.png")));
		lblLogo.setBounds(118, 34, 250, 48);
		viewUserPanel.add(lblLogo);

		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(AdminViewUserScreen.class.getResource("/shared/img/CBS baggrund_20.png")));
		lblBackground.setBounds(0, 0, 480, 640);
		viewUserPanel.add(lblBackground);

		btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(AdminViewUserScreen.class.getResource("/shared/img/home-button.png")));
		btnHome.setBounds(0, 0, 64, 64);
		viewUserPanel.add(btnHome);
		btnHome.addActionListener(new Eventhandler());

	}

	/**
	 * Gets the table.
	 *
	 * @return the table
	 * @deprecated Use {@link logic.ViewUserLogic#getTable(gui.AdminViewUserScreen)} instead
	 */
	private void getTable()
	{
		tableModel.getTable(this);
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
