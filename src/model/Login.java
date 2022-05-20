package model;

import java.sql.ResultSet;

public class Login {
	private int id;
	private String email;
	private String saltedhash;
	private String salted;
	
	public static Login createFromResultSet(ResultSet res) throws Exception {
		int id = res.getInt("id");
		String email = res.getString("email");
		String saltedhash = res.getString("saltedhash");
		String salted = res.getString("salted");

		
		return new Login(id, email, saltedhash, salted);
	}
	
	public static Login createFromValue(
			int id, 
			String email, 
			String saltedhash,
			String salted
			) {
		return new Login(id, email ,saltedhash, salted);
	}
	
	private Login(int id, String email, String saltedhash, String salted) {
		this.id = id;
		this.email = email;
		this.saltedhash = saltedhash;
		this.salted = salted;
	}
	
	public int getId() {
		return id;
	}
	
	public String getemail() {
		return email;
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
	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public void setSaltedHash(String saltedhash) {
		this.saltedhash = saltedhash;
	}
	
	public void setSalted(String salted) {
		this.salted = salted;
	}
}
