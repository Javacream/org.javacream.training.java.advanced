package org.javacream.training.java.aufbau.javafx;

import org.javacream.training.java.aufbau.javafx.util.BaseApplication;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class HelloWorldApplication2 extends BaseApplication {

	public static void main(String[] args) {
		Application.launch(HelloWorldApplication2.class, args);
	}

	@Override
	public void buildUi(ObservableList<Node> children) {

		Button btn = new Button();
		btn.setText("Hello World");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
			}
		});
        btn.setLayoutY(80);
        btn.setLayoutX(100);
		children.add(btn);
	}

}