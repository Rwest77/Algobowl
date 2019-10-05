package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Algorithm {
	ArrayList<Subsets> sortedSets;
	
	//these 3 variables will make up the output
	int totalWeight;
	int[] subSetsUsed = {};
	Set<Integer> universalSet;
	
	
	Algorithm(int sizeUniSet) {
		universalSet = new HashSet<Integer>();
		for(int i = 1; i <= sizeUniSet; i++) universalSet.add(i);
		totalWeight = 0;
		
	}
	
	void sortSets (ArrayList<Subsets> arr) { //sort sets by weight/size
		sortedSets = new ArrayList<Subsets>();
		Collections.sort(arr);
		sortedSets = arr;
	}
	
	
}
