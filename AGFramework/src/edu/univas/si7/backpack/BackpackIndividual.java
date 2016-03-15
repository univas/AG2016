package edu.univas.si7.backpack;

import java.util.ArrayList;
import java.util.Collections;

import edu.univas.si7.ag.Chromossome;
import edu.univas.si7.ag.Individual;

public class BackpackIndividual extends Individual {
	
	public static final int CAPACITY_X = 12;
	public static final int CAPACITY_Y = 6;
	public static final int CAPACITY_Z = 6;

	private int itemsAmountX;
	private int itemsAmountY;
	private int itemsAmountZ;

	public BackpackIndividual() {
		chromossomes = new ArrayList<>();
		
		chromossomes.add(new BackpackChromossome("A", 11, 10));
		chromossomes.add(new BackpackChromossome("B", 6, 3));
		chromossomes.add(new BackpackChromossome("C", 2, 7));
		chromossomes.add(new BackpackChromossome("D", 1, 5));
		chromossomes.add(new BackpackChromossome("E", 7, 4));
		chromossomes.add(new BackpackChromossome("F", 5, 9));
		chromossomes.add(new BackpackChromossome("G", 10, 4));
		chromossomes.add(new BackpackChromossome("H", 4, 1));

		chromossomes.add(new BackpackChromossome("I", 4, 10));
		chromossomes.add(new BackpackChromossome("J", 2, 4));
		chromossomes.add(new BackpackChromossome("K", 5, 8));
		chromossomes.add(new BackpackChromossome("L", 1, 12));
		chromossomes.add(new BackpackChromossome("M", 6, 2));
		chromossomes.add(new BackpackChromossome("N", 3, 6));
		chromossomes.add(new BackpackChromossome("O", 7, 14));

		Collections.shuffle(chromossomes);
	}
	
	@Override
	public int compareTo(Individual obj) {
		if(value > obj.getValue()) {
			return -1;
		} else if(value < obj.getValue()) {
			return 1;
		}
			
		return 0;
	}

	@Override
	public float calculateValue() {
		value = 0;
		
		itemsAmountX = 0;
		itemsAmountY = 0;
		itemsAmountZ = 0;
		
		int totalWeightX = 0;
		int totalWeightY = 0;
		int totalWeightZ = 0;
		
		boolean bagXFull = false;
		boolean bagYFull = false;
		
		for (Chromossome chromossome : chromossomes) {
			if(!bagXFull) {
				totalWeightX += ((BackpackChromossome) chromossome).getWeight();
				
				if(totalWeightX > CAPACITY_X) {
					bagXFull = true;
				} else {
					value += ((BackpackChromossome) chromossome).getValue();
					itemsAmountX++;
					continue;
				}
			}
			
			if(/*bagXFull && */!bagYFull) {
				totalWeightY += ((BackpackChromossome) chromossome).getWeight();
				
				if(totalWeightY > CAPACITY_Y) {
					bagYFull = true;
				} else {
					value += ((BackpackChromossome) chromossome).getValue();
					itemsAmountY++;
					continue;
				}
			}
			
//			if(bagXFull && bagYFull)
			totalWeightZ += ((BackpackChromossome) chromossome).getWeight();
			
			if(totalWeightZ > CAPACITY_Z) {
				break;
			} else {
				value += ((BackpackChromossome) chromossome).getValue();
				itemsAmountZ++;
			}
			
		}
		
		return value;
	}

	@Override
	public String toString() {
		return super.toString() + " Quantidade: " + itemsAmountX + " " + itemsAmountY + " " + itemsAmountZ;
	}
}
