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

    	ObservableList<Flight1>list=FXCollections.observableArrayList();
    	
    			
    	 @Override
    		public void initialize(URL arg0, ResourceBundle arg1) {
    		 
    		 
    				try {
    				Connection con=DBConnect.connection();
    				ResultSet rs=con.createStatement().executeQuery("select * from flights2");
    				
    				while (rs.next()) {
    					list.add(new Flight1(rs.getString("flight2"),rs.getString("airline2"),rs.getString("to2"),rs.getString("date2"),rs.getString("scheduled2"),rs.getString("etd2"),rs.getString("status2")));
    				}
    				
    				
    			}catch(SQLException ex) {
    				Logger.getLogger(FlightViewController.class.getName()).log(Level.SEVERE,null, ex);
    			}
    		 
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

	}


   
    

