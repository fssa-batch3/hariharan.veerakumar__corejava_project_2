package crazyFitness.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import crazyFitness.dao.UserDAO;
import crazyFitness.dao.exceptions.DAOException;
import crazyFitness.model.User;
import crazyFitness.validation.exceptions.InvalidUserException;

public class UserValidator {
	
	  private UserValidator() {
		    throw new IllegalStateException("UserValidator class");
		  }
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
		if (validateEmail(email) && validatePassword(providedPassword)) {
			try {
				User storedUser = userDAO.getUserByEmail(email);
				if (storedUser != null) {
					String storedPassword = storedUser.getPassword();
					if (storedPassword.equals(providedPassword)) {
						System.out.println("Logged in Successfully");
						return true;
					} else {
						System.out.println("Your password is wrong, please correct it");
						return false;
					}

				}
				System.out.println("Your email is not exists, Please register");
			} catch (DAOException e) {
				throw new InvalidUserException("Login details are not valid");
			}

		}
		return false;
	}

	public static boolean validateName(String name) {
		boolean match = false;
		if (name == null || name.isEmpty())
			return false;
		
			String regex = "^[A-Z a-z]{3,29}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				System.out.println("The name is valid.");
			} else {
				System.out.println("The name is not valid");
			}
		
		return match;
	}

	public static boolean validatePassword(String password) {
		boolean match = false;
		if (password == null || password.isEmpty())
			return false;
		


			String pattern_string = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(pattern_string, password);


			if (match) {

				System.out.println("Valid password.");
			} else {
				System.out.println("Invalid password.");
			}
	

		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = false;
		if (email == null || email.isEmpty())
			return false;
	
			String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email address is Valid");
			} else {
				System.out.println("The email address is Invalid");
			}
			return isMatch;
		
	
	}

	public static boolean validatePhone(String phone) {
		boolean isMatch = false;
		if (phone == null || phone.isEmpty())
			return false;
	
			String regex = "^[6789]\\d{9}$";
			isMatch = Pattern.matches(regex, phone);
			if (isMatch) {
				System.out.println("The Phone number is Valid");
			} else {
				System.out.println("The Phone number is Invalid");
			}
			return isMatch;
		
	}

	
	
	
	public static boolean validateAge(int age) {
		boolean isMatch = false;
		if (age == 0 )
			return false;
		
			if (age >= 10 && age < 100) {
				isMatch = true;
				System.out.println("The Age is Valid");
			} else {
				System.out.println("The Age is InValid");
			}
			return isMatch;
		}
	}

