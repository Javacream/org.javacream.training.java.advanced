package org.javacream.training.java.aufbau.heizkraftwerk.controller.api;

public class HeizungsMetrik {

	private Integer istTemperatur;
	private Integer sollTemperatur;
	private Integer kuehlTemperatur;
	private Integer anzahlUnverbrannteElemente;
	private Integer anzahlVerbrannteElemente;
	@Override
	public String toString() {
		return "HeizungsMetrik [istTemperatur=" + istTemperatur + ", sollTemperatur=" + sollTemperatur
				+ ", kuehlTemperatur=" + kuehlTemperatur + ", anzahlUnverbrannteElemente=" + anzahlUnverbrannteElemente
				+ ", anzahlVerbrannteElemente=" + anzahlVerbrannteElemente + "]";
	}
	public HeizungsMetrik(Integer istTemperatur, Integer sollTemperatur, Integer kuehlTemperatur,
			Integer anzahlUnverbrannteElemente, Integer anzahlVerbrannteElemente) {
		super();
		this.istTemperatur = istTemperatur;
		this.sollTemperatur = sollTemperatur;
		this.kuehlTemperatur = kuehlTemperatur;
		this.anzahlUnverbrannteElemente = anzahlUnverbrannteElemente;
		this.anzahlVerbrannteElemente = anzahlVerbrannteElemente;
	}
	public Integer getIstTemperatur() {
		return istTemperatur;
	}
	public Integer getSollTemperatur() {
		return sollTemperatur;
	}
	public Integer getKuehlTemperatur() {
		return kuehlTemperatur;
	}
	public Integer getAnzahlUnverbrannteElemente() {
		return anzahlUnverbrannteElemente;
	}
	public Integer getAnzahlVerbrannteElemente() {
		return anzahlVerbrannteElemente;
	}

}
