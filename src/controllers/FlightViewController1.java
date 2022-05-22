package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
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
import javafx.util.Callback;
import model.Flight1;


public class FlightViewController1 implements Initializable{
	
	

	@FXML
    private TableColumn<Flight1, String> airline1;

    @FXML
    private TableColumn<Flight1, String> date1;

    @FXML
    private TableColumn<Flight1, String> etd;

    @FXML
    private TableColumn<Flight1, String> flight1;

    @FXML
    private TableColumn<Flight1, String> scheduled1;

    @FXML
    private TableColumn<Flight1, String> status1;

    @FXML
    private TableView<Flight1> table1;

    @FXML
    private TableColumn<Flight1, String> to;
	
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

    	ObservableList<Flight1>list=FXCollections.observableArrayList(
    			new Flight1("IV650", "GP AVIATION","Munich", "21 May", "11:30", "","CANCELLED"),
    			new Flight1("IV630", "GP AVIATION","Sttutgart", "21 May", "12:00", "12:00","TAKE OFF 12:11"),
    			new Flight1("OS768", "AUSTRIAN AIRLINES","Vienna", "21 May", "12:25", "13:15","TAKE OFF 13:12"),
    			new Flight1("W97791", "WIZZ AIR UK","London - Luton", "21 May", "12:40", "12:40","TAKE OFF 12:44"),
    			new Flight1("LI1806", "ETF AIRWAYS","Basel - Mulhouse", "21 May", "12:55", "13:35","TAKE OFF 13:42"),
    			new Flight1("EW6622", "EUROWINGS","Geneve", "21 May", "13:25", "13:55","EXPECTED 13:55"),
    			new Flight1("W67787", "WIZZ AIR HUNGARY","Basel - Mulhouse", "21 May", "13:45", "14:01","EXPECTED 14:01"),
    			new Flight1( "E46052","ENTER AIR", "Basel - Mulhouse","21 May", "14:05", "14:05","EXPECTED 14:05"),
    			new Flight1("EW5705", "EUROWINGS","Hamburg", "21 May", "14:45", "14:45","EXPECTED 14:45"),
    			new Flight1("EZS1186", "EASYJET","Sttutgart", "Basel - Mulhouse", "15:05", "15:05","EXPECTED 15:05"),
    			new Flight1("IV650", "GP AVIATION","Munich", "21 May", "11:30", "","CANCELLED"),
    			new Flight1("IV630", "GP AVIATION","Sttutgart", "21 May", "12:00", "12:00","TAKE OFF 12:11"),
    			new Flight1("OS768", "AUSTRIAN AIRLINES","Vienna", "21 May", "12:25", "13:15","TAKE OFF 13:12"),
    			new Flight1("W97791", "WIZZ AIR UK","London - Luton", "21 May", "12:40", "12:40","TAKE OFF 12:44"),
    			new Flight1("LI1806", "ETF AIRWAYS","Basel - Mulhouse", "21 May", "12:55", "13:35","TAKE OFF 13:42"),
    			new Flight1("EW6622", "EUROWINGS","Geneve", "21 May", "13:25", "13:55","EXPECTED 13:55"),
    			new Flight1("W67787", "WIZZ AIR HUNGARY","Basel - Mulhouse", "21 May", "13:45", "14:01","EXPECTED 14:01"),
    			new Flight1( "E46052","ENTER AIR", "Basel - Mulhouse","21 May", "14:05", "14:05","EXPECTED 14:05"),
    			new Flight1("EW5705", "EUROWINGS","Hamburg", "21 May", "14:45", "14:45","EXPECTED 14:45"),
    			new Flight1("EZS1186", "EASYJET","Sttutgart", "Basel - Mulhouse", "15:05", "15:05","EXPECTED 15:05"));
    			
    	 @Override
    		public void initialize(URL arg0, ResourceBundle arg1) {
    		 
    		 
    				flight1.setCellValueFactory(new PropertyValueFactory<Flight1,String>("flight1"));
    				airline1.setCellValueFactory(new PropertyValueFactory<Flight1,String>("airline1"));
    				date1.setCellValueFactory(new PropertyValueFactory<Flight1,String>("date1"));
    				to.setCellValueFactory(new PropertyValueFactory<Flight1,String>("to"));
    				scheduled1.setCellValueFactory(new PropertyValueFactory<Flight1,String>("scheduled1"));
    				etd.setCellValueFactory(new PropertyValueFactory<Flight1,String>("etd"));
    				status1.setCellValueFactory(new PropertyValueFactory<Flight1,String>("status1"));
    				
    				table1.setItems(list);
    				
    			}

	}


   
    

