package edu.univas.si7.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AGFramework {

	private AGModel model;
	private ArrayList<Individual> population;
	private ArrayList<Individual> nextGeneration;
	
	private int maxValue = 0;

	public AGFramework(AGModel model) {
		this.model = model;
	}
	
	public void execute() {
		
		population = new ArrayList<Individual>();
		
		// Criando a população inicial
		for(int i = 0; i < model.getPopulationSize(); i++) {
			Individual individual = model.createIndividual();
			individual.calculateValue();
			
			population.add(individual);
		}
		
		// Início do futuro for de gerações
		
			// Classificação
			Collections.sort(population);
			
			// Elitísmo
			nextGeneration = new ArrayList<>();
			
			if((model.getPopulationSize() % 2) == 0) {
				nextGeneration.add(population.get(0));
				nextGeneration.add(population.get(1));
			} else {
				nextGeneration.add(population.get(0));
			}
			
			// Seleção
			Individual individual1 = doSelection();
			Individual individual2 = doSelection();

			System.out.println("I1: " + individual1);
			System.out.println("I2: " + individual2);
			
		// Fim do futuro for de gerações
			
		System.out.println();
		for (Individual individual : population) {
			System.out.println(individual);
		}

	}

	public Individual doSelection() {
		
		if(maxValue == 0) {
			for(int i = 1; i <= model.getPopulationSize(); i++) {
				maxValue += i;
			}
		}		

//		int selection = (int) ((Math.random() * maxValue) + 1);
		
		Random random = new Random();
		int selection = random.nextInt(maxValue) + 1;
		
		for(int i = 0; i < population.size(); i++) {
			int index = population.size() - i;
			
			if(selection > index) {
				selection -= index;
				continue;
			} else {
				return population.get(i);
			}
		}
		
		return null;
	}
}








