package edu.univas.si7.salesman;

import edu.univas.si7.ag.AGModel;
import edu.univas.si7.ag.Individual;

public class SalesmanModel extends AGModel {

	@Override
	public Individual createIndividual() {
		return new SalesmanIndividual();
	}

}
