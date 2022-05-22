package controllers;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.I18N;



public class AdminViewController {

	    
	    @FXML
	    void add(ActionEvent event )throws IOException {
	    	
	    	this.add((Node) event.getSource());
	    
	    }
	   
	    private void add(Node source) throws IOException {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/views/AdddView.fxml")
					);
			Parent pane = loader.load();
			Scene scene = new Scene(pane, 920, 760);
			Stage primaryStage = (Stage) source.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);	
	    }
			

		


}

