package com.application;

import java.net.URL;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainAppliction extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		URL viewUrl = getClass().getResource("/com/application/ui/main.fxml");
		
		//BorderPane root= (BorderPane)FXMLLoader.load(viewUrl);
		AnchorPane root = (AnchorPane)FXMLLoader.load(viewUrl);
	

		Scene scene = new Scene(root);
		
		
		primaryStage.setScene(scene);	
		primaryStage.setTitle("Taulanti ");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
			launch(args);
		}
}
