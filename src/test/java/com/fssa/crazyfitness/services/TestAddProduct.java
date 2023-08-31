package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.services.exceptions.ServiceException;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;
import com.fssa.crazyfitness.model.Product;

class TestAddProduct {
	@Test
	void testCreateProduct() {
		ProductService productService = new ProductService();
		String url = "https://www.bftfitness.com/uploads/allimg/220616/1-220616095201I6.jpg";
		Product product = new Product(url, "Lat Pulldown", 39999,
				"The lat pull down machine is designed for the purpose of compound exercise, specifically exercise meant to both develop and then stress the lat muscle");
		try {
			assertTrue(productService.productCreate(product));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testNullProduct() {

		ProductService productService = new ProductService();
		Product product = null;
		try {
			productService.productCreate(product);
			Throwable exception = assertThrows(InvalidProductException.class, () -> {
			});
			assertEquals("Product should not be null", exception.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
