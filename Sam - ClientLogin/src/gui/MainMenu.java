package gui;

//importerer.
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JTextField;

import logic.JsonObjektCreator;

//Klassen extender JPanel.
public class MainMenu extends JPanel {
	private JButton btnLogOut;
	private JLabel QOTD;
	private JButton calendar_button;
	private JButton events_button;
	private JButton profile_button;
	private JButton btnHome;
	private JLabel baggrund;
	private JLabel QOTDLabel;
	private JLabel ForecastLabel;

	// Klassens variabler instantieres.

	// Konstruktoer.
	public MainMenu() {
		setLayout(null);
		setBounds(0,0,1024,768);



		// Der oprettes endnu en JButton, som logger brugeren ud af programmet
		// og tilbage til login.
		btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setBounds(6, 72, 119, 45);
		add(btnLogOut);


		QOTD = new JLabel("Quote of the day:");
		QOTD.setForeground(Color.CYAN);
		QOTD.setFont(new Font("MT Extra", Font.BOLD | Font.ITALIC, 12));
		QOTD.setHorizontalAlignment(SwingConstants.CENTER);
		QOTD.setBounds(391, 476, 247, 25);
		add(QOTD);


		calendar_button = new JButton("Calendar");
		calendar_button.setForeground(Color.BLACK);
		calendar_button.setBounds(65, 159, 324, 112);
		add(calendar_button);


		events_button = new JButton("Events");
		events_button.setForeground(Color.BLACK);
		events_button.setBounds(65, 296, 324, 112);
		add(events_button);


		btnHome = new JButton("Home");
		btnHome.setBounds(26, 6, 64, 65);
		btnHome.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/home-button.png")));
		add(btnHome);

		QOTDLabel = new JLabel("QOTDLabel");
		QOTDLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		QOTDLabel.setForeground(Color.CYAN);
		QOTDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		QOTDLabel.setBounds(6, 473, 1001, 199);
		add(QOTDLabel);

		ForecastLabel = new JLabel("Forecast");
		ForecastLabel.setVerticalAlignment(SwingConstants.TOP);
		ForecastLabel.setForeground(Color.BLUE);
		ForecastLabel.setBounds(427, 138, 597, 310);
		add(ForecastLabel);


		baggrund = new JLabel("");
		baggrund.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/img/sam-bg.png")));
		baggrund.setBounds(0, 0, 1024, 768);
		add(baggrund);

	}		

	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		calendar_button.addActionListener(l);
		events_button.addActionListener(l);
		btnHome.addActionListener(l);

	}
	public JButton getbtnLogOut() {
		return btnLogOut;
	}
	public JButton getcalendar_button() {
		return calendar_button;
	}
	public JButton getevents_button() {
		return events_button;
	}
	public JButton getbtnHome() {
		return btnHome;
	}

	public JLabel getQOTDLabel() {
		return QOTDLabel;

	}
	public JLabel getForecastLabel() {
		return ForecastLabel;
	}
}
