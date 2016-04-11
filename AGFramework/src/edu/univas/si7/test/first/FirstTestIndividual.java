package edu.univas.si7.test.first;

import java.util.ArrayList;
import java.util.Collections;

import edu.univas.si7.ag.Chromossome;
import edu.univas.si7.ag.Individual;

public class FirstTestIndividual extends Individual {

	public FirstTestIndividual() {
		chromossomes = 
				new ArrayList<Chromossome>();
		
		chromossomes.add(new FirstTestChromossome(43));
		chromossomes.add(new FirstTestChromossome(46));
		chromossomes.add(new FirstTestChromossome(48));
		chromossomes.add(new FirstTestChromossome(21));
		chromossomes.add(new FirstTestChromossome(15));
		chromossomes.add(new FirstTestChromossome(24));
		chromossomes.add(new FirstTestChromossome(23));
		chromossomes.add(new FirstTestChromossome(45));
		chromossomes.add(new FirstTestChromossome(19));
		chromossomes.add(new FirstTestChromossome(40));
		chromossomes.add(new FirstTestChromossome(44));
		chromossomes.add(new FirstTestChromossome(16));
		chromossomes.add(new FirstTestChromossome(02));
		chromossomes.add(new FirstTestChromossome(39));
		chromossomes.add(new FirstTestChromossome(22));
		chromossomes.add(new FirstTestChromossome(07));

		Collections.shuffle(chromossomes);
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
		
		for (Chromossome chromossome : chromossomes) {
			int floor = ((FirstTestChromossome) chromossome).getFloor();
			
			if(floor % 2 != 0) {
				elevatorATime += Math.abs(lastFloorA - floor) * 3 + 10;
				lastFloorA = floor;
			} else {
				elevatorBTime += Math.abs(lastFloorB - floor) * 3 + 10;
				lastFloorB = floor;
			}
		}

		value = elevatorATime + elevatorBTime;
//		value = Math.max(elevatorATime, elevatorBTime);
		return value;
	}

}
