package com.fssa.crazyfitness.validations;

import java.time.LocalDate;

import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.model.UserExerciseStatus;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserExerciseException;

public class UserExerciseValidator {
	/**
	 * 
	 * @param userExercise
	 * @throws InvalidUserExerciseException
	 */
	public static void validateUserExercise(UserExercise userExercise) throws InvalidUserExerciseException {
		if(userExercise == null)
			throw new InvalidUserExerciseException("User exercise should not be null");
		validateId(userExercise.getUserId());
		validateId(userExercise.getExerciseId());
		validateStatus(userExercise.getStatus());
		validateLocalDate(userExercise.getExerciseDate());
	}
	/**
	 * 
	 * @param userExercise
	 * @throws InvalidUserExerciseException
	 */
	public static void validateEditUserExercise(UserExercise userExercise) throws InvalidUserExerciseException {
		if(userExercise == null)
			throw new InvalidUserExerciseException("User exercise should not be null");
		validateId(userExercise.getUserExerciseId());
		validateStatus(userExercise.getStatus());

	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws InvalidUserExerciseException
	 */
public static boolean validateId(int id) throws InvalidUserExerciseException {
	if( 0 < id)
		return true;
	else
		throw new InvalidUserExerciseException("The ID should not be in negative values and must not contain alphabetic characters also should not be 0");
}
/*
 * 
 * @param status
 * @return
 * @throws InvalidUserExerciseException
 */
public static boolean validateStatus(UserExerciseStatus status) throws InvalidUserExerciseException {
	  if (status == null) {
	        throw new InvalidUserExerciseException("User exercise status should not be null");
	    }
	    // Check if the status is not one of the valid enum values
	    if (status != UserExerciseStatus.PLANNED && status != UserExerciseStatus.COMPLETED) {
	        throw new InvalidUserExerciseException("Invalid user exercise status: " + status);
	    }
	    return true;
}
/**
 * 
 * @param date
 * @return
 * @throws InvalidUserExerciseException
 */
public static boolean validateLocalDate(LocalDate date) throws InvalidUserExerciseException {
    LocalDate yesterday = LocalDate.now().minusDays(1);

    if(!date.isEqual(yesterday))
    	return true;
    else
    	throw new InvalidUserExerciseException("Invalid date, You are supposed to choose today's date");
}
}
