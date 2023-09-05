package com.fssa.crazyfitness.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.crazyfitness.dao.UserDAO;
import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

public class UserValidator {

	/**
	 * @param user
	 * @return
	 * @throws InvalidUserException
	 */

	public static void validateUser(User user) throws InvalidUserException {
		if (user == null) {
			throw new InvalidUserException("User details should not be NULL");
		}

		validateName(user.getFname());
		validateName(user.getLname());
		validateEmail(user.getEmail());
		validatePassword(user.getPassword());
		validatePhone(user.getPhone());
		validateAge(user.getAge());

	}


//	login user 
	public static boolean validateLogin(String email, String providedPassword) throws InvalidUserException {
		UserDAO userDAO = new UserDAO();
		try {
			validateEmail(email);
			validatePassword(providedPassword);
				User storedUser = userDAO.getUserByEmail(email);
				if (storedUser != null) {
					String storedPassword = storedUser.getPassword();
					if (storedPassword.equals(providedPassword)) {

						return true;
					} else {

						throw new InvalidUserException("Wrong password, please correct it");
					}
				} else {
					throw new InvalidUserException("User not found");
				}
			
		} catch (DAOException e) {
			throw new InvalidUserException("Login details are not valid");
		}

	}

	// validation for name
	public static boolean validateName(String name) throws InvalidUserException {

		if (name == null)
			throw new InvalidUserException("Name should not be null");

		if (name.trim().isEmpty())
			throw new InvalidUserException("Name should not be empty");

		String regex = "^[A-Z a-z]{3,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		boolean match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(
					"Name must contain alphabetic letters also minimum 3 characters is required and should be in 30 characters");
		}

	}

	public static boolean validatePassword(String password) throws InvalidUserException {

		if (password == null)
			throw new InvalidUserException("Password should not be null");
		if (password.trim().isEmpty()) {
			throw new InvalidUserException("Password should not be empty");
		}

		String patternstring = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		boolean match = Pattern.matches(patternstring, password);
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(
					"Password must contain a special character and a numeric value and a upper case and lower case also minimum 8 characters is required");
		}
	}

	public static boolean validateEmail(String email) throws InvalidUserException {

		if (email == null)
			throw new InvalidUserException("Email should not be null");
		if (email.trim().isEmpty()) {
			throw new InvalidUserException("Email should not be empty");
		}

		String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
		boolean isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException(
					"Email must contain @ and . and all the alphabetic value should be in lowercase");
		}

	}

	public static boolean validatePhone(String phone) throws InvalidUserException {

		if (phone == null)
			throw new InvalidUserException("Phone number contains only 10 numberic values[0-9], should not be null");
		if (phone.trim().isEmpty()) {
			throw new InvalidUserException("Phone number contains only 10 numberic values[0-9], should not be empty");
		}
		String regex = "^[6789]\\d{9}$";
		boolean isMatch = Pattern.matches(regex, phone);
		if (isMatch) {
			return true;

		} else {
			throw new InvalidUserException("Phone number contains only 10 numberic values[0-9]");
		}

	}

	public static boolean validateAge(int age) throws InvalidUserException {
		if (age >= 10 && age < 100) {
			return true;
		} else {
			throw new InvalidUserException("Age must between 9 to 99");
		}

	}

	public static boolean validateId(int id) throws InvalidUserException {
		if (id <= 0) {
			throw new InvalidUserException("User Id should not be zero or in negative values");
		} else
			return true;
	}
}
