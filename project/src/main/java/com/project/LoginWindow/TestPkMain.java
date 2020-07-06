package com.project.LoginWindow;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class TestPkMain extends Application {
	
	

    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		

	
		primaryStage.close();
		LoginWindowController login = new LoginWindowController();
		login.initializeLoginPage();
	}

	



}

    


    
    




