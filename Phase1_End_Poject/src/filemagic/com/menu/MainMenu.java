package filemagic.com.menu;

import java.util.Scanner;

public class MainMenu {

	public static void mainMenu() {

		String mainMenuChoice; // user's choice in main menu
		String mainMenuCon = "n"; // check if user wants to continue or not
		Scanner scanner = new Scanner(System.in);

		do {
			mainMenuMessage();
			mainMenuChoice = scanner.nextLine();

			switch (mainMenuChoice) {
			case "1":
				System.out.println(" ------------------------------------------- ");
				System.out.println(" You have entered in display mode ");
				System.out.println();
				break;

			case "2":
				System.out.println(" ------------------------------------------- ");
				System.out.println(" You have entered in Business level mode ");
				System.out.println();

				break;

			case "0":
				exitMessasge();
				System.exit(0);
				break;

			default:invalidMainMenuOption();
			break;
			}
			System.out.println(" *************************************************** ");
			System.out.println(" Please press y,Y or n,N in order to continue or not");
			mainMenuCon = scanner.nextLine();

			if (!mainMenuCon.equalsIgnoreCase("y") && !mainMenuCon.equalsIgnoreCase("n")) {
				System.out.println(" You have provided an invalid option ");
				System.out.println(" Valid options are yY and nN ");
			}

			System.out.println(" *************************************************** ");

		} while (!mainMenuCon.equalsIgnoreCase("n"));

		scanner.close();
		exitMessasge();

	}

	public static void exitMessasge() {

		System.out.println(" ------------------------------------------- ");
		System.out.println(" Thank you for selecting FileMagic App ");
		System.out.println(" The application has exited ");
		System.out.println(" ------------------------------------------- ");
	}

	public static void mainMenuMessage() {
		System.out.println(" ########################################## ");
		System.out.println(" FileMagic provides the below options:");
		System.out.println(" 1: Display the files of a folder in ascending order");
		System.out.println(" 2: Business level operation (For adding, deleting and searching a file");
		System.out.println(" 0: To exit from the app");
		System.out.println(" Please enter your choice <0-2>");
		System.out.println(" ########################################## ");
		System.out.println();
	}
	
	public static void invalidMainMenuOption(){
	System.out.println(" ------------------------------------------- ");
	System.out.println(" You have provided an invalid option ");
	System.out.println(" Valid options are 0,1,2 ");
	System.out.println(" ------------------------------------------- ");
	System.out.println();
	}
}
