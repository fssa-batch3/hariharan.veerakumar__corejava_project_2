package crazyFitness.validations.testProductValidation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.ProductValidator;

public class TestProductId {
@Test
public void testValidId() {
	assertTrue(ProductValidator.validateId(1));
}

@Test
public void testInValidId() {
	assertFalse(ProductValidator.validateId(0));
}
}
