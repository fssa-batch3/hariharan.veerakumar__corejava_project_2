package crazyFitness.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import crazyFitness.model.Product;
import crazyFitness.validation.exceptions.InvalidProductException;
import crazyFitness.validation.exceptions.InvalidUserException;

public class ProductValidator {
	
	public static boolean validateProduct(Product product) throws InvalidProductException{
		if(product != null && validateProductName(product.getProduct_name()) && validateProductImage(product.getProduct_image())
				 && validateProductPrice(product.getProduct_price()) && validateDescrption(product.getDescrption()) && validateId(product.getProduct_id())) {
			return true;
		}
		else {
			throw new InvalidProductException("Product details are not valid");
		}
	}
	
	
	
	public static boolean validateProductName(String name) {
		boolean match = false;
		if(name == null)
			return false;
		try {
			String regex = "^[a-zA-Z0-9\\s-_]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				System.out.println("The Product name is valid."); 
			} else {
				System.out.println("The Product name is not valid");
			}
		} catch (Exception e) { 
			System.out.println("Product name is not valid");
		}
		return match; 
	}
	
	public static boolean validateProductImage(String url) {
		boolean match = true;
		if(url == null) {
			match = false;
		}
		return match;
	}

	public static boolean validateId(int id) {
		boolean match = true;
		if(id > 0) {
			System.out.println("The ID is valid");
			match = true;
		}
		else if (id <= 0){	
			System.out.println("The ID is Invalid");
			match = false;
		}
		return match;
	}
	
//	public static boolean validateProductAlt(String alt) {
//		boolean match = true;
//		if(alt == null) {
//			match = false;
//		}
//		return match;
//	}
	
	public static boolean validateDescrption(String desc) {
		boolean match = true;
		if(desc == null) {
			System.out.println("Your product description is Invalid or null");
			match = false;
		}
		System.out.println("Your product description in Valid");
		return match;
	}
	public static boolean validateProductPrice(int price) {
		boolean match = false;
		if(price < 0) {
			return false;
		}
		try {
			String regex ="^\\d+(\\.\\d{1,2})?$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(String.valueOf(price));
			match = m.matches();
			if(match) {
				System.out.println("The product price is Valid");
			}else {
				System.out.println("The product price is Invalid");
			}
			
		} catch (Exception e) {
			System.out.println("The product price is Invalid");
		}
		return match;
	}
}
