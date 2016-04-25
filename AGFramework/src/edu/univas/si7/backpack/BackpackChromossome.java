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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BackpackChromossome other = (BackpackChromossome) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public void doMutation() {
		// TODO Auto-generated method stub
		
	}

}
