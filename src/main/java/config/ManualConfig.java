package config;

import adapter.encoder.sha256.Sha256PasswordEncoder;
import adapter.id.JugIdGenerator;
import adapter.repository.in_memory_simple.db.InMemoryUserRepository;
import usecase.CreateUser;
import usecase.FindUser;
import usecase.LoginUser;
import usecase.port.IdGenerator;
import usecase.port.PasswordEncoder;
import usecase.port.UserRepository;

public class ManualConfig {
	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, idGenerator);
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}
