package com.fssa.crazyfitness.validations.testuservalidtion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.UserValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

 class TestValidateAge {
@Test
 void testValidAge() throws InvalidUserException{
	 // Valid age range (between 12 and 99)
    assertTrue(UserValidator.validateAge(20));
	}
 
@Test
 void testInvalidAgeLessThanTwelve(){
    // Invalid age (less than 12)
    assertThrows(InvalidUserException.class, () -> {
        UserValidator.validateAge(10);
    });
}

@Test
void testInvalidAgeGreaterThanNintynine() {
    // Invalid age (greater than or equal to 100)
    assertThrows(InvalidUserException.class, () -> {
        UserValidator.validateAge(100);
    });
}

}
 