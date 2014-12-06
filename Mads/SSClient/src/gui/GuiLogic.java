package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import logic.Controller;
import logic.ObjectCreator;


public class GuiLogic {
	
	
 private Screen screen;
 public GuiLogic(){
	 
	 
	 screen = new Screen();

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
							
				if(userInputs.userControlls("login").equals("login"))
					
				{
					screen.show("frontScreen");
					
				}else{
					
					JOptionPane.showMessageDialog(null, "\nYour input was wrong. Please try again."
							, "Error message",JOptionPane.PLAIN_MESSAGE);
					}
			}
		}
	}
	
	private class FrontActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getFrontScreen().getCalendar()){
				screen.show("calendarScreen");
			}
			
			if (e.getSource() == screen.getFrontScreen().getEvenList()){
				
				screen.show("eventScreen");
			}
			
			if (e.getSource() == screen.getFrontScreen().getLogOut()){
				
				screen.show("loginScreen");
			}
			
			

		}
	}
	
	private class CalendarActionListener implements ActionListener {
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==screen.getCalendarScreen().getReturn()){
				
				screen.show("frontScreen");
			}
			
			if(e.getSource()==screen.getCalendarScreen().getBtnCreateTestEvent()){
				
				ObjectCreator objCreator = new ObjectCreator();
				objCreator.createCalendar();
				
				
			
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
