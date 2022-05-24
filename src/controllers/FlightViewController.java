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
    @FXML
    void language(ActionEvent event) throws IOException {
      //

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
	    	I18N.buttonForKey("button.english");
	    	switchLanguage(Locale.ENGLISH);

	    }

	    @FXML
	    void ger(ActionEvent event) {
	    	I18N.buttonForKey("button.german");
	    	switchLanguage(Locale.GERMAN);
	    }

	    
	    private Integer numSwitches = 0;
	    private void switchLanguage(Locale locale) {
	        numSwitches++;
	        I18N.setLocale(locale);
	    }

			
		ObservableList<Flight2>list1=FXCollections.observableArrayList();
		@Override
		public void initialize(URL url, ResourceBundle rb) {
			
			
			try {
				Connection con=DBConnect.connection();
				ResultSet rs=con.createStatement().executeQuery("select * from flights1");
				
				while (rs.next()) {
					list1.add(new Flight2(rs.getString("flight1"),rs.getString("airline1"),rs.getString("from1"),rs.getString("date1"),rs.getString("scheduled1"),rs.getString("eta"),rs.getString("status1")));
				}
				
				
			}catch(SQLException ex) {
				Logger.getLogger(FlightViewController.class.getName()).log(Level.SEVERE,null, ex);
			}
			flight.setCellValueFactory(new PropertyValueFactory<Flight2,String>("flight"));
			airline.setCellValueFactory(new PropertyValueFactory<Flight2,String>("airline"));
			date.setCellValueFactory(new PropertyValueFactory<Flight2,String>("date"));
			from.setCellValueFactory(new PropertyValueFactory<Flight2,String>("from"));
			scheduled.setCellValueFactory(new PropertyValueFactory<Flight2,String>("scheduled"));
			eta.setCellValueFactory(new PropertyValueFactory<Flight2,String>("eta"));
			status.setCellValueFactory(new PropertyValueFactory<Flight2,String>("status"));
			
			table.setItems(list1);
			
			//table.refresh();
			
		
	}

}
