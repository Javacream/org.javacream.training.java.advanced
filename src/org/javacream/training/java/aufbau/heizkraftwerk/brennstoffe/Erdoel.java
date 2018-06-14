package org.javacream.training.java.aufbau.heizkraftwerk.brennstoffe;

import org.javacream.training.java.aufbau.heizkraftwerk.Energietraeger;

public class Erdoel implements Energietraeger{
	
	@Override
	public Integer brennen() {
		return 99;
	}

}
