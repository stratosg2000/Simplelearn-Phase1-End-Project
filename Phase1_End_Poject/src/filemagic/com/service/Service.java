package filemagic.com.service;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Service {

	public void serviceApp(Scanner scanner, String operation) {
		// TODO Auto-generated method stub
		Service serv = new Service();

		serv.initialServiceMessage(operation);
		String directoryPath = scanner.nextLine();

		File directory = new File(directoryPath);

		if (serv.validateDirectory(directory) == true) {

			switch (operation) {

			case "DISPLAY":
				serv.displayFiles(directory);
				break;

//			case "creating":
//				createFile(file, businnessFileName, businessDirectoryPath);
//				break;
//
//			case "deleting":
//				deleteFile(file, businnessFileName);
//				break;
//
//			case "searching":
//				searchFile(file, businnessFileName, businessDirectoryPath);
//				break;
//
			default:
				System.out.println(" Something gone wrong ... invalid input value in Service class ");
				break;
			}
		}

	}

	private void initialServiceMessage(String operation) {
		System.out.println(" =================================================================================================== ");
		System.out.println("Please provide the path of the directory for the file " + operation + ".");
		System.out.println("An example of a path in WINDOWS is C:\\Users\\strat\\REPOS\\Simplelearn-Phase1-End-Project\\ProjectDir");
		System.out.println(" ==================================================================================================== ");
	}

	private boolean validateDirectory(File directory) {
		if (directory.exists() && directory.isDirectory()) {
			System.out.println("The directory indeed exists.");
			return true;
		} else {
			System.out.println(" ----------------------------------------------");
			System.out.println("The provided directory does not exist ");
			return false;
		}
	}

	private void displayFiles(File directory) {
		File[] files = directory.listFiles();
		Arrays.sort(files);
		System.out.println(" ----------------------------------------------");
		System.out.println("Below is the list of files in ascending order: ");
		for (File file : files) {
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}
}