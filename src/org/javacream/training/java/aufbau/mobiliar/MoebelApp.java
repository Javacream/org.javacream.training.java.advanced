package org.javacream.training.java.aufbau.mobiliar;

public class MoebelApp {

	public static void main(String[] args) {
		Metallschrank metallschrank = new Metallschrank("IKEA", 3.2);
		Sofa sofa = new Sofa("IKEA", 3);
		//Moebel m = new Moebel("IKEA");
		
		
		System.out.println(metallschrank);
		System.out.println(sofa);
		
	}

}
