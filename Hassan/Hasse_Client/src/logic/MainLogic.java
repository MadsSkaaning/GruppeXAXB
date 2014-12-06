package logic;

import gui.MainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.xml.transform.OutputKeys;


//denne klasse h�ndtere ALLE knapper p� klienten. Den best�r af et objekt af mit main frame, samt en masse private inner klasser, der implementere ActionListener interfacet.


public class MainLogic {
	
	
 private MainScreen screen;
 

 
 public MainLogic(){
	 
	 
	 screen = new MainScreen();

	 //Tilf�jer ActionListeners til alle klientens knapper
		screen.getLoginScreen().addActionListener(new LoginActionListener());
		screen.getFrontScreen().addActionListener(new FrontActionListener());
		screen.getEventScreen().AddActionListener(new UserEventActionListener());
		screen.getCalendarScreen().addActionListenerReturn(new CalendarActionListener());
		screen.getCalendarScreen().addActionListenerCreateCal(new CreateUserActionListener());
		screen.getCalendarScreen().addActionListenerGetCalendar(new GetCalendarActionListener());

	 
	 
	 
	 
 }
 
 //K�rer Guien ved at sette den synlig
 
 public void run() {

		screen.show("loginScreen");
		screen.setVisible(true);
	}
 
 //Action listener til login knappen p� loginscreen
	public class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getLoginScreen().getbtnLogic()){
				
				Controller userInputs = new Controller();
				
				if(userInputs.userControlls("login").equals("login")){
					
					//Efter login bliver et quote og ugens forecasts hentet fra serverens vejr API (requesten g�r alts� ikke gennem serverens database - endnu. 
					//Bem�rk at hvis API'et er overbelastet kan  klienten fryse ved tryk p� login, udkommenter koden nedenfor og s� skulle den k�re igen.
				
					screen.getFrontScreen().getForecastfield().setText(userInputs.userControlls("forecast"));
					
					screen.getFrontScreen().getQuoteField().setText(userInputs.userControlls("quote"));
					
					screen.show("frontScreen");
					
				}else{System.out.println("failed2");}
			}
			
			

		}
	}
	
	
	//Action listener til mit mainscreen
	private class FrontActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getFrontScreen().getCalendar()){
		
				
			
				
				screen.show("calendarScreen");
			}
			
			else if (e.getSource() == screen.getFrontScreen().getEvenList()){
				
				Controller moreuserInputs = new Controller();
				
				//Henter CBS events ud i et text field
				
				screen.getEventScreen().getEventsArea().setText(moreuserInputs.userControlls("getCBS"));
				
				System.out.println(moreuserInputs.userControlls("getCBS"));
				
				screen.show("eventScreen");
				
			}
			
			

		}
	}
	
	private class CalendarActionListener implements ActionListener {
		
		//Action listener til tilbage knappen i calendar screen
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==screen.getCalendarScreen().getReturn()){
				
				screen.show("frontScreen");
			}
			
			
		}
		
		
		
	}
	
	//Actionlistener til tilbage knappen i eventScreen
	private class UserEventActionListener implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==screen.getEventScreen().getReturn()){
				
				screen.show("frontScreen");
			}
			
		}
		
		
	}
	
	//Action listener til CreateCalendar knappen
	private class CreateUserActionListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e){
			
			
			if(e.getSource()==screen.getCalendarScreen().getCreateCalenderBtn()){
				
				//Virkede af en m�rkv�rdig �rsag ikke, hvis setCreateCalendarFields() var en boolean metode...
				//If statementen nedenunder har til form�l at registrere, hvis der bliver trykket p� OK i dialog boksen.
				if(screen.getCalendarScreen().setCreateCalendarFields().equals("true") ){
					TcpClient clientconnection = new TcpClient();
					
					ObjectCreator objectCreator = new ObjectCreator();
					
					//Laver en kalendar gennem en TCPclientens serverComm metode. 
					//Det kunne ikke g�res brug controller klassen her, eftersom det ville v�re umuligt at registrere om der blev trykket OK p� dialogen f�r metoden k�rte.
					
					try {
						clientconnection.serverComm(objectCreator.createCalendar(screen.getCalendarScreen().getCreateEventName(), screen.getCalendarScreen().getCreatedBy(), screen.getCalendarScreen().getCalendarPublicPricate()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				
				}else{System.out.println("failed");}
					
				
			}
			
			
		}	
			
	}
	
	private class GetCalendarActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == screen.getCalendarScreen().getCalendarBtn()){
				
				TcpClient clientconnection = new TcpClient();
				
				ObjectCreator objectCreator = new ObjectCreator();
				
				//Henter en specifik kaldener fra serverens database. 
				//Dette sker ogs� direkte gennem TCPClientens serverComm() metode, da det ellers ville v�re umuligt at registrerer om brugeren trykker OK
				
				try {
					System.out.println(clientconnection.serverComm(objectCreator.getCalendar(screen.getCalendarScreen().getCalendarUserinputs())));
				} catch (Exception e1) {
					
					
					e1.printStackTrace();
				}
				
				
			}
			
		}
		
		
		
		
	}
			
			
	
public Class<LoginActionListener> getLoginActionListener(){
	
	return LoginActionListener.class;
				
	}




}

		
