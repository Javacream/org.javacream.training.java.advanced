package org.javacream.training.java.aufbau.heizkraftwerk;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.javacream.training.java.aufbau.heizkraftwerk.app.HeizungsAnwendung;
import org.javacream.training.java.aufbau.heizkraftwerk.app.HeizungsKonfigurationsAnwendung;
import org.javacream.training.java.aufbau.heizkraftwerk.app.ParallelHeizungsAnwendung;
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
import org.javacream.training.java.aufbau.heizkraftwerk.view.HeizungsStage;
import org.javacream.training.java.aufbau.heizkraftwerk.view.WartungsStage;

public abstract class Context {
	private static HeizungsController heizungsController;
	private static WartungsController wartungsController;
	private static HeizungsKonfigurationsController heizungsKonfigurationsController;
	private static Ofen ofen;
	private static HeizungsAnwendung heizungsAnwendung;
	private static WartungsAnwendung wartungsAnwendung;
	private static HeizungsKonfigurationsAnwendung heizungsKonfigurationsAnwendung;
	private static ParallelHeizungsAnwendung parallelHeizungsAnwendung;
	private static Integer umgebungsTemperatur;
	private static ExecutorService executorService;
	private static ScheduledExecutorService scheduledExecutorService;
	private static WartungsStage wartungsStage;
	public static WartungsStage getWartungsStage() {
		return wartungsStage;
	}
	public static HeizungsStage getHeizungsStage() {
		return heizungsStage;
	}
	private static HeizungsStage heizungsStage;
	
	public static ExecutorService getExecutorService() {
		return executorService;
	}
	public static ScheduledExecutorService getScheduledExecutorService() {
		return scheduledExecutorService;
	}
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
		Integer isolation = Integer.parseInt(konfiguration.getProperty("ofen.isolation"));
		Integer aufheizEnergie = Integer.parseInt(konfiguration.getProperty("ofen.aufheizEnergie"));
		Integer aufheizPeriode = Integer.parseInt(konfiguration.getProperty("ofen.aufheizPeriode"));
		umgebungsTemperatur = Integer.parseInt(konfiguration.getProperty("umgebungsTemperatur"));

		executorService = Executors.newCachedThreadPool();
		scheduledExecutorService = Executors.newScheduledThreadPool(1);

		//fachobjekte erzeugen
		heizungsStage = new HeizungsStage();
		wartungsStage = new WartungsStage();
		
		HeizungsControllerImpl heizungsControllerImpl = new HeizungsControllerImpl();
		AuditingHeizungsControllerDecorator auditingHeizungsControllerDecorator = new AuditingHeizungsControllerDecorator();
		ProfilingHeizungsControllerDecorator profilingHeizungsControllerDecorator = new ProfilingHeizungsControllerDecorator(); 
		profilingHeizungsControllerDecorator.setDelegate(heizungsControllerImpl);
		auditingHeizungsControllerDecorator.setDelegate(profilingHeizungsControllerDecorator);
		WartungsControllerImpl wartungsControllerImpl = new WartungsControllerImpl();
		HeizungsKonfigurationsControllerImpl heizungsKonfigurationsControllerImpl = new HeizungsKonfigurationsControllerImpl();
		parallelHeizungsAnwendung = new ParallelHeizungsAnwendung();
		heizungsAnwendung = new HeizungsAnwendung();
		wartungsAnwendung = new WartungsAnwendung();
		heizungsKonfigurationsAnwendung = new HeizungsKonfigurationsAnwendung();
		
		//abhängigkeiten (dependencies) setzen (injecten)
		OfenImpl ofenImpl = new OfenImpl(sollTemperatur, isolation);
		ofenImpl.setKuehlTemperatur(kuehlTemperatur);
		ofenImpl.setScheduledExecutorService(scheduledExecutorService);
		wartungsControllerImpl.setMaximumUnverbrannt(maxUnverbrannt);
		wartungsControllerImpl.setMaximumVerbrannt(maxVerbrannt);
		heizungsControllerImpl.setOfen(ofenImpl);
		wartungsControllerImpl.setOfen(ofenImpl);
		heizungsKonfigurationsControllerImpl.setOfen(ofenImpl);
		heizungsAnwendung.setHeizungsController(auditingHeizungsControllerDecorator);
		wartungsAnwendung.setWartungsController(wartungsControllerImpl);
		heizungsKonfigurationsAnwendung.setHeizungsKonfigurationsController(heizungsKonfigurationsControllerImpl);
		parallelHeizungsAnwendung.setExecutorService(executorService);
		parallelHeizungsAnwendung.setScheduledExecutorService(scheduledExecutorService);
		parallelHeizungsAnwendung.setHeizungsController(heizungsControllerImpl);
		parallelHeizungsAnwendung.setAufheizEnergie(aufheizEnergie);
		parallelHeizungsAnwendung.setAufheizPeriode(aufheizPeriode);
		heizungsStage.setHeizungsController(heizungsControllerImpl);
		heizungsStage.setScheduledExecutorService(scheduledExecutorService);
		//initialisiere
		ofenImpl.init();
		//setze referenzen
		heizungsController = auditingHeizungsControllerDecorator;
		wartungsController = wartungsControllerImpl;
		heizungsKonfigurationsController = heizungsKonfigurationsControllerImpl;
		ofen = ofenImpl;
	}

	public static ParallelHeizungsAnwendung getParallelHeizungsAnwendung() {
		return parallelHeizungsAnwendung;
	}
	public static Integer getUmgebungsTemperatur() {
		return umgebungsTemperatur;
	}
	
}
