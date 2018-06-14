package org.javacream.training.java.aufbau.mobiliar;

public abstract class Moebel{

	private String hersteller;
	private String description;

	public Moebel(String hersteller) {
		super();
		this.hersteller = hersteller;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Moebel [hersteller=" + hersteller + ", description=" + description + "]";
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHersteller() {
		return hersteller;
	}
	
	public abstract void transportiere();

}
