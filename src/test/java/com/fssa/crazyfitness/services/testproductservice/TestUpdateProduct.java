package com.fssa.crazyfitness.services.testproductservice;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import  com.fssa.crazyfitness.model.Product;
import  com.fssa.crazyfitness.services.ProductService;
import  com.fssa.crazyfitness.services.exceptions.ServiceException;

 class TestUpdateProduct {
@Test
 void testValidUpdate() {
	ProductService productService = new ProductService();
	Product product = new Product(1,"./../assets/images/LegMachine.jpg","Leg Machine",30000,"Used to strength your leg");
	try {
		assertTrue(productService.productUpdate(product));
	}catch(ServiceException e){
		e.printStackTrace();
		fail();
	}
}
  
@Test
 void testInvalidUpdate() {
	ProductService productService = new ProductService();
	Product product = new Product(10,"./../assets/images/dumbbells.jpg","Dumb Bells",1000,"Made up of rubber and iron");
	try {
		assertFalse(productService.productUpdate(product));
	}catch(ServiceException e){
		e.printStackTrace();
		
	}
}
@Test
 void testNegativePriceUpdate() {
	ProductService productService = new ProductService();
	Product product = new Product(1,"./../assets/images/dumbbells.jpg","Dumb Bells",-1000,"Made up of rubber and iron");
	try {
		assertFalse(productService.productUpdate(product));
	}catch(ServiceException e){
		e.printStackTrace();
		
	}
}

}
