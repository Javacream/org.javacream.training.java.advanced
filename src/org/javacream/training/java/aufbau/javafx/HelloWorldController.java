/**
 * Sample Skeleton for "HelloWorld.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package org.javacream.training.java.aufbau.javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HelloWorldController implements Initializable {

	@FXML
	private Button helloWorldButton; // Value injected by FXMLLoader

	public void sayHello(ActionEvent event) {
		System.out.println("Hello World");
	}

	
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert helloWorldButton != null : "fx:id=\"helloWorldButton\" was not injected: check your FXML file 'HelloWorld.fxml'.";
		helloWorldButton.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						System.out.println("Hello");
					}
				});
	}
}
