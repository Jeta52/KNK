package controllers;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import database.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.AddFlight1;




public class AddViewController1 implements Initializable {
	@FXML
    private TableColumn<AddFlight1, String> Airline;

    @FXML
    private TableColumn<AddFlight1, String> Date;

    @FXML
    private TableColumn<AddFlight1, String> Eta;

    @FXML
    private TableColumn<AddFlight1, String> Flight;

    @FXML
    private TableColumn<AddFlight1, String> To;

    @FXML
    private TableColumn<AddFlight1, String> Scheduled;

    @FXML
    private TableColumn<AddFlight1, String> Status;

    @FXML
    private TableView<AddFlight1> Table;

    @FXML
    private Button AddFlight1;
    @FXML
    private Button delete;
    @FXML
    private Button update;

    @FXML
    private TextField txt_airline;

    @FXML
    private TextField txt_date;

    @FXML
    private TextField txt_eta;

    @FXML
    private TextField txt_flight;

    @FXML
    private TextField txt_from;

    @FXML
    private TextField txt_scheduled;

    @FXML
    private TextField txt_status;
    @FXML
    private TextField filterField;
    
    @FXML
    private Hyperlink flighthyp;
    
    
    
int index = -1;
    
ObservableList<AddFlight1> listM;
ObservableList<AddFlight1> dataList;

    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
   

    
    public void Add_flights (){    
        conn = DBConnect.connection();
        String sql="insert into flights2(flight2, airline2 ,to2,date2,scheduled2,etd2,status2)values(?,?,?,?,?,?,?)";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(1, txt_flight.getText());
    		pst.setString(2, txt_airline.getText());
    		pst.setString(3, txt_from.getText());
    		pst.setString(4, txt_date.getText());
    		pst.setString(5, txt_scheduled.getText());
    		pst.setString(6, txt_eta.getText());
    		pst.setString(7, txt_status.getText());
    		pst.execute();
    		JOptionPane.showMessageDialog(null, "Flight Add Success");
    		UpdateTable();
    		search_flight();
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}

    }
    @FXML
    void getSelected(MouseEvent event) {
    	index=Table.getSelectionModel().getSelectedIndex();
    	if(index<=-1) {
    		return;
    		
    	}
    	txt_flight.setText(Flight.getCellData(index).toString());
    	txt_airline.setText(Airline.getCellData(index).toString());
    	txt_from.setText(To.getCellData(index).toString());
    	txt_date.setText(Date.getCellData(index).toString());
    	txt_scheduled.setText(Scheduled.getCellData(index).toString());
    	txt_eta.setText(Eta.getCellData(index).toString());
    	txt_status.setText(Status.getCellData(index).toString());
    }
    
    public void Edit() {
    	try {
    		conn=DBConnect.connection();
    		String value1=txt_flight.getText();
    		String value2=txt_airline.getText();
    		String value3=txt_from.getText();
    		String value4=txt_date.getText();
    		String value5=txt_scheduled.getText();
    		String value6=txt_eta.getText();
    		String value7=txt_status.getText();
    		String sql = "update flights2 set flight2= '"+value1+"',airline2= '"+value2+"',from2= '"+
                    value3+"',date2= '"+value4+"',scheduled2= '"+value5+"',eta= '"+value6+"',status2= '"+value5+"' where flight2='"+value1+"' ";
    		pst=conn.prepareStatement(sql);
    		pst.execute();
    		JOptionPane.showMessageDialog(null, "Update");
    		UpdateTable();
    		search_flight();
    		
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
    
    
    
    
  public void Delete() {
	  conn=DBConnect.connection();
	  String sql="delete from flights2 where flight2=?";
	  try {
		  pst=conn.prepareStatement(sql);
		  pst.setString(1, txt_flight.getText());
		  pst.execute();
		  JOptionPane.showMessageDialog(null, "Delete");
		  UpdateTable();
		  search_flight();
		  
	  }catch(Exception e) {
		  JOptionPane.showMessageDialog(null, e);
		  
	  }
  }
  
  public void UpdateTable() {
	  Flight.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("flight2"));
	  Airline.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("airline2"));
	  To.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("to2"));
	  Date.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("date2"));
	  Scheduled.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("scheduled2"));
	  Eta.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("etd2"));
	  Status.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("status2"));
	  listM=DBConnect.getFlight1();
	  Table.setItems(listM);
  }
  
  @FXML
  void  search_flight() {
	  Flight.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("flight2"));
	  Airline.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("airline2"));
	  To.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("to2"));
	  Date.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("date2"));
	  Scheduled.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("scheduled2"));
	 Eta.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("etd2"));
	  Status.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("status2"));
	  
	  
	  dataList=DBConnect.getFlight1();
	  Table.setItems(dataList);
	  
	  FilteredList<AddFlight1>filteredData=new FilteredList<>(dataList,b->true);
	  
	  filterField.textProperty().addListener((observable,oldValue,newValue)->{
		  filteredData.setPredicate(person->{
			  if(newValue==null||newValue.isEmpty()) {
				  return true;
			  }
			  String lowerCaseFilter=newValue.toLowerCase();
			  
			  if(person.getFlight().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
				  return true;
			  }else if(person.getAirline().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
				  return true;
			  }else if(person.getFrom().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
				  return true;
			  }else if(person.getDate().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
				  return true;
			  }else if(person.getScheduled().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
				  return true;
			  }else if(person.getEta().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
				  return true;
			  }else if(person.getStatus().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
				  return true;
			  }else
				  return false;
			  
			  
		  });
	  });
	  SortedList<AddFlight1>sortedData=new SortedList<>(filteredData);
	  sortedData.comparatorProperty().bind(Table.comparatorProperty());
	  Table.setItems(sortedData);
  }
 		
	@FXML
	private void adminHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
			this.loadAdmin((Node) ae.getSource());
	}
	
	private void loadAdmin(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/AdddView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 842, 526);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
	
	ObservableList<AddFlight1> list = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Connection con = DBConnect.connection();
			ResultSet rs = con.createStatement().executeQuery("select * from flights2");
			
			while(rs.next()) {
				list.add(new AddFlight1(rs.getString("flight2"),rs.getString("airline2"),rs.getString("to2"),rs.getString("date2"),rs.getString("scheduled2"),rs.getString("etd2"),rs.getString("status2")));
			}
		}catch(SQLException ex) {
			Logger.getLogger(FlightViewController.class.getName()).log(Level.SEVERE,null, ex);
		}
		
		Flight.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("flight2"));
		Airline.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("airline2"));
		To.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("to2"));
		Date.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("date2"));
		Scheduled.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("scheduled2"));
		Eta.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("etd2"));
		Status.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("status2"));
	}
}