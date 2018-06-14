package org.javacream.training.java.aufbau.heizkraftwerk.controller.impl;

import org.javacream.training.java.aufbau.heizkraftwerk.model.api.Ofen;

public abstract class OfenControllerImpl {

	protected Ofen ofen;

	public void setOfen(Ofen ofen) {
		this.ofen = ofen;
	}

}