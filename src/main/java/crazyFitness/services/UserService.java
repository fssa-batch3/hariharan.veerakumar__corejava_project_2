package crazyFitness.services;

import crazyFitness.model.User;
import crazyFitness.services.exceptions.ServiceException;
import crazyFitness.validation.*;
import crazyFitness.validation.exceptions.InvalidUserException;

import crazyFitness.dao.UserDAO;
import crazyFitness.dao.exceptions.DAOException;

public class UserService {
	// register
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			if (userDAO.register(user)) {
				System.out.println(user.getEmail() + " Sucessfully added");
				return true;
			} else {
				System.out.println("Registration not Unsuccessful!");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// login
//	 public boolean loginUser(String email, String password) throws ServiceException{
//			UserDAO userDAO = new UserDAO();
//			try {
//				UserValidator.validateLoginUser(email,password);
//				if (userDAO.login(email,password)) {
//					System.out.println(email + " Sucessfully logged in");
//					return true;
//				} else {
//					System.out.println("Login failed");
//					return false;
//				}
//
//			} catch (DAOException | InvalidUserException
//					e) {
//				throw new ServiceException(e);
//			}
//	 }

	public boolean login(String email, String providedPassword) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		if (UserValidator.validateLogin(email, providedPassword)) {
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
				throw new ServiceException(e);
			}
		}
		return false;

	}
}
