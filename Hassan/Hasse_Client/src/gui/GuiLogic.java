package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.Controller;






public class GuiLogic {
	
	
 private MainScreen screen;
 

 
 public GuiLogic(){
	 
	 
	 screen = new MainScreen();

		screen.getLoginScreen().addActionListener(new LoginActionListener());
		screen.getFrontScreen().addActionListener(new FrontActionListener());
		screen.getEventScreen().AddActionListener(new UserEventActionListener());
		screen.getCalendarScreen().addActionListener(new CalendarActionListener());
		
	 
	 
	 
	 
 }
 
 
 
 public void run() {

		screen.show("loginScreen");
		screen.setVisible(true);
	}
 
 
	public class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getLoginScreen().getbtnLogic()){
				
				Controller userInputs = new Controller();
				
				if(userInputs.userControlls("login").equals("login")){
					
					userInputs.userControlls("createCalendar");
				
					screen.getFrontScreen().getForecastfield().setText(userInputs.userControlls("forecast"));
					
					//screen.getFrontScreen().getQutelabel
				
					screen.show("frontScreen");
					
				}else{System.out.println("failed2");}
			}
			
			

		}
	}
	
	private class FrontActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getFrontScreen().getCalendar()){
				
				Controller userInputs = new Controller();
				
				userInputs.userControlls("getCalendar");
				
				screen.show("calendarScreen");
			}
			
			else if (e.getSource() == screen.getFrontScreen().getEvenList()){
				
				Controller moreuserInputs = new Controller();
				
				moreuserInputs.userControlls("getEvent");
				
				screen.show("eventScreen");
				
			}
			
			

		}
	}
	
	private class CalendarActionListener implements ActionListener {
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==screen.getCalendarScreen().getReturn()){
				
				screen.show("frontScreen");
			}
			
			
		}
		
		
		
	}
	
	private class UserEventActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==screen.getEventScreen().getReturn()){
				
				screen.show("frontScreen");
			}
			
		}
		
		
	}
	
	
public Class<LoginActionListener> getLoginActionListener(){
	
	return LoginActionListener.class;
}	

}
