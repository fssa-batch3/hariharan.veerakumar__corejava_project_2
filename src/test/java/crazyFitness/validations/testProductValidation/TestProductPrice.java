package crazyFitness.validations.testProductValidation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import crazyFitness.validation.ProductValidator;

public class TestProductPrice {
	@Test
	public void testValidPrice() {
		assertTrue(ProductValidator.validateProductPrice(999));
	}
	
	@Test
	public void testInvalidPrice() {
		assertFalse(ProductValidator.validateProductPrice(-999));
	}
	

}
