package main;

import java.util.ArrayList;


public class Subset implements Comparable<Subset>{
	int subsetNum;
	int weight;
	double value;
	ArrayList<Integer> elements;
	
	public Subset(ArrayList<Integer> subset, int weight, int subsetNum){
		this.elements = subset;
		this.weight = weight;
		this.subsetNum = subsetNum;
		value =(double) (this.weight)/subset.size() *1000;
	}
	
	@Override
	public String toString() {
		return "Subset [subsetNum=" + subsetNum + ", weight=" + weight + ", value=" + value + ", elements=" + elements
				+ "]";
	}


	@Override
	public int compareTo(Subset o){
		int x = (int) (value);
		int y = (int) (o.value);
		return (x-y);
	}
	
	
	
}
