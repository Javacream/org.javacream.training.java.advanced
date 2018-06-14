package org.javacream.training.java.aufbau;

public class Person {

	private String nachname;
	private String vorname;
	String vorstellen() {
		return "OK";
	}
	private Adresse adresse;
	@Override
	public String toString() {
		return "Person [nachname=" + nachname + ", vorname=" + vorname + ", adresse=" + adresse + "]";
	}
	public Person(String nachname, String vorname) {
		super();
		this.nachname = nachname;
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public String getVorname() {
		return vorname;
	}
}
