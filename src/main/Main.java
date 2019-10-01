package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	
	public void createSets(String filename){
		int sizeUniSet;
		int numSubsets;
		String currentLine;
		FileReader reader;
		Scanner scan;
		
		try{
			reader = new FileReader(filename);
			scan = new Scanner(reader);
			
			//get Universal set and number of subsets
			sizeUniSet = scan.nextInt();
			numSubsets = scan.nextInt();
			
			//keep going if there is another line with another set
			while(scan.hasNextLine()){
				currentLine = scan.nextLine();
				System.out.println("currentLine is: " + currentLine);
				
				String[] temp= currentLine.split(" ");
				int[] values = new int[temp.length];
				
			}
		}
		catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}
	
	public static void main(String[] args) {
		Main prog = new Main();
		prog.createSets("Input file");
	}

}
