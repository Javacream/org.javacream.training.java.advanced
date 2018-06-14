package org.javacream.training.java.aufbau.heizkraftwerk.controller.decorators;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsMetrik;

public class ProfilingHeizungsControllerDecorator implements HeizungsController{

	private HeizungsController delegate;
	public void setDelegate(HeizungsController delegate) {
		this.delegate = delegate;
	}
	@Override
	public void planAusfuehren() {
		long start = System.currentTimeMillis();
		delegate.planAusfuehren();
		System.err.println("Aufruf von planAusfuehren dauerte " + (System.currentTimeMillis() - start));
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
