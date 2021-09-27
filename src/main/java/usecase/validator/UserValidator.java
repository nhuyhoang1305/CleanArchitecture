package usecase.validator;

import domain.entity.User;
import usecase.exception.UserValidationException;

public class UserValidator {

	public static void validateCreateUser(final User user) {
		if (user == null) throw new UserValidationException("User should not be null");
		if (user.getEmail().length() == 0) throw new UserValidationException("Email should not be null");
		if (user.getFirstName().length() == 0) throw new UserValidationException("First name should not be null");
		if (user.getLastName().length() == 0) throw new UserValidationException("Last name should not be null");
	}

	private UserValidator() {

	}
}
