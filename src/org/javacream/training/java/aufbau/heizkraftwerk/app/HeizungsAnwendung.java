package org.javacream.training.java.aufbau.heizkraftwerk.app;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController;

public class HeizungsAnwendung {
	private HeizungsController heizungsController;
	
	public void setHeizungsController(HeizungsController heizungsController) {
		this.heizungsController = heizungsController;
	}

	public void heizen() {
		heizungsController.planAusfuehren();
		System.out.println(heizungsController.ueberwachen());
		heizungsController.aufheizen(500);
		System.out.println(heizungsController.ueberwachen());
		heizungsController.aufheizen(200);
		System.out.println(heizungsController.ueberwachen());
	}
}
