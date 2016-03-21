package edu.univas.si7.ag;

import java.util.ArrayList;

public abstract class Individual implements Comparable<Individual> {

	protected ArrayList<Chromossome> chromossomes;
	protected float value;
	
	public abstract float calculateValue();

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getCrhomossomeQuantity() {
		return chromossomes.size();
	}
	
	@Override
	public String toString() {
		return "" + chromossomes + " Value: " + value;
	}
}
