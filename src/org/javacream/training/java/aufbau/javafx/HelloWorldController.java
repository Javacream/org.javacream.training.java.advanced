/**
 * Sample Skeleton for "HelloWorld.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package org.javacream.training.java.aufbau.javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Injected button: " + helloWorldButton);
	}

}	
