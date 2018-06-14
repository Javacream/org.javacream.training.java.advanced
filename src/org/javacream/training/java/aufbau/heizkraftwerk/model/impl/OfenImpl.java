package org.javacream.training.java.aufbau.heizkraftwerk.model.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.javacream.training.java.aufbau.heizkraftwerk.Energietraeger;
import org.javacream.training.java.aufbau.heizkraftwerk.model.api.Ofen;
import org.javacream.training.java.aufbau.heizkraftwerk.model.api.TemperaturException;

/**
 * Der Ofen beschreibt das Modell unser Heizkraftwerksanwendung, das heisst,
 * hier ist der Geschäftsprozess abgebildet, der Ofen wird beladen,
 * Brennelemente werden verbrannt und erhöhen die Temperatur des Ofens. Wird der
 * Ofen zu heiss wird automatisch gekühlt.
 * 
 * 
 * @version 1.4 krg 8.3.2004 (hkw00)
 */
public class OfenImpl implements Ofen {

	private Integer istTemperatur = 20;
	private Integer sollTemperatur = 100;
	private Integer kuehlTemperatur = 25;
	private Brennkammer brennkammer = null;
	private Set<Object> unverbrennbar;
	private Set<Energietraeger> asche;
	public OfenImpl(Integer sollTemperatur) {
		this.sollTemperatur = sollTemperatur;
		brennkammer = new Brennkammer();
		asche = new HashSet<>();
		unverbrennbar = new HashSet<>();
	}

	private void erhöheTemperatur(Integer brennwert) {
		setIstTemperatur(this.istTemperatur + brennwert);
	}

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.model.Ofen#kuehlen()
	 */
	@Override
	public void kuehlen() {
		this.istTemperatur -= this.kuehlTemperatur;
	}

	private void setIstTemperatur(Integer istTemperatur) {
		this.istTemperatur = istTemperatur;
	}

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.model.Ofen#getSollTemperatur()
	 */
	@Override
	public Integer getSollTemperatur() {
		return sollTemperatur;
	}

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.model.Ofen#getKuehlTemperatur()
	 */
	@Override
	public Integer getKuehlTemperatur() {
		return kuehlTemperatur;
	}

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.model.Ofen#setKuehlTemperatur(java.lang.Integer)
	 */
	@Override
	public void setKuehlTemperatur(Integer kuehlTemperatur) {
		this.kuehlTemperatur = kuehlTemperatur;
	}

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.model.Ofen#getIstTemperatur()
	 */
	@Override
	public Integer getIstTemperatur() {
		return istTemperatur;
	}

	private void vorbereiten(Object o)  throws TemperaturException {
		if (o == null) {
			System.out.println("null-Objekt hat keinen Heizwert");
		} else {
			try {
				Energietraeger et = (Energietraeger) o;
				brennkammer.verbrennen(et);
				asche.add(et);
			} catch (ClassCastException e) {
				unverbrennbar.add(o);
				System.out.println("kann nicht verbrannt werden: " + o);
			}
			if (istTemperatur > sollTemperatur) {
				// this.kuehlen();
				throw new TemperaturException("ofen zu heiß", istTemperatur, sollTemperatur);
			}

		}
		
	}
	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.model.Ofen#beladen(java.lang.Object)
	 */
	@Override
	public void beladen(Object... objects) throws TemperaturException{
		for(Object o: objects) {
			vorbereiten(o);
		}
	}

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.model.Ofen#putzen()
	 */
	@Override
	public void putzen() {
		System.out.println("Putze Ofen");
		asche.clear();
		unverbrennbar.clear();
	}
	private class Brennkammer {

		private Brennkammer() {

		}

		public void verbrennen(Energietraeger b) {
			System.out.println("Verbrenne " + b);
			Integer heizleistung = b.brennen();

			erhöheTemperatur(heizleistung);
			System.out.println(
					"Temperatur: ist=" + OfenImpl.this.getIstTemperatur() + ", soll=" + OfenImpl.this.getSollTemperatur());

		}
	}
	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.model.Ofen#getUnverbrennbar()
	 */
	@Override
	public Set<Object> getUnverbrennbar() {
		return Collections.unmodifiableSet(unverbrennbar);
	}

	/* (non-Javadoc)
	 * @see org.javacream.training.java.aufbau.heizkraftwerk.model.Ofen#getAsche()
	 */
	@Override
	public Set<Energietraeger> getAsche() {
		return Collections.unmodifiableSet(asche);
	}

}// END OF OFEN
