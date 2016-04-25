package edu.univas.si7.sinx;

import edu.univas.si7.ag.AGModel;
import edu.univas.si7.ag.Individual;

public class SinXModel extends AGModel {

	@Override
	public Individual createIndividual() {
		return new SinXIndividual();
	}

}
