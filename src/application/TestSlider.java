/*
* Created by Oleg Volkov
*
* Copyright (c) 2016 Oleg Volkov. All Rights Reserved.
*/
package application;
	
import application.view.RootLayout;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Font;

/**
* Main application
*
* @version 1.01 22 Feb 2016
* @author Oleg Volkov
*/
public class TestSlider extends Application {
	
	/* Start method implementation */
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Initializing root layout and scene
			RootLayout root = new RootLayout(primaryStage);
			Scene scene = new Scene(root,10,10);
			
			// Loading stylesheet and custom font
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Font.loadFont("file:resources/fonts/festus.ttf", 16);
			
			// Showing primary stage
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Main method that launches application */
	public static void main(String[] args) {
		launch(args);
	}
}
