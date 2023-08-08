package crazyFitness.validations.testProductValidation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.ProductValidator;

 class TestProductId {
@Test
 void testValidId() { 
	assertTrue(ProductValidator.validateId(1));
}

@Test
void testInValidId() {
	assertFalse(ProductValidator.validateId(0));
}
}
