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
	public boolean productCreate(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.createProduct(product)) {
				System.out.println( product.getProductName() + " Successfully added");
				return true;
			} else {
				System.out.println( product.getProductName() + " creating not successful");
				return false;
			} 
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		} 
	}
	 
//list product
    public List<Product> getAllProductsList() throws ServiceException {
        try {
            return ProductDAO.getAllProducts();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
// update product
	public boolean productUpdate(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.updateProduct(product)) {
				System.out.println( product.getProductName() + " Successfully Updated");
				return true;
			} else {
				System.out.println( product.getProductName() + " Updating not successful");
				return false;
			}
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		}
	}
// delete product
	public boolean productDelete(int id) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateId(id);
			if (productDAO.deleteProduct(id)) {
				System.out.println( id + " deleted Successfully");
				return true;
			} else {
				System.out.println( id + " unable to delete");
				return false;
			}
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		}
	}
}
