package com.fssa.crazyfitness.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.crazyfitness.dao.UserDAO;
import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

public class UserValidator {

//	register user
	public static boolean validateUser(User user) throws InvalidUserException {
		if (user != null && validateName(user.getFname()) && validateName(user.getLname())
				&& validateEmail(user.getEmail()) && validatePassword(user.getPassword())
				&& validatePhone(user.getPhone()) && validateAge(user.getAge())) {
			return true;
		} else { 
			throw new InvalidUserException("User details are not valid");
		}
 
	} 

//	login user 
	public static boolean validateLogin(String email, String providedPassword) throws InvalidUserException {
		UserDAO userDAO = new UserDAO();
		try {
		if (validateEmail(email) && validatePassword(providedPassword)) {
			
				User storedUser = userDAO.getUserByEmail(email);
				if (storedUser != null) {
					String storedPassword = storedUser.getPassword();
					if (storedPassword.equals(providedPassword)) {
	
						return true;
					} else {
					
						throw new InvalidUserException("Your password is wrong, please correct it");
					}
				}	else {
					throw new InvalidUserException("User not found");
				}
			}
		} 
		catch (DAOException e) {
			throw new InvalidUserException("Login details are not valid");
		}
		throw new InvalidUserException("Login details are not valid");
		}

	// validation for name
	public static boolean validateName(String name) throws InvalidUserException {
	
		if (name == null || name.isEmpty())
			return false;

		String regex = "^[A-Z a-z]{3,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		boolean match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException("Invalid name");
		}
	
	}

	public static boolean validatePassword(String password) throws InvalidUserException {

		if (password == null || password.isEmpty())
			return false;
		String pattern_string = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		boolean match = Pattern.matches(pattern_string, password);
		if (match) {
			return true;
		} else {
			throw new InvalidUserException("Invalid Password");
		}

	}

	public static boolean validateEmail(String email) throws InvalidUserException {

		if (email == null || email.isEmpty())
			return false;

		String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
		boolean isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("Invalid Email");
		}

	}

	public static boolean validatePhone(String phone) throws InvalidUserException {

		if (phone == null || phone.isEmpty())
			return false;

		String regex = "^[6789]\\d{9}$";
		boolean isMatch = Pattern.matches(regex, phone);
		if (isMatch) {
			return true;

		} else {
			throw new InvalidUserException("Invalid phone number");
		}

	}

	public static boolean validateAge(int age) throws InvalidUserException {
		if (age == 0)
			return false;
		if (age >= 10 && age < 100) {
			return true;
		} else {
			throw new InvalidUserException("Invalid Age");
		}

	}
}
