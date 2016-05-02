package edu.univas.si7.sinxcosy;

import edu.univas.si7.ag.AGFramework;
import edu.univas.si7.ag.AGModel.CrossType;
import edu.univas.si7.ag.AGModel.MutationType;

public class SinXCosYApp {

	public static void main(String[] args) {
		
		SinXCosYModel model = new SinXCosYModel();
		model.setPopulationSize(25);
		model.setGenerationQuantity(2000);
		model.setCrossType(CrossType.Binary);
		model.setMutationType(MutationType.Binary);
		
		AGFramework framework = new AGFramework(model);
		
		framework.execute();
	}
}
