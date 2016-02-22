/*
* Created by Oleg Volkov
*
* Copyright (c) 2016 Oleg Volkov. All Rights Reserved.
*/
package application.controller;

import application.model.TreeViewModel;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
* Controller class for root layout
*
* @version 1.01 22 Feb 2016
* @author Oleg Volkov
*/
public class RootLayoutController {
	
	/* Primary stage reference */
	private Stage primaryStage;
	
	/* FXML root layout elements */
	@FXML
	private CheckBox checkBox12, checkBox42, checkBox201;
	
	@FXML
	private TextField textSum;
	
	@FXML
	private TreeView<String> treeView;
	
	@FXML
	private Button buttonSlider;
	
	/* Controller initializer */
	@FXML
	private void initialize() {
		textSum.setText("0");
		treeView.setRoot(new TreeViewModel().getRoot());
	}
	
	/* On check boxes selected */
	@FXML
	private void onCheckBoxes() {
		updateSum();
	}
	
	/* On slider button clicked */
	@FXML
	private void onButtonSliderClick() {
		
		// Hide slider button
		buttonSlider.setVisible(false);
		
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
	    
	    // Stage sliding in animation
		Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(writableWidth, 300d);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(2000), keyValue);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();
	}
	
	/* Updating result field value */
	private void updateSum() {
		int sum = 0;
		sum += checkBox12.isSelected() ? 12 : 0;
		sum += checkBox42.isSelected() ? 42 : 0;
		sum += checkBox201.isSelected() ? 201 : 0;
		textSum.setText(sum + "");
	}
	
	/* Setter for primary stage */
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	/* Getter of slider button */
	public Button getButtonSlider() {
		return buttonSlider;
	}
}
