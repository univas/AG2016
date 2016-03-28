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
		
		for(int generation = 0; generation < model.getGenerationQuantity(); generation++) {
		
			// Classificação
			Collections.sort(population);
			System.out.println("Geração: " + (generation + 1) + " // " + population.get(0));
			
			// Elitísmo
			nextGeneration = new ArrayList<>();
			
			if((model.getPopulationSize() % 2) == 0) {
				nextGeneration.add(population.get(0));
				nextGeneration.add(population.get(1));
			} else {
				nextGeneration.add(population.get(0));
			}
			
			while(nextGeneration.size() < model.getPopulationSize()) {
				// Seleção
				Individual individual1 = doSelection();
				Individual individual2 = doSelection();
				
				// Cruzamento
				doCrossing(individual1, individual2);

			}
			
			population = nextGeneration;
		}
			
		System.out.println();
		System.out.println(population.get(0));
//		for (Individual individual : population) {
//			System.out.println(individual);
//		}

	}

	private void doCrossing(Individual individual1, Individual individual2) {

		int crossPoint = (int) (Math.random() * (individual1.getCrhomossomeQuantity() - 1)) + 1;
		
		switch (model.getCrossType()) {
			case Binary: break;
				
			case Permutation:
				nextGeneration.add(doPermutationCrossing(individual1, individual2, crossPoint));
				nextGeneration.add(doPermutationCrossing(individual2, individual1, crossPoint));
				
				break;
		}
	}

	private Individual doPermutationCrossing(Individual first, Individual second, int crossPoint) {

		ArrayList<Chromossome> chromossomes = new ArrayList<Chromossome>();
		
		for(int i = 0; i < crossPoint; i++) {
			chromossomes.add(first.get(i));
		}
		
		for(int i = 0; i < first.size(); i++) {
			if(!chromossomes.contains(second.get(i))) {
				chromossomes.add(second.get(i));
			}
		}
		
		Individual individual = model.createIndividual();
		individual.addAll(chromossomes);
		individual.calculateValue();
		
		return individual;
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








