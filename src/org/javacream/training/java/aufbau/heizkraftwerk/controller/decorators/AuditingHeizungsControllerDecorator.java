package org.javacream.training.java.aufbau.heizkraftwerk.controller.decorators;

import org.javacream.training.java.aufbau.audit.api.Audit;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsMetrik;

public class AuditingHeizungsControllerDecorator implements HeizungsController{
	private Audit audit;
	
	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	private HeizungsController delegate;
	public void setDelegate(HeizungsController delegate) {
		this.delegate = delegate;
	}
	@Override
	public void planAusfuehren() {
		delegate.planAusfuehren();
	}
	@Override
	public HeizungsMetrik ueberwachen() {
		return delegate.ueberwachen();
	}
	@Override
	public void aufheizen(Integer energie) {
		audit.log("rufe aufheizen auf mit energie " + energie);
		delegate.aufheizen(energie);
	}

}
