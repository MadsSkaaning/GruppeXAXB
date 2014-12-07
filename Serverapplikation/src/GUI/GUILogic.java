package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import GUI.UserInformation;
import databaseMethods.SwitchMethods;

import javax.swing.JOptionPane;

import model.QueryBuild.*;
import GUI.Screen;
import JsonClasses.AuthUser;

// TODO: Auto-generated Javadoc
/**
 * The Class GUILogic.
 */
public class GUILogic {

	/** The screen. */
	private Screen screen;

	/** The u. */
	private boolean u;

	/** The full. */
	private boolean full = false;

	/**
	 * Instantiates a new GUI logic.
	 */
	public GUILogic(){
		screen = new Screen();

		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener());
		screen.getUserInfo().addActionListener(new UserInfoActionListener());
		screen.getNoteList().addActionListener(new NoteListActionListener());
		screen.getUserList().addActionListener(new UserListActionListener());
		screen.getCalendarList().addActionListener(new CalendarListActionListener()); 
		screen.getEventlist().addActionListener(new EventListActionListener());
		screen.getAddEventGUI().addActionListener(new AddEventGUIActionListener());
		screen.getAddUser().addActionListener(new AddUserActionListener());
		screen.getAddCalendar().addActionListener(new AddCalendarActionListener());

	}

	/**
	 * Run.
	 */
	public void run() {

		screen.show(Screen.LOGIN);
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
	private class LoginActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getLogin().getBtnLogIn()){

				SwitchMethods logmein = new SwitchMethods();
				String email = screen.getLogin().getTextFieldUsername().getText();
				String password = screen.getLogin().getTextFieldPassword().getText();

				try {
					if(logmein.authenticateadmin(email, password).equals("0") )
						screen.show(Screen.MAINMENU);
					else{
						JOptionPane.showMessageDialog(null, "Wrong combination. Please try again!");	}
				} catch (Exception e1) {

					e1.printStackTrace();
				}


			}	
		}	
	}

	/**
	 * The listener interface for receiving mainMenuAction events.
	 * The class that is interested in processing a mainMenuAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addMainMenuActionListener<code> method. When
	 * the mainMenuAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see MainMenuActionEvent
	 */
	private class MainMenuActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getMainMenu().getBtnLogOut()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getMainMenu().getBtnUserlist()){
				screen.show(Screen.USERLIST);
			}
			if (e.getSource() == screen.getMainMenu().getBtnNotelist()){
				screen.show(Screen.NOTELIST);
			}
			if (e.getSource() == screen.getMainMenu().getBtnEventlist()){
				screen.show(Screen.EVENTLIST);
			}
			if (e.getSource() == screen.getMainMenu().getBtnCalendarList()){
				screen.show(Screen.CALENDARLIST);
			}


		}
	}

	/**
	 * The listener interface for receiving addEventGUIAction events.
	 * The class that is interested in processing a addEventGUIAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addAddEventGUIActionListener<code> method. When
	 * the addEventGUIAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see AddEventGUIActionEvent
	 */
	private class AddEventGUIActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getAddEventGUI().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getAddEventGUI().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getAddEventGUI().getBtnCancel()){
				screen.show(Screen.EVENTLIST);
			}

			if (e.getSource() == screen.getAddEventGUI().getBtnSubmit()){
				String Location = screen.getAddEventGUI().getTextField_Location().getText();
				String Createdby = screen.getAddEventGUI().getTextField_Createdby().getText();
				String start = screen.getAddEventGUI().getTextField_Start().getText();
				String end = screen.getAddEventGUI().getTextField_End().getText();
				String eventname = screen.getAddEventGUI().getTextField_Name().getText();
				String text = screen.getAddEventGUI().getTextField_Text().getText();

				String active = "1";
				String customevent = "1";

				//calendarid 1 is meant only to be the admin calendar which is public to everyone.
				// Admin cannot add events into a specific user calendar.

				String calendarid = "1";

				if (Location.equals("")|| Createdby.equals("")|| start.equals("")|| end.equals("")|| eventname.equals("")|| text.equals(""))
				{
					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					QueryBuilder qb = new QueryBuilder();

					String[] kolonner = { "location", "createdby", "start", "end", "eventname", "description", "calendarid", "active", "customevent"};
					String[] Values = { Location, Createdby, start, end, eventname, text, calendarid, active, customevent };


					try {
						qb.insertInto("events", kolonner ).values(Values).Execute();

						JOptionPane.showMessageDialog(null, "\nEvent has been succesfully added!"
								, "OBS",JOptionPane.PLAIN_MESSAGE);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "\nERROR: Please fill out fields correctly."
								, "Error message",JOptionPane.PLAIN_MESSAGE);

					}
				}


			}
		}
	}

	/**
	 * The listener interface for receiving addUserAction events.
	 * The class that is interested in processing a addUserAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addAddUserActionListener<code> method. When
	 * the addUserAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see AddUserActionEvent
	 */
	private class AddUserActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getAddUser().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getAddUser().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getAddUser().getBtnCancel()){
				screen.show(Screen.USERLIST);
			}

			if (e.getSource() == screen.getAddUser().getBtnSubmit()){
				String Email = screen.getAddUser().getTextField_Email().getText();
				String Type = screen.getAddUser().getTextField_Type().getText();
				String Password = screen.getAddUser().getTextField_Password().getText();
				String Active = "1";


				if (Email.equals("")|| Type.equals("")|| Password.equals(""))
				{
					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					QueryBuilder qb = new QueryBuilder();

					String[] kolonner = { "email", "password", "type", "active"};
					String[] Values = { Email, Password, Type, Active};
					try {
						qb.insertInto("users", kolonner ).values(Values).Execute();

						JOptionPane.showMessageDialog(null, "\nUser has been succesfully added!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);

						screen.show(Screen.USERLIST);

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}


			}
		}
	}

	/**
	 * The listener interface for receiving addCalendarAction events.
	 * The class that is interested in processing a addCalendarAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addAddCalendarActionListener<code> method. When
	 * the addCalendarAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see AddCalendarActionEvent
	 */
	private class AddCalendarActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getAddCalendar().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getAddCalendar().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getAddCalendar().getBtnCancel()){
				screen.show(Screen.CALENDARLIST);
			}

			if (e.getSource() == screen.getAddCalendar().getBtnSubmit()){


				String CalendarName = screen.getAddCalendar().getTextField_Name().getText();
				String Active = "1";
				//Hardcoded created by and user name, to 1 and user. HAS TO BE CHANGED.
				String CreatedBy = "admin";
				
				
				
				String PrivatePublic = "1";
				if (CalendarName.equals(""))
				{
					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					QueryBuilder qb = new QueryBuilder();

					String[] kolonner = { "calendarname", "createdby", "privatepublic", "active", };
					String[] Values = { CalendarName, CreatedBy, PrivatePublic, Active};
					try {
						qb.insertInto("calendar", kolonner ).values(Values).Execute();

						JOptionPane.showMessageDialog(null, "\nCalendar has been succesfully added!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);

						screen.show(Screen.CALENDARLIST);




					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}


			}
		}
	}

	/**
	 * The listener interface for receiving userInfoAction events.
	 * The class that is interested in processing a userInfoAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addUserInfoActionListener<code> method. When
	 * the userInfoAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see UserInfoActionEvent
	 */
	private class UserInfoActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getUserInfo().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getUserInfo().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getUserInfo().getBtnSubmit()){

			}
		}
	}

	/**
	 * The listener interface for receiving noteListAction events.
	 * The class that is interested in processing a noteListAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addNoteListActionListener<code> method. When
	 * the noteListAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see NoteListActionEvent
	 */
	private class NoteListActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getNoteList().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getNoteList().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}

			if(e.getSource() == screen.getNoteList().getBtnDeleteNote()){

				String NoteID = screen.getNoteList().getTextField().getText();

				if	(NoteID.equals("")) {

					JOptionPane.showMessageDialog(null, "\nPlease fill out the Note ID"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}

				else
				{
					QueryBuilder qb = new QueryBuilder();

					String activestatus = screen.getNoteList().getEnabledisabletextField().getText();


					String[] keys = { "active" };
					String[] values = { activestatus};
					try {

						qb.update("notes", keys, values).where("noteid", "=", NoteID).Execute();
						JOptionPane.showMessageDialog(null, "\nThe note has been succesfully edited!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);


					} catch (SQLException e1) {

						JOptionPane.showMessageDialog(null, "\nNote ID doesnt exist. Try again!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);

						e1.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * The listener interface for receiving userListAction events.
	 * The class that is interested in processing a userListAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addUserListActionListener<code> method. When
	 * the userListAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see UserListActionEvent
	 */
	private class UserListActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getUserList().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getUserList().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getUserList().getBtnAdd()){
				screen.show(Screen.ADDUSER);
			}
			if (e.getSource() == screen.getUserList().getBtnDelete()){
			}

			if(e.getSource() == screen.getUserList().getBtnFinalDeleteUser()){

				String UserID = screen.getUserList().getTextField().getText();

				if	(UserID.equals("")) {

					JOptionPane.showMessageDialog(null, "\nPlease fill out the User ID"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}

				else
				{
					QueryBuilder qb = new QueryBuilder();

					String activestatus = screen.getUserList().getEnabledisabletextField().getText();


					String[] keys = { "active" };
					String[] values = { activestatus};
					try {

						qb.update("users", keys, values).where("userid", "=", UserID).Execute();
						JOptionPane.showMessageDialog(null, "\nThe user has been succesfully edited!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);


					} catch (SQLException e1) {

						JOptionPane.showMessageDialog(null, "\nUser ID doesnt exist. Try again!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);

						e1.printStackTrace();
					}
				}
			}

		}
	}

	/**
	 * The listener interface for receiving eventListAction events.
	 * The class that is interested in processing a eventListAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addEventListActionListener<code> method. When
	 * the eventListAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see EventListActionEvent
	 */
	private class EventListActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getEventlist().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getEventlist().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getEventlist().getBtnAdd()){
				screen.show(Screen.ADDEVENT);
			}
			if (e.getSource() == screen.getEventlist().getBtnCancel()){
				screen.show(Screen.EVENTLIST);
			}

			if(e.getSource() == screen.getEventlist().getBtnDeleteEvent()){

				String EventID  = screen.getEventlist().getTextField().getText();

				if	(EventID.equals("")) {

					JOptionPane.showMessageDialog(null, "\nPlease fill out the Event ID"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}

				else
				{
					QueryBuilder qb = new QueryBuilder();

					String activestatus = screen.getEventlist().getEnabledisabletextField().getText();


					String[] keys = { "active" };
					String[] values = { activestatus};
					try {

						qb.update("events", keys, values).where("eventid", "=", EventID).Execute();
						JOptionPane.showMessageDialog(null, "\nThe event has been succesfully changed!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);



					} catch (SQLException e1) {

						JOptionPane.showMessageDialog(null, "\nEvent ID doesnt exist. Try again!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);

						e1.printStackTrace();
					}
				}
			}






		}
	}

	/**
	 * The listener interface for receiving calendarListAction events.
	 * The class that is interested in processing a calendarListAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addCalendarListActionListener<code> method. When
	 * the calendarListAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see CalendarListActionEvent
	 */
	private class CalendarListActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getCalendarList().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getCalendarList().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getCalendarList().getBtnAdd()){
				screen.show(Screen.ADDCALENDAR);
			}


			if(e.getSource() == screen.getCalendarList().getBtnfinaldelete()){

				String CalendarID = screen.getCalendarList().getTextField().getText();

				if	(CalendarID.equals("")) {

					JOptionPane.showMessageDialog(null, "\nPlease fill out the Calendar ID"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}

				else
				{
					QueryBuilder qb = new QueryBuilder();

					String activestatus = screen.getCalendarList().getEnabledisabletextField().getText();


					String[] keys = { "active" };
					String[] values = { activestatus};
					try {

						qb.update("calendar", keys, values).where("calendarid", "=", CalendarID).Execute();
						JOptionPane.showMessageDialog(null, "\nCalendar has been succesfully deleted!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);


					} catch (SQLException e1) {

						JOptionPane.showMessageDialog(null, "\nCalendar ID doesnt exist. Try again!"
								, "Error message",JOptionPane.PLAIN_MESSAGE);

						e1.printStackTrace();
					}
				}
			}

		}
	}
}