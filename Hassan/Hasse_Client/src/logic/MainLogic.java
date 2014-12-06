package logic;

import gui.MainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.xml.transform.OutputKeys;


//denne klasse håndtere ALLE knapper på klienten. Den består af et objekt af mit main frame, samt en masse private inner klasser, der implementere ActionListener interfacet.


public class MainLogic {
	
	
 private MainScreen screen;
 

 
 public MainLogic(){
	 
	 
	 screen = new MainScreen();

	 //Tilføjer ActionListeners til alle klientens knapper
		screen.getLoginScreen().addActionListener(new LoginActionListener());
		screen.getFrontScreen().addActionListener(new FrontActionListener());
		screen.getEventScreen().AddActionListener(new UserEventActionListener());
		screen.getCalendarScreen().addActionListenerReturn(new CalendarActionListener());
		screen.getCalendarScreen().addActionListenerCreateCal(new CreateUserActionListener());
		screen.getCalendarScreen().addActionListenerGetCalendar(new GetCalendarActionListener());

	 
	 
	 
	 
 }
 
 //Kører Guien ved at sette den synlig
 
 public void run() {

		screen.show("loginScreen");
		screen.setVisible(true);
	}
 
 //Action listener til login knappen på loginscreen
	public class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getLoginScreen().getbtnLogic()){
				
				Controller userInputs = new Controller();
				
				if(userInputs.userControlls("login").equals("login")){
					
					//Efter login bliver et quote og ugens forecasts hentet fra serverens vejr API (requesten går altså ikke gennem serverens database - endnu. 
					//Bemærk at hvis API'et er overbelastet kan  klienten fryse ved tryk på login, udkommenter koden nedenfor og så skulle den køre igen.
				
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
				
				//Virkede af en mærkværdig årsag ikke, hvis setCreateCalendarFields() var en boolean metode...
				//If statementen nedenunder har til formål at registrere, hvis der bliver trykket på OK i dialog boksen.
				if(screen.getCalendarScreen().setCreateCalendarFields().equals("true") ){
					TcpClient clientconnection = new TcpClient();
					
					ObjectCreator objectCreator = new ObjectCreator();
					
					//Laver en kalendar gennem en TCPclientens serverComm metode. 
					//Det kunne ikke gøres brug controller klassen her, eftersom det ville være umuligt at registrere om der blev trykket OK på dialogen før metoden kørte.
					
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
				//Dette sker også direkte gennem TCPClientens serverComm() metode, da det ellers ville være umuligt at registrerer om brugeren trykker OK
				
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

		
