package org.javacream.training.java.aufbau.heizkraftwerk.brennstoffe;

public class Hersteller {

	public static BrennstoffContainer kauefe(Integer min) {
		Integer start = min;
		Integer energie = 0;
		BrennstoffContainer bc = new BrennstoffContainer();
		// erdoel
		Integer iErdoel = start / 99;
		for (int i = 0; i < iErdoel; i++) {
			start -= 99;
			energie += 99;
			bc.addEnergietraeger(new Erdoel());
		}
		Integer iErdgas = start / 42;
		for (int i = 0; i < iErdgas; i++) {
			start -= 42;
			energie += 42;
			bc.addEnergietraeger(new Erdgas());
		}
		
		if (start > 0) {
			energie += 42;
			bc.addEnergietraeger(new Erdgas());
			iErdgas++;
		}
		
		System.out.println("Erzeuge Container mit " + iErdoel + " Erdöl und " + iErdgas + " Erdgas, Gesamtenergie " + energie + ", Bestellung " + min);
		return bc;

	}
}
