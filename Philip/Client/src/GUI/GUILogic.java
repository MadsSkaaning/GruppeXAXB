package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logic.Controller;




public class GUILogic {
	private Screen screen;
	private Login login;

	
	

	public GUILogic(){
		screen = new Screen();

		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener());
		screen.getProfile().addActionListener(new ProfileActionListener());
		screen.getCalendar().addActionListener(new CalendarActionListener());
		screen.getEvents().addActionListener(new EventsActionListener());
		screen.getAddCalendar().addActionListener(new AddCalendarActionListener());
		screen.getAddEvent().addActionListener(new AddEventActionListener());

		
		
	}
	public void run() {

		screen.show("login");
		screen.setVisible(true);
	}
	
	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getLogin().getBtnLogIn()){
				screen.getLogin().getTextFieldUsername().getText();
				screen.getLogin().getTextFieldPassword().getText();
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
			
			if (e.getSource() == screen.getCalendar().getBtnAdd()){
				screen.show("addcalendar");
			}

		}
	}
	
	private class EventsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getEvents().getBtnHome()){
				screen.show("mainmenu");
			}
			
			if(e.getSource() == screen.getEvents().getBtnAdd()){
				screen.show("addevent");
			}
		}
	}
	
	private class AddCalendarActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == screen.getAddCalendar().getBtnAdd()){
				
				screen.getAddCalendar().getCalendarName();
				screen.getAddCalendar().getPublicPrivate();
				
			}
			
			if (e.getSource() == screen.getAddCalendar().getBtnCancel()){
				screen.show("calendar");
			}
			
			if (e.getSource() == screen.getAddCalendar().getBtnHome()){
				screen.show("mainmenu");
			}
		}
	}
	
	private class AddEventActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			if (e.getSource() == screen.getAddEvent().getBtnCancel()){
				
				screen.show("events");
			}
			
			if (e.getSource() == screen.getAddEvent().getBtnHome()){
				
				screen.show("mainmenu");
			}
		}
	}
	
}
