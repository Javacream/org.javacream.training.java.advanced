package org.javacream.training.java.aufbau.mobiliar;

import org.javacream.training.java.aufbau.heizkraftwerk.Energietraeger;

public class Sofa extends Moebel implements Energietraeger{

	private Integer sitze;
	public Sofa(String hersteller, Integer sitze) {
		super(hersteller);
		this.sitze = sitze;
	}
	public Integer getSitze() {
		return sitze;
	}
	@Override
	public void transportiere() {
		System.out.println("transportiere ein Sofa mit zwei leuten...");
	}
	
	public Integer brennen() {
		return 5 * sitze; 
	}
	@Override
	public String toString() {
		return "Sofa [sitze=" + sitze + ", getDescription()=" + getDescription() + ", toString()=" + super.toString()
				+ ", getHersteller()=" + getHersteller() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
