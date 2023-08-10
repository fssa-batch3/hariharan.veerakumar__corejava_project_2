package crazyFitness.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import crazyFitness.dao.exceptions.DAOException;
import crazyFitness.model.Product;
import crazyFitness.util.ConnectionDb;
import crazyFitness.util.DatabaseException;

public class ProductDAO {

// create product
	public boolean createProduct(Product product) throws DAOException {
		final String insertQuery = "INSERT INTO product (product_id,image_url,product_name,price,description) VALUES(?,?,?,?,?)";
		final String selectQuery = "SELECT product_id FROM product WHERE product_id = ?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery);
				PreparedStatement insertPst = connect.prepareStatement(insertQuery);) {

			selectPst.setInt(1, product.getProductId());
			ResultSet rs = selectPst.executeQuery();
			if (rs.next()) {
				// Product id already exists, do not allow in database
				rs.close();
				return false; 
			}
			rs.close();
			insertPst.setInt(1, product.getProductId());
			insertPst.setString(2, product.getProductImage());
			insertPst.setString(3, product.getProductName());
			insertPst.setInt(4, product.getProductPrice());
			insertPst.setString(5, product.getProductDescrption());
			int rows = insertPst.executeUpdate();
			return (rows == 1);
		} catch (SQLException | DatabaseException  e) {
			throw new DAOException(e);
		}
	}

//	Read product
	public static List<Product> getAllProducts() throws DAOException {
		final String selectAllProductsQuery = "SELECT * FROM product";
		List<Product> productList = new ArrayList<>();
		try (Connection connect = ConnectionDb.getConnection();
				Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(selectAllProductsQuery);) {

			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productImage = rs.getString("image_url");
				String name = rs.getString("product_name");
				int price = rs.getInt("price");
				String description = rs.getString("description");

				Product product = new Product(productId, productImage, name, price, description);
				productList.add(product);
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
		return productList;
	}

	// update product
	public boolean updateProduct(Product product) throws DAOException {
		final String updateQuery = "UPDATE product SET image_url = ?, product_name =?, price = ? ,description =? WHERE product_id =?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement updatePst = connect.prepareStatement(updateQuery);) {
			updatePst.setString(1, product.getProductImage());
			updatePst.setString(2, product.getProductName());
			updatePst.setInt(3, product.getProductPrice());
			updatePst.setString(4, product.getProductDescrption());
			updatePst.setInt(5, product.getProductId());
			int rows = updatePst.executeUpdate();
			return (rows == 1);
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}

	}

//	delete product
	public boolean deleteProduct(int id) throws DAOException {
		final String deleteQuery = "DELETE FROM product WHERE product_id = ?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement deletePst = connect.prepareStatement(deleteQuery);) {
			deletePst.setInt(1, id);
			int rows = deletePst.executeUpdate();
			return (rows == 1);
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
	}

}
