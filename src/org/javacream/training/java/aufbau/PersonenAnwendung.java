package org.javacream.training.java.aufbau;

public class PersonenAnwendung {

	public static void main(String[] args) {
//		String nachnamePerson1 = "Sawitzki";
//		String vornamePerson2 = "Rainer";
//		String strassePerson1 = "Marienplatz";
//		String stadtPerson1 = "München";
//		String nachnamePerson2 = "Meier";
//		String vornamePerson1 = "Hans";
//		String strassePerson2 = "Alexanderplatz";
//		String stadtPerson2 = "Berlin";
		

		Person person1 = new Person("Sawitzki", "Rainer");
		Adresse adresse1 = new Adresse("München", "Marienplatz");
		person1.setAdresse(adresse1);
		
		
		Person person2 = new Person("Meier", "Hans");
		Adresse adresse2 = new Adresse("Berlin", "Alexanderplatz");
		person2.setAdresse(adresse2);
		
	}

}
