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
		Product product = new Product(2,"./../assets/images/LegMachine.jpg","Leg Machine",29999,"Used to strength your leg");
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
	