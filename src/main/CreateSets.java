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

	public CreateSets(){
		subsetsList = new ArrayList<Subset>();
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
				System.out.println("currentLine is: " + currentLine);
				
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
	
/*	checks that the input file is valid
	check that the number of subsets specified in the input file match the number of subsets made
	check if there are elements in subsets that aren't in the universal set
	check if there are elements in the universal set that are not in any subset*/

	public Boolean verifyInput(){
		boolean validInput = true;
		int elementMissing = 0;
		Set<Integer> universalSetCopy = new HashSet<Integer>();
		universalSetCopy.addAll(universalSet);
		
		//check if each subset contains integers from the universal set
		System.out.println("Universal set is: " + universalSet.toString());
		
		//Iterate through all subsets
		for(Subset i : subsetsList){
//			System.out.println();
//			System.out.println("Subset number is: " + i.subsetNum);
//			System.out.println("weight for current subset is: " + i.weight);
//			System.out.print("elements are: ");
			
			//Iterate through the elements in the subset
			for(int j : i.elements){
				universalSetCopy.remove(j);
//				System.out.print(j + " ");
				if(universalSet.contains(j) == false){
					elementMissing = j;
//					System.out.println();
					System.out.println("******* " + j + " not found it the universal set! **********" );
				}
			}
//			System.out.println();
		}
		
		//check that the number of subsets specified in the input file match the number of subsets made
		if(numSubsets != subsetsList.size()) {
			System.out.println("Number of subsets specified in the input file does not match "
					+ " the number of subsets made");
			validInput = false;
		}
					
		
		//check if there are elements in subsets that aren't in the universal set
		if(elementMissing != 0) {
			System.out.println(elementMissing + " not found in the universal set!!");
			validInput = false;
		}
		
		//check if there are elements in the universal set that are not in any subset
		if(universalSetCopy.size() != 0){
			System.out.println("Not all elements found in the subsets");
			System.out.println("Elements not found in the subsets that are in the univeral set are: "
					+ universalSetCopy.toString());
			validInput = false;
		}
		return validInput;
	}
	
	public void displaySubsets(){
		System.out.println("Subsets are: ");
		for(Subset i : subsetsList) System.out.println(i.toString());
		
	}

	
	//setters and getters
	public int getSizeUniSet() {
		return sizeUniSet;
	}

	public void setSizeUniSet(int sizeUniSet) {
		this.sizeUniSet = sizeUniSet;
	}

	public int getNumSubsets() {
		return numSubsets;
	}

	public void setNumSubsets(int numSubsets) {
		this.numSubsets = numSubsets;
	}

	public int getSubsetsWeight() {
		return subsetsWeight;
	}

	public void setSubsetsWeight(int subsetsWeight) {
		this.subsetsWeight = subsetsWeight;
	}

	public Set<Integer> getUniversalSet() {
		return universalSet;
	}

	public void setUniversalSet(Set<Integer> universalSet) {
		this.universalSet = universalSet;
	}

	public ArrayList<Subset> getSubsetsList() {
		return subsetsList;
	}

	public void setSubsetsList(ArrayList<Subset> subsetsList) {
		this.subsetsList = subsetsList;
	}
	
	
}
