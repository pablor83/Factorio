module JavaFX {
	exports com.project.LoginWindow;
	
	
	
	
    requires javafx.fxml;
    requires javafx.controls;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	
	
	
	
	
	opens com.project.LoginWindow to javafx.fxml;
	
	
   
}

