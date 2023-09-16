package com.fssa.crazyfitness.services;

import java.util.List;

import com.fssa.crazyfitness.dao.ExerciseDAO;
import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.Exercise;
import com.fssa.crazyfitness.services.exceptions.ServiceException;
import com.fssa.crazyfitness.validations.ExerciseValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidExerciseException;

public class ExerciseService {
	/**
 * Creates a new exercise by validating the provided exercise data and
 * delegating the creation process to the ExerciseDAO.
 *
 * @param exercise The Exercise object containing exercise details to be created.
 * @return True if the exercise is successfully created; false otherwise.
 * @throws ServiceException If there is an issue with the service operation,
 *                         including validation or DAO-related errors.
	 */
	public boolean createExercise(Exercise exercise) throws ServiceException {
		ExerciseDAO exerciseDAO = new ExerciseDAO();

		try {
			ExerciseValidator.validateExercise(exercise);
			return exerciseDAO.createExercise(exercise);
		} catch (DAOException | InvalidExerciseException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a list of all exercises from the data source.
	 *
	 * @return A list of Exercise objects representing all exercises.
	 * @throws ServiceException If there is an issue with the service operation, such as a DAO-related error.
	 */
	public List<Exercise> getAllExerciseList() throws ServiceException {
		try {
			return ExerciseDAO.getAllExercises();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves an exercise by its unique identifier.
	 *
	 * @param id The unique identifier of the exercise to retrieve.
	 * @return The Exercise object with the specified ID.
	 * @throws ServiceException If there is an issue with the service operation, including validation or DAO-related errors.
	 */
	public Exercise getExerciseById(int id) throws ServiceException {
		try {
			ExerciseValidator.validateId(id);
			return ExerciseDAO.getExerciseById(id);
		} catch (DAOException | InvalidExerciseException e) {
			throw new ServiceException(e);
		}
	}
	/**
	 * Updates an existing exercise with new data.
	 *
	 * @param exercise The Exercise object containing the updated exercise details.
	 * @return True if the exercise is successfully updated; false otherwise.
	 * @throws ServiceException If there is an issue with the service operation, including validation or DAO-related errors.
	 */
	public boolean updateExercise(Exercise exercise) throws ServiceException {
		ExerciseDAO exerciseDAO = new ExerciseDAO();
		try {
			ExerciseValidator.validateEditExercise(exercise);
			return exerciseDAO.updateExercise(exercise);
		} catch (InvalidExerciseException | DAOException e) {
			throw new ServiceException(e);
		}

	}
	/**
	 * Deletes an exercise by its unique identifier.
	 *
	 * @param id The unique identifier of the exercise to delete.
	 * @return True if the exercise is successfully deleted; false otherwise.
	 * @throws ServiceException If there is an issue with the service operation, including validation or DAO-related errors.
	 */
	public boolean deleteExercise(int id) throws ServiceException {
		ExerciseDAO exerciseDAO = new ExerciseDAO();

		try {
			ExerciseValidator.validateId(id);
			return exerciseDAO.deleteExercise(id);
		} catch (DAOException | InvalidExerciseException e) {
			throw new ServiceException(e);
		}
	}

}
