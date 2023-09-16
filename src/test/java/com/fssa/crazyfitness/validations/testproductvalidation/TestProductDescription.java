package com.fssa.crazyfitness.validations.testproductvalidation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


import com.fssa.crazyfitness.validations.ProductValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

 class TestProductDescription {
    @Test
     void testValidDescription() throws InvalidProductException {
        // Valid product descriptions
        assertTrue(ProductValidator.validateDescription("This is a valid description."));
           }

    @Test
     void testNullDescription() {
        // Null product description should throw an exception
        assertThrows(InvalidProductException.class, () -> {
            ProductValidator.validateDescription(null);
        });
    }

    @Test
     void testEmptyDescription() {
        // Empty product description should throw an exception
        assertThrows(InvalidProductException.class, () -> {
            ProductValidator.validateDescription("");
        });
    }
}
