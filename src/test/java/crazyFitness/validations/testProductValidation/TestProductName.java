package crazyFitness.validations.testProductValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import crazyFitness.validation.ProductValidator;

 class TestProductName {
	@Test
	 void testValidName() {
		assertTrue(ProductValidator.validateProductName("DumbBells"));
	}
	
	@Test
	 void testInvalidName() {
		assertFalse(ProductValidator.validateProductName("myemail@example.com"));
	} 
	@Test
	 void testInvalidNameSpecailCharacter() {
		assertFalse(ProductValidator.validateProductName("username!"));
	}

}
