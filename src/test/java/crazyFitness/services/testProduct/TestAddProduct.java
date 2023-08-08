package crazyFitness.services.testProduct;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import crazyFitness.services.exceptions.*;

import crazyFitness.services.ProductService; 
import crazyFitness.model.Product; 

public class TestAddProduct {
	@Test
	public void testCreateProduct() {
		ProductService productService = new ProductService();
		Product product = new Product(2,"./../assets/images/legmachine.jpg","Leg Machine",29999,"Used to stronger your leg");
		try {
			assertTrue(productService.ProductCreate(product));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void testNullProduct() { 
		ProductService productService = new ProductService();
		Product product = null;
		try {
			assertFalse(productService.ProductCreate(product));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}


}
	