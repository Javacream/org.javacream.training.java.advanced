package org.javacream.training.java.aufbau.heizkraftwerk.controller.impl;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsKonfigurationsController;

public class HeizungsKonfigurationsControllerImpl extends OfenControllerImpl implements HeizungsKonfigurationsController{
	
	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsKonfigurationsController#konfiguriere(java.lang.Integer)
	 */
	@Override
	public void konfiguriere(Integer kuehlTemperatur) {
		ofen.setKuehlTemperatur(kuehlTemperatur);
	}

}
