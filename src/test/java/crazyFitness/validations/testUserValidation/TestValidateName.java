package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;

public class TestValidateName {
@Test
public void testValidName() {
	assertTrue(UserValidator.validateName("Hariharan"));
}
@Test
public void testInValidNameUsingNumbers() {
	assertFalse(UserValidator.validateName("123456"));
}
@Test
public void testInValidNameLesserLength() {
	assertFalse(UserValidator.validateName("Ha"));
}
@Test
public void testInValidNameGreaterLength() {
	assertFalse(UserValidator.validateName("Hariharanvhariharanvhariharanv"));
}
}
