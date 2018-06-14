package org.javacream.training.java.aufbau.heizkraftwerk;

public class Starter {

	public static void main(String[] args) {
		Context.getHeizungsAnwendung().heizen();
		Context.getWartungsAnwendung().wartungsArbeiten();
		Context.getHeizungsKonfigurationsAnwendung().konfiguriere();
		Context.getHeizungsAnwendung().heizen();
		Context.getWartungsAnwendung().wartungsArbeiten();
	}

}
