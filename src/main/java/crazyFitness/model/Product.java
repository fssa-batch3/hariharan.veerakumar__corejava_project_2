package crazyFitness.model;

public class Product {
	public String product_image;
	public String product_name;
	public int product_price;
	public String descrption;
	public int product_id;
	
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
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
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Product(int product_id,String product_image, String product_name, int product_price, String descrption ) {
		super();
		this.product_id = product_id;
		this.product_image = product_image;
		this.product_name = product_name;
		this.product_price = product_price;
		this.descrption = descrption;
		
	}
	
	
	@Override
	public String toString() {
		return "Product [product_image=" + product_image + ", product_name=" + product_name + ", product_price="
				+ product_price + ", descrption=" + descrption + ", product_id=" + product_id + "]";
	}
	
	
	
	

}
