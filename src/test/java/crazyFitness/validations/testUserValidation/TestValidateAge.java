package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;

public class TestValidateAge {
@Test
public void testValidAge(){
	assertTrue(UserValidator.validateAge(19));
	}

@Test
public void testInValidAgeLessThan10(){
	assertFalse(UserValidator.validateAge(-5));
	}
@Test
public void testValidAgeGreaterThan100(){
	assertFalse(UserValidator.validateAge(102));
	}
}
