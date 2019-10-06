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
	
	Algorithm(int sizeUniSet) {
		foundRed = new HashSet<Integer>();
		elementsUsed = new ArrayList<Integer>();
		subSetsUsed = new HashSet<Integer>();
		universalSet = new HashSet<Integer>();
		for(int i = 1; i <= sizeUniSet; i++) universalSet.add(i);
		totalWeight = 0;
		
	}
	
	void sortSets (ArrayList<Subset> arr) { //sort sets by weight/size
		sortedSets = new ArrayList<Subset>();
		Collections.sort(arr);
		sortedSets = arr;
	}
	
	public void doAlgorithm(){
		
		for(Subset i : sortedSets){
			for(int j : i.elements){
				if(elementsUsed.contains(j) != true){
					subSetsUsed.add(i.subsetNum);
					elementsUsed.add(j);
				}
			}
			if(elementsUsed.size() == universalSet.size()){
				break;
			}
		}
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
