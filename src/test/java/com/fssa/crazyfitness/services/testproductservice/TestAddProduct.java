package com.fssa.crazyfitness.services.testproductservice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.services.exceptions.ServiceException;

import  com.fssa.crazyfitness.services.ProductService; 
import  com.fssa.crazyfitness.model.Product; 

 class TestAddProduct {
	@Test
	 void testCreateProduct() {
		ProductService productService = new ProductService();
		Product product = new Product("./../assets/images/DumbBells.jpg","Dumb Bells",999,"Made up of rubber and Iron");
		try {
			assertTrue(productService.productCreate(product));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}
	@Test  
	 void testNullProduct() { 
		ProductService productService = new ProductService();
		Product product = null;
		try {
			assertFalse(productService.productCreate(product));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}


}
	