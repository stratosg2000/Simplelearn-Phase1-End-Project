package filemagic.com.util;

import java.util.Scanner;
import java.util.InputMismatchException;
import filemagic.com.service.Service;

public class MainMenu {

	public void displayMainMenu() {

		int mainMenuChoice; // user's choice in main menu
		String mainMenuCon = "n"; // check if user wants to continue or not
		
		Scanner scanner = new Scanner(System.in);

		MainMenu mainMenu = new MainMenu();
		SubMenu mainSubMenu = new SubMenu();
		Service mainMenuServ = new Service();

		do {
			mainMenu.mainMenuMessage();

			try {
				mainMenuChoice = scanner.nextInt();

			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block

				// we pass to switch block the invalid value 999 in order to present an invalid
				// input
				// Thus the program will present the same error message in the case of invalid
				// integer number
				// or an input mismatch

				mainMenuChoice = 999;
			}

			scanner.nextLine();

			switch (mainMenuChoice) {
			case 1:
				 mainMenuServ.serviceApp(scanner, "DISPLAY");
				break;

			case 2:
				mainSubMenu.displaySubMenu(scanner);
				mainMenu.displayMainMenu();
				break;

			case 0:
				mainMenu.exitMainMenuMessasge();
				System.exit(0);
				break;

			default:
				mainMenu.invalidMainMenuOptionMessage();
				break;
			}

			System.out.println(" *************************************************** ");
			System.out.println(" Please press y or n in order to continue or not to main menu");
			mainMenuCon = scanner.nextLine();

			if (!mainMenuCon.equalsIgnoreCase("y") && !mainMenuCon.equalsIgnoreCase("n")) {
				System.out.println(" You have provided an invalid option ");
				System.out.println(" Valid options are y/Y and n/N ");
			}

			System.out.println(" *************************************************** ");
			System.out.println();

		} while (!mainMenuCon.equalsIgnoreCase("n"));

		scanner.close();
		mainMenu.exitMainMenuMessasge();

	}

	private void exitMainMenuMessasge() {
		System.out.println(" ------------------------------------------- ");
		System.out.println(" Thank you for using FileMagic App ");
		System.out.println(" The application has exited ");
		System.out.println(" ------------------------------------------- ");
	}

	private void mainMenuMessage() {
		System.out.println(" ########################################## ");
		System.out.println(" FileMagic provides the below options:");
		System.out.println(" 1: Display the files of a folder in ascending order");
		System.out.println(" 2: Business level operation (For adding, deleting and searching a file)");
		System.out.println(" 0: To exit from the app");
		System.out.println(" Please enter your choice <0-2>");
		System.out.println(" ########################################## ");
		System.out.println();
	}

	private void invalidMainMenuOptionMessage() {
		System.out.println(" ------------------------------------------------ ");
		System.out.println(" You have provided an invalid option ");
		System.out.println(" Valid options in main menu are integers from 0-2 ");
		System.out.println(" ------------------------------------------------ ");
		System.out.println();
	}
}
