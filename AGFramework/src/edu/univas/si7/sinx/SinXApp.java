package edu.univas.si7.sinx;

import edu.univas.si7.ag.AGFramework;
import edu.univas.si7.ag.AGModel.CrossType;
import edu.univas.si7.ag.AGModel.MutationType;

public class SinXApp {

	public static void main(String[] args) {
		
		SinXModel model = new SinXModel();
		model.setPopulationSize(25);
		model.setGenerationQuantity(200);
		model.setCrossType(CrossType.Binary);
		model.setMutationType(MutationType.Binary);
		
		AGFramework framework = new AGFramework(model);
		
		framework.execute();
	}
}
