package com.fssa.crazyfitness.validations.testproductvalidation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ProductValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

class TestProductImageUrl {
	 @Test
	     void testValidProductImage() throws InvalidProductException {
	        // Valid product image URLs
	        assertTrue(ProductValidator.validateProductImage("https://example.com/image.jpg"));
	        assertTrue(ProductValidator.validateProductImage("http://example.com/image.png"));
	    }

	    @Test
	     void testNullProductImage() {
	        // Null product image URL should throw an exception
	        assertThrows(InvalidProductException.class, () -> {
	            ProductValidator.validateProductImage(null);
	        });
	    }

	    @Test
	     void testEmptyProductImage() {
	        // Empty product image URL should throw an exception
	        assertThrows(InvalidProductException.class, () -> {
	            ProductValidator.validateProductImage("  ");
	        });
	    }


}
