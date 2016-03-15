package edu.univas.si7.backpack;

import edu.univas.si7.ag.AGModel;
import edu.univas.si7.ag.Individual;

public class BackpackModel extends AGModel {

	@Override
	public Individual createIndividual() {
		return new BackpackIndividual();
	}

}
