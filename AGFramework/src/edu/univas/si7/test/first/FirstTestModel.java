package edu.univas.si7.test.first;

import edu.univas.si7.ag.AGModel;
import edu.univas.si7.ag.Individual;

public class FirstTestModel extends AGModel {

	@Override
	public Individual createIndividual() {
		return new FirstTestIndividual();
	}

}
