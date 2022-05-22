package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminViewController {
	@FXML
	private Button arrivals_btn;
	
	@FXML
	private Button departures_btn;
	
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
	
}
