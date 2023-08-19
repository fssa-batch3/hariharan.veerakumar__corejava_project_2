package com.fssa.crazyfitness.services;

import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.services.exceptions.ServiceException;
import com.fssa.crazyfitness.validations.UserValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

import com.fssa.crazyfitness.dao.UserDAO;
import com.fssa.crazyfitness.dao.exceptions.DAOException;

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

 

	public boolean login(String email, String providedPassword) throws ServiceException {
		try {
			return UserValidator.validateLogin(email, providedPassword);
	} catch (InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
}
