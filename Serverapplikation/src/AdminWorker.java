import GUI.GUILogic;
// TODO: Auto-generated Javadoc


// This is supposed to be the thread running for admins. 

/**
 * The Class AdminWorker.
 */
public class AdminWorker implements Runnable{
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run(){
		GUILogic admin = new GUILogic();
		admin.run();
	}
}
