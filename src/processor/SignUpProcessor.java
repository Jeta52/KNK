package processor;

import java.security.NoSuchAlgorithmException;

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
}
