package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Algorithm {
	ArrayList<Subset> sortedSets;
	
	FileWriter file = null;
	BufferedWriter buffer = null;
	PrintWriter output = null;
	
	//these 3 variables will make up the output
	int totalWeight;
	Set<Integer> subSetsUsed;
	Set<Integer> universalSet;
	ArrayList<Integer> elementsUsed;
	Set<Integer> foundRed;
	
	Algorithm(int sizeUniSet, ArrayList<Subset> subsets) {
		foundRed = new HashSet<Integer>();
		elementsUsed = new ArrayList<Integer>();
		subSetsUsed = new HashSet<Integer>();
		universalSet = new HashSet<Integer>();
		for(int i = 1; i <= sizeUniSet; i++) universalSet.add(i);
		totalWeight = 0;
		sortSets(subsets);
	}
	
	//sort sets by weight/size
	void sortSets (ArrayList<Subset> arr) { 
		sortedSets = new ArrayList<Subset>();
		Collections.sort(arr);
		sortedSets = arr;
	}
	
	public void doAlgorithm(){
		boolean newSubset = false;
		for(Subset i : sortedSets){
			newSubset = false;
			for(int j : i.elements){
				if(elementsUsed.contains(j) != true){
					newSubset = true;
					subSetsUsed.add(i.subsetNum);
					elementsUsed.add(j);
				}
			}
			if(newSubset == true){
				//TODO: add all elements of current subset to new arraylist
				totalWeight += i.weight;
			}
			if(elementsUsed.size() == universalSet.size()){
				break;
			}
		}

		//output the subsets used and their weights
		System.out.println();
		System.out.println("subsets used were: " + subSetsUsed.toString());
		System.out.println("Total weight was: " + totalWeight);
	}
	
	public void removeRed(){
		Collections.sort(elementsUsed);
		System.out.println("elements used: " + elementsUsed.toString());
		for(int i = 0; i < elementsUsed.size() - 1; i++){
			
			if(elementsUsed.get(i) == elementsUsed.get(i+1)){
				foundRed.add(elementsUsed.get(i));
			}
		}
	}
	
	//generate the output file based on the algorithm
	public void outputFile(){
		
		try{
			file = new FileWriter("outputFile.txt", false);
			buffer = new BufferedWriter(file);
			output = new PrintWriter(buffer);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		output.println(this.totalWeight);
		for(int i : subSetsUsed){
			output.print(i + " ");
		}
		output.close();
	}
	
	
}
