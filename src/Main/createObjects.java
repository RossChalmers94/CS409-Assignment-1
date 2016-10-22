package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


import ClassDiagram.ClassDiagram;
import Files.FileReader;
import SoftwareMetrics.MetricsCreator;

public class createObjects {

	public static void main(String[] args) throws Exception {

		File filePath = new File("JavaFiles");
		ArrayList<File> files = FileReader.readFiles(filePath);

		Boolean stop = false;
		while (!stop) {

			System.out.println("Please choose the analyzer you would like to run.");
			System.out.println("1. WMC?");
			System.out.println("2. DIT?");
			System.out.println("3. NOC?");
			System.out.println("4. Class Diagram?");

			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();

			if (input.equals("1")) {
				MetricsCreator.setUpCompilationUnit(files, 1);
			} else if (input.equals("2")) {
				MetricsCreator.setUpCompilationUnit(files, 2);
			} else if (input.equals("3")){
				MetricsCreator.setUpCompilationUnit(files, 3);
			} else if (input.equals("4")){
				ClassDiagram.setUpCompilationUnit(files);
			} else if (input.toLowerCase().equals("q")) {
				System.out.println("Bye!");
				break;
			} else {
				System.out.println("Enter your number only please.");
			}
		}
	}

}
