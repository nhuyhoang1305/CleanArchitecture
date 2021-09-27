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

public class VertxConfig {

	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();
	private final CreateUser createUser = new CreateUser(userRepository, passwordEncoder, idGenerator);
	private final FindUser findUser = new FindUser(userRepository);
	private final LoginUser loginUser = new LoginUser(userRepository, passwordEncoder);

	public CreateUser createUser() {
		return createUser;
	}

	public FindUser findUser() {
		return findUser;
	}

	public LoginUser loginUser() {
		return loginUser;
	}
}
