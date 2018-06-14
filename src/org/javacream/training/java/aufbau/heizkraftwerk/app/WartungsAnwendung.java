package org.javacream.training.java.aufbau.heizkraftwerk.app;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.WartungsController;

public class WartungsAnwendung {
	private WartungsController wartungsController;
	
	public void setWartungsController(WartungsController wartungsController) {
		this.wartungsController = wartungsController;
	}

	public void wartungsArbeiten() {
		wartungsController.reinigung();

	}
}
