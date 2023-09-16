package com.fssa.crazyfitness.validations;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.crazyfitness.model.Exercise;
import com.fssa.crazyfitness.validations.exceptions.InvalidExerciseException;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

public class ExerciseValidator {
	
	/**
	 * 
	 * @param exercise
	 * @throws InvalidExerciseException
	 */
	public static void validateExercise(Exercise exercise) throws InvalidExerciseException{
		if(exercise == null)
			throw new InvalidExerciseException("Exercise should not be null");
		validateExerciseName(exercise.getExerciseName());
		validateExerciseImage(exercise.getExerciseImage());
		validateExerciseTiming(exercise.getExerciseTiming());
		validateExerciseSteps(exercise.getExerciseSteps());
		validateExerciseCategory(exercise.getExerciseCategory());
	}
	
	/**
	 * 
	 * @param exercise
	 * @throws InvalidExerciseException
	 */
	public static void validateEditExercise(Exercise exercise) throws InvalidExerciseException{
		if(exercise == null)
			throw new InvalidExerciseException("Exercise should not be null");
		validateExerciseName(exercise.getExerciseName());
		validateExerciseImage(exercise.getExerciseImage());
		validateExerciseTiming(exercise.getExerciseTiming());
		validateExerciseSteps(exercise.getExerciseSteps());
		validateExerciseCategory(exercise.getExerciseCategory());
		validateId(exercise.getExerciseId());
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws InvalidProductException
	 */
	public static boolean validateId(int id) throws InvalidExerciseException {
		if (id > 0) {
			return true;
		} else {
			throw new InvalidExerciseException(
					"The Exercise ID should not be in negative values and must not contain alphabetic characters also should not be 0");
		}
	}
/**
 * 
 * @param name
 * @return
 * @throws InvalidExerciseException
 */
	public static boolean validateExerciseName(String name) throws InvalidExerciseException{
		if(name == null)
			throw new InvalidExerciseException("The Exerice name should not be null");
		if(name.trim().isEmpty())
			throw new InvalidExerciseException("The Exercise name should not be empty");
		String regex = "^[A-Za-z-\\s]{3,20}$";
	    Pattern p = Pattern.compile(regex);
	    Matcher m = p.matcher(name);
	    if(m.matches())
	    	return true;
	    else
	    	throw new InvalidExerciseException("The exercise name should not contain numeric values also minimum 3 characters is required and maximum 20");
	}
	
/**
 * 	
 * @param url
 * @return
 * @throws InvalidExerciseException
 */
	public static boolean validateExerciseImage(String url) throws InvalidExerciseException{
		if (url == null) {
			throw new InvalidExerciseException("The Product image URL should not be null");
		}
		if (url.trim().isEmpty()) {
			throw new InvalidExerciseException("The Product image URL should not be empty");
		}

		return true;
	}
	
	/**
	 * 
	 * @param timing
	 * @return
	 * @throws InvalidExerciseException
	 */
	public static boolean validateExerciseTiming(int timing) throws InvalidExerciseException{
		if (timing <= 4)
			throw new InvalidExerciseException("The timing of the exercise should not be less than 5 seconds");
		else
			return true;
	}
	
	/**
	 * 
	 * @param steps
	 * @return
	 * @throws InvalidExerciseException
	 */
	public static boolean validateExerciseSteps(String steps) throws InvalidExerciseException{
		if(steps == null)
			throw new InvalidExerciseException("The Exerice steps should not be null");
		if(steps.trim().isEmpty())
			throw new InvalidExerciseException("The Exercise steps should not be empty");
        return true;
	}
	
	/**
	 * 
	 * @param category
	 * @return
	 * @throws InvalidExerciseException
	 */
	public static boolean validateExerciseCategory(String category) throws InvalidExerciseException{
		if(category == null)
			throw new InvalidExerciseException("The Exerice category should not be null");
		if(category.trim().isEmpty())
			throw new InvalidExerciseException("The Exercise category should not be empty");
        
		 List<String> validCategories = Arrays.asList("FULLBODY", "LOWERBODY", "ABS", "CHEST", "ARMS", "SHOULDER", "LEG");

		    if (validCategories.contains(category.toUpperCase())) {
		        return true;
		    } else {
		        throw new InvalidExerciseException("Unknown category, please enter a valid category");
		    }	}
}
