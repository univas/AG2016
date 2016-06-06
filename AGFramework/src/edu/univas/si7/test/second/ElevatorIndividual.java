package edu.univas.si7.test.second;

import java.util.ArrayList;

import edu.univas.si7.ag.Chromossome;
import edu.univas.si7.ag.Individual;
import edu.univas.si7.test.first.FirstTestChromossome;

public class ElevatorIndividual extends Individual {

	private static final int FLOOR[] = 
		{43,15,19,2,46,24,40,39,48,23,44,22,21,45,16,7};
	private static final int BITS = 16; 

	public ElevatorIndividual() {
		chromossomes = 
				new ArrayList<Chromossome>();

		for(int i = 0; i < BITS; i++) {
			chromossomes.add(
					new ElevatorChromossome(
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
		
		int elevatorATime = 0;
		int lastFloorA = 0;
		
		int elevatorBTime = 0;
		int lastFloorB = 0;
		
		for (int index = 0; index < chromossomes.size(); index++) {
			ElevatorChromossome chromossome = 
					(ElevatorChromossome) chromossomes.get(index);
			
			int choose = chromossome.getBit();
			
			if(choose == 0) {
				elevatorATime += 
						Math.abs(lastFloorA - FLOOR[index]) * 3 + 10;
				lastFloorA = FLOOR[index];
			} else {
				elevatorBTime += 
						Math.abs(lastFloorB - FLOOR[index]) * 3 + 10;
				lastFloorB = FLOOR[index];
			}
		}

		value = elevatorATime + elevatorBTime;
//		value = Math.max(elevatorATime, elevatorBTime);
		return value;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
