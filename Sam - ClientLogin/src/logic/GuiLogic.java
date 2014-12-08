package logic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import shared.AuthUser;
import gui.MainFrame;

public class GuiLogic {

	private MainFrame frame;

	TcpClient clientconnection = new TcpClient();

	private JsonObjektCreator jsonobjektcreator = new JsonObjektCreator();


	public GuiLogic() {
		frame = new MainFrame();

		frame.getLogin().addActionListener(new LoginActionListener());
		frame.getMainMenu().addActionListener(new MainMenuActionListener());
		frame.getCalendar().addActionListener(new CalendarActionListener());
		frame.getEvents().addActionListener(new EventsActionListener());
		frame.getAddCalendar().addActionListener(new CreateCalendarActionListener());
		frame.getAddEvent().addActionListener(new AddEventActionListener());
		frame.getNotes().addActionListener(new NotesActionListener());
		frame.getAddNote().addActionListener(new AddNoteActionListener());
	}


	public void run() {

		frame.show(MainFrame.LOGIN);
		frame.setVisible(true);
	}



	private class MainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {



			if (e.getSource() == frame.getMainMenu().getbtnLogOut()){
				frame.show(MainFrame.LOGIN);
			}
			if (e.getSource() == frame.getMainMenu().getcalendar_button()){
				frame.show(MainFrame.CALENDAR);
			}
			if (e.getSource() == frame.getMainMenu().getevents_button()){
				frame.show(MainFrame.EVENTS);
			}
			if (e.getSource() == frame.getMainMenu().getbtnHome()){
				frame.show(MainFrame.MAINMENU);
			}

		}
	}


	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == frame.getLogin().getexitbutton()){
				JOptionPane.showMessageDialog(null, "Goodbye");
				System.exit(0);
			}
			if (e.getSource() == frame.getLogin().getloginbtn()){	

				try {
					if(clientconnection.serverComm(jsonobjektcreator.authenticateUser()).equals("0")){
						frame.show( MainFrame.MAINMENU);		
						frame.getMainMenu().getQOTDLabel().setText(clientconnection.serverComm(jsonobjektcreator.getQuote()));
						String manipulermig = clientconnection.serverComm(jsonobjektcreator.getWeather());
						manipulermig = manipulermig.replace("},", "<br/>");
						frame.getMainMenu().getForecastLabel().setText("<html>" + manipulermig + "</html>");

					}
					else{
						JOptionPane.showMessageDialog(null, "Wrong combination. Please try again!");	}
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}

		}}


	private class CalendarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == frame.getCalendar().getbtnLogOut()){
				frame.show(MainFrame.LOGIN);
			}
			if (e.getSource() == frame.getCalendar().getbtnHome()){
				frame.show(MainFrame.MAINMENU);
			}
			if (e.getSource() == frame.getCalendar().getbtnNewCalendar()){
				frame.show(MainFrame.ADDCALENDAR);
			}

		}

	}

	private class CreateCalendarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == frame.getAddCalendar().getbtnLogOut()){
				frame.show(MainFrame.LOGIN);
			}
			if (e.getSource() == frame.getAddCalendar().getbtnHome()){
				frame.show(MainFrame.MAINMENU);
			}
			if (e.getSource() == frame.getAddCalendar().getbtnCreate()){
				try {
					clientconnection.serverComm(jsonobjektcreator.addEvent());
					JOptionPane.showMessageDialog(null, "Your calendar has now been created!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}


		}

	}


	private class EventsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == frame.getEvents().getbtnLogOut()){
				frame.show(MainFrame.LOGIN);
			}
			if (e.getSource() == frame.getEvents().getbtnHome()){
				frame.show(MainFrame.MAINMENU);
			}
			if (e.getSource() == frame.getEvents().getbtnNewEvent()){
				frame.show(MainFrame.ADDEVENT);
			}
			if (e.getSource() == frame.getEvents().getbtnNotes()){
				frame.show(MainFrame.NOTES);
			}



		}
	}

	private class AddEventActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == frame.getAddEvent().getbtnLogOut()){
				frame.show(MainFrame.LOGIN);
			}
			if (e.getSource() == frame.getAddEvent().getbtnHome()){
				frame.show(MainFrame.MAINMENU);
			}
			if (e.getSource() == frame.getAddEvent().getbtnCreate()){
				try {
					clientconnection.serverComm(jsonobjektcreator.addEvent());
					JOptionPane.showMessageDialog(null, "Your event has now been created!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		}
	}

	private class NotesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == frame.getNotes().getbtnLogOut()){
				frame.show(MainFrame.LOGIN);
			}
			if (e.getSource() == frame.getNotes().getbtnHome()){
				frame.show(MainFrame.MAINMENU);
			}
			if (e.getSource() == frame.getNotes().getbtnNewNote()){
				frame.show(MainFrame.ADDNOTE);
			}}
	}


	private class AddNoteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == frame.getAddNote().getbtnLogOut()){
				frame.show(MainFrame.LOGIN);
			}
			if (e.getSource() == frame.getAddNote().getbtnHome()){
				frame.show(MainFrame.MAINMENU);
			}
			if (e.getSource() == frame.getAddNote().getbtnCreate()){
				try {
					clientconnection.serverComm(jsonobjektcreator.addNote());
					JOptionPane.showMessageDialog(null, "Your note has now been created!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		}

	}




}