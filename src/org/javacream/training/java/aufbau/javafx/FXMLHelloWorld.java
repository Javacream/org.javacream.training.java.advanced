package org.javacream.training.java.aufbau.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLHelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("FXML Hello World");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("HelloWorld.fxml"));
        loader.load();
        HelloWorldController controller = loader.getController();
        System.out.println(controller);
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
}
