package edu.univas.si7.backpack;

import edu.univas.si7.ag.AGFramework;

public class BackpackApp {

	public static void main(String[] args) {
		
		BackpackModel model = new BackpackModel();
		model.setPopulationSize(25);
		model.setGenerationQuantity(100);
		
		AGFramework framework = new AGFramework(model);
		framework.execute();
	}
}
