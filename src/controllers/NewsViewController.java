package controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ResourceBundle;

import database.DBConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;



public class NewsViewController implements Initializable{
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
    private MenuItem al;


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
	news.setText(bundle.getString("Button"));
	login.setText(bundle.getString("Button1"));
	signup.setText(bundle.getString("Button2"));
	arrivals.setText(bundle.getString("Button3"));
	departures.setText(bundle.getString("Button4"));
	language.setText(bundle.getString("MenuButton"));
}

		
	    @FXML
	    public BarChart barchart;
	    DBConnect dbc = DBConnect.getInstance();
	    String tableName = "flights1";
	    String groupby_column = "date1";
	    public XYChart.Series getDataSeriesBarChart() throws SQLException, ClassNotFoundException {
	        ResultSet db_data = dbc.count_values(tableName, groupby_column);

	        XYChart.Series dataSeries1 = new XYChart.Series();
	        while (db_data.next()) {
	        	
	            int value = db_data.getInt("count(*)");
	            String cond = "monthname("+groupby_column+")";
	            String key = db_data.getString(cond);
	            dataSeries1.getData().add(new XYChart.Data(key, value));
	        }
	        return dataSeries1;
	    }
	    

	 
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		      try {
		            this.barchart.getData().add(getDataSeriesBarChart());
		        }
		        catch (Exception ignore) {};
			
		}
	 
	    
}






