package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;

 class TestValidateName {
@Test
 void testValidName() {
	assertTrue(UserValidator.validateName("Hariharan"));
}
@Test
 void testInValidNameUsingNumbers() {
	assertFalse(UserValidator.validateName("123456"));
}
@Test
 void testInValidNameLesserLength() {
	assertFalse(UserValidator.validateName("Ha"));
}
@Test
 void testInValidNameGreaterLength() {
	assertFalse(UserValidator.validateName("Hariharanvhariharanvhariharanv"));
} 
}
