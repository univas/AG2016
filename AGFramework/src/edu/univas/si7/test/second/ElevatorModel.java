package edu.univas.si7.test.second;

import edu.univas.si7.ag.AGModel;
import edu.univas.si7.ag.Individual;

public class ElevatorModel extends AGModel {

	@Override
	public Individual createIndividual() {
		return new ElevatorIndividual();
	}

}
