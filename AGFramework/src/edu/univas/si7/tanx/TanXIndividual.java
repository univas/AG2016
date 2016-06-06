package edu.univas.si7.tanx;

import java.util.ArrayList;

import edu.univas.si7.ag.Chromossome;
import edu.univas.si7.ag.Individual;

public class TanXIndividual extends Individual {

	private float x = 0;
	
	private static final int BITS = 20; 
	private static final float MIN = 2; 
	private static final float MAX = 4; 

	public TanXIndividual() {
		chromossomes = 
				new ArrayList<Chromossome>();

		for(int i = 0; i < BITS; i++) {
			chromossomes.add(
					new TanXChromossome(
							(int) Math.round(Math.random())));
		}
	}
	
	@Override
	public int compareTo(Individual obj) {
		if(value == obj.getValue()) {
			return 0;
		} else if(value < obj.getValue()){
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public float calculateValue() {
		value = 0;
		
		StringBuilder strBuilder = new StringBuilder();
		
		for(int i = 0; i < BITS; i++) {
			TanXChromossome c = (TanXChromossome) chromossomes.get(i);
			strBuilder.append(c.getBit());
		}
		
		int xBits = Integer.parseInt(strBuilder.toString(), 2);
		
		x = (float) ((xBits * (MAX - MIN)) / 
				(Math.pow(2, BITS) - 1) + MIN);
		
		value = (float) Math.abs(Math.tan(x));
		
		return value;
	}

	@Override
	public String toString() {
		return super.toString() + " x: " + x;
	}
}
