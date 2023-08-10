package crazyFitness.validations.testProductValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.ProductValidator;
import crazyFitness.validation.exceptions.InvalidProductException;

 class TestProductPrice {
	@Test 
	 void testValidPrice() {
		try {
			assertTrue(ProductValidator.validateProductPrice(999));
		} catch (InvalidProductException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	 void testInvalidPriceExpectException() {

		try {
			ProductValidator.validateProductPrice(-999);
			Throwable exception = assertThrows(InvalidProductException.class, () -> {
			});
			assertEquals("The Product price is not valid", exception.getMessage());
		} catch (InvalidProductException e) {
			e.printStackTrace();
		}
	}
	
	

}
 