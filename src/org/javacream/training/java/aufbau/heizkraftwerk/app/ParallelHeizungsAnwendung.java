package org.javacream.training.java.aufbau.heizkraftwerk.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController;

public class ParallelHeizungsAnwendung {
	private ExecutorService executorService;
	private ScheduledExecutorService scheduledExecutorService;
	private HeizungsController heizungsController;
	private Integer aufheizPeriode;
	private Integer aufheizEnergie;
	
	public void setHeizungsController(HeizungsController heizungsController) {
		this.heizungsController = heizungsController;
	}

	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}

	public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
		this.scheduledExecutorService = scheduledExecutorService;
	}

	public void parallelHeizen() {
		executorService.execute(() -> heizungsController.planAusfuehren());
		scheduledExecutorService.scheduleAtFixedRate(() -> heizungsController.aufheizen(aufheizEnergie) , 0, aufheizPeriode, TimeUnit.SECONDS);

	}

	public void setAufheizPeriode(Integer aufheizPeriode) {
		this.aufheizPeriode = aufheizPeriode;
	}

	public void setAufheizEnergie(Integer aufheizEnergie) {
		this.aufheizEnergie = aufheizEnergie;
	}

}
