package com.fssa.crazyfitness.validations.testproductvalidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ProductValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

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
 