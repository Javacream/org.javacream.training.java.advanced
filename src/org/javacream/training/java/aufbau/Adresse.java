package org.javacream.training.java.aufbau;

public class Adresse {
	private String stadt;
	private String strasse;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stadt == null) ? 0 : stadt.hashCode());
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		if (stadt == null) {
			if (other.stadt != null)
				return false;
		} else if (!stadt.equals(other.stadt))
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Adresse [stadt=" + stadt + ", strasse=" + strasse + "]";
	}
	public Adresse(String stadt, String strasse) {
		super();
		this.stadt = stadt;
		this.strasse = strasse;
	}
	public String getStadt() {
		return stadt;
	}
	public String getStrasse() {
		return strasse;
	}
}
