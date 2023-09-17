package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.Product;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestGetProductById {
	@Test
	void testValidGetProductById() {
		ProductService productService = new ProductService();
		Product product = new Product();
		try {
			product = productService.getProductById(1);
			System.out.println(product.getProductId() + " - " + product.getProductName());
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
