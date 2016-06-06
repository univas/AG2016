package edu.univas.si7.tanx;

import edu.univas.si7.ag.AGModel;
import edu.univas.si7.ag.Individual;

public class TanXModel extends AGModel {

	@Override
	public Individual createIndividual() {
		return new TanXIndividual();
	}

}
