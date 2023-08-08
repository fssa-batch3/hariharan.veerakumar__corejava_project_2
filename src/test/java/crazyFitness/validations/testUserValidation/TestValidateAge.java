package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;

 class TestValidateAge {
@Test
 void testValidAge(){
	assertTrue(UserValidator.validateAge(19));
	}
 
@Test
 void testInValidAgeLessThan10(){
	assertFalse(UserValidator.validateAge(-5));
	}
@Test
 void testValidAgeGreaterThan100(){
	assertFalse(UserValidator.validateAge(102));
	}
}
