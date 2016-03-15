package edu.univas.si7.ag;

public abstract class AGModel {

	private int populationSize = 25;
	
//	public abstract ArrayList<Individual> createInitialPopulation();
	public abstract Individual createIndividual();

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}
	
}
