package model;

import java.sql.ResultSet;

public class Login {
	private int id;
	private String username;
	private String password;
	private String saltedhash;
	private String salted;
	
	public static Login createFromResultSet(ResultSet res) throws Exception {
		int id = res.getInt("id");
		String username = res.getString("username");
		String password = res.getString("password");
		String saltedhash = res.getString("saltedhash");
		String salted = res.getString("salted");

		
		return new Login(id, username, password, saltedhash, salted);
	}
	
	public static Login createFromValue(
			int id, 
			String username, 
			String password,
			String saltedhash, 
			String salted
			) {
		return new Login(id, username, password, saltedhash, salted);
	}
	
	private Login(int id, String username, String password, String saltedhash, String salted) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.saltedhash = saltedhash;
		this.salted = salted;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getSaltedHash() {
		return saltedhash;
	}
	
	public String getSalt() {
		return salted;
	}
	
	public void setUId(int id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSaltedHash(String saltedhash) {
		this.saltedhash = saltedhash;
	}
	
	public void setSalted(String salted) {
		this.salted = salted;
	}
}
