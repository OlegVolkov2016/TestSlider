/*
* Created by Oleg Volkov
*
* Copyright (c) 2016 Oleg Volkov. All Rights Reserved.
*/
package application.view;

import java.io.IOException;

import application.TestSlider;
import application.controller.RootLayoutController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
* View class for root layout
*
* @version 1.01 22 Feb 2016
* @author Oleg Volkov
*/
public class RootLayout extends BorderPane {
	
	/* Primary stage reference */
	private Stage primaryStage;
	
	/* View controller reference */
	private RootLayoutController controller;
	
	/* View controller constructor */
	public RootLayout(Stage primaryStage) {
		// TODO Auto-generated constructor stub
		
		// Initializing primary stage and layout
		this.primaryStage = primaryStage;
		initLayout();
	}
	
	/* View controller initializer */
	private void initLayout() {
		
		// Loading view from FXML file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestSlider.class.getResource("/application/view/RootLayout.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("IOException when loading: "+e.getMessage());		
		}
		
		// Getting controller
		controller = ((RootLayoutController) loader.getController());
		controller.setPrimaryStage(primaryStage);
		
		// Setting primary stage title and size
		primaryStage.setTitle("TestSlider");
		primaryStage.setMinWidth(10);
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX(bounds.getMaxX() - primaryStage.getMinWidth()-16);
		primaryStage.setY(bounds.getMinY());
		primaryStage.setHeight(bounds.getHeight());
		primaryStage.setResizable(false);
		
		// Stage width property
		WritableValue<Double> writableWidth = new WritableValue<Double>() {
	        @Override
	        public Double getValue() {
	            return primaryStage.getWidth();
	        }

	        @Override
	        public void setValue(Double value) {
	            primaryStage.setX(Screen.getPrimary().getVisualBounds().getMaxX() - value);
	            primaryStage.setWidth(value);
	        }
	    };
	    
	    // Stage on minimized listener
		primaryStage.iconifiedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
		    	// TODO Auto-generated method stub
		    	
		        if (t1 == true && !controller.getButtonSlider().isVisible()) {
		        	
		        	// Stage sliding out animation
		        	primaryStage.setIconified(false);
		        	Timeline timeline = new Timeline();
	                KeyFrame keyFrame = new KeyFrame(Duration.millis(3000), new KeyValue(writableWidth, 30.0));
	                timeline.getKeyFrames().add(keyFrame);
	                timeline.play();
	                
	                // Show slider button
	                controller.getButtonSlider().setVisible(true);
		        }
		    }
		});
	}
	
}
