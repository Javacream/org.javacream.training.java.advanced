package org.javacream.training.java.aufbau.material;

import java.util.HashMap;
import java.util.Map;

import org.javacream.training.java.aufbau.heizkraftwerk.Energietraeger;

public class Holz implements Energietraeger{

	protected String typ;
	protected Integer brennwert = 0;

	public Holz(String typ) {
		this.typ = typ;
		this.brennwert = bestimmeBrennwert(typ);
	}

	public Integer brennen() {
		System.out.println(typ + " verbrennt mit brennwert=" + this.brennwert);
		Integer returnValue = brennwert;
		brennwert = 0;
		return returnValue;
	}

	private static Map<String, Integer> brennwerte = new HashMap<>();
	
	static {
		brennwerte.put("Bruchholz", 3);
		brennwerte.put("Fichte", 4);
		brennwerte.put("Buche", 5);
		
	}
	private Integer bestimmeBrennwert(String typ) {
		Integer brennwert = brennwerte.get(typ);
		if (brennwert == null) {
			return 0;
		}else {
			return brennwert;
		}
	}
}
