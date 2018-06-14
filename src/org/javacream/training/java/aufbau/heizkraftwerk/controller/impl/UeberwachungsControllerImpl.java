package org.javacream.training.java.aufbau.heizkraftwerk.controller.impl;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsMetrik;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.UeberwachungsController;

public class UeberwachungsControllerImpl extends OfenControllerImpl implements UeberwachungsController {

	public UeberwachungsControllerImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.controller.UeberwachungsController#ueberwachen()
	 */
	@Override
	public HeizungsMetrik ueberwachen() {
		HeizungsMetrik heizungsMetrik = new HeizungsMetrik(ofen.getIstTemperatur(), ofen.getSollTemperatur(),
				ofen.getKuehlTemperatur(), ofen.getUnverbrennbar().size(), ofen.getAsche().size());
		return heizungsMetrik;
	
	}

}