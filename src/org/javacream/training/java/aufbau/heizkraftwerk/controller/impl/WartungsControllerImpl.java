package org.javacream.training.java.aufbau.heizkraftwerk.controller.impl;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsMetrik;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.WartungsController;

public class WartungsControllerImpl extends UeberwachungsControllerImpl implements WartungsController{
	private Integer maximumUnverbrannt;
	private Integer maximumVerbrannt;
	public void setMaximumUnverbrannt(Integer maximumUnverbrannt) {
		this.maximumUnverbrannt = maximumUnverbrannt;
	}


	public void setMaximumVerbrannt(Integer maximumVerbrannt) {
		this.maximumVerbrannt = maximumVerbrannt;
	}


	
	
	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.controller.api.WartungsController#reinigung()
	 */
	@Override
	public void reinigung() {
		HeizungsMetrik metrik = this.ueberwachen();
		if (metrik.getAnzahlUnverbrannteElemente() > maximumUnverbrannt || metrik.getAnzahlVerbrannteElemente() > maximumVerbrannt) {
			ofen.putzen();
			System.out.println("reinige ofen");
		}else {
			System.out.println("völlig überflüssig, was soll das?????");
		}
		
		
	}
}
