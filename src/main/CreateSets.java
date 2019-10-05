package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CreateSets {
	int sizeUniSet;
	int numSubsets;
	int subsetsWeight;
	
	Set<Integer> universalSet;
	ArrayList<Subset> subsetsList;
	ArrayList<Integer> weightsList;

	public CreateSets(){
		subsetsList = new ArrayList<Subset>();
		weightsList = new ArrayList<Integer>();
		universalSet = new HashSet<Integer>();
	}
	
	public void createSets(String filename){
		String currentLine;
		FileReader reader;
		Scanner scan;
		int weight;
		int subsetNum = 1;
		try{
			//load the file and create the canner
			reader = new FileReader(filename);
			scan = new Scanner(reader);
			
			//get Universal set and number of subsets
			sizeUniSet = scan.nextInt();
			numSubsets = scan.nextInt();
			
			//create the universal set
			for(int i = 1; i <= sizeUniSet; i++) universalSet.add(i);
			
			//keep going if there is another line with another set
			while(scan.hasNextLine()){
				scan.nextLine();
				currentLine = scan.nextLine();
				
				//parse the line with a space as the delimiter
				String[] temp= currentLine.split(" ");
				
				//get the values from the line
				ArrayList<Integer> values = new ArrayList<Integer>();
				for(int i = 0; i < temp.length; i++){
					values.add(Integer.parseInt(temp[i]));
				}
				
				//get the weight of the subset
				weight = scan.nextInt();
				
				//create the subset
				Subset subset = new Subset(values, weight, subsetNum);
				subsetsList.add(subset);
				System.out.println("subsetsList size is: " + subsetsList.size());
				
			}
		}
		
		catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}
	
	public void verifier(){
		
		//check if each subset contains integers from the universal set
		System.out.println("Universal set is: " + universalSet.toString());
		System.out.println("subsets are: ");
		for(int i = 0; i < subsetsList.size(); i++){
			System.out.println("weight for current subset is: " + weightsList.get(i));
			for(int j = 0; j < subsetsList.get(i).length; j++){
				System.out.print(subsetsList.get(i)[j] + " ");
				if(universalSet.contains(subsetsList.get(i)[j]) == false){
					System.out.println();
					System.out.println("******* " + subsetsList.get(i)[j] + " not found it the universal set! **********" );
				}
			}
			System.out.println();
		}
	}
	
	public void displaySubsets(){
		for(Subset i : subsetsList){
			System.out.println(i.toString());
		}
	}
}
