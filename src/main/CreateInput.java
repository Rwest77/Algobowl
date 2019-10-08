package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CreateInput {
	
	//universal set size
	int uniSetSize;
	
	//number of subsets
	int numSubsets; 
	
	//number of elements in a set
	int elements;
	
	//weight
	int weight;
	
	int randNum;
	Set<Integer> usedNums = new HashSet<Integer>();
	FileWriter file = null;
	BufferedWriter buffer = null;
	PrintWriter output = null;
	
	Random rand = new Random();

	public CreateInput(){
		
		
		try{
			file = new FileWriter("inputFile.txt", false);
			buffer = new BufferedWriter(file);
			output = new PrintWriter(buffer);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		//generate n
		uniSetSize = rand.nextInt(399) + 600;
		System.out.println("n is: " + uniSetSize);
		output.println(uniSetSize);
		
		//generate m
		numSubsets = rand.nextInt(199) + 300;
		System.out.println("m is: " + numSubsets);
		output.println(numSubsets);
		
		//create m number of sets
		for(int i = 0; i < numSubsets; i++){
			usedNums.clear();
			
			//create a random number of elements for that set
			elements = rand.nextInt(300) + 2;
			System.out.println("elements is: " + elements);
			for(int j = 0; j < elements; j++){
				
				//generate a random element
				randNum = rand.nextInt(uniSetSize) + 1;
				System.out.println("randNum is: " + randNum);
				while(usedNums.contains(randNum) == true){
					System.out.println("in loop");
					randNum = rand.nextInt(uniSetSize) + 1;
				}
				usedNums.add(randNum);
				
				//check if this is the last element to put in the set
				if((j + 1) == elements){
					output.println(randNum);
					continue;
				}
				else{
					output.print((randNum) + " ");
				}
			}
			
			//generate weight
			if(i + 1 == numSubsets){
				output.print(rand.nextInt(998) + 1);

			}
			else{
				output.println(rand.nextInt(998) + 1);
			}
		}
		System.out.println("Finished Creating input");
		output.close();
	}
}
