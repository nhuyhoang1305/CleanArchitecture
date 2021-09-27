package config;

import adapter.encoder.sha256.Sha256PasswordEncoder;
import adapter.id_generator.uuid.UuidGenerator;
import adapter.repository.in_memory_hazelcast.db.hazelcast.HazelcastUserRepository;
import usecase.CreateUser;
import usecase.FindUser;
import usecase.LoginUser;
import usecase.port.PasswordEncoder;
import usecase.port.UserRepository;

public class SpringConfig {

	private final UserRepository userRepository = new HazelcastUserRepository();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, new UuidGenerator());
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}
