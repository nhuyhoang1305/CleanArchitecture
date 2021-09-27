package com.slalom.example;

import com.slalom.config.ManualConfig;
import com.slalom.example.domain.entity.User;
import com.slalom.example.usecase.CreateUser;
import com.slalom.example.usecase.FindUser;
import com.slalom.example.usecase.LoginUser;

import java.util.List;
import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		// Setup
		ManualConfig config = new ManualConfig();
		CreateUser createUser = config.createUser();
		FindUser findUser = config.findUser();
		LoginUser loginUser = config.loginUser();
		User user = User.builder()
			.email("john.doe@gmail.com")
			.password("mypassword")
			.lastName("doe")
			.firstName("john")
			.build();

		// Create a user
		User actualCreateUser = createUser.create(user);
		System.out.println("User created with id " + actualCreateUser.getId());

		// Find a user by id
		Optional<User> actualFindUser = findUser.findById(actualCreateUser.getId());
		System.out.println("Found user with id " + actualFindUser.get().getId());

		// List all users
		List<User> users = findUser.findAllUsers();
		System.out.println("List all users: " + users);

		// Login
		loginUser.login("john.doe@gmail.com", "mypassword");
		System.out.println("Allowed to login with email 'john.doe@gmail.com' and password  'mypassword'");
	}
}
