package org.javacream.training.java.aufbau.javafx.util;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

public abstract class BaseApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        buildUi(root.getChildren());
        primaryStage.setScene(scene);
        primaryStage.show();
        Platform.setImplicitExit(true);
	}

	public abstract void buildUi(ObservableList<Node> children);
	
	

	
}
