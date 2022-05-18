package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		this.conn = this.connection();
	}
	
	private static Connection connection() {
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

		ResultSet res = preparedStatement.getGeneratedKeys();
		if(res.next()) {
			lastInsertedId = res.getInt(1);
		}
		preparedStatement.execute();
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
}
