package edu.univas.si7.ag;

public abstract class AGModel {

	private int populationSize = 25;
	private int generationQuantity = 10;
	
//	public abstract ArrayList<Individual> createInitialPopulation();
	public abstract Individual createIndividual();

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public int getGenerationQuantity() {
		return generationQuantity;
	}

	public void setGenerationQuantity(int generationQuantity) {
		this.generationQuantity = generationQuantity;
	}
	
}
