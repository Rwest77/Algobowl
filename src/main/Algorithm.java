package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Algorithm {
	ArrayList<Subset> sortedSets;
	
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
			if(newSubset == true) totalWeight += i.weight;
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
		System.out.println(elementsUsed.toString());
		for(int i = 0; i < elementsUsed.size() - 1; i++){
			
			if(elementsUsed.get(i) == elementsUsed.get(i+1)){
				foundRed.add(elementsUsed.get(i));
			}
		}
	}
	
	
}
