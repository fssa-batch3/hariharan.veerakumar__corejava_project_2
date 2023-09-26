package com.fssa.crazyfitness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.model.UserExerciseStatus;
import com.fssa.crazyfitness.util.ConnectionDb;
import com.fssa.crazyfitness.util.DatabaseException;

public class UserExerciseDAO {
	/**
	 * 
	 * @param userExercise The UserExercise object containing the data to be
	 *                     inserted.
	 * @return True if the user exercise record was successfully created, false
	 *         otherwise.
	 * @throws DAOException If there is an error during the database operation.
	 */
	public boolean createUserExercise(UserExercise userExercise) throws DAOException {
		final String insertQuery = "INSERT INTO user_exercise (user_id, exercise_id, exercise_date, status) VALUES (?, ?, ?, ?)";

		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement insertPst = connect.prepareStatement(insertQuery);) {
			insertPst.setInt(1, userExercise.getUserId());
			insertPst.setInt(2, userExercise.getExerciseId());
			insertPst.setDate(3, java.sql.Date.valueOf(userExercise.getExerciseDate()));
			insertPst.setString(4, userExercise.getStatus().name());

			int rows = insertPst.executeUpdate();
			return (rows == 1);
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
	} 

	/**
	 * 
	 * Retrieves a list of all user exercise records from the database.
	 *
	 * @return A list containing UserExercise objects representing all user
	 *         exercises in the database.
	 * @throws DAOException If there is an issue with the database connection or
	 *                      query execution.
	 */
	public static List<UserExercise> getAllUserExercises() throws DAOException {
		final String selectQuery = "SELECT * FROM user_exercise";
		List<UserExercise> userExerciseList = new ArrayList<>();
		try (Connection connect = ConnectionDb.getConnection();
				Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(selectQuery);) {
			while (rs.next()) {
				int userExerciseId = rs.getInt("user_exercise_id");
				int userId = rs.getInt("user_id");
				int exerciseId = rs.getInt("exercise_id");
				java.sql.Date date = rs.getDate("exercise_date");
				String exerciseStatus = rs.getString("status");

				LocalDate exerciseDate = date.toLocalDate();
				UserExerciseStatus status = UserExerciseStatus.valueOf(exerciseStatus);

				UserExercise userExercise = new UserExercise();
				userExercise.setUserExerciseId(userExerciseId);
				userExercise.setUserId(userId);
				userExercise.setExerciseId(exerciseId);
				userExercise.setExerciseDate(exerciseDate);
				userExercise.setStatus(status);
				userExerciseList.add(userExercise);
			}

		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
		return userExerciseList;
	}
/**
 * 
 * @param id
 * @return
 * @throws DAOException
 */
	public static UserExercise getExerciseByUserId(int id) throws DAOException {
		final String selectQuery = "SELECT * FROM user_exercise WHERE user_id=?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery);) {
			selectPst.setInt(1, id);
			try (ResultSet rs = selectPst.executeQuery()) {
				if (rs.next()) {
					UserExercise userExercise = new UserExercise();
					java.sql.Date date = rs.getDate("exercise_date");
					String exerciseStatus = rs.getString("status");

					LocalDate exerciseDate = date.toLocalDate();
					UserExerciseStatus status = UserExerciseStatus.valueOf(exerciseStatus);

					userExercise.setUserExerciseId(rs.getInt("user_exercise_id"));
					userExercise.setUserId(rs.getInt("user_id"));
					userExercise.setExerciseId(rs.getInt("exercise_id"));
					userExercise.setExerciseDate(exerciseDate);
					userExercise.setStatus(status);
					return userExercise;
				} else {
					rs.close();

				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
		return null;
	}

	/**
	 * 
	 * @param id The ID of the UserExercise to be retrieved.
	 * @return An UserExercise object representing the retrieved UserExercise, or
	 *         null if not found.
	 * @throws DAOException If a database access error occurs.
	 */
	public static List<UserExercise> getUserExercisesListByUserId(int id) throws DAOException {
		final String selectQuery = "SELECT * FROM user_exercise WHERE user_id=?";
		List<UserExercise> userExercises = new ArrayList<>();

		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery);) {
			selectPst.setInt(1, id);
			try (ResultSet rs = selectPst.executeQuery()) { 
				while (rs.next()) {
					UserExercise userExercise = new UserExercise();
					java.sql.Date date = rs.getDate("exercise_date");
					String exerciseStatus = rs.getString("status");

					LocalDate exerciseDate = date.toLocalDate();
					UserExerciseStatus status = UserExerciseStatus.valueOf(exerciseStatus);

					userExercise.setUserExerciseId(rs.getInt("user_exercise_id"));
					userExercise.setUserId(rs.getInt("user_id"));
					userExercise.setExerciseId(rs.getInt("exercise_id"));
					userExercise.setExerciseDate(exerciseDate);
					userExercise.setStatus(status);

					userExercises.add(userExercise);
				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}

		return userExercises;
	}

	/**
	 * Updates the status of a user exercise in the database.
	 *
	 * @param userExercise The UserExercise object containing the updated status and
	 *                     userExerciseId.
	 * @return True if the user exercise status was successfully updated, false
	 *         otherwise.
	 * @throws DAOException If there is an issue with the database connection or
	 *                      query execution.
	 */
	public boolean updateUserExercise(UserExercise userExercise) throws DAOException {
		final String updateQuery = "UPDATE user_exercise SET status = ? WHERE user_exercise_id = ?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement updatePst = connect.prepareStatement(updateQuery);) {
			updatePst.setString(1, userExercise.getStatus().name());
			updatePst.setInt(2, userExercise.getUserExerciseId());

			int row = updatePst.executeUpdate();
			return (row == 1);
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Deletes a user exercise record from the database based on the given user
	 * exercise ID.
	 *
	 * @param id The ID of the user exercise record to delete.
	 * @return True if the user exercise record was successfully deleted, false
	 *         otherwise.
	 * @throws DAOException If there is an issue with the database connection or
	 *                      query execution.
	 */
	public boolean deleteUserExercise(int id) throws DAOException {
		final String deleteQuery = "DELETE FROM user_exercise WHERE user_exercise_id=?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement deletePst = connect.prepareStatement(deleteQuery);) {
			deletePst.setInt(1, id);
			int row = deletePst.executeUpdate();
			return (row == 1);
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
	}
}
