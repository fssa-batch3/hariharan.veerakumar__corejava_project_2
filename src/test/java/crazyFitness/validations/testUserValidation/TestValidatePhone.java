package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;

 class TestValidatePhone { 
  @Test
   void testValidPhoneNumber() {
	  assertTrue(UserValidator.validatePhone("9842356365"));
  }
  @Test
   void testInValidPhoneNumber() {
	  assertFalse(UserValidator.validatePhone("1234567890"));
  }
  @Test
   void testInValidPhoneNumberLesserLength() {
	  assertFalse(UserValidator.validatePhone("12345"));
  }
  @Test
   void testInValidPhoneNumberGreaterLength() {
	  assertFalse(UserValidator.validatePhone("123456789098765"));
  }
}
