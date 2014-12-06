package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import logic.Controller;
import logic.ObjectCreator;


// TODO: Auto-generated Javadoc
/**
 * The Class GuiLogic.
 */
public class GuiLogic {


	/** The screen. */
	private Screen screen;

	/**
	 * Instantiates a new gui logic.
	 */
	public GuiLogic(){


		screen = new Screen();

		screen.getLoginScreen().addActionListener(new LoginActionListener());
		screen.getFrontScreen().addActionListener(new FrontActionListener());
		screen.getEventScreen().AddActionListener(new UserEventActionListener());
		screen.getCalendarScreen().addActionListener(new CalendarActionListener());
	}


	/**
	 * Run.
	 */
	public void run() {

		screen.show("loginScreen");
		screen.setVisible(true);
	}



	/**
	 * The listener interface for receiving loginAction events.
	 * The class that is interested in processing a loginAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addLoginActionListener<code> method. When
	 * the loginAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see LoginActionEvent
	 */
	public class LoginActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getLoginScreen().getbtnLogic()){

				Controller userInputs = new Controller();

				if(userInputs.userControls("login").equals("login"))

				{
					screen.show("frontScreen");

				}else{

					JOptionPane.showMessageDialog(null, "\nYour input was wrong. Please try again."
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
	}

	/**
	 * The listener interface for receiving frontAction events.
	 * The class that is interested in processing a frontAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addFrontActionListener<code> method. When
	 * the frontAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see FrontActionEvent
	 */
	private class FrontActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
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

	/**
	 * The listener interface for receiving calendarAction events.
	 * The class that is interested in processing a calendarAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addCalendarActionListener<code> method. When
	 * the calendarAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see CalendarActionEvent
	 */
	private class CalendarActionListener implements ActionListener {


		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
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

	/**
	 * The listener interface for receiving userEventAction events.
	 * The class that is interested in processing a userEventAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addUserEventActionListener<code> method. When
	 * the userEventAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see UserEventActionEvent
	 */
	private class UserEventActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==screen.getEventScreen().getReturn()){

				screen.show("frontScreen");
			}

		}


	}

}
