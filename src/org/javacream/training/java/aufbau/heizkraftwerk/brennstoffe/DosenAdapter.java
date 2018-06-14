package org.javacream.training.java.aufbau.heizkraftwerk.brennstoffe;

import org.javacream.training.java.aufbau.dinge.Dose;
import org.javacream.training.java.aufbau.heizkraftwerk.Energietraeger;

public class DosenAdapter implements Energietraeger {

	private Dose dose;

	public DosenAdapter(Dose dose) {
		super();
		this.dose = dose;
	}

	@Override
	public Integer brennen() {
		System.out.println("im Adapter brennt auch eine Dose!!!");
		if (dose != null) {
			dose = null;
			return 66;
		} else {
			return 0;
		}
	}

}
