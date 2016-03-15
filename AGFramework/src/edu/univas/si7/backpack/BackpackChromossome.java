package edu.univas.si7.backpack;

import edu.univas.si7.ag.Chromossome;

public class BackpackChromossome extends Chromossome {

	private String name;
	private int weight;
	private int value;
	
	public BackpackChromossome(String name, int weight, int value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
	}

	@Override
	public String toString() {
		return name + " " + weight + " " + value;
//		return name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
