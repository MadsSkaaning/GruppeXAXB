package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

import java.awt.Dimension;

import logic.Controller;

public class MainMenu extends JPanel {
	private JLabel label;
	private JButton btnLogOut;
	private JButton btnEvents;
	private JButton btnCalendar;
	private JLabel lblLoggedin;
	private JLabel labelUser;
	private JLabel lblQotd;
	private JLabel lblBackground;
	private JLabel lblWeatherForecast;
	private JLabel lblQuote;
	private JLabel lblWeather;
	private JLabel lblQ;
	private JLabel lblA;
	private JLabel lblT;
	

	
	public MainMenu() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);
		
		Controller mycont = new Controller();
		
		btnEvents = new JButton("Events");
		btnEvents.setContentAreaFilled(false);
		btnEvents.setForeground(Color.WHITE);
		btnEvents.setFont(new Font("Arial", Font.BOLD, 30));
		btnEvents.setBackground(Color.WHITE);
		btnEvents.setBounds(400, 70, 145, 50);
		btnEvents.setOpaque(false);
		btnEvents.setBorderPainted(false);
		add(btnEvents);

		
		lblLoggedin = new JLabel("Logged in as:");
		lblLoggedin.setBounds(846, 49, 98, 16);
		add(lblLoggedin);
		
		labelUser = new JLabel("");
		labelUser.setBounds(846, 70, 132, 29);
		add(labelUser);
		
		String forecast = mycont.userControlls("weather");
		
		lblWeatherForecast = new JLabel();
		lblWeatherForecast.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblWeatherForecast.setForeground(Color.LIGHT_GRAY);
		forecast = forecast.replace("},", "<br/>");
		forecast = forecast.replace("Forecast{date=", "");
		forecast = forecast.replace("[", "");
		forecast = forecast.replace("]", "");
		forecast = forecast.replace("celsius=", "Temperature: ");
		forecast = forecast.replace("desc=", "Risk of rain: ");
		forecast = forecast.replace("12:00:00", "");
		lblWeatherForecast.setText("<html>" + forecast + "</html>");
		lblWeatherForecast.setBounds(140, 457, 837, 241);
		add(lblWeatherForecast);
		
		btnCalendar = new JButton("Calendar");
		btnCalendar.setForeground(Color.WHITE);
		btnCalendar.setFont(new Font("Arial", Font.BOLD, 30));
		btnCalendar.setBackground(Color.WHITE);
		btnCalendar.setBounds(140, 70, 190, 50);
		btnCalendar.setOpaque(false);
		btnCalendar.setContentAreaFilled(false);
		btnCalendar.setBorderPainted(false);
		add(btnCalendar);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.LIGHT_GRAY);
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(792, 654, 167, 44);
		btnLogOut.setOpaque(false);
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorderPainted(false);
		add(btnLogOut);
		
		lblQuote = new JLabel("Quote of the day");
		lblQuote.setForeground(Color.LIGHT_GRAY);
		lblQuote.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		lblQuote.setBounds(113, 170, 215, 78);
		add(lblQuote);
		
		lblWeather = new JLabel("Weatherforecast");
		lblWeather.setForeground(Color.LIGHT_GRAY);
		lblWeather.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		lblWeather.setBounds(453, 381, 215, 78);
		add(lblWeather);
		
		String qotd = (mycont.userControlls("qotd"));
		
		String[] parts = qotd.split(":");
		String quotedontuse = parts[0]; 
		String quote = parts[1];
		String author = parts[2]; 
		String topic = parts[3];

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
		
		
		lblQ = new JLabel(quoteF);
		lblQ.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblQ.setForeground(Color.LIGHT_GRAY);
		lblQ.setBounds(113, 270, 905, 38);
		add(lblQ);
		
		lblA = new JLabel(authorF);
		lblA.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblA.setForeground(Color.LIGHT_GRAY);
		lblA.setBounds(113, 320, 557, 38);
		add(lblA);
		
		lblT = new JLabel(topicF);
		lblT.setForeground(Color.LIGHT_GRAY);
		lblT.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblT.setBounds(113, 370, 347, 38);
		add(lblT);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MainMenu.class.getResource("/img/philip-bg.png")));
		lblBackground.setBounds(0, 0, 1024, 768);
		add(lblBackground);

	}
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnCalendar.addActionListener(l);
		btnEvents.addActionListener(l);
		
		
	}

	public JButton getBtnEvents() {
		return btnEvents;
	}
	public JButton getBtnCalendar() {
		return btnCalendar;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	
}
