package filemagic.com.util;

import java.util.Scanner;

import filemagic.com.service.Service;

import java.util.InputMismatchException;

public class SubMenu {

	public void displaySubMenu(Scanner scanner) {
		// TODO Auto-generated method stub
		int businessMenuChoice;
		String businessMenuCon = "n";

		SubMenu menuSub = new SubMenu();
		Service subServ = new Service();
		
		do {
			menuSub.subMenuMessage();
			
			try {
				businessMenuChoice = scanner.nextInt();
				
			} catch (InputMismatchException e) {
				
				// we pass to switch block the invalid value 999 in order to present an invalid
				// input
				// Thus the program will present the same error message in the case of invalid
				// integer number
				// or an input mismatch

				businessMenuChoice = 999;

			}

			switch (businessMenuChoice) {

			case 1:
				subServ.serviceApp(scanner, "CREATION");
				break;

			case 2:
				subServ.serviceApp(scanner, "DELETION");
				break;

			case 3:
				subServ.serviceApp(scanner, "SEARCHING");
				break;

			case 0:
				menuSub.exitSubMenuMessasge();
				break;

			default:
				menuSub.invalidMainMenuOptionMessage();
				break;
			}
//          We want the below code block not to be executed when user has already selected not to 
//          continue in business sub menu which means  businessMenuChoice is equal to zero
			
			if (businessMenuChoice != 0) {

				scanner.nextLine();

				System.out.println(" *************************************************** ");
				System.out.println(" Please press y or n in order to continue or not to business sub menu");
				businessMenuCon = scanner.nextLine();

				if (!businessMenuCon.equalsIgnoreCase("y") && !businessMenuCon.equalsIgnoreCase("n")) {
					System.out.println(" You have provided an invalid option ");
					System.out.println(" Valid options are y/Y and n/N ");
				}

				System.out.println(" *************************************************** ");
				System.out.println();
				menuSub.exitSubMenuMessasge();
			}

		} while (!businessMenuCon.equalsIgnoreCase("n"));
	}

	private void subMenuMessage() {
		System.out.println(" ############################################# ");
		System.out.println(" FileMagic provides the below business options:");
		System.out.println(" 1: To create a file");
		System.out.println(" 2: To delete a file");
		System.out.println(" 3: To search a file");
		System.out.println(" 0: Exit sub menu");
		System.out.println(" Please enter your choice <0-3>");
		System.out.println(" ############################################# ");
	}

	private void invalidMainMenuOptionMessage() {
		System.out.println(" ------------------------------------------------ ");
		System.out.println(" You have provided an invalid option ");
		System.out.println(" Valid options in sub menu are integers from 0-3 ");
		System.out.println(" ------------------------------------------------ ");
		System.out.println();
	}

	private void exitSubMenuMessasge() {
		System.out.println(" ------------------------------------------- ");
		System.out.println(" You have exited from sub menu");
		System.out.println(" ------------------------------------------- ");
		System.out.println();
	}

}
