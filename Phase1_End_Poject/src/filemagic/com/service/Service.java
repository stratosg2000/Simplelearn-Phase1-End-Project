package filemagic.com.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Service {

	public void serviceApp(Scanner scanner, String operation) {
		// TODO Auto-generated method stub

		String directoryPath;

		initialServiceMessage(operation);

		directoryPath = scanner.nextLine();
		System.out.println("The provided path is: " + directoryPath);

		File directory = new File(directoryPath);

		if (validateDirectory(directory) == true) {

			switch (operation) {

			case "DISPLAYING":
				displayFiles(directory);
				break;

			case "CREATING":
				String fileToCreate = retrieveFilename(scanner);
				createFile(directoryPath, fileToCreate);
				break;

			case "DELETING":
				String fileToDelete = retrieveFilename(scanner);
				deleteFile(directoryPath, fileToDelete);
				break;

			case "SEARCHING":
				String fileToSearch = retrieveFilename(scanner);
				searchFile(directoryPath, fileToSearch);
				break;

			default:
				System.out.println(" Something gone wrong ... invalid input value in Service class ");
				break;
			}
		}

	}

	private void initialServiceMessage(String message) {
		System.out.println(
				" =================================================================================================== ");

		if (message == "DISPLAYING") {
			System.out.println("Please provide the path of the directory for " + message + " the files");
		} else {
			System.out.println("Please provide the path of the directory for " + message + " your file");
		}
		;

		System.out.println(
				"An example of a path in WINDOWS is C:\\Users\\strat\\REPOS\\Simplelearn-Phase1-End-Project\\ProjectDir");
		System.out.println(
				" ==================================================================================================== ");
	}

	private boolean validateDirectory(File directoryName) {
		if (directoryName.exists() && directoryName.isDirectory()) {
			System.out.println("The directory indeed exists.");
			return true;
		} else {
			System.out.println(" ----------------------------------------------");
			System.out.println("The provided directory does not exist ");
			System.out.println(" ------------------------------------------------");
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
		System.out.println(" ----------------------------------------------");
	}

	private String retrieveFilename(Scanner retrieveScanner) {

		System.out.println(" Please provide the name of the filename  ");
		String fileName = retrieveScanner.nextLine();
		System.out.println(" ----------------------------------------------");
		return fileName;

	}

	private void createFile(String userDirectory, String createFileName) {
		String fullPath = userDirectory + File.separator + createFileName;
		File file = new File(fullPath);

		if (file.exists()) {
			System.out.println("The file " + createFileName + " was already found in the specified directory");
		} else {

			// Create a new empty file in the given directory
			try {

				boolean created = file.createNewFile();
				if (created) {
					System.out
							.println(" File " + createFileName + " has been created successfully in " + userDirectory);
				} else {
					System.out.println(" File creation failed.");
				}
			} catch (IOException e) {
				System.out.println("Something went wrong during creation ......");
				e.printStackTrace();
			}
		}

	}

	private void deleteFile(String userDirectory, String deleteFileName) {

		String fullPath = userDirectory + File.separator + deleteFileName;
		File file = new File(fullPath);

		if (!file.exists()) {
			System.out.println("The file " + deleteFileName + " was not found in the specified directory");
		} else {

			// Delete an existing file in the given directory

			try {

				boolean deleted = file.delete();
				if (deleted) {
					System.out
							.println(" File " + deleteFileName + " has been successfully deleted in " + userDirectory);
				} else {
					System.out.println(" File deletion failed.");
				}
			} catch (Exception e) {
				System.out.println("Something went wrong during deletion......");
				e.printStackTrace();
			}
		}

	}
	
	private void searchFile(String userDirectory, String searchFileName) {
		String fullPath = userDirectory + File.separator + searchFileName;
		File file = new File(fullPath);

		if (!file.exists()) {
			System.out.println("The file " + searchFileName + " was not found in the specified directory");
		} else {System.out.println("The file " + searchFileName + " was found in the specified directory");
}
}
}