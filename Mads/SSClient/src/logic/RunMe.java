package logic;

import gui.GuiLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class RunMe.
 */
public class RunMe {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		//Starting the program and continue to the GUI LoginScreen to authenticate.
		GuiLogic gui = new GuiLogic();

		gui.run();
	}

}
