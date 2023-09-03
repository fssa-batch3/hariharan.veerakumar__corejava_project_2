package com.fssa.crazyfitness.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.crazyfitness.model.Product;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;

public class ProductValidator {

	/**
	 * 
	 * @param product
	 * @return
	 * @throws InvalidProductException
	 */
	public static boolean validateEditProduct(Product product) throws InvalidProductException {
		if (product == null) {
			throw new InvalidProductException("Product should not be null");
		}

		return validateProductName(product.getProductName()) && validateProductImage(product.getProductImage())
				&& validateProductPrice(product.getProductPrice()) && validateDescrption(product.getProductDescrption())
				&& validateId(product.getProductId());
	}

	/**
	 * 
	 * @param product
	 * @return
	 * @throws InvalidProductException
	 */
	public static boolean validateProduct(Product product) throws InvalidProductException {
		if (product == null) {
			throw new InvalidProductException("Product should not be null");
		}
		return validateProductName(product.getProductName()) && validateProductImage(product.getProductImage())
				&& validateProductPrice(product.getProductPrice())
				&& validateDescrption(product.getProductDescrption());

	}

	public static boolean validateProductName(String name) throws InvalidProductException {
		if (name == null)
			throw new InvalidProductException("The Product name should not be null");
		if (name.trim().isEmpty()) {
			throw new InvalidProductException("The Product name is should not be empty");
		}

		String regex = "^[a-zA-Z0-9\\s-_]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		boolean match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidProductException(
					"The Product name can contain alphabetic values or numeric values and spaces");
		}

	}

	public static boolean validateProductImage(String url) throws InvalidProductException {
		if (url == null) {
			throw new InvalidProductException("The Product image URL should not be null");
		}
		if (url.trim().isEmpty()) {
			throw new InvalidProductException("The Product image URL should not be empty");
		}

		return true;

	}

	public static boolean validateId(int id) throws InvalidProductException {
		if (id > 0) {
			return true;
		} else {
			throw new InvalidProductException(
					"The Product ID should not be in negative values and must not contain alphabetic characters also should not be 0");
		}
	}

	public static boolean validateDescrption(String desc) throws InvalidProductException {
		if (desc == null) {
			throw new InvalidProductException("The Product description should not be null");
		}
		if (desc.trim().isEmpty()) {
			throw new InvalidProductException("The Product description should not be empty");
		} else {
			return true;
		}
	}

	public static boolean validateProductPrice(int price) throws InvalidProductException {

		if (price <= 0) {
			throw new InvalidProductException("The Product price should not be in negative values and 0");
		} else {
			return true;
		}

	}
}
