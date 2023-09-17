package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import  com.fssa.crazyfitness.model.Product;
import  com.fssa.crazyfitness.services.exceptions.ServiceException;

 class TestUpdateProduct {
@Test
 void testValidUpdate() {
	ProductService productService = new ProductService();
	String url = "https://media.istockphoto.com/id/531520849/photo/barbell.jpg?b=1&s=612x612&w=0&k=20&c=23n5ib9GETy8PwO6UcbjSaY_RqGXjVcxeO7epZ7pmmY=";

	Product product = new Product();
	product.setProductId(7);
	product.setProductImage(url);
	product.setProductName("Bar Bells");
	product.setProductPrice(21000);
	product.setProductDescrption("Consists of couple bars with specific kilograms");

	try {
	    assertTrue(productService.productUpdate(product));
	} catch (ServiceException e) {
	    e.printStackTrace();
	    fail();
	}

}
   
@Test
 void testInvalidUpdate() {
	ProductService productService = new ProductService();
	Product product = new Product();
	product.setProductId(10110);
	product.setProductImage("./../assets/images/dumbbells.jpg");
	product.setProductName("Dumb Bells");
	product.setProductPrice(1000);
	product.setProductDescrption("Made up of rubber and iron");
	try {
		assertFalse(productService.productUpdate(product));
	}catch(ServiceException e){
		e.printStackTrace();
		
	}
}

}
