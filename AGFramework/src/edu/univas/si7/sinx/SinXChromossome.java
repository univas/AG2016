package edu.univas.si7.sinx;

import edu.univas.si7.ag.Chromossome;

public class SinXChromossome extends Chromossome {

	private int bit = 0;

	public SinXChromossome(int bit) {
		super();
		this.bit = bit;
	}

	public int getBit() {
		return bit;
	}

	public void setBit(int bit) {
		this.bit = bit;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinXChromossome other = (SinXChromossome) obj;
		if (bit != other.bit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(bit);
	}

	@Override
	public void doMutation() {
		if(bit == 0) {
			bit = 1;
		} else {
			bit = 0;
		}
		
	}
}
