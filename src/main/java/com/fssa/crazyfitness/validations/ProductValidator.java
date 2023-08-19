package com.fssa.crazyfitness.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.crazyfitness.model.Product;
import com.fssa.crazyfitness.validations.exceptions.InvalidProductException;


public class ProductValidator {
	
	public static boolean validateProduct(Product product) throws InvalidProductException{
		if(product != null && validateProductName(product.getProductName()) && validateProductImage(product.getProductImage())
				 && validateProductPrice(product.getProductPrice()) && validateDescrption(product.getProductDescrption()) && validateId(product.getProductId())) {
			return true;
		}
		else {
			throw new InvalidProductException("Product details are not valid");
		}
	} 
	
	
	
	public static boolean validateProductName(String name) throws InvalidProductException {

		if(name == null || name.isEmpty())
			return false;
	
			String regex = "^[a-zA-Z0-9\\s-_]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			boolean match = m.matches();
			if (match) {
				return true; 
			} else {
				throw new InvalidProductException("The Product name is not valid");
			} 
	}
	 
	public static boolean validateProductImage(String url) throws InvalidProductException {
		if(url == null || url.isEmpty()) {
			throw new InvalidProductException("The Product image URL is not valid");
		} else {
			return true;
		}
	}

	public static boolean validateId(int id) throws InvalidProductException {
		if(id > 0) {
			return true;
		}
		else {	
			throw new InvalidProductException("The Product ID is not valid");
		}
	}
	
//	public static boolean validateProductAlt(String alt) {
//		boolean match = true;
//		if(alt == null) {
//			match = false;
//		}
//		return match;
//	}
	
	public static boolean validateDescrption(String desc) throws InvalidProductException {
		if(desc == null || desc.isEmpty()) {
			throw new InvalidProductException("The Product description is not valid");
		} else {
			return true;
		}
	}
	
	public static boolean validateProductPrice(int price) throws InvalidProductException {
		
		if(price < 0) {
			throw new InvalidProductException("The Product price is not valid");
		}
		
			String regex ="^\\d+(\\.\\d{1,2})?$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(String.valueOf(price));
			boolean match = m.matches();
			if(match) {
				return true;
			}else {
				throw new InvalidProductException("The Product price is not valid");
			}
			
	
	}
}
