package com.fssa.crazyfitness.validations.testproductvalidation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ProductValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

class TestProductImageUrl {
@Test
void testValidURL() {
	try {
		assertTrue(ProductValidator.validateProductImage("https://freeimage.host/i/Hm3OtqXhttps"));
	} catch (InvalidProductException e) {
		e.printStackTrace();
		
	}
}
}
