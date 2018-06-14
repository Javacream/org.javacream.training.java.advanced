package org.javacream.training.java.aufbau.heizkraftwerk.model.api;

import java.util.Set;

import org.javacream.training.java.aufbau.heizkraftwerk.Energietraeger;

public interface Ofen {

	void kuehlen();

	Integer getSollTemperatur();

	Integer getKuehlTemperatur();

	void setKuehlTemperatur(Integer kuehlTemperatur);

	Integer getIstTemperatur();

	void beladen(Object... objects) throws TemperaturException;

	void putzen();

	Set<Object> getUnverbrennbar();

	Set<Energietraeger> getAsche();

}