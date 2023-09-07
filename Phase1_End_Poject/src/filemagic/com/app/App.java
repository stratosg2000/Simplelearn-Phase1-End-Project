package filemagic.com.app;

import filemagic.com.menu.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Welcome wel = new Welcome();
		wel.displayWelcome();

		MainMenu menu = new MainMenu();
		menu.mainMenu();
	}
}
