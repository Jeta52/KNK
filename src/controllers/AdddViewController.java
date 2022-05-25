package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

import database.DBConnect;
import model.AddFlight;



public class AdddViewController implements Initializable {
	@FXML
    private TableColumn<AddFlight, String> Airline;

    @FXML
    private TableColumn<AddFlight, String> Date;

    @FXML
    private TableColumn<AddFlight, String> Eta;

    @FXML
    private TableColumn<AddFlight, String> Flight;

    @FXML
    private TableColumn<AddFlight, String> From;

    @FXML
    private TableColumn<AddFlight, String> Scheduled;

    @FXML
    private TableColumn<AddFlight, String> Status;

    @FXML
    private TableView<AddFlight> Table;

    @FXML
    private Button addFlight;
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
    private Hyperlink flightHyp1;
    

    
    
int index = -1;
    
ObservableList<AddFlight> listM;
ObservableList<AddFlight> dataList;

    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
   

    
    public void Add_flights (){    
        conn = DBConnect.connection();
        String sql="insert into flights1(flight1, airline1,from1,date1,scheduled1,eta,status1)values(?,?,?,?,?,?,?)";
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
    	txt_from.setText(From.getCellData(index).toString());
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
    		String sql = "update flights1 set flight1= '"+value1+"',airline1= '"+value2+"',from1= '"+
                    value3+"',date1= '"+value4+"',scheduled1= '"+value5+"',eta= '"+value6+"',status1= '"+value5+"' where flight1='"+value1+"' ";
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
	  String sql="delete from flights1 where flight1=?";
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
	  Flight.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("flight2"));
	  Airline.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("airline2"));
	  From.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("from2"));
	  Date.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("date2"));
	  Scheduled.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("scheduled2"));
	 Eta.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("eta2"));
	  Status.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("status2"));
	  listM=DBConnect.getFlight();
	  Table.setItems(listM);
	
  }
  
  @FXML
  void  search_flight() {
	  //	  Flight.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("flight2"));
//	  Airline.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("airline2"));
//	  From.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("from2"));
//	  Date.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("date2"));
//	  Scheduled.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("scheduled2"));
//	 Eta.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("eta2"));
//	  Status.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("status2"));
//	  
//	  
//	  dataList=DBConnect.getFlight();
//	  Table.setItems(dataList);
//	  
//	  FilteredList<AddFlight>filteredData=new FilteredList<>(dataList,b->true);
//	  
//	  filterField.textProperty().addListener((observable,oldValue,newValue)->{
//		  filteredData.setPredicate(person->{
//			  if(newValue==null||newValue.isEmpty()) {
//				  return true;
//			  }
//			  String lowerCaseFilter=newValue.toLowerCase();
//			  
//			  if(person.getFlight().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
//				  return true;
//			  }else if(person.getAirline().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
//				  return true;
//			  }else if(person.getFrom().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
//				  return true;
//			  }else if(person.getDate().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
//				  return true;
//			  }else if(person.getScheduled().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
//				  return true;
//			  }else if(person.getEta().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
//				  return true;
//			  }else if(person.getStatus().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
//				  return true;
//			  }else
//				  return false;
//			  
//			  
//		  });
//	  });
//	  SortedList<AddFlight>sortedData=new SortedList<>(filteredData);
//	  sortedData.comparatorProperty().bind(Table.comparatorProperty());
//	  Table.setItems(sortedData);
  }
	@FXML
	private void adminHandler1(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
			this.loadAdmin1((Node) ae.getSource());
	}
	
	private void loadAdmin1(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/AddView1.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 920, 760);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
  
  
  
  
   	ObservableList<AddFlight>list3=FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
			try {
			Connection con=DBConnect.connection();
			ResultSet rs=con.createStatement().executeQuery("select * from flights1");
			
			while (rs.next()) {
				list3.add(new AddFlight(rs.getString("flight1"),rs.getString("airline1"),rs.getString("from1"),rs.getString("date1"),rs.getString("scheduled1"),rs.getString("eta"),rs.getString("status1")));
			}
			
			
		}catch(SQLException ex) {
			Logger.getLogger(FlightViewController.class.getName()).log(Level.SEVERE,null, ex);
		}
		Flight.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("flight"));
		Airline.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("airline"));
		Date.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("date"));
		From.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("from"));
		Scheduled.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("scheduled"));
		Eta.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("eta"));
		Status.setCellValueFactory(new PropertyValueFactory<AddFlight,String>("status"));
		
		Table.setItems(list3);
		
		 FilteredList<AddFlight>filteredData=new FilteredList<>(list3,b->true);
		  
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
		  SortedList<AddFlight>sortedData=new SortedList<>(filteredData);
		  sortedData.comparatorProperty().bind(Table.comparatorProperty());
		  Table.setItems(sortedData);
//		UpdateTable();
//		search_flight();
		
		
	}


	
}
