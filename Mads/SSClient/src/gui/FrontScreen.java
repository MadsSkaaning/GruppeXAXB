package gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import JsonClasses.AuthUser;

import java.awt.Color;
import java.awt.Font;

import logic.Controller;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.border.Border;


public class FrontScreen extends JPanel {
	
	/**
	 * Create the panel.
	 */
	
	private JButton btnCalendar = new JButton("");
	private JButton btnEventlist = new JButton("");
	private JButton btnLogOut = new JButton("");
	private JButton btnExit = new JButton("");
	private final JLabel lblBackground = new JLabel("");
	private final JLabel lblgetUserName = new JLabel("");
	private final JLabel lblQotd = new JLabel("Quote of the day");
	private final JLabel lblgetQotd = new JLabel("");
	private final JLabel lblWeatherInfo = new JLabel("");
	private final JLabel lblWeather = new JLabel("Forecast - Next 8 days");
	private final JLabel lblQuote = new JLabel("Quote");
	private final JLabel lblAuthor = new JLabel("New label");
	private final JLabel lblCategory = new JLabel("New label");
	private final JLabel lblIconAuthor = new JLabel("");
	private final JLabel lblIconQuote = new JLabel("");
	private final JLabel lblIconCategory = new JLabel("");
	
	
	public FrontScreen() {
		setLayout(null);
		setBounds(0, 0, 1024, 768);
		
		
		Controller mycontroller = new Controller();
		btnCalendar.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/calendarbtn.png")));
		btnCalendar.setBounds(342, 74, 153, 41);
		add(btnCalendar);
		btnEventlist.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/eventbtn.png")));
		btnEventlist.setBounds(550, 74, 153, 41);
		add(btnEventlist);
		btnLogOut.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/Logout.png")));
		btnLogOut.setBounds(10, 22, 153, 41);
		add(btnLogOut);
		btnExit.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/exit.png")));
		btnExit.setBounds(10, 74, 153, 41);
		add(btnExit);
		lblgetUserName.setBounds(821, 59, 76, 14);
		System.out.println();
		
		add(lblgetUserName);
		lblQotd.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblQotd.setBounds(342, 138, 415, 50);
		
		add(lblQotd);
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		lblWeatherInfo.setBounds(10, 420, 985, 247);
		
		String forecast = mycontroller.userControlls("getWeather");
		forecast = forecast.replace("},", "<br/>");
		forecast = forecast.replace("[", "");
		forecast = forecast.replace("{date='", " Date: ");
		forecast = forecast.replace("12:00:00 CET", "");
		forecast = forecast.replace(", desc=", " Description: ");
		forecast = forecast.replace("Forecast{date=", "");
		forecast = forecast.replace(", celsius='", " Temperature: ");
		
		
		lblWeatherInfo.setText("<html><body><p>" + forecast + "</body></p></html>");
		lblWeatherInfo.setBorder(border);
		add(lblWeatherInfo);
		
		
		lblWeather.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblWeather.setBounds(328, 379, 294, 50);
		
		add(lblWeather);
		
		
		
		String qotd = mycontroller.userControlls("qotd");
		String[] qotdparts = qotd.split(":");
		String quotedontuse = qotdparts[0]; 
		String quote = qotdparts[1];
		String author = qotdparts[2]; 
		String topic = qotdparts[3];

		// Trying to remove {}:
		String quoteF = quote;
		quoteF = quoteF.replace("{", "");
		quoteF = quoteF.replace("quote", "");
		quoteF = quoteF.replace("author", "");
		
		String authorF = author;
		authorF = authorF.replace("{", "");
		authorF = authorF.replace("topic", "");
		
		String topicF = topic;
		topicF = topicF.replace("{", "");
		topicF = topicF.replace("}", "");
		
		
		
		
		lblQuote.setBounds(81, 248, 914, 41);
		
		
		lblQuote.setText(quoteF);
		
		add(lblQuote);
		lblAuthor.setBounds(81, 300, 816, 20);
		lblAuthor.setText(authorF);
		
		add(lblAuthor);
		lblgetQotd.setBounds(10, 187, 985, 203);
		
				lblgetQotd.setBorder(border);
				
				add(lblgetQotd);
		lblCategory.setBounds(81, 336, 816, 14);
		
		lblCategory.setText(topicF);
		
		add(lblCategory);
		lblIconAuthor.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/author.png")));
		lblIconAuthor.setBounds(26, 295, 32, 32);
		
		add(lblIconAuthor);
		lblIconQuote.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/quote.png")));
		lblIconQuote.setBounds(26, 258, 32, 32);
		
		add(lblIconQuote);
		lblIconCategory.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/Nuvola_apps_bookcase.png")));
		lblIconCategory.setBounds(27, 338, 32, 32);
		
		add(lblIconCategory);
		
		
		lblBackground.setIcon(new ImageIcon(FrontScreen.class.getResource("/images/login-mainframe.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		
		add(lblBackground);

	}
	
	public void addActionListener(ActionListener l) {
		btnCalendar.addActionListener(l);
		btnEventlist.addActionListener(l);
		btnLogOut.addActionListener(l);
		
	}
	
	public JButton getCalendar(){
		
		return btnCalendar;
	}
	
	public JButton getEvenList(){
		
		return btnEventlist;
	}
	
	public JButton getLogOut(){
		return btnLogOut;
	}
	
	
	public JButton getExit(){
		
		return btnExit;
	}
}
