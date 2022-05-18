package processor;

import java.security.NoSuchAlgorithmException;

import model.Login;
import repository.LoginRepository;

public class LoginProcessor {
	private LoginRepository loginRepository;
	
	public LoginProcessor() {
		this.loginRepository = new LoginRepository();
	}

	
	public boolean isUserValid(String username, String password) throws NoSuchAlgorithmException {
		Login loginUser = this.loginRepository.findOne(username);
		if(loginUser == null) {
			return false;
		}
		
		String saltedHash = GenerateHash.generate(password, loginUser.getSalt());
		
		if(loginUser.getSaltedHash().equals(saltedHash)) {
			return true;
		}
		
		return false;
	}
}
