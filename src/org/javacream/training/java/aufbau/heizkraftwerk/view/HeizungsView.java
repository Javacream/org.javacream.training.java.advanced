package org.javacream.training.java.aufbau.heizkraftwerk.view;

import org.javacream.training.java.aufbau.heizkraftwerk.Context;
import org.javacream.training.java.aufbau.javafx.util.BaseApplication;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public class HeizungsView extends BaseApplication {

	@Override
	public void buildUi(ObservableList<Node> children) {
		HeizungsStage heizungsStage = Context.getHeizungsStage();
		WartungsStage wartungsStage = Context.getWartungsStage();
		heizungsStage.init();
		wartungsStage.init();
		heizungsStage.getStage().show();
		wartungsStage.getStage().show();
	}

}
