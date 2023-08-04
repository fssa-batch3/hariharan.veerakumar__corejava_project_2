package crazyFitness.model;

public class Product {
	public String product_image;
	public String product_alt;
	public String product_name;
	public int product_price;
	
	
	public Product(String product_image,String product_alt, String product_name, int product_price) {
		super();
		this.product_image = product_image;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_alt = product_alt;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	
	public String getProduct_alt() {
		return product_alt;
	}
	public void setProduct_alt(String product_alt) {
		this.product_alt = product_alt;
	}
	
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "Product [product_image=" + product_image + ", product_alt=" + product_alt + ", product_name="
				+ product_name + ", product_price=" + product_price + "]";
	}
	
	


}
