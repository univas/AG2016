package edu.univas.si7.test.first;

import edu.univas.si7.ag.Chromossome;

public class FirstTestChromossome extends Chromossome {

	private int floor = 0;

	public FirstTestChromossome(int floor) {
		super();
		this.floor = floor;
	}

	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	@Override
	public String toString() {
		return String.valueOf(floor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floor;
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
		FirstTestChromossome other = (FirstTestChromossome) obj;
		if (floor != other.floor)
			return false;
		return true;
	}

}
