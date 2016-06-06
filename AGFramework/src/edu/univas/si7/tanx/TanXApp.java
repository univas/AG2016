package edu.univas.si7.tanx;

import edu.univas.si7.ag.AGFramework;
import edu.univas.si7.ag.AGModel.CrossType;
import edu.univas.si7.ag.AGModel.MutationType;

public class TanXApp {

	public static void main(String[] args) {
		
		TanXModel model = new TanXModel();
		model.setPopulationSize(25);
		model.setGenerationQuantity(100);
		model.setCrossType(CrossType.Binary);
		model.setMutationType(MutationType.Binary);
		
		AGFramework framework = new AGFramework(model);
		
		framework.execute();
	}
}
