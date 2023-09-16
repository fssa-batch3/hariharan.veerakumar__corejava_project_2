package com.fssa.crazyfitness.validations.testproductvalidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ProductValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

 class TestProductPrice {
	 @Test
	     void testValidProductPrice() throws InvalidProductException {
	        // Valid product prices (positive integers)
	        assertTrue(ProductValidator.validateProductPrice(1000));
	        assertTrue(ProductValidator.validateProductPrice(2000));
	    }

	    @Test
	     void testNegativeProductPrice() {
	        // Negative product price should throw an exception
	        assertThrows(InvalidProductException.class, () -> {
	            ProductValidator.validateProductPrice(-1);
	        });
	    }

	    @Test
	     void testZeroProductPrice() {
	        // Zero product price should throw an exception
	        assertThrows(InvalidProductException.class, () -> {
	            ProductValidator.validateProductPrice(0);
	        });
	    }
	

}
 