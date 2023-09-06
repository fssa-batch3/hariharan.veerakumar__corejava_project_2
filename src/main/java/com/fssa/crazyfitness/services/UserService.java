package com.fssa.crazyfitness.services;

import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.services.exceptions.ServiceException;
import com.fssa.crazyfitness.validations.UserValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

import java.util.List;

import com.fssa.crazyfitness.dao.UserDAO;
import com.fssa.crazyfitness.dao.exceptions.DAOException;

public class UserService {
	// register
	/**
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			return userDAO.register(user);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	/**
	 * @param email
	 * @param providedPassword
	 * @return
	 * @throws ServiceException
	 */
	public boolean login(String email, String providedPassword) throws ServiceException {
		try {
			return UserValidator.validateLogin(email, providedPassword);
		} catch (InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * @return
	 * @throws ServiceException
	 */
	public List<User> getAllUserList() throws ServiceException {
		try {
			return UserDAO.getAllUsers();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * 
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public boolean userUpdate(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			return userDAO.update(user);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean userDelete(int id) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateId(id);
			return userDAO.deleteUser(id);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * 
	 * @param email
	 * @return
	 * @throws ServiceException
	 */
	public User getUserbyEmail(String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		try {
			UserValidator.validateEmail(email);
			user = userDAO.getUserByEmail(email);
			return user;
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e);
		}

	}
/**
 * 
 * @param id
 * @return
 * @throws ServiceException
 */
	public User getUserbyId(int id) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		User user = new User();

		try {
			UserValidator.validateId(id);
			user = userDAO.getUserById(id);
			return user;
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}



}
