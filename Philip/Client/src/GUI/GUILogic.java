package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

//import GUI.UserInformation;


import javax.swing.JOptionPane;



import logic.Controller;
//import model.QueryBuild.*;
import GUI.Screen;
import JsonClasses.AuthUser;

public class GUILogic {
	private Screen screen;
	private boolean u;
	private boolean full = false;
	
	AuthUser a = new AuthUser();  
	

	public GUILogic(){
		screen = new Screen();

		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener());
		screen.getProfile().addActionListener(new ProfileActionListener());
		screen.getCalendar().addActionListener(new CalendarActionListener());
		screen.getEvents().addActionListener(new EventsActionListener());

		
		
	}
	public void run() {

		screen.show(Screen.LOGIN);
		screen.setVisible(true);
	}
	
	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getLogin().getBtnLogIn()){
				
				screen.getLogin().getUsername();
				screen.getLogin().getPassword();
				
				Controller userInputs = new Controller();
				
				if(userInputs.userControlls("login").equals("login")){
				
				
				
					screen.show(Screen.MAINMENU);
					
				}else{System.out.println("failed2");}
			}
			
			

		}
	}
	
	private class MainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getMainMenu().getBtnLogOut()){
				screen.show(Screen.LOGIN);
			}

			if (e.getSource() == screen.getMainMenu().getBtnCalendar()){
				screen.show(Screen.CALENDAR);
			}
			if (e.getSource() == screen.getMainMenu().getBtnEvents()){
				screen.show(Screen.EVENTS);
			}
			
			if (e.getSource() == screen.getMainMenu().getBtnProfile()){
				screen.show(Screen.PROFILE);
			}
			
			

		}
	}

	private class ProfileActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getProfile().getBtnHome()){
				screen.show(Screen.MAINMENU);
			}
		}
	}
	
	private class CalendarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getCalendar().getBtnHome()){
				screen.show(Screen.MAINMENU);
			}

		}
	}
	
	private class EventsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getEvents().getBtnHome()){
				screen.show(Screen.MAINMENU);
			}
		}
	}
	
	
}
