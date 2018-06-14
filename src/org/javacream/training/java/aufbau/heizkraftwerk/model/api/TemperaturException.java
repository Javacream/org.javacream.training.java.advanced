package org.javacream.training.java.aufbau.heizkraftwerk.model.api;

public class TemperaturException extends Exception {

	private Integer ofenIstTemperatur;
	private Integer ofenSollTemperatur;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TemperaturException(String message, Integer ist, Integer soll) {
		super(message);
		ofenIstTemperatur = ist;
		ofenSollTemperatur = soll;
	}

	public Integer getOfenIstTemperatur() {
		return ofenIstTemperatur;
	}

	public Integer getOfenSollTemperatur() {
		return ofenSollTemperatur;
	}


}
