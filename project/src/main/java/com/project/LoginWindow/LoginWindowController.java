package com.project.LoginWindow;

import com.project.window.verification.UserVerification;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController {

	private Stage loginStage;


	@FXML
	private TextField userNameField;

	@FXML
	private PasswordField userPassField;

	@FXML
	private Button okButton;

	@FXML
	private Button canceButton;

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
		UserVerification verification = new UserVerification();
		int IsCorrectPaswordAndUser = verification.isDataLoginCorrect(user, pass);
	
		if (IsCorrectPaswordAndUser == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Błąd");
			alert.setHeaderText(null);
			alert.setContentText("Bład połaczenia z bazą danych!");
			alert.showAndWait();
		} else if (IsCorrectPaswordAndUser == 1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Błąd");
			alert.setHeaderText(null);
			alert.setContentText("Niepoprawna nazwa użytkownika lub niewłaściwe hasło!");
			alert.showAndWait();
			
		} else if (IsCorrectPaswordAndUser == 2) {

			Stage stage = (Stage) okButton.getScene().getWindow();
			stage.close();
			MainWindowContorller mainWindowContorller = new MainWindowContorller();
			mainWindowContorller.initializeMainWindow();
		}

	}



}
