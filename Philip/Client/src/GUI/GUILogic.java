package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logic.Controller;

//import GUI.UserInformation;






//import model.QueryBuild.*;


public class GUILogic {
	private Screen screen;

	
	

	public GUILogic(){
		screen = new Screen();

		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener());
		screen.getProfile().addActionListener(new ProfileActionListener());
		screen.getCalendar().addActionListener(new CalendarActionListener());
		screen.getEvents().addActionListener(new EventsActionListener());

		
		
	}
	public void run() {

		screen.show("login");
		screen.setVisible(true);
	}
	
	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getLogin().getBtnLogIn()){
				
				screen.getLogin().getUsername();
				screen.getLogin().getPassword();
				
				Controller userInputs = new Controller();
				
				if(userInputs.userControlls("login").equals("login")){
				
				
				
					screen.show("mainmenu");
					
				}else{System.out.println("failed2");}
			}
			
			

		}
	}
	
	private class MainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getMainMenu().getBtnLogOut()){
				screen.show("login");
			}

			if (e.getSource() == screen.getMainMenu().getBtnCalendar()){
				screen.show("calendar");
			}
			if (e.getSource() == screen.getMainMenu().getBtnEvents()){
				screen.show("events");
			}
			
			if (e.getSource() == screen.getMainMenu().getBtnProfile()){
				screen.show("profile");
			}
			
			

		}
	}

	private class ProfileActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getProfile().getBtnHome()){
				screen.show("mainmenu");
			}
		}
	}
	
	private class CalendarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getCalendar().getBtnHome()){
				screen.show("mainmenu");
			}

		}
	}
	
	private class EventsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getEvents().getBtnHome()){
				screen.show("mainmenu");
			}
		}
	}
	
	
}
