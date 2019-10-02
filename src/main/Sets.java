package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Sets {
	int sizeUniSet;
	int numSubsets;
	
	public void createSets(String filename){

		String currentLine;
		FileReader reader;
		Scanner scan;
		
		try{
			//load the file and create the canner
			reader = new FileReader(filename);
			scan = new Scanner(reader);
			
			//get Universal set and number of subsets
			sizeUniSet = scan.nextInt();
			numSubsets = scan.nextInt();
			scan.nextLine();
			
			System.out.println(sizeUniSet + ", " + numSubsets);
			//keep going if there is another line with another set
			while(scan.hasNextLine()){
				currentLine = scan.nextLine();
				System.out.println("currentLine is: " + currentLine);
				
				//parse the line with a space as the delimiter
				String[] temp= currentLine.split(" ");
				System.out.println(temp[0]);
				int[] values = new int[temp.length];
				
				for(int i = 0; i < values.length; i++){
					values[i] = Integer.parseInt(temp[i]);
				}
				scan.nextLine();
			}
		}
		
		catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}
}
