package com.fssa.crazyfitness.model;

public class Product {
	private String productImage;
	private String productName;
	private int productPrice;
	private String productDescrption;
	private int productId;
	
	public String getProductImage() { 
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescrption() {
		return productDescrption;
	}
	public void setProductDescrption(String productDescrption) {
		this.productDescrption = productDescrption;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	/**
	 * @param productImage
	 * @param productName
	 * @param productPrice
	 * @param productDescrption
	 * constructor which is used for add product (Create) because id is auto increment in database
	 */
	public Product(String productImage, String productName, int productPrice, String productDescrption ) {
		super();
	
		this.productImage = productImage;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescrption = productDescrption;
		
	}
	
	/**
	 * @param productId
	 * @param productImage
	 * @param productName
	 * @param productPrice
	 * @param productDescrption
	 * constructor which is used for edit product because getting product by id(Update)
	 */
	public Product(int productId,String productImage, String productName, int productPrice, String productDescrption ) {
		super();
		this.productId = productId;
		this.productImage = productImage;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescrption = productDescrption;
		
	}
	
	
	@Override
	public String toString() {
		return "Product [product_image=" + productImage + ", product_name=" + productName + ", product_price="
				+ productPrice + ", descrption=" + productDescrption + ", product_id=" + productId + "]";
	}
	
	
	
	

}
