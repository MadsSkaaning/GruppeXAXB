package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Class Eventhandler.
 */
public class Eventhandler implements ActionListener {

	/**
	 * 
	 */
	private final CalendarScreen calendarScreen;

	/**
	 * @param calendarScreen
	 */
	Eventhandler(CalendarScreen calendarScreen) {
		this.calendarScreen = calendarScreen;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		//CustomerScreen screen = new CustomerScreen();

		this.calendarScreen.screen.changecards.show(this.calendarScreen.screen.contentPane,"menuPanel");

	}


}