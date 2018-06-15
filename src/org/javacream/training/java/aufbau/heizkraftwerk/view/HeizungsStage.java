package org.javacream.training.java.aufbau.heizkraftwerk.view;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsController;
import org.javacream.training.java.aufbau.heizkraftwerk.controller.api.HeizungsMetrik;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HeizungsStage {
	private HeizungsController heizungsController;
	private ScheduledExecutorService scheduledExecutorService;
	private HeizungsMetrik heizungsMetrik;

	public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
		this.scheduledExecutorService = scheduledExecutorService;
	}

	public void setHeizungsController(HeizungsController heizungsController) {
		this.heizungsController = heizungsController;
	}

	public Stage getStage() {
		return stage;
	}

	private Stage stage;

	public void init() {
		stage = new Stage();
		Group root = new Group();
		Scene scene = new Scene(root, 300, 250);
		buildUi(root.getChildren());
		stage.setX(0);
		stage.setY(0);
		stage.setScene(scene);
		stage.show();
	}

	private void buildUi(ObservableList<Node> children) {
		Button ladeplanButton = new Button();
		ladeplanButton.setText("Ladeplan");
		ladeplanButton.setOnAction((event) -> heizungsController.planAusfuehren());
		ladeplanButton.setLayoutY(80);
		ladeplanButton.setLayoutX(100);
		TextField energieEingabe = new TextField();
		energieEingabe.setLayoutY(110);
		energieEingabe.setLayoutX(100);
		Button kaufenButton = new Button();
		kaufenButton.setText("kaufen");
		kaufenButton.setOnAction((event) -> {
			Integer energie = Integer.parseInt(energieEingabe.getText());
			heizungsController.aufheizen(energie);
		});
		kaufenButton.setLayoutY(140);
		kaufenButton.setLayoutX(100);

		Label temperatur = new Label();
		temperatur.setLayoutY(170);
		temperatur.setLayoutX(100);
		Runnable aufrufDerUeberwachung = () -> {
			heizungsMetrik = heizungsController.ueberwachen();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable aktualisierungDerOberfläche = () -> Platform
				.runLater(() -> temperatur.setText("Temperatur: " + heizungsMetrik.getIstTemperatur()));
		scheduledExecutorService.scheduleAtFixedRate(aufrufDerUeberwachung, 0, 5, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleAtFixedRate(aktualisierungDerOberfläche, 0, 1, TimeUnit.SECONDS);

		children.add(kaufenButton);
		children.add(ladeplanButton);
		children.add(energieEingabe);
		children.add(temperatur);

		Button block = new Button();
		block.setLayoutY(200);
		block.setLayoutX(100);
		block.setOnAction((event) -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		children.add(block);

	}

}
