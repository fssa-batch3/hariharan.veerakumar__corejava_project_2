package com.fssa.crazyfitness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.util.ConnectionDb;
import com.fssa.crazyfitness.util.DatabaseException;

public class UserExerciseDAO {
	/**
	 * 
 * @param userExercise The UserExercise object containing the data to be inserted.
 * @return True if the user exercise record was successfully created, false otherwise.
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
}
