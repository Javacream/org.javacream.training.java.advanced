package org.javacream.training.java.aufbau.heizkraftwerk;

public interface Energietraeger {
	public Integer brennen();
	default Integer kompostieren() {
		return 2 * brennen();
	}
	default Double explodieren() {
		return 0.75 * brennen();
	}
}
