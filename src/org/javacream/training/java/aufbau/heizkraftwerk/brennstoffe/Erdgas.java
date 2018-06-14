package org.javacream.training.java.aufbau.heizkraftwerk.brennstoffe;

import org.javacream.training.java.aufbau.heizkraftwerk.Energietraeger;

public class Erdgas implements Energietraeger{

	@Override
	public Integer brennen() {
		return 42;
	}

}
