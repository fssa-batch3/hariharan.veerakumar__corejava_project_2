 package crazyFitness.validations.testProductValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import crazyFitness.validation.ProductValidator;
import crazyFitness.validation.exceptions.InvalidProductException;

 class TestProductName {
	@Test
	 void testValidName() {
		try {
			assertTrue(ProductValidator.validateProductName("DumbBells"));
		} catch (InvalidProductException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	 void testInvalidProductName() {
		try {
			ProductValidator.validateProductName("productname!");
			Throwable exception = assertThrows(InvalidProductException.class, () ->{
				
			});
			assertEquals("The Product name is not valid", exception.getMessage());
		} catch (InvalidProductException e) {
		e.printStackTrace();
		}
	} 
	
}
