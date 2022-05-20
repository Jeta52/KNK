package repository;

import java.sql.ResultSet;

import database.DBConnect;
import database.FilterQueryBuilder;
import database.InsertQueryBuilder;
import model.CreateUserDTO;
import model.Login;


public class LoginRepository {
	private final String TABLE_NAME = "user";
	private DBConnect connection;
	
	public LoginRepository() {
		this.connection = DBConnect.getInstance();
	}
	
	public Login findOne(String email) {
		try {
			FilterQueryBuilder query = (FilterQueryBuilder)
					FilterQueryBuilder.create(this.TABLE_NAME)
					.addWhere("email", email , "s");
			ResultSet res = this.connection.executeQuery(query.getQuery(), query.getTypes(), query.getValues());
			if(res.next()) {
				return Login.createFromValue(
						res.getInt("id"),
						res.getString("email"),
						res.getString("saltedhash"),
						res.getString("salted")
						);
			}
			return null;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public boolean create(CreateUserDTO userDto) {
		try {
			InsertQueryBuilder query = (InsertQueryBuilder)
					InsertQueryBuilder.create("user")
					.add("id", 0, "i")
					.add("NAME", userDto.getName(), "s")
					.add("lastname", userDto.getLastName(), "s")
					.add("email", userDto.getEmail(), "s")
					.add("saltedhash", userDto.getSaltedHash(), "s")
					.add("salted", userDto.getSalted(), "s");
					;

			int lastInsertedId = 
					this.connection.execute(
							query.getQuery(), query.getTypes(), query.getValues()
							);
			if (lastInsertedId > 0) {
				return true;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
	}
}
