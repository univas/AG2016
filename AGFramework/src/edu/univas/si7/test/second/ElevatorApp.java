package edu.univas.si7.test.second;

import edu.univas.si7.ag.AGFramework;
import edu.univas.si7.ag.AGModel.CrossType;
import edu.univas.si7.ag.AGModel.MutationType;

public class ElevatorApp {

	public static void main(String[] args) {
		
		ElevatorModel model = new ElevatorModel();
		model.setPopulationSize(25);
		model.setGenerationQuantity(500);
		model.setCrossType(CrossType.Binary);
		model.setMutationType(MutationType.Binary);
		
		AGFramework framework = new AGFramework(model);
		
		framework.execute();
	}
}
