package main;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args){
		CreateInput input = new CreateInput();
		CreateSets sets = new CreateSets();
		sets.createSets("inputFile.txt");
		if(sets.verifyInput() == false) System.exit(0);
		System.out.println();
		System.out.println();
		//sets.displaySubsets();
		Algorithm algo = new Algorithm(sets.getSizeUniSet(), sets.getSubsetsList());
		algo.doAlgorithm();
	}

}
