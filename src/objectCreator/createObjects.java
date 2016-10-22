package objectCreator;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import badSmells.bloaterCreator;
import classDiagram.ClassDiagram;
import files.FileReader;
import softwareMetrics.MetricsCreator;

public class createObjects {

	public static void main(String[] args) throws Exception {

		File filePath = new File("JavaFiles");
		ArrayList<File> files = FileReader.readFiles(filePath);

		Boolean stop = false;
		
		while (!stop) {

			System.out.println("Please choose the analyzer you would like to run.");
			System.out.println("1. Metrics?");
			System.out.println("2. Bad Smells?");
			System.out.println("3. Class Diagram?");

			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			
			
			if (input.equals("1")) {
				Boolean metric = false;
				while(!metric){
					System.out.println("Select your metric.");
					System.out.println("1. Methods Per Class?");
					System.out.println("2. Depth of Inheritance?");
					System.out.println("3. Number of Children?");
					String metricChoice = scan.nextLine();
					if(metricChoice.equals("1")){
						MetricsCreator.setUpCompilationUnit(files, 1);
						metric = true;
					} else if(metricChoice.equals("2")){
						MetricsCreator.setUpCompilationUnit(files, 2);
						metric = true;
					} else if(metricChoice.equals("3")){
						MetricsCreator.setUpCompilationUnit(files, 3);
						metric = true;
					}
					else {
						System.out.println("Not a valid option");
					}
				}
			} else if (input.equals("2")){
				Boolean bloater = false;
				while(!bloater){
					System.out.println("Select a bad smell.");
					System.out.println("1. Bloaters");
					String badSmellChoice = scan.nextLine();
					if(badSmellChoice.equals("1")){
						Boolean bloaterChoice = false;
						while(!bloaterChoice){
							System.out.println("S"
									+ "elect a bloater");
							System.out.println("1. Long Methods");
							System.out.println("2. Large Class");
							System.out.println("3. Long Parameter List");
							String bloaterSelect = scan.nextLine();
							if(bloaterSelect.equals("1")){
								bloaterCreator.setUpCompilationUnit(files, 1);
								bloaterChoice = true;
								bloater = true;
							} else if(bloaterSelect.equals("2")){
								bloaterCreator.setUpCompilationUnit(files, 2);
								bloaterChoice = true;
								bloater = true;
							} else if(bloaterSelect.equals("3")){
								bloaterCreator.setUpCompilationUnit(files, 3);
								bloaterChoice = true;
								bloater = true;
							} else {
								System.out.println("Not a valid option");
							}
						}
					}
					else
					{
						System.out.println("Not a valid option");
					}
				}
				
			} else if(input.equals("3")){
				ClassDiagram.setUpCompilationUnit(files);
			}
			else if (input.toLowerCase().equals("q")) {
				System.out.println("Bye!");
				break;
			} else {
				System.out.println("Enter your number only please.");
			}
		}
	}

}
