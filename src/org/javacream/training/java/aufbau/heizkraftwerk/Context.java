package org.javacream.training.java.aufbau.heizkraftwerk;

import java.io.IOException;
import java.util.Properties;

import org.javacream.training.java.aufbau.heizkraftwerk.app.HeizungsAnwendung;
import org.javacream.training.java.aufbau.heizkraftwerk.app.HeizungsKonfigurationsAnwendung;
import org.javacream.training.java.aufbau.heizkraftwerk.app.WartungsAnwendung;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsKonfigurationsController;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.WartungsController;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.decorators.AuditingHeizungsControllerDecorator;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.decorators.ProfilingHeizungsControllerDecorator;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.impl.HeizungsControllerImpl;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.impl.HeizungsKonfigurationsControllerImpl;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.impl.WartungsControllerImpl;
import org.javacream.training.java.aufbau.heizkraftwerk.model.api.Ofen;
import org.javacream.training.java.aufbau.heizkraftwerk.model.impl.OfenImpl;

public abstract class Context {
	private static HeizungsController heizungsController;
	private static WartungsController wartungsController;
	private static HeizungsKonfigurationsController heizungsKonfigurationsController;
	private static Ofen ofen;
	private static HeizungsAnwendung heizungsAnwendung;
	private static WartungsAnwendung wartungsAnwendung;
	private static HeizungsKonfigurationsAnwendung heizungsKonfigurationsAnwendung;

	public static HeizungsKonfigurationsAnwendung getHeizungsKonfigurationsAnwendung() {
		return heizungsKonfigurationsAnwendung;
	}
	public static HeizungsController getHeizungsController() {
		return heizungsController;
	}
	public static HeizungsKonfigurationsController getHeizungsKonfigurationsController() {
		return heizungsKonfigurationsController;
	}
	public static WartungsController getWartungsController() {
		return wartungsController;
	}
	public Ofen getOfen() {
		return ofen;
	}
	
	public static HeizungsAnwendung getHeizungsAnwendung() {
		return heizungsAnwendung;
	}
	public static WartungsAnwendung getWartungsAnwendung() {
		return wartungsAnwendung;
	}

	static {
		//lese Konfiguration
		Properties konfiguration = new Properties();
		try {
			konfiguration.load(Context.class.getResourceAsStream("heizung.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		Integer sollTemperatur = Integer.parseInt(konfiguration.getProperty("ofen.sollTemperatur"));
		Integer kuehlTemperatur = Integer.parseInt(konfiguration.getProperty("ofen.kuehlTemperatur"));
		Integer maxVerbrannt = Integer.parseInt(konfiguration.getProperty("ofen.kapazitaetVerbrannt"));
		Integer maxUnverbrannt = Integer.parseInt(konfiguration.getProperty("ofen.kapazitaetUnverbrannt"));

		//fachobjekte erzeugen
		HeizungsControllerImpl heizungsControllerImpl = new HeizungsControllerImpl();
		AuditingHeizungsControllerDecorator auditingHeizungsControllerDecorator = new AuditingHeizungsControllerDecorator();
		ProfilingHeizungsControllerDecorator profilingHeizungsControllerDecorator = new ProfilingHeizungsControllerDecorator(); 
		profilingHeizungsControllerDecorator.setDelegate(heizungsControllerImpl);
		auditingHeizungsControllerDecorator.setDelegate(profilingHeizungsControllerDecorator);
		
		
		WartungsControllerImpl wartungsControllerImpl = new WartungsControllerImpl();
		HeizungsKonfigurationsControllerImpl heizungsKonfigurationsControllerImpl = new HeizungsKonfigurationsControllerImpl();
		heizungsAnwendung = new HeizungsAnwendung();
		wartungsAnwendung = new WartungsAnwendung();
		heizungsKonfigurationsAnwendung = new HeizungsKonfigurationsAnwendung();
		
		//abhängigkeiten (dependencies) setzen (injecten)
		ofen = new OfenImpl(sollTemperatur);
		ofen.setKuehlTemperatur(kuehlTemperatur);
		
		wartungsControllerImpl.setMaximumUnverbrannt(maxUnverbrannt);
		wartungsControllerImpl.setMaximumVerbrannt(maxVerbrannt);
		heizungsControllerImpl.setOfen(ofen);
		wartungsControllerImpl.setOfen(ofen);
		heizungsKonfigurationsControllerImpl.setOfen(ofen);
		heizungsAnwendung.setHeizungsController(auditingHeizungsControllerDecorator);
		wartungsAnwendung.setWartungsController(wartungsControllerImpl);
		heizungsKonfigurationsAnwendung.setHeizungsKonfigurationsController(heizungsKonfigurationsControllerImpl);
		
		heizungsController = auditingHeizungsControllerDecorator;
		wartungsController = wartungsControllerImpl;
		heizungsKonfigurationsController = heizungsKonfigurationsControllerImpl;
	}
	
}
