package org.javacream.training.java.aufbau.mobiliar;

public class Metallschrank extends Moebel {

	private Double volumen;
	public Metallschrank(String hersteller, Double volumen) {
		super(hersteller);
		this.volumen = volumen;
	}
	@Override
	public String toString() {
		return "Metallschrank [volumen=" + volumen + ", getDescription()=" + getDescription() + ", toString()="
				+ super.toString() + ", getHersteller()=" + getHersteller() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	public Double getVolumen() {
		return volumen;
	}
	@Override
	public void transportiere() {
		System.out.println("transportiere den Metallschrank mit Kran");
	}

}
