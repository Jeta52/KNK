package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import utilities.I18N;


public class AdminViewController {
    @FXML
    private Button arrivals_btn;
	
    @FXML
    private Button departures_btn;

    @FXML
    private MenuButton language;

    @FXML
    private Button login;

    @FXML
    private Button signup;
    
    @FXML
    private MenuItem eng;

    @FXML
    private MenuItem ger;
    
    @FXML
    private MenuItem al;

    
	@FXML
	private void arrivalsEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
			this.loadArrivals((Node) ae.getSource());
	}
	
	@FXML
	private void departuresHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
			this.loadDepartures((Node) ae.getSource());
	}
	
	private void loadArrivals(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/AdddView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 920, 760);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
	
	private void loadDepartures(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/AddView1.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 920, 760);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
	
    @FXML
    void language(ActionEvent event) throws IOException {
    	
    	eng.setOnAction(a-> {
    		english(a);
    	});
    	ger.setOnAction(a-> {
    		german(a);
    	});
    	al.setOnAction(a-> {
    		albanian(a);
    	});
    	language.getItems().addAll(eng,ger,al);
    	
    }
    @FXML
   void english(ActionEvent event) {
    	loadMessages("en");
    	
    }

    @FXML
    void german(ActionEvent event) {
         loadMessages("de");
    
    }
    
    @FXML
    void albanian(ActionEvent event) {
          loadMessages("al");
    	
    }
    
    private ResourceBundle bundle;
    private void loadMessages(String messages) {
    	Locale locale = new Locale(messages);
        bundle = ResourceBundle.getBundle("resources.messages",locale);
    	login.setText(bundle.getString("Button1"));
    	signup.setText(bundle.getString("Button2"));
    	language.setText(bundle.getString("MenuButton"));
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
