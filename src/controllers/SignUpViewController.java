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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CreateUserDTO;
import processor.SignUpProcessor;

public class SignUpViewController {
	private SignUpProcessor signUpProcessor;
	
	public SignUpViewController() {
		signUpProcessor = new SignUpProcessor();
	}
	
	@FXML
	private TextField nameTxt;
	
	@FXML
	private TextField lastNameTxt;
	
	@FXML
	private PasswordField passField;
	
	@FXML
	private PasswordField passRepeatField;

	@FXML
	private TextField emailField;
	
	@FXML
	private Button signUpButton;
	
	@FXML
	private Hyperlink loginHyp;
	
	@FXML
	private Label msgLabel;
	
	@FXML 
	private CheckBox terms;
	
	@FXML
	private void signUpEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
		String name = nameTxt.getText();
		String lastname = lastNameTxt.getText();
		String password = passField.getText();
		String confirmPassword = passRepeatField.getText();
		String email = emailField.getText();
		
		if(!password.equals(confirmPassword)) {
			msgLabel.setText("The confirmed password was not the same !"); 
			return;
		} 
		
		CreateUserDTO dtoObject = new CreateUserDTO(
				name, lastname, email, password, confirmPassword);
		
		if(!this.signUpProcessor.notNull(name, lastname, password, confirmPassword, email)) {
			msgLabel.setText("Do not leave blank fields.");
		}
		
		if(!this.signUpProcessor.emailValidation(email)) {
			msgLabel.setText("Invalid email format!");
		}
		
		if(!this.signUpProcessor.checkTerms(terms)) {
			msgLabel.setText("You have to agree to our terms !");			
		}
		
		if(!this.signUpProcessor.passwordValidation(password)) {
			msgLabel.setText("Invalid password format !");
		}
		
		if(this.signUpProcessor.notNull(name, lastname, password, confirmPassword, email) && this.signUpProcessor.checkTerms(terms) 
		   && this.signUpProcessor.emailValidation(email) && this.signUpProcessor.passwordValidation(password)) {
			if(this.signUpProcessor.createNewUser(dtoObject) ) {
				this.loadLoginPage((Node) ae.getSource());
			}else {
				msgLabel.setText("Something went wrong."); 
			}
		}
	}
	
	@FXML
	private void loginEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException  {

			this.loadLoginPage((Node) ae.getSource());

	}

	
	private void loadLoginPage(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/LoginView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 640, 400);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
}
