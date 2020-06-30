package com.project.LoginWindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowContorller {

	 Stage mainStage;
	
	
	public void initializeMainWindow() throws Exception {
		mainStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("MainWindowForm.fxml"));
		mainStage.setTitle("Faktorio");
		mainStage.setScene(new Scene(root, 1200, 900));
		mainStage.getOnCloseRequest();
		mainStage.show();
		
	}
	
	
	
}
