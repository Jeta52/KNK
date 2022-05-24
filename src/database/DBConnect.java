package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import model.AddFlight;
import model.AddFlight1;

public class DBConnect {
	public static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static String IP = "localhost:3306";
	private static String DATABASE_NAME = "airport";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";
	private Connection conn;
	
	public static DBConnect getInstance() {
		return new DBConnect();
	}
	
	
	
	private DBConnect() { 
		this.conn = DBConnect.connection();
	}
	
	public static Connection connection() {
		try {
			Class.forName(DBConnect.DRIVER_NAME);  
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+ DBConnect.IP +"/" + DBConnect.DATABASE_NAME,
					DBConnect.USER_NAME,
					DBConnect.PASSWORD); 
			return con;
		}catch (Exception e) {
			return null;
		}
	}
	
	public ResultSet executeQuery(String query, String types, Object[] values) throws SQLException {
		PreparedStatement preparedStatement = this.conn.prepareStatement(query);
		for(int i = 0; i < values.length; i++) {
			if( types.charAt(i) == 'i') {
				preparedStatement.setInt(i+1, (int) values[i]);
			}else if( types.charAt(i) == 's') {
				preparedStatement.setString(i+1, (String) values[i]);
			}else {
				// ---
			}
		}
		return preparedStatement.executeQuery();
	}
	
	public int execute(String query, String types, Object[] values) throws SQLException {
		PreparedStatement preparedStatement = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		for(int i = 0; i < values.length; i++) {
			if( types.charAt(i) == 'i') {
				preparedStatement.setInt(i+1, (int) values[i]);
			}else if( types.charAt(i) == 's') {
				preparedStatement.setString(i+1, (String) values[i]);
			}else {
				// ---
			}
		}

		int lastInsertedId = 0;
		
		preparedStatement.execute();
		
		ResultSet res = preparedStatement.getGeneratedKeys();
		if(res.next()) {
			lastInsertedId = res.getInt(1);
		}
		
		preparedStatement.close();
		this.close();
		
		return lastInsertedId;
	}
	
	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ObservableList<AddFlight>getFlight(){
    	Connection conn=connection();
    	
    	ObservableList<AddFlight>list=FXCollections.observableArrayList();
    	try {
    		PreparedStatement ps=conn.prepareStatement("select * from flights1");
    		ResultSet rs=ps.executeQuery(); 
    		while(rs.next()) {
    			list.add(new AddFlight(rs.getString("flight2"),rs.getString("airline2"),rs.getString("from2"),rs.getString("date2"),rs.getString("scheduled2"),rs.getString("eta2"),rs.getString("status2")));
    			
    		}
    	}catch(Exception e) {
    		
    	}
    	
    	return list;
    }
	
	public static ObservableList<AddFlight1>getFlight1(){
    	Connection conn = connection();
    	
    	ObservableList<AddFlight1>list=FXCollections.observableArrayList();
    	try {
    		PreparedStatement ps=conn.prepareStatement("select * from flights2");
    		ResultSet rs=ps.executeQuery();
    		while(rs.next()) {
    			list.add(new AddFlight1(rs.getString("flight2"),rs.getString("airline2"),rs.getString("to2"),rs.getString("date2"),rs.getString("scheduled2"),rs.getString("etd2"),rs.getString("status2")));	
    		}
    	}catch(Exception e) {
    		
    	}
    	
    	return list;
    }
	
    public ResultSet count_values(String tableName, String groupby) throws SQLException {

    	String query = "select month("+groupby+"), monthname("+groupby+"), count(*)  from "+ tableName+" group by month("+groupby+") order by  month("+groupby+") asc";
   
    	ResultSet rs =  this.conn.createStatement().executeQuery(query);
    	System.out.println(rs);
        return rs;
    }
    


	
}