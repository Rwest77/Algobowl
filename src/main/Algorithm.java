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
	ArrayList<Integer> foundRed;
	ArrayList<Integer> redundancy;
	//ArrayList<Subset> subsets;
	
	Algorithm(int sizeUniSet, ArrayList<Subset> subsets) {
		foundRed = new ArrayList<Integer>();
		redundancy = new ArrayList<Integer>();
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
				//TODO: add all elements of current subset to new arraylist to find all redundancies
				totalWeight += i.weight;
				for(int k : i.elements){
					redundancy.add(k);
				}
			}
			if(elementsUsed.size() == universalSet.size()){
				break;
			}
		}

		//output the subsets used and their weights
		System.out.println("redundancy is: " + redundancy.toString());
		System.out.println("subsets used were: " + subSetsUsed.toString());
		System.out.println("Total weight was: " + totalWeight);
	}
	
	public void removeRed(){
		boolean test = true;
		Collections.sort(redundancy);
		System.out.println("redundancy: " + redundancy.toString());
		for(int i = 0; i < redundancy.size() - 1; i++){
			
			if(redundancy.get(i) == redundancy.get(i+1)){
				foundRed.add(redundancy.get(i));
			}
		}
		System.out.println("foundRed: " + foundRed.toString());

		for(Subset j : sortedSets){
			if(!subSetsUsed.contains(j.subsetNum)) continue; 
			test = true;

			//found subset that is in subSetsUsed, j is the subset
			for(int k : j.elements){
				
				System.out.println("j elements: " + j.elements.toString());
				System.out.println("k is: " + k);
				if(foundRed.contains(k) == false){
					test = false; 
					//subset j has an element that is not redundant
					break;
				}
			}
			
			//j has an element
			if(test == true){
				System.out.println("removed redundancy: " + j.subsetNum);
				totalWeight -= j.weight;
				subSetsUsed.remove(j.subsetNum);
				for(int k : j.elements){
					System.out.println("foundRed.indexOf(k) is: " + foundRed.indexOf(k));
					foundRed.remove(foundRed.indexOf(k));
				}
			}
		}
		System.out.println("new subSetsUsed is: " + subSetsUsed);
		System.out.println("new weight is: " + totalWeight);
		System.out.println("redundancy is: " + foundRed.toString());
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
