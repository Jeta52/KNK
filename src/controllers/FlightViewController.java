package controllers;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Flight2;

public class FlightViewController implements Initializable{
	
	

    @FXML
    private TableColumn<Flight2, String> airline;

    @FXML
    private TableColumn<Flight2, String> date;

    @FXML
    private TableColumn<Flight2, String> eta;

    @FXML
    private TableColumn<Flight2, String> flight;

    @FXML
    private TableColumn<Flight2, String> from;

    @FXML
    private TableColumn<Flight2, String> scheduled;

    @FXML
    private TableColumn<Flight2, String> status;

    @FXML
    private TableView<Flight2> table;

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

    } private void flights(Node source) throws IOException {
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

			

		@Override
		public void initialize(URL url, ResourceBundle rb) {
			
			ObservableList<Flight2>list1=FXCollections.observableArrayList(
					new Flight2("EW6617", "ETF AIRWAYS","Bremen", "21 May", "11:30", "11:25","ARRIVED 11:12"),
					new Flight2("OS767", "AUSTRIAN AIRLINES","Vienna", "21 May", "11:40", "12:31","ARRIVED 12:31"),
					new Flight2("W97792", "WIZZ AIR UK","London-Lutton", "21 May", "12:05", "11:49","ARRIVED 11:50"),
					new Flight2("EW6603", "EUROWINGS","Hannover", "21 May", "12:35", "13:06","TAKE OFF 12:11"),
					new Flight2("W67788", "WIZZ AIR HUNGARY", "Basel - Mulhouse","21 May", "13:05", "13:32","ARRIVED 13:28"),
					new Flight2("E46051", "ENTER AIR","Basel - Mulhouse", "21 May", "13:15", "13:25	","ARRIVED 13:24"),
					new Flight2("EW5712", "EUROWINGS","Sttutgart", "21 May", "14:05", "14:05","APPROACH 13:57"),
					new Flight2("EZS1185", "EASYJET","SBasel - Mulhouse", "21 May", "14:20", "14:20","EXPECTED 14:20"),
					new Flight2("IV651", "GP AVIATION","Munich", "21 May", "16:25", "","CANCELLED"),
					new Flight2("C32505", "TRADE AIR","Dusseldorf", "21 May", "16:25", "","SCHEDULED"),
			
					new Flight2("EW6617", "ETF AIRWAYS","Bremen", "21 May", "11:30", "11:25","ARRIVED 11:12"),
					new Flight2("OS767", "AUSTRIAN AIRLINES","Vienna", "21 May", "11:40", "12:31","ARRIVED 12:31"),
					new Flight2("W97792", "WIZZ AIR UK","London-Lutton", "21 May", "12:05", "11:49","ARRIVED 11:50"),
					new Flight2("EW6603", "EUROWINGS","Hannover", "21 May", "12:35", "13:06","TAKE OFF 12:11"),
					new Flight2("W67788", "WIZZ AIR HUNGARY", "Basel - Mulhouse","21 May", "13:05", "13:32","ARRIVED 13:28"),
					new Flight2("E46051", "ENTER AIR","Basel - Mulhouse", "21 May", "13:15", "13:25	","ARRIVED 13:24"),
					new Flight2("EW5712", "EUROWINGS","Sttutgart", "21 May", "14:05", "14:05","APPROACH 13:57"),
					new Flight2("EZS1185", "EASYJET","SBasel - Mulhouse", "21 May", "14:20", "14:20","EXPECTED 14:20"),
					new Flight2("IV651", "GP AVIATION","Munich", "21 May", "16:25", "","CANCELLED"),
					new Flight2("C32505", "TRADE AIR","Dusseldorf", "21 May", "16:25", "","SCHEDULED"));
			flight.setCellValueFactory(new PropertyValueFactory<Flight2,String>("flight"));
			airline.setCellValueFactory(new PropertyValueFactory<Flight2,String>("airline"));
			date.setCellValueFactory(new PropertyValueFactory<Flight2,String>("date"));
			from.setCellValueFactory(new PropertyValueFactory<Flight2,String>("from"));
			scheduled.setCellValueFactory(new PropertyValueFactory<Flight2,String>("scheduled"));
			eta.setCellValueFactory(new PropertyValueFactory<Flight2,String>("eta"));
			status.setCellValueFactory(new PropertyValueFactory<Flight2,String>("status"));
			
			table.setItems(list1);
			
			table.refresh();
			
		
	}

}
