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
	Product product = new Product(1,"https://www.google.com/imgres?imgurl=https%3A%2F%2F5.imimg.com%2Fdata5%2FHD%2FWK%2FQJ%2FANDROID-15561817%2F1560767688964-jpg-500x500.jpg&tbnid=xqf9YzB-bmRk3M&vet=12ahUKEwj2nOnZg4GBAxUk2jgGHTJpAqoQMygCegQIARBX..i&imgrefurl=https%3A%2F%2Fwww.indiamart.com%2Fproddetail%2Fleg-press-machine-21029521773.html&docid=rAir3UfoPPd9yM&w=500&h=500&q=leg%20machine%20images%20hd&ved=2ahUKEwj2nOnZg4GBAxUk2jgGHTJpAqoQMygCegQIARBX","Leg Machine",30000,"Used to strength your leg");
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
