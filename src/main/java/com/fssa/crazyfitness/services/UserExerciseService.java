package com.fssa.crazyfitness.services;

import com.fssa.crazyfitness.dao.UserExerciseDAO;
import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.services.exceptions.ServiceException;
import com.fssa.crazyfitness.validations.UserExerciseValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserExerciseException;

public class UserExerciseService {
	/**
	 * 
 * Creates a new user exercise by delegating the operation to the UserExerciseDAO.
 *
 * @param userExercise The UserExercise object to be created in the database.
 * @return True if the user exercise was successfully created, false otherwise.
 * @throws ServiceException If there is an issue with data validation or a DAO operation error.
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
}
