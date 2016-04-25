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
			
			// Individuos Estrangeiros
			int foreignQuantity = 
					Math.round(model.getPopulationSize() 
							* model.getForeignRate() / 100f);
			
			if(foreignQuantity % 2 != 0) {
				foreignQuantity++;
			}
			
			for(int i = 0; i < foreignQuantity; i++) {
				Individual individual = model.createIndividual();
				individual.calculateValue();
				
				nextGeneration.add(individual);
			}
			
			// Cruzamento e Mutação
			while(nextGeneration.size() < model.getPopulationSize()) {
				// Seleção
				Individual individual1 = doSelection();
				Individual individual2 = doSelection();
				
				// Cruzamento
				doCrossing(individual1, individual2);

				doMutation();
				
			}
			
			population = nextGeneration;
		}
			
		System.out.println();
		System.out.println(population.get(0));
//		for (Individual individual : population) {
//			System.out.println(individual);
//		}

	}
	
	private void doMutation() {

		Individual individual1 = nextGeneration.get(nextGeneration.size() - 1);
		Individual individual2 = nextGeneration.get(nextGeneration.size() - 2);
		
		switch (model.getMutationType()) {
			case Binary: 
				doBinaryMutation(individual1);
				doBinaryMutation(individual2);
	
				break;
			
			case Permutation:
				doPermutationMutation(individual1);
				doPermutationMutation(individual2);
				
				break;
		}
	}


	private void doPermutationMutation(Individual individual) {

		float rate = model.getMutationRate() / 100f;
		
		if(Math.random() < rate) {
			int indexC1 = (int) (individual.getCrhomossomeQuantity() * Math.random());
			int indexC2 = (int) (individual.getCrhomossomeQuantity() * Math.random());
			
			Chromossome c1 = individual.get(indexC1);
			Chromossome c2 = individual.get(indexC2);
			
			individual.set(indexC1, c2);
			individual.set(indexC2, c1);
			
			individual.calculateValue();
		}
		
	}

	private void doBinaryMutation(Individual individual) {

		float rate = model.getMutationRate() / 100f;
		
		if(Math.random() < rate) {
			int indexC1 = (int) (individual.getCrhomossomeQuantity() * Math.random());
			
			Chromossome c1 = individual.get(indexC1);
			c1.doMutation();
			
			individual.calculateValue();
		}
		
	}

	private void doCrossing(Individual individual1, Individual individual2) {

		int crossPoint = (int) (Math.random() * (individual1.getCrhomossomeQuantity() - 1)) + 1;
		
		switch (model.getCrossType()) {
			case Binary: 
				nextGeneration.add(doBinaryCrossing(individual1, individual2, crossPoint));
				nextGeneration.add(doBinaryCrossing(individual2, individual1, crossPoint));
				
				break;
			
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

	private Individual doBinaryCrossing(Individual first, Individual second, int crossPoint) {

		ArrayList<Chromossome> chromossomes = new ArrayList<Chromossome>();
		
		for(int i = 0; i < crossPoint; i++) {
			chromossomes.add(first.get(i));
		}
		
		for(int i = crossPoint; i < first.size(); i++) {
			chromossomes.add(second.get(i));
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








