package edu.univas.si7.salesman;

import edu.univas.si7.ag.AGFramework;

public class SalesmanApp {

	public static void main(String[] args) {
		
		SalesmanModel model = new SalesmanModel();
		model.setPopulationSize(25);
		model.setGenerationQuantity(100);
		
		AGFramework framework = new AGFramework(model);
		
		framework.execute();
	}
}
