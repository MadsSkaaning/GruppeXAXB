package gui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import java.awt.Font;

import logic.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class UserEventScreen.
 */
public class UserEventScreen extends JPanel {

	/** The table. */
	private JTable table;

	/** The btn home. */
	private JButton btnHome = new JButton("");

	/** The lbl background. */
	private JLabel lblBackground;

	/** The lbl events. */
	private JLabel lblEvents;

	/** The lbl events view. */
	private JLabel lblEventsView;

	/**
	 * Instantiates a new user event screen.
	 */
	public UserEventScreen() {
		setLayout(null);
		setBounds(0,0,1024,768);


		table = new JTable();
		table.setBounds(108, 508, 407, -173);
		add(table);
		btnHome.setIcon(new ImageIcon(UserEventScreen.class.getResource("/images/home-button.png")));
		btnHome.setBounds(10, 11, 64, 64);
		add(btnHome);

		lblEvents = new JLabel("New label");
		lblEvents.setIcon(new ImageIcon(UserEventScreen.class.getResource("/images/eventbtn.png")));
		lblEvents.setBounds(412, 77, 153, 41);
		add(lblEvents);

		lblEventsView = new JLabel("New label");
		lblEventsView.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEventsView.setBounds(40, 143, 937, 520);


		Controller mycontroller = new Controller();
		String event = mycontroller.userControls("getEvent");

		event = event.replace("{", "");
		event = event.replace("activityid", "<br/>");



		lblEventsView.setText("<html>" + event + "</html>");

		add(lblEventsView);


		lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(UserEventScreen.class.getResource("/images/login-mainframe.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);

		// Opretter et panel her der skal være 
		final JPanel addEventPanel = new JPanel();
		addEventPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		addEventPanel.setBounds(159,159,600,450);
		addEventPanel.setVisible(false);
		addEventPanel.setLayout(null);

	}


	/**
	 * Gets the return.
	 *
	 * @return the return
	 */
	public JButton getReturn(){

		return btnHome;
	}

	/**
	 * Adds the action listener.
	 *
	 * @param l the l
	 */
	public void AddActionListener(ActionListener l){

		btnHome.addActionListener(l);
	}

}
