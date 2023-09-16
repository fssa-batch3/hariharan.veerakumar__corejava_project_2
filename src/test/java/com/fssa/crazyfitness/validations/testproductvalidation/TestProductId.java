package com.fssa.crazyfitness.validations.testproductvalidation;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import  com.fssa.crazyfitness.validations.ProductValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

 class TestProductId {
	 @Test
	     void testValidId() throws InvalidProductException {
	        // Valid product IDs (positive integers)
	        assertTrue(ProductValidator.validateId(1));
	        assertTrue(ProductValidator.validateId(100));
	    }

	    @Test
	     void testNegativeId() {
	        // Negative product ID should throw an exception
	        assertThrows(InvalidProductException.class, () -> {
	            ProductValidator.validateId(-1);
	        });
	    }

	    @Test
	     void testZeroId() {
	        // Zero product ID should throw an exception
	        assertThrows(InvalidProductException.class, () -> {
	            ProductValidator.validateId(0);
	        });
	    }

}
