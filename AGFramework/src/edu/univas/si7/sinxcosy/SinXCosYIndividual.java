package edu.univas.si7.sinxcosy;

import java.util.ArrayList;

import edu.univas.si7.ag.Chromossome;
import edu.univas.si7.ag.Individual;

public class SinXCosYIndividual extends Individual {

	private float x = 0;
	private float y = 0;
	
	private static final int BITS = 20; 
	private static final float MIN = 0; 
	private static final float MAX = (float) Math.PI * 2; 

	public SinXCosYIndividual() {
		chromossomes = 
				new ArrayList<Chromossome>();

		for(int i = 0; i < 2 * BITS; i++) {
			chromossomes.add(
					new SinXCosYChromossome(
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
		
		
		// Parte X
		
		for(int i = 0; i < BITS; i++) {
			SinXCosYChromossome c = (SinXCosYChromossome) chromossomes.get(i);
			strBuilder.append(c.getBit());
		}
		
		int xBits = Integer.parseInt(strBuilder.toString(), 2);
		
		x = (float) ((xBits * (MAX - MIN)) / 
				(Math.pow(2, BITS) - 1) + MIN);
		
		
		// Parte Y
		
		strBuilder = new StringBuilder();
		
		for(int i = BITS; i < 2 * BITS; i++) {
			SinXCosYChromossome c = (SinXCosYChromossome) chromossomes.get(i);
			strBuilder.append(c.getBit());
		}
		
		int yBits = Integer.parseInt(strBuilder.toString(), 2);
		
		y = (float) ((yBits * (MAX - MIN)) / 
				(Math.pow(2, BITS) - 1) + MIN);
		
				
		value = (float) (Math.sin(x) + Math.cos(y));
		
		return value;
	}

	@Override
	public String toString() {
		return super.toString() + " x: " + x + " y: " + y;
	}
}
