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
				System.out.println("Product " + product.getProduct_name() + " Successfully added");
				return true;
			} else {
				System.out.println("Product " + product.getProduct_name() + " creating not successful");
				return false;
			}
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		}
	}

	public boolean ProductUpdate(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.UpdateProduct(product)) {
				System.out.println("Product " + product.getProduct_name() + " Successfully Updated");
				return true;
			} else {
				System.out.println("Product " + product.getProduct_name() + " Updating not successful");
				return false;
			}
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		}
	}

	public boolean ProductDelete(int id) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateId(id);
			if (productDAO.DeleteProduct(id)) {
				System.out.println("Product ID no " + id + " deleted Successfully");
				return true;
			} else {
				System.out.println("Product ID no " + id + " unable to delete");
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
