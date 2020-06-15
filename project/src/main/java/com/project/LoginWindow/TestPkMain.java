package com.project.LoginWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestPkMain extends Application {

	
    @Override
    public void start(Stage primaryStage) throws Exception{
      Parent root = FXMLLoader.load(getClass().getResource("LoginWindowForm.fxml"));



        primaryStage.setTitle("Rejestracja Użytkownika");
        primaryStage.setScene(new Scene(root, 300, 110));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



}
