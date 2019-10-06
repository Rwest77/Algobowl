package main;

import java.util.ArrayList;


public class Subset implements Comparable<Subset>{
	int subsetNum;
	int weight;
	int value;
	ArrayList<Integer> elements;
	
	public Subset(ArrayList<Integer> subset, int weight, int subsetNum){
		this.elements = subset;
		this.weight = weight;
		this.subsetNum = subsetNum;
		value =this.weight/subset.size();
	}

	public String toString() {
		return "Subset [subsetNum=" + subsetNum + ", weight=" + weight + ", subset=" + elements + "]";
	}
	
	@Override
	public int compareTo(Subset o){
		return value - o.value;
	}
	
	
	
}
