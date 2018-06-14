package org.javacream.training.java.aufbau.heizkraftwerk.controller.decorators;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsMetrik;

public class AuditingHeizungsControllerDecorator implements HeizungsController{

	private HeizungsController delegate;
	public void setDelegate(HeizungsController delegate) {
		this.delegate = delegate;
	}
	@Override
	public void planAusfuehren() {
		System.err.println("rufe planAusfuehren auf");
		delegate.planAusfuehren();
	}
	@Override
	public HeizungsMetrik ueberwachen() {
		return delegate.ueberwachen();
	}
	@Override
	public void aufheizen(Integer energie) {
		delegate.aufheizen(energie);
	}

}
