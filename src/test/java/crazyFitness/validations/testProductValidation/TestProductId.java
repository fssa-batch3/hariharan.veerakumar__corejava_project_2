package crazyFitness.validations.testProductValidation;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import crazyFitness.validation.ProductValidator;
import crazyFitness.validation.exceptions.InvalidProductException;

 class TestProductId {
@Test
 void testValidId() { 
	try {
		assertTrue(ProductValidator.validateId(1));
	} catch (InvalidProductException e) {

		e.printStackTrace();
		fail();
	}
}

@Test
void testInValidIdExpectException() { 

	try {
		ProductValidator.validateId(0);
		Throwable exception = assertThrows(InvalidProductException.class, () -> {
			
		});
		assertEquals("The Product ID is not valid",exception.getMessage());
	} catch (InvalidProductException e) {
		e.printStackTrace();
	}
}
}
