package com.project.LoginWindow;

import com.project.window.verification.UserVerification;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController {

	private Stage loginStage;
	
	@FXML
	private TextField userNameField;
	
	@FXML
	private  PasswordField userPassField;

	@FXML
	private  Button okButton;

	@FXML
	private  Button canceButton;

	public void initializeLoginPage() throws Exception {
		loginStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("LoginWindowForm.fxml"));
		loginStage.setTitle("Logowanie użytkownika");
		loginStage.setScene(new Scene(root, 300, 120));
		loginStage.setResizable(false);
		loginStage.centerOnScreen();
		loginStage.show();

	}

	@FXML
	private void cancelButtonClick() {
		Platform.exit();
	}

	@FXML
	private void OkButtonClick() throws Exception {
		String user = userNameField.getText();
		String pass = userPassField.getText();
		UserVerification verification = new	UserVerification("PATH");
		boolean IsCorrectPaswordAndUser = verification.isDataLoginCorrect(user,	pass);
		if (IsCorrectPaswordAndUser) {
			Stage stage = (Stage) okButton.getScene().getWindow();
			stage.close();
			MainWindowContorller mainWindowContorller = new MainWindowContorller();
			mainWindowContorller.initializeMainWindow();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Błąd");
			alert.setHeaderText("Niepoprawna nazwa użytkownika lub niewłaściwe hasło!");
			alert.showAndWait();
			
		}

	}

}
