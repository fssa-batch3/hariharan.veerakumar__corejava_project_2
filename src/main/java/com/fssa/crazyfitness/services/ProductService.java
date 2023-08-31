package com.fssa.crazyfitness.services;

import java.util.List;

import com.fssa.crazyfitness.dao.ProductDAO;
import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.Product;
import com.fssa.crazyfitness.services.exceptions.ServiceException;
import com.fssa.crazyfitness.validations.ProductValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

public class ProductService {
// create product 
	/**
	 * 
	 * @param product
	 * @return
	 * @throws ServiceException
	 */
	public boolean productCreate(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();

		try {
			ProductValidator.validateProduct(product);
			return productDAO.createProduct(product);
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		}
	}

//list product
	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<Product> getAllProductsList() throws ServiceException {
		try {
			return ProductDAO.getAllProducts();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

// update product
	/**
	 * 
	 * @param product
	 * @return
	 * @throws ServiceException
	 */
	public boolean productUpdate(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateEditProduct(product);
			return productDAO.updateProduct(product);

		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		}
	}

// delete product
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean productDelete(int id) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateId(id);
			return productDAO.deleteProduct(id);
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		}
	}
}
