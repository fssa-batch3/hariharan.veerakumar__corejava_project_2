package crazyFitness.validations.testProductValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import crazyFitness.validation.ProductValidator;

public class TestProductName {
	@Test
	public void testValidName() {
		assertTrue(ProductValidator.validateProductName("DumbBells"));
	}
	
	@Test
	public void testInvalidName() {
		assertFalse(ProductValidator.validateProductName("email@example.com"));
	}
	@Test
	public void testInvalidNameSpecailCharacter() {
		assertFalse(ProductValidator.validateProductName("username!"));
	}

}
