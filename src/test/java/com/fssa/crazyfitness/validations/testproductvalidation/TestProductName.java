 package com.fssa.crazyfitness.validations.testproductvalidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.fssa.crazyfitness.validations.ProductValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

 class TestProductName {
	    @Test
	     void testValidProductName() throws InvalidProductException {
	        // Valid product names
	        assertTrue(ProductValidator.validateProductName("Bar123"));
	        assertTrue(ProductValidator.validateProductName("Dumb bells"));
	        assertTrue(ProductValidator.validateProductName("Bar-with-hyphens"));
	        assertTrue(ProductValidator.validateProductName("Bar_with_underscores"));
	    }
	 
	    @Test
	     void testNullProductName() {
	        // Null product name should throw an exception
	        assertThrows(InvalidProductException.class, () -> {
	            ProductValidator.validateProductName(null);
	        });
	    }
	    
	    @Test
	     void testEmptyProductName() {
	        // Empty product name should throw an exception
	        assertThrows(InvalidProductException.class, () -> {
	            ProductValidator.validateProductName("");
	        });
	    }
	    @Test
	     void testInvalidCharactersInProductName() {
	        // Product names with special characters should throw an exception
	        assertThrows(InvalidProductException.class, () -> {
	            ProductValidator.validateProductName("Product$%^");
	        });


	    }
	
}
