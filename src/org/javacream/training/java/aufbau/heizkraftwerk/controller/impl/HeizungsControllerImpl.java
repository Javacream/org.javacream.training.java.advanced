package org.javacream.training.java.aufbau.heizkraftwerk.controller.impl;

import org.javacream.training.java.aufbau.dinge.Dose;
import org.javacream.training.java.aufbau.heizkraftwerk.brennstoffe.DosenAdapter;
import org.javacream.training.java.aufbau.heizkraftwerk.brennstoffe.Hersteller;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController;
import org.javacream.training.java.aufbau.heizkraftwerk.model.api.TemperaturException;
import org.javacream.training.java.aufbau.heizkraftwerk.util.Fabrik;

public class HeizungsControllerImpl extends UeberwachungsControllerImpl implements HeizungsController {

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController#planAusfuehren()
	 */
	@Override
	public void planAusfuehren() {
		for (String element : Fabrik.DatenbankBeladungsplanlader.ladeplan()) {
			Object o = Fabrik.create(element);
			if (o instanceof Dose) {
				o = new DosenAdapter((Dose) o);
			}
			if (o != null) {
				try {
					ofen.beladen(o);
				} catch (TemperaturException e) {
					pruefeTemperatur();
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController#aufheizen(java.lang.Integer)
	 */
	@Override
	public void aufheizen(Integer energie) {
		try {
			ofen.beladen(Hersteller.kauefe(energie));
		} catch (TemperaturException e) {
			pruefeTemperatur();
		}
	}
	
	private void pruefeTemperatur() {
		int counter = 0;
		while (ofen.getIstTemperatur() > ofen.getSollTemperatur()) {
			counter++;
			ofen.kuehlen();
		}
		System.out.println("musste " + counter + " mal kühlen!");
		
	}
}
