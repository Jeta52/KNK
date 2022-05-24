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
    private TableColumn<AddFlight1,String > Airline1;

    @FXML
    private TableColumn<AddFlight1,String> Date1;

    @FXML
    private TableColumn<AddFlight1,String> Eta1;

    @FXML
    private TableColumn<AddFlight1,String> Flight1;

    @FXML
    private TableColumn<AddFlight1,String> Scheduled1;

    @FXML
    private TableColumn<AddFlight1,String> Status1;

    @FXML
    private TableView<AddFlight1> Table1;

    @FXML
    private TableColumn<AddFlight1,String> To1;

    @FXML
    private Button addFlight1;

    @FXML
    private Button delete1;

    @FXML
    private TextField filterField1;

    @FXML
    private Hyperlink flightHyp;

    @FXML
    private TextField txt_airline1;

    @FXML
    private TextField txt_date1;

    @FXML
    private TextField txt_etd1;

    @FXML
    private TextField txt_flight1;

    @FXML
    private TextField txt_scheduled1;

    @FXML
    private TextField txt_status1;

    @FXML
    private TextField txt_to1;

    @FXML
    private Button update1;

    
    
    
int index = -1;
    
ObservableList<AddFlight1> listN;
ObservableList<AddFlight1> DataList;

    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
   

    
    public void Add_flights1 (){    
        conn = DBConnect.connection();
        String sql="insert into flights2(flight2, airline2 ,to2,date2,scheduled2,etd2,status2)values(?,?,?,?,?,?,?)";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(1, txt_flight1.getText());
    		pst.setString(2, txt_airline1.getText());
    		pst.setString(3, txt_to1.getText());
    		pst.setString(4, txt_date1.getText());
    		pst.setString(5, txt_scheduled1.getText());
    		pst.setString(6, txt_etd1.getText());
    		pst.setString(7, txt_status1.getText());
    		pst.execute();
    		JOptionPane.showMessageDialog(null, "Flight Add Success");
    		UpdateTable1();
    		search_flight1();
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}

    }
    @FXML
    void getSelected1(MouseEvent event) {
    	index=Table1.getSelectionModel().getSelectedIndex();
    	if(index<=-1) {
    		return;
    		
    	}
    	txt_flight1.setText(Flight1.getCellData(index).toString());
    	txt_airline1.setText(Airline1.getCellData(index).toString());
    	txt_to1.setText(To1.getCellData(index).toString());
    	txt_date1.setText(Date1.getCellData(index).toString());
    	txt_scheduled1.setText(Scheduled1.getCellData(index).toString());
    	txt_etd1.setText(Eta1.getCellData(index).toString());
    	txt_status1.setText(Status1.getCellData(index).toString());
    }
    
    public void Edit1() {
    	try {
    		conn=DBConnect.connection();
    		String value1=txt_flight1.getText();
    		String value2=txt_airline1.getText();
    		String value3=txt_to1.getText();
    		String value4=txt_date1.getText();
    		String value5=txt_scheduled1.getText();
    		String value6=txt_etd1.getText();
    		String value7=txt_status1.getText();
    		String sql = "update flights2 set flight2= '"+value1+"',airline2= '"+value2+"',to2= '"+
                    value3+"',date2= '"+value4+"',scheduled2= '"+value5+"',etd2= '"+value6+"',status2= '"+value5+"' where flight2='"+value1+"' ";
    		pst=conn.prepareStatement(sql);
    		pst.execute();
    		JOptionPane.showMessageDialog(null, "Update");
    		UpdateTable1();
    		search_flight1();
    		
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
    
    
    
    
  public void Delete1() {
	  conn=DBConnect.connection();
	  String sql="delete from flights2 where flight2=?";
	  try {
		  pst=conn.prepareStatement(sql);
		  pst.setString(1, txt_flight1.getText());
		  pst.execute();
		  JOptionPane.showMessageDialog(null, "Delete");
		  UpdateTable1();
		  search_flight1();
		  
	  }catch(Exception e) {
		  JOptionPane.showMessageDialog(null, e);
		  
	  }
  }
  
  public void UpdateTable1() {
	  Flight1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("flight2"));
	  Airline1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("airline2"));
	  To1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("to2"));
	  Date1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("date2"));
	  Scheduled1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("scheduled2"));
	  Eta1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("etd2"));
	  Status1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("status2"));
	  listN=DBConnect.getFlight1();
	  Table1.setItems(listN);
  }
  
  @FXML
  void  search_flight1() {
//	  Flight.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("flight2"));
//	  Airline.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("airline2"));
//	  To.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("to2"));
//	  Date.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("date2"));
//	  Scheduled.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("scheduled2"));
//	 Eta.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("etd2"));
//	  Status.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("status2"));
//	  
//	  
//	  dataList=DBConnect.getFlight1();
//	  Table.setItems(dataList);
//	  
//	  FilteredList<AddFlight1>filteredData=new FilteredList<>(dataList,b->true);
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
//	  SortedList<AddFlight1>sortedData=new SortedList<>(filteredData);
//	  sortedData.comparatorProperty().bind(Table.comparatorProperty());
//	  Table.setItems(sortedData);
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
			Logger.getLogger(FlightViewController1.class.getName()).log(Level.SEVERE,null, ex);
		}
		
		Flight1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("flight"));
		Airline1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("airline"));
		To1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("to"));
		Date1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("date"));
		Scheduled1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("scheduled"));
		Eta1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("etd"));
		Status1.setCellValueFactory(new PropertyValueFactory<AddFlight1,String>("status"));
		
		Table1.setItems(list);
		
		 FilteredList<AddFlight1>filteredData=new FilteredList<>(list,b->true);
		  
		  filterField1.textProperty().addListener((observable,oldValue,newValue)->{
			  filteredData.setPredicate(person->{
				  if(newValue==null||newValue.isEmpty()) {
					  return true;
				  }
				  String lowerCaseFilter=newValue.toLowerCase();
				  
				  if(person.getFlight().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
					  return true;
				  }else if(person.getAirline().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
					  return true;
				  }else if(person.getTo().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
					  return true;
				  }else if(person.getDate().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
					  return true;
				  }else if(person.getScheduled().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
					  return true;
				  }else if(person.getEtd().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
					  return true;
				  }else if(person.getStatus().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
					  return true;
				  }else
					  return false;
				  
				  
			  });
		  });
		  SortedList<AddFlight1>sortedData=new SortedList<>(filteredData);
		  sortedData.comparatorProperty().bind(Table1.comparatorProperty());
		  Table1.setItems(sortedData);
//		UpdateTable();
//		search_flight();
		
		
	}


	}
