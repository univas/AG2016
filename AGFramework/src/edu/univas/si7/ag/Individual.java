package edu.univas.si7.ag;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Individual implements Comparable<Individual> {

	protected ArrayList<Chromossome> chromossomes;
	protected float value;
	
	public abstract float calculateValue();
	
	public Individual() {

	}
	
	public Individual(ArrayList<Chromossome> chromossomes) {
		this.chromossomes = chromossomes;
	}
	
	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getCrhomossomeQuantity() {
		return chromossomes.size();
	}
	
	public Chromossome get(int index) {
		return chromossomes.get(index);
	}

	public int size() {
		return chromossomes.size();
	}

	public boolean addAll(Collection<? extends Chromossome> c) {
		chromossomes.clear();
		return chromossomes.addAll(c);
	}

	@Override
	public String toString() {
		return "" + chromossomes + " Value: " + value;
	}
}
