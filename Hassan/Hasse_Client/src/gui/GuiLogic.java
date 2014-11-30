package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







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
 
 
	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getLoginScreen().getbtnLogic()){
				screen.show("frontScreen");
			}
			
			

		}
	}
	
	private class FrontActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getFrontScreen().getCalendar()){
				screen.show("calendarScreen");
			}
			
			else if (e.getSource() == screen.getFrontScreen().getEvenList()){
				
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
	
	
	

}
