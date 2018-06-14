package org.javacream.training.java.aufbau.heizkraftwerk.brennstoffe;

import java.util.ArrayList;
import java.util.List;

import org.javacream.training.java.aufbau.heizkraftwerk.Energietraeger;

public class BrennstoffContainer implements Energietraeger{

	private List<Energietraeger> elemente = new ArrayList<>();
	
	public void addEnergietraeger(Energietraeger et) {
		elemente.add(et);
	}
	
	public Integer brennen() {
		
		return elemente.stream().mapToInt((e) -> e.brennen()).sum();
	}
}
