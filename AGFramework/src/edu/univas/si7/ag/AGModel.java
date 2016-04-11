package edu.univas.si7.ag;

public abstract class AGModel {

	public static enum CrossType { Permutation, Binary };
	public static enum MutationType { Permutation, Binary };
	
	private int populationSize = 25;
	private int generationQuantity = 10;
	private int crossPointQuantity = 1;
	private CrossType crossType = CrossType.Permutation;
	private MutationType mutationType = MutationType.Permutation;
	
	private int foreignRate = 10;
	private int mutationRate = 3;
	
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

	public int getCrossPointQuantity() {
		return crossPointQuantity;
	}

	public void setCrossPointQuantity(int crossPointQuantity) {
		this.crossPointQuantity = crossPointQuantity;
	}

	public CrossType getCrossType() {
		return crossType;
	}

	public void setCrossType(CrossType crossType) {
		this.crossType = crossType;
	}

	public int getForeignRate() {
		return foreignRate;
	}

	public void setForeignRate(int foreignRate) {
		this.foreignRate = foreignRate;
	}

	public int getMutationRate() {
		return mutationRate;
	}

	public void setMutationRate(int mutationRate) {
		this.mutationRate = mutationRate;
	}

	public MutationType getMutationType() {
		return mutationType;
	}

	public void setMutationType(MutationType mutationType) {
		this.mutationType = mutationType;
	}

	
}
