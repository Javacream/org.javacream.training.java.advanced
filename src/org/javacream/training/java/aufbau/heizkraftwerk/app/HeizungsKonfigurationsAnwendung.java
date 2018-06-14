package org.javacream.training.java.aufbau.heizkraftwerk.app;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsKonfigurationsController;

public class HeizungsKonfigurationsAnwendung {
	private HeizungsKonfigurationsController heizungskonfigurationsController;
	
	public void setHeizungsKonfigurationsController(HeizungsKonfigurationsController heizungsKonfigurationsController) {
		this.heizungskonfigurationsController = heizungsKonfigurationsController;
	}

	public void konfiguriere() {
		heizungskonfigurationsController.konfiguriere(75);
	}
}
