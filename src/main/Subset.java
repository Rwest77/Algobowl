package main;

import java.util.ArrayList;

public class Subset{
	int subsetNum;
	int weight;
	ArrayList<Integer> subset;
	
	public Subset(ArrayList<Integer> subset, int weight, int subsetNum){
		this.subset = subset;
		this.weight = weight;
		this.subsetNum = subsetNum;
	}

	@Override
	public String toString() {
		return "Subset [subsetNum=" + subsetNum + ", weight=" + weight + ", subset=" + subset + "]";
	}
	
	
	
}
