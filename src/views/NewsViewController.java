package controllers;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;



public class NewsViewController {
	
	    @FXML
	    private MenuButton flights;

	    @FXML
	    private MenuButton language;

	    @FXML
	    private Button login;

	    @FXML
	    private Button news;

	    @FXML
	    private Button signup;

	    @FXML
	    void flights(ActionEvent event)throws IOException {
	    	this.flights((Node) event.getSource());

	    } 
	    
	    private void flights(Node source) throws IOException {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/views/.fxml")
					);
			Parent pane = loader.load();
			Scene scene = new Scene(pane, 640, 400);
			Stage primaryStage = (Stage) source.getScene().getWindow();
			primaryStage.setScene(scene);
		}

	    @FXML
	    void language(ActionEvent event) throws IOException {
            this.language((Node) event.getSource());

	    }
	    
	    private void language(Node source) throws IOException {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/views/.fxml")
					);
			Parent pane = loader.load();
			Scene scene = new Scene(pane, 640, 400);
			Stage primaryStage = (Stage) source.getScene().getWindow();
			primaryStage.setScene(scene);
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
			Scene scene = new Scene(pane, 940, 760);
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
			
}


