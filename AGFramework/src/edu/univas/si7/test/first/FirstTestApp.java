package edu.univas.si7.test.first;

import edu.univas.si7.ag.AGFramework;

public class FirstTestApp {

	public static void main(String[] args) {
		
		FirstTestModel model = new FirstTestModel();
		model.setPopulationSize(25);
		model.setGenerationQuantity(500);
		model.setForeignRate(10);
		model.setMutationRate(7);
		
		AGFramework framework = new AGFramework(model);
		
		framework.execute();
	}
}
