package crazyFitness.services.testProduct;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import crazyFitness.model.Product;
import crazyFitness.services.ProductService;
import crazyFitness.services.exceptions.ServiceException;

 class TestUpdateProduct {
@Test
 void testValidUpdate() {
	ProductService productService = new ProductService();
	Product product = new Product(1,"./../assets/images/dumbbells.jpg","Dumb Bells",1000,"Made up of rubber and iron");
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
