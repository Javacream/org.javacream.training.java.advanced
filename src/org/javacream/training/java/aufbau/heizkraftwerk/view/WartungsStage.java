package org.javacream.training.java.aufbau.heizkraftwerk.view;

import org.javacream.training.java.aufbau.heizkraftwerk.Context;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WartungsStage {
	private Stage stage;
	public Stage getStage() {
		return stage;
	}

	public void init() {
		stage = new Stage();
		Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        buildUi(root.getChildren());
        stage.setScene(scene);
        stage.setX(0);
        stage.setY(300);

        stage.show();
	}
	private void buildUi(ObservableList<Node> children) {
		Button putzen = new Button();
		putzen.setText("Ofen reinigen");
		putzen.setOnAction((event) -> Context.getWartungsController().reinigung());
		putzen.setLayoutY(80);
		putzen.setLayoutX(100);
		children.add(putzen);
	}

}
