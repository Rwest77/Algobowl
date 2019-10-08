package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class VerifyOutput {

	public VerifyOutput(int sizeUniSet, ArrayList<Subset> subsets, String filename){
		
		String currentLine;
		FileReader reader;
		Scanner scan;
		
		try{
			reader = new FileReader(filename);
			scan = new Scanner(reader);
		}
		
		catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}
}
