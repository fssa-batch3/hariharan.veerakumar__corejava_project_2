package com.fssa.crazyfitness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.Exercise;
import com.fssa.crazyfitness.util.ConnectionDb;
import com.fssa.crazyfitness.util.DatabaseException;

public class ExerciseDAO {

	public boolean exerciseNameCheck(String name) throws DAOException, SQLException {
		final String selectQuery = "SELECT exercise_name FROM exercise WHERE exercise_name=?";
		ResultSet rs = null;
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery)) {
			selectPst.setString(1, name);
			rs = selectPst.executeQuery();

			// Email already exists, do not proceed with registration
			return rs.next();

		} catch (DatabaseException e) {
			throw new DAOException(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
	}

	/**
	 * 
	 * @param exercise The exercise object to be inserted.
	 * @return True if the exercise was successfully inserted, FALSE otherwise.
	 * @throws DAOException If a database access error occurs.
	 * 
	 */
	public boolean createExercise(Exercise exercise) throws DAOException {
		final String insertQuery = "INSERT INTO exercise (exercise_name, exercise_image, exercise_timing, exercise_steps, exercise_category) VALUES (?, ?, ?, ?, ?)";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement insertPst = connect.prepareStatement(insertQuery);) {
			if (!exerciseNameCheck(exercise.getExerciseName())) {

				insertPst.setString(1, exercise.getExerciseName());
				insertPst.setString(2, exercise.getExerciseImage());
				insertPst.setInt(3, exercise.getExerciseTiming());
				insertPst.setString(4, exercise.getExerciseSteps());
				insertPst.setString(5, exercise.getExerciseCategory());
				int rows = insertPst.executeUpdate();
				return (rows == 1);
			} else {
				throw new DAOException("Entered Exercise already existed, please add various exercise");
			}

		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * 
	 * @return A list of Exercise objects representing all exercises in the
	 *         database.
	 * @throws DAOException If a database access error occurs.
	 */
	public static List<Exercise> getAllExercises() throws DAOException {
		final String selectAllExercisesQuery = "SELECT * FROM exercise";
		List<Exercise> exerciseList = new ArrayList<>();
		try (Connection connect = ConnectionDb.getConnection();
				Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(selectAllExercisesQuery);) {
			while (rs.next()) {
				int exerciseId = rs.getInt("exercise_id");
				String exerciseName = rs.getString("exercise_name");
				String exerciseImage = rs.getString("exercise_image");
				int exerciseTiming = rs.getInt("exercise_timing");
				String exerciseSteps = rs.getString("exercise_steps");
				String exerciseCategory = rs.getString("exercise_category");

				Exercise exercise = new Exercise(exerciseId, exerciseName, exerciseImage, exerciseTiming, exerciseSteps,
						exerciseCategory);
				exerciseList.add(exercise);
			}

		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
		return exerciseList;
	}

	/**
	 * 
	 * @param exercise The Exercise object containing updated information.
	 * @return True if the exercise was successfully updated, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean updateExercise(Exercise exercise) throws DAOException {
		final String updateQuery = "UPDATE exercise SET exercise_name=?,exercise_image=?,exercise_timing=?,exercise_steps=?,exercise_category=? WHERE exercise_id = ?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement updatePst = connect.prepareStatement(updateQuery);) {
			updatePst.setString(1, exercise.getExerciseName());
			updatePst.setString(2, exercise.getExerciseImage());
			updatePst.setInt(3, exercise.getExerciseTiming());
			updatePst.setString(4, exercise.getExerciseSteps());
			updatePst.setString(5, exercise.getExerciseCategory());
			updatePst.setInt(6, exercise.getExerciseId());
			int rows = updatePst.executeUpdate();
			return (rows == 1);
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * 
	 * @param id The ID of the exercise to be deleted.
	 * @return True if the exercise was successfully deleted, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean deleteExercise(int id) throws DAOException {
		final String deleteQuery = "DELETE FROM exercise WHERE exercise_id=?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement deletePst = connect.prepareStatement(deleteQuery);) {
			deletePst.setInt(1, id);
			int row = deletePst.executeUpdate();
			return (row == 1);
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * 
	 * @param id The ID of the exercise to be retrieved.
	 * @return An Exercise object representing the retrieved exercise, or null if
	 *         not found.
	 * @throws DAOException If a database access error occurs.
	 */
	public static Exercise getExerciseById(int id) throws DAOException {
		final String selectExerciseQuery = "SELECT * FROM exercise WHERE exercise_id=?";
		ResultSet rs = null;
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectExerciseQuery);) {
			selectPst.setInt(1, id);
			rs = selectPst.executeQuery();
			if (rs.next()) {
				Exercise exercise = new Exercise();
				exercise.setExerciseId(rs.getInt("exercise_id"));
				exercise.setExerciseName(rs.getString("exercise_name"));
				exercise.setExerciseImage(rs.getString("exercise_image"));
				exercise.setExerciseTiming(rs.getInt("exercise_timing"));
				exercise.setExerciseSteps(rs.getString("exercise_steps"));
				exercise.setExerciseCategory(rs.getString("exercise_category"));
				return exercise;
			} else {
				rs.close();
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
		return null;
	}

}
