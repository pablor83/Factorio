package com.project.LoginWindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainWindowContorller {

	 Stage mainStage;
		 
	 private  Image programLogo = new Image("/programLogo.png");
	 
	
	  @FXML
	  private TableView<?> clientData;
	  
	  @FXML
	  public TableColumn<?, String> firstName;
	  
	  @FXML
	   public TableColumn<?, String> lastName;
	 
	  @FXML
	   public TableColumn<?, String> adress;
	  
	  @FXML
	   public TableColumn<?, String> nip;
	  
	  @FXML
	   public TableColumn<?, String> pesel;
	  
	  @FXML
	   public TableColumn<?, String> phoneNumber;
	  
	  @FXML
	   public TableColumn<?, String> comments;
	 
	 
	 
	
	public void initializeMainWindow() throws Exception {
		mainStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("MainWindowForm.fxml"));
		mainStage.setTitle("Faktorio");
		mainStage.getIcons().add(programLogo);
		mainStage.setScene(new Scene(root, 1200, 900));
		
		mainStage.getOnCloseRequest();
		mainStage.show();
		

		
	}
	
	
	
}
