package com.fssa.crazyfitness.validations.testuservalidtion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.UserValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

 class TestValidateName {
		
@Test
 void testValidName() throws InvalidUserException {
    // Valid names
    assertTrue(UserValidator.validateName("Hari haran"));
    assertTrue(UserValidator.validateName("Veerakumar"));
}
@Test 
 void testInValidNameHavingNumbers() {
    // Invalid names (contains numbers)
    assertThrows(InvalidUserException.class, () -> {
        UserValidator.validateName("Hari123");
    });

}
@Test
 void testInValidNameLesserLength() {
    // Invalid names (less than 3 characters)
    assertThrows(InvalidUserException.class, () -> {
        UserValidator.validateName("Ha");
    });

}
@Test
 void testInValidNameGreaterLengthExpectValidation() {

    // Invalid names (more than 30 characters)
    assertThrows(InvalidUserException.class, () -> {
        UserValidator.validateName("ThisIsAVeryLongNameThatExceedsThe30CharacterLimit");
    });

} 
}
