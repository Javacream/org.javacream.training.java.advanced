package org.javacream.training.java.aufbau.heizkraftwerk.controller.api;

public interface HeizungsController extends UeberwachungsController {

	void planAusfuehren();

	void aufheizen(Integer energie);

}