package com.fssa.crazyfitness.validations.testuservalidtion;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.UserValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

 class TestValidateLogin {
	   @Test
	     void testValidateLogin() throws InvalidUserException {
	        

	        // Valid login credentials should return true
	        assertTrue(UserValidator.validateLogin("hari@gmail.com", "Haripassword@10"));
	    }

	   @Test 
	   void testWrongPassword() {
	        // Wrong password (with correct email)
	        assertThrows(InvalidUserException.class, () -> {
	            UserValidator.validateLogin("hari@gmail.com","Haripassword@20");
	        });
	   }
	   
	   @Test
	   void testInvalidUser() {
	        // Unregistered email and password  
	        assertThrows(InvalidUserException.class, () -> {
	            UserValidator.validateLogin("hariju@gmail.com","Haripassword@200");
	        }); 
	   }
}
