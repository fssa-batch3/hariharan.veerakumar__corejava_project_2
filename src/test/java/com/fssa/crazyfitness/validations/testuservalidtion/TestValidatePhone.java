package com.fssa.crazyfitness.validations.testuservalidtion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.UserValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

 class TestValidatePhone {  
	 Throwable exception;
  @Test
   void testValidPhoneNumber() {
	  try {
		assertTrue(UserValidator.validatePhone("9842356365"));
	} catch (InvalidUserException e) {
		e.printStackTrace();
		fail();
	}
  }
  @Test
   void testInValidPhoneNumber() {
	 
	  try {
		  UserValidator.validatePhone("1234567890");
		  exception = assertThrows(InvalidUserException.class , () -> {  
		  });
		  assertEquals("Invalid phone number",exception.getMessage());
	} catch (InvalidUserException e) {
		e.printStackTrace();
	}
  }
  @Test
   void testInValidPhoneNumberLesserLength() {
	
	  try {
		  UserValidator.validatePhone("12345");
		  exception = assertThrows(InvalidUserException.class , () -> {  
		  });
		  assertEquals("Invalid phone number",exception.getMessage());
	} catch (InvalidUserException e) {
		e.printStackTrace();
	}
  }
  @Test
   void testInValidPhoneNumberGreaterLength() {
	  try {
		  UserValidator.validatePhone("123456789098765");
		  exception = assertThrows(InvalidUserException.class , () -> {  
		  });
		  assertEquals("Invalid phone number",exception.getMessage());
	} catch (InvalidUserException e) {
		e.printStackTrace();
	}
  }
}
