package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import  com.fssa.crazyfitness.services.exceptions.ServiceException;

 class TestDeleteProduct {
	@Test
	 void testValidDelete() {
		ProductService productService = new ProductService();
		try {
			assertTrue(productService.productDelete(14));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test 
	 void testInValidIDDelete() {
		ProductService productService = new ProductService();
		try {
			assertFalse(productService.productDelete(2));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test 
	 void testNegativeIdDelete() {
		ProductService productService = new ProductService();
		try {
			assertFalse(productService.productDelete(-2));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
