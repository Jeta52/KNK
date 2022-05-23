package controllers;


import java.io.IOException;
import java.net.URL;
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



public class HomeViewController {
	


	    @FXML
	    private MenuButton language;

	    @FXML
	    private Button login;

	    @FXML
	    private Button news;

	    @FXML
	    private Button signup;

	    @FXML
	    private Button arrivals;


	    @FXML
	    private Button departures;
	    
	    @FXML
	    private MenuItem eng;

	    @FXML
	    private MenuItem ger;
	    
//	    @FXML
//	    private Button bt;
//	    
//	    
//	    @FXML
//	    void bt (ActionEvent event) throws Exception{
//	    	this.initialize(null, null);
//	    	
//	    }
//	    
//	  
//	    private void initialize(URL location, ResourceBundle resources) {
//	        I18N.setLocale(resources.getLocale());
//	    }

	    @FXML
	    void language(ActionEvent event) throws IOException {
            this.language((Node) event.getSource());

	    }
	    private void language(Node source) throws IOException {
			
		}
	    @FXML
	    void login(ActionEvent event) throws IOException{
	    	this.login((Node) event.getSource());
	    }
	    private void login(Node source) throws IOException {
				FXMLLoader loader = new FXMLLoader(
						getClass().getResource("/views/LoginView.fxml")
						);
				Parent pane = loader.load();
				Scene scene = new Scene(pane, 640, 400);
				Stage primaryStage = (Stage) source.getScene().getWindow();
				primaryStage.setScene(scene);
			}

	    @FXML
	    void news(ActionEvent event) throws IOException{
	    	this.news((Node) event.getSource());
	    }
	    private void news(Node source) throws IOException {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/views/NewsView.fxml")
					);
			Parent pane = loader.load();
			Scene scene = new Scene(pane, 920, 760);
			Stage primaryStage = (Stage) source.getScene().getWindow();
			primaryStage.setScene(scene);
		}
	    
	    @FXML
	    void signup(ActionEvent event )throws IOException {
	    	
	    	this.signup((Node) event.getSource());
	    
	    }
	   
	    private void signup(Node source) throws IOException {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/views/SignUpView.fxml")
					);
			Parent pane = loader.load();
			Scene scene = new Scene(pane, 640, 400);
			Stage primaryStage = (Stage) source.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);		
		}


	    
	    @FXML
	    void arrivals(ActionEvent event )throws IOException {
	    	
	    	this.arrivals((Node) event.getSource());
	    
	    }
	   
	    private void arrivals(Node source) throws IOException {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/views/FlightView.fxml")
					);
			Parent pane = loader.load();
			Scene scene = new Scene(pane, 920, 760);
			Stage primaryStage = (Stage) source.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);	
	    }
			
			
			  
		    @FXML
		    void departures(ActionEvent event )throws IOException {
		    	
		    	this.departures((Node) event.getSource());
		    
		    }
		   
		    private void departures(Node source) throws IOException {
				FXMLLoader loader = new FXMLLoader(
						getClass().getResource("/views/FlightView2.fxml")
						);
				Parent pane = loader.load();
				Scene scene = new Scene(pane, 920, 760);
				Stage primaryStage = (Stage) source.getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);	


		    }
		    @FXML
		    void eng(ActionEvent event) {
		    	I18N.setLocale(Locale.ENGLISH);

		    }

		    @FXML
		    void ger(ActionEvent event) {
		    	I18N.setLocale(Locale.GERMAN);
		    }

		 



}

