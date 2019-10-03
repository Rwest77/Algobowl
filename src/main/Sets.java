package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sets {
	int sizeUniSet;
	int numSubsets;
	
	Set<Integer> universalSet;
	ArrayList<int[]> subsetsList;
	ArrayList<Integer> weightsList;

	public Sets(){
		subsetsList = new ArrayList<int[]>();
		weightsList = new ArrayList<Integer>();
		universalSet = new HashSet<Integer>();
	}
	
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
			
			//create the universal set
			
			
			//keep going if there is another line with another set
			while(scan.hasNextLine()){
				currentLine = scan.nextLine();
				System.out.println("currentLine is: " + currentLine);
				
				//parse the line with a space as the delimiter
				String[] temp= currentLine.split(" ");
				int[] values = new int[temp.length];
				
				for(int i = 0; i < values.length; i++){
					values[i] = Integer.parseInt(temp[i]);
				}
				System.out.println(values[0]);
				//scan.nextLine();
				weights.add(scan.nextInt());
			}
		}
		
		catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}
	
	public void checkSets(){
		System.out.println("Universal set is: ");
	}
}
