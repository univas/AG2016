package edu.univas.si7.sinxcosy;

import edu.univas.si7.ag.AGModel;
import edu.univas.si7.ag.Individual;

public class SinXCosYModel extends AGModel {

	@Override
	public Individual createIndividual() {
		return new SinXCosYIndividual();
	}

}
