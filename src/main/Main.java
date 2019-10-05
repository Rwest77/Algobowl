package main;

public class Main {
	
	public static void main(String[] args) {
		CreateSets sets = new CreateSets();
		sets.createSets("Input File");
		sets.verifier();
		System.out.println();
		System.out.println();
		sets.displaySubsets();
	}

}
