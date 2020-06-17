package com.project.LoginWindow;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class LoginWindowController {

	@FXML
	private String userName;
	
	@FXML
	private String UserPass;
	
	
	
	
	@FXML
	public void cancelButtonClick() {
		Platform.exit();
	}
	
	
	@FXML
	public static void OkButtonClick() {
		
	}
	
	
	
	
	
}
