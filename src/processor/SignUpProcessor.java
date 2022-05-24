package processor;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.CheckBox;
import model.CreateUserDTO;
import repository.LoginRepository;

public class SignUpProcessor {
	private LoginRepository loginRepository;
	
	public SignUpProcessor() {
		this.loginRepository = new LoginRepository();
	}
	
	public boolean createNewUser(CreateUserDTO userDto) throws NoSuchAlgorithmException {
		String salted = GenerateHash.generateSalted();
		String saltedHash = GenerateHash.generate(
				userDto.getPassword(), salted);
		userDto.setSalted(salted);
		userDto.setSaltedHash(saltedHash);
		
		return this.loginRepository.create(userDto);
	}
	
	public boolean checkTerms(CheckBox terms) {
		if(terms.isSelected()) {
			return true;
		}
		return false;
	}
	
	public boolean notNull(String name, String lastname, String password, String confirmPassword, String email) {
		if(name != "" & lastname != "" & password != "" & confirmPassword != "" & email != "") {
			return true;
		}
		return false;
	}
	


	public boolean emailValidation(String email) {
        final String regex = "^(.+)@(.+)$";
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			return true;
		}
		
		return false;
	}
	
	public boolean passwordValidation(String password) {
		String regex1 = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])"
	+ "(?=\\S+$).{8,20}$";
		
		Pattern pattern1 = Pattern.compile(regex1);
		
		Matcher matcher1 = pattern1.matcher(password);
		
		return matcher1.matches();
	}
	
	
}

