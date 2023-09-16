package com.fssa.crazyfitness.validations.testuservalidtion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.UserValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

 class TestValidatePhone {  
	 
  @Test
   void testValidPhoneNumber() throws InvalidUserException {
      // Valid phone numbers
      assertTrue(UserValidator.validatePhone("7234567890"));
      assertTrue(UserValidator.validatePhone("9876543210"));
  }
  @Test
   void testInValidPhoneNumber() {
      // Invalid phone numbers (contains non-numeric characters)
      assertThrows(InvalidUserException.class, () -> {
          UserValidator.validatePhone("1234a56789");
      });
  }
  @Test
   void testInValidPhoneNumberLesserLength() {
      // Invalid phone numbers (less than 10 digits)
      assertThrows(InvalidUserException.class, () -> {
          UserValidator.validatePhone("12345678");
      });
  }
  @Test
   void testInValidPhoneNumberGreaterLength() {
      // Invalid phone numbers (more than 10 digits)
      assertThrows(InvalidUserException.class, () -> {
          UserValidator.validatePhone("98765432101");
      });
}
 }
