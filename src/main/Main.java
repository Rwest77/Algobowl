package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	
	public void createSets(String filename){
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
	
	public static void main(String[] args) {
		
	}

}
