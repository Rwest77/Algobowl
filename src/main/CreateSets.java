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
		int subsetNum = 0;
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
				subsetNum++;
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
			}
		}
		
		catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}
	
	public void verifier(){
		int elementMissing = 0;
		Set<Integer> universalSetCopy = new HashSet<Integer>();
		universalSetCopy.addAll(universalSet);
		
		//check if each subset contains integers from the universal set
		System.out.println("Universal set is: " + universalSet.toString());
		System.out.println("subsets are: ");
		
		//Iterate through all subsets
		for(Subset i : subsetsList){
			System.out.println();
			System.out.println("Subset number is: " + i.subsetNum);
			System.out.println("weight for current subset is: " + i.weight);
			System.out.print("elements are: ");
			
			//Iterate through the elements in the subset
			for(int j : i.elements){
				universalSetCopy.remove(j);
				System.out.print(j + " ");
				if(universalSet.contains(j) == false){
					elementMissing = j;
					System.out.println();
					System.out.println("******* " + j + " not found it the universal set! **********" );
				}
			}
			System.out.println();
		}
		
		if(elementMissing != 0){
			System.out.println(elementMissing + " not found in the universal set!!");
		}
		
		if(universalSetCopy.size() != 0){
			System.out.println("Not all elements found in the subsets");
			System.out.println("Elements not found in the subsets that are in the univeral set are: "
					+ universalSetCopy.toString());
		}
	}
	
	public void displaySubsets(){
		for(Subset i : subsetsList){
			System.out.println(i.toString());
		}
	}
}
