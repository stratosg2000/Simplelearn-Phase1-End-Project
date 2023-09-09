package filemagic.com.app;

import filemagic.com.util.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			Welcome wel = new Welcome();
			wel.displayWelcome();

			MainMenu menuMain = new MainMenu();
			menuMain.displayMainMenu();

		} catch (Exception e) {
			System.out.println("Something gone wrong .....");
			System.out.println("File Magic is exiting .....");
			e.printStackTrace();
		}
	}
}
