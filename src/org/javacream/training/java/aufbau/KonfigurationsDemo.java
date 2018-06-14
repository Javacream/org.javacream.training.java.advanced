package org.javacream.training.java.aufbau;

import java.io.IOException;
import java.util.Properties;

public class KonfigurationsDemo {

	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			properties.load(KonfigurationsDemo.class.getResourceAsStream("/demo.properties"));
			System.out.println(properties.getProperty("key2"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
