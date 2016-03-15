package edu.univas.si7.salesman;

import java.util.ArrayList;
import java.util.Collections;

import edu.univas.si7.ag.Chromossome;
import edu.univas.si7.ag.Individual;

public class SalesmanIndividual extends Individual {

	public SalesmanIndividual() {
		chromossomes = 
				new ArrayList<Chromossome>();
		
		chromossomes.add(new SalesmanChromossome("A", 7, 5));
		chromossomes.add(new SalesmanChromossome("B", 2, 5));
		chromossomes.add(new SalesmanChromossome("C", 10, 15));
		chromossomes.add(new SalesmanChromossome("D", 1, 1));
		chromossomes.add(new SalesmanChromossome("E", 7, 9));
		chromossomes.add(new SalesmanChromossome("F", 3, 5));
		chromossomes.add(new SalesmanChromossome("G", 2, 1));

		Collections.shuffle(chromossomes);
	}
	
	@Override
	public int compareTo(Individual obj) {
		if(value == obj.getValue()) {
			return 0;
		} else if(value < obj.getValue()){
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public float calculateValue() {
		value = 0;
		
		SalesmanChromossome chromossomeCurrent = 
				(SalesmanChromossome) chromossomes.get(chromossomes.size() - 1);
		
		for (Chromossome chromossome : chromossomes) {
			value += calculateDistance(chromossomeCurrent, (SalesmanChromossome) chromossome);
			chromossomeCurrent = (SalesmanChromossome) chromossome;
		}
		
		return value;
	}

	public float calculateDistance(SalesmanChromossome c1, SalesmanChromossome c2) {
		float value = 0;
		
		value = (float) Math.sqrt(Math.pow(c2.getX() - c1.getX(), 2) + 
								  Math.pow(c2.getY() - c1.getY(), 2));
		
		return value;
	}

}
