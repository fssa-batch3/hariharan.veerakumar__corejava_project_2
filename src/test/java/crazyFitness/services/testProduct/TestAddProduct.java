package crazyFitness.services.testProduct;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import crazyFitness.services.exceptions.*;

import crazyFitness.services.ProductService; 
import crazyFitness.model.Product; 

 class TestAddProduct {
	@Test
	 void testCreateProduct() {
		ProductService productService = new ProductService();
		Product product = new Product(1,"./../assets/images/Dumbbells.jpg","Dumb Bells",999,"Made up of Rubber and Iron");
		try {
			assertTrue(productService.ProductCreate(product));
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
			assertFalse(productService.ProductCreate(product));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}


}
	