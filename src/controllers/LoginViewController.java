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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import processor.LoginProcessor;

public class LoginViewController {
	private LoginProcessor loginProcessor;
	
	public LoginViewController() {
		loginProcessor = new LoginProcessor();
	}
	
	@FXML 
	private Button cancelButton;
	@FXML 
	private TextField emailTxtField;
	@FXML 
	private PasswordField passwordTxtField;
	@FXML 
	private Button signinButton;
	@FXML 
	private Hyperlink signUp;
	@FXML
	private Label loginMsgLabel;
	
	@FXML
	private void loginEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
		String email = this.emailTxtField.getText();
		String password = this.passwordTxtField.getText();
		
		if(this.loginProcessor.isUserValid(email, password) & email != "" || password != "" ) {
			if(this.loginProcessor.isUserAdmin(email)) {
				this.loadAddView((Node) ae.getSource());
			} else {
				this.loadHomePage((Node) ae.getSource());
			}
		}else {
			loginMsgLabel.setText("Please enter email and password !");
		}
	}
	
	@FXML
	private void signUpEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {

			this.loadSignUp((Node) ae.getSource());

	}
	
	@FXML
	private void cancelButtonOnAction(ActionEvent e)
	{
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
	
	
	private void loadHomePage(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/HomeView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 920, 760);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
	
	private void loadSignUp(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/SignUpView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 640, 400);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
	
	private void loadAddView(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/AdminView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 640, 400);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}

}
