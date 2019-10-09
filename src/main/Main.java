package main;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args){
//		CreateInput input = new CreateInput();
		CreateSets sets = new CreateSets();
		sets.createSets("testFile");
		if(sets.verifyInput() == false) System.exit(0);
		//sets.displaySubsets();
		Algorithm algo = new Algorithm(sets.getSizeUniSet(), sets.getSubsetsList());
		algo.doAlgorithm();
		algo.removeRed();
		algo.outputFile();
		algo.verifyOutput();
//		VerifyOutput verify = new VerifyOutput(sets.getSizeUniSet(), sets.getSubsetsList(), "outputFile.txt")
		
	}

}
