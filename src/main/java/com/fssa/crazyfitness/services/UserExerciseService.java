package com.fssa.crazyfitness.services;

import java.util.List;

import com.fssa.crazyfitness.dao.UserExerciseDAO;
import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.services.exceptions.ServiceException;
import com.fssa.crazyfitness.validations.UserExerciseValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserExerciseException;

public class UserExerciseService {
	/**
	 * 
	 * Creates a new user exercise by delegating the operation to the
	 * UserExerciseDAO.
	 *
	 * @param userExercise The UserExercise object to be created in the database.
	 * @return True if the user exercise was successfully created, false otherwise.
	 * @throws ServiceException If there is an issue with data validation or a DAO
	 *                          operation error.
	 */
	public boolean createUserExercise(UserExercise userExercise) throws ServiceException {
		UserExerciseDAO userExerciseDAO = new UserExerciseDAO();

		try {
			UserExerciseValidator.validateUserExercise(userExercise);
			return userExerciseDAO.createUserExercise(userExercise);
		} catch (DAOException | InvalidUserExerciseException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a list of all user exercise records from the database through the
	 * UserExerciseDAO.
	 *
	 * @return A list containing UserExercise objects representing all user
	 *         exercises in the database.
	 * @throws ServiceException If there is an issue with the DAO operation or a
	 *                          database connection error.
	 */
	public List<UserExercise> getAllUserExercise() throws ServiceException {
		try {
			return UserExerciseDAO.getAllUserExercises();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves an UserExercise by its unique identifier.
	 * 
	 * @param id The unique identifier of the UserExercise to retrieve.
	 * @return The UserExercise object with the specified ID.
	 * @throws ServiceException If there is an issue with the service operation,
	 *                          including validation or DAO-related errors.
	 */
	public UserExercise getUserExerciseByUserId(int id) throws ServiceException {

		try {
			UserExerciseValidator.validateId(id);
			return UserExerciseDAO.getUserExerciseByUserId(id);
		} catch (DAOException | InvalidUserExerciseException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Updates the status of a user exercise by delegating the operation to the
	 * UserExerciseDAO.
	 *
	 * @param userExercise The UserExercise object containing the updated status and
	 *                     userExerciseId.
	 * @return True if the user exercise status was successfully updated, false
	 *         otherwise.
	 * @throws ServiceException If there is an issue with data validation, a DAO
	 *                          operation error, or a database connection error.
	 */
	public boolean updateUserExercise(UserExercise userExercise) throws ServiceException {
		UserExerciseDAO userExerciseDAO = new UserExerciseDAO();
		try {
			UserExerciseValidator.validateEditUserExercise(userExercise);
			return userExerciseDAO.updateUserExercise(userExercise);
		} catch (InvalidUserExerciseException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
/**
 * Deletes a user exercise record from the database by delegating the operation to the UserExerciseDAO.
 *
 * @param id The ID of the user exercise record to delete.
 * @return True if the user exercise record was successfully deleted, false otherwise.
 * @throws ServiceException If there is an issue with data validation, a DAO operation error, or a database connection error.
	 */
	public boolean deleteUserExercise(int id) throws ServiceException {
		UserExerciseDAO userExerciseDAO = new UserExerciseDAO();

		try {
			UserExerciseValidator.validateId(id);
			return userExerciseDAO.deleteUserExercise(id);
		} catch (InvalidUserExerciseException | DAOException e) {
			throw new ServiceException(e);
		}
	}
}
