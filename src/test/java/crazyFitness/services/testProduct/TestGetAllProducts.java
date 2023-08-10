package crazyFitness.services.testProduct;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import crazyFitness.dao.ProductDAO;
import crazyFitness.dao.exceptions.DAOException;
import crazyFitness.model.Product;

class TestGetAllProducts {
 @Test
 void testGetAllProductsSuccess() {
	 try {
		List<Product> products = ProductDAO.getAllProducts(); 
		for(Product product : products) {
			System.out.println(product.getProductId() + " - " + product.getProductImage()+ " - " + product.getProductName() 
			+ " - "+ product.getProductPrice() + " - " +product.getProductDescrption());
		}
	} catch (DAOException e) {
		e.printStackTrace();
		fail();
	}
	 
 }
 
}
