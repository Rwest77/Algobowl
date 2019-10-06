package main;

public class Main {
	
	public static void main(String[] args) {
		CreateSets sets = new CreateSets();
		sets.createSets("Input File");
		if(sets.verifier() == false) System.exit(0);
		System.out.println();
		System.out.println();
		sets.displaySubsets();
		Algorithm algo = new Algorithm(sets.getSizeUniSet(), sets.getSubsetsList());
		algo.doAlgorithm();
	}

}
