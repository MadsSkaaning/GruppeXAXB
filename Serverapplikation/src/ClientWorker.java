import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class ClientWorker implements  Runnable{
	private Socket connectionSocketConected;
	private CalendarInfo CI = new CalendarInfo();
	private GiantSwitch GS = new GiantSwitch();
	private encryption cryp = new encryption();
	private String incomingJson;
	
	ClientWorker(Socket connectionSocket){
		this.connectionSocketConected = connectionSocket;
	}
	
	public void run(){
		try{
			System.out.println("forbindelse Oprettet!");
			//BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			byte[] b = new byte[500000];
			int count = connectionSocketConected.getInputStream().read(b);
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			DataInputStream inFromClient = new DataInputStream(connectionSocketConected.getInputStream());		
			//Creates an object of the data which is to be send back to the client, via the connectionSocket
			DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());
			System.out.println("Outtoclient oprettet!");
			//Sets client sentence equals input from client
			//incomingJson = inFromClient.readLine();			
			
			String ny = cryp.decrypt(b);
			
			//cryp.StringEncryption(inFromClient.readLine());
			System.out.println("Besked modtaget!");
			//Sysout recieved message
			System.out.println("Received: " + ny);
			String returnSvar = GS.GiantSwitchMethod(ny);		
			//Sends the capitalized message back to client!!
			outToClient.writeBytes(returnSvar + "\n");
			System.out.println("svar sendt");
			//BufferedWriter writer = new BufferedWriter(arg0)
		}catch(Exception exception){
			System.err.print(exception);
		}
	}


}
