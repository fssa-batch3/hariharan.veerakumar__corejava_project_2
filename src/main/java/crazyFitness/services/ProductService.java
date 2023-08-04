package crazyFitness.services;

import crazyFitness.dao.ProductDAO;
import crazyFitness.dao.exceptions.DAOException;
import crazyFitness.model.Product;
import crazyFitness.services.exceptions.ServiceException;
import crazyFitness.validation.ProductValidator;
import crazyFitness.validation.exceptions.InvalidProductException;
import crazyFitness.validation.exceptions.InvalidUserException;

public class ProductService {
	public boolean ProductCreate(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.CreateProduct(product)) {
				System.out.println("Product " +product.getProduct_name() + " Successfully added");
				return true;
			} else {
				System.out.println("Product " +product.getProduct_name() + " creating not successful");
				return false;
			}
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		}
	}
}
