package edu.univas.si7.prototype;

import java.util.ArrayList;
import java.util.Collections;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Individual> individuals = 
				new ArrayList<>();
		
		for(int i = 0; i < 25; i++) {
			individuals.add(new Individual());
		}
		
		Collections.sort(individuals);
		
		for (Individual individual : individuals) {
			System.out.println(individual);
		}
	}
}
