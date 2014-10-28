import GUI.GUILogic;
public class AdminWorker implements Runnable{
	public void run(){
		GUILogic admin = new GUILogic();
		admin.run();
	}
}
