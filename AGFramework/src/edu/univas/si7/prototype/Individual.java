package edu.univas.si7.prototype;

import java.util.ArrayList;
import java.util.Collections;

public class Individual implements Comparable<Individual> {

	private ArrayList<Chromossome> chromossomes;
	private float totalValue; 
	
	public Individual() {
		chromossomes = 
				new ArrayList<Chromossome>();
		
		chromossomes.add(new Chromossome("A", 7, 5));
		chromossomes.add(new Chromossome("B", 2, 5));
		chromossomes.add(new Chromossome("C", 10, 15));
		chromossomes.add(new Chromossome("D", 1, 1));
		chromossomes.add(new Chromossome("E", 7, 9));
		chromossomes.add(new Chromossome("F", 3, 5));
		chromossomes.add(new Chromossome("G", 2, 1));

		Collections.shuffle(chromossomes);
		
		calculateTotalValue();
	}
	
	public void calculateTotalValue() {
		totalValue = 0;
		
		Chromossome chromossomeCurrent = chromossomes.get(chromossomes.size() - 1);
		
		for (Chromossome chromossome : chromossomes) {
			totalValue += calculateDistance(chromossomeCurrent, chromossome);
			chromossomeCurrent = chromossome;
		}
	}
	
	public float calculateDistance(Chromossome c1, Chromossome c2) {
		float value = 0;
		
		value = (float) Math.sqrt(Math.pow(c2.getX() - c1.getX(), 2) + 
								  Math.pow(c2.getY() - c1.getY(), 2));
		
		return value;
	}
	
	public float getTotalValue() {
		return totalValue;
	}
	
	@Override
	public String toString() {
		return "" + chromossomes + " Value: " + totalValue;
	}

	@Override
	public int compareTo(Individual obj) {
		if(totalValue == obj.totalValue) {
			return 0;
		} else if(totalValue < obj.totalValue){
			return -1;
		} else {
			return 1;
		}
	}
}
