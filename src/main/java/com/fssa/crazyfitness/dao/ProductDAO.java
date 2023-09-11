package com.fssa.crazyfitness.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.Product;
import com.fssa.crazyfitness.util.ConnectionDb;
import com.fssa.crazyfitness.util.DatabaseException;

public class ProductDAO {

	/**
	 * @param productName
	 * @return
	 * @throws SQLException 
	 * @throws DAOException 
	 */
	public boolean productNameCheck(String productName) throws SQLException, DAOException {
		final String selectQuery = "SELECT product_name FROM product WHERE product_name = ?";
		ResultSet rs = null;
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery);) {
			selectPst.setString(1, productName);
			rs = selectPst.executeQuery();
			// Product name already exists, do not allow in database
			return rs.next();
		} catch (DatabaseException e) {
			throw new DAOException(e);
		} finally {
			if (rs != null) {
				rs.close();
			}

		}
	}

// create product
	/**
	 * @param product
	 * @return
	 * @throws DAOException
	 */ 
	public boolean createProduct(Product product) throws DAOException {
		final String insertQuery = "INSERT INTO product (image_url,product_name,price,description) VALUES(?,?,?,?)";

		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement insertPst = connect.prepareStatement(insertQuery);) {
			if (!productNameCheck(product.getProductName())) {
				insertPst.setString(1, product.getProductImage());
				insertPst.setString(2, product.getProductName());
				insertPst.setInt(3, product.getProductPrice());
				insertPst.setString(4, product.getProductDescrption());
				int rows = insertPst.executeUpdate();
				return (rows == 1);
			} else {
				throw new DAOException("This product already added");
			}
		} catch (SQLException |DatabaseException e) {
			throw new DAOException(e);
		} 
	}

//	Read product
	/**
	 * @return
	 * @throws DAOException
	 */
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
	/**
	 * @param product
	 * @return
	 * @throws DAOException
	 */
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
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public static Product getProductById(int id) throws DAOException{
		final String selectProductQuery  = "SELECT * FROM product WHERE product_id=?";
		ResultSet rs = null;
		try(Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectProductQuery);){
			selectPst.setInt(1, id);
			rs = selectPst.executeQuery();
			if(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductImage(rs.getString("image_url"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("price"));
				product.setProductDescrption(rs.getString("description"));
				
				return product;
			}
			else {
				rs.close();
			}
		}catch(SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
		return null;
	}

//	delete product
	/**
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public boolean deleteProduct(int id) throws DAOException {
		final String deleteQuery = "DELETE FROM product WHERE product_id = ?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement deletePst = connect.prepareStatement(deleteQuery);) {
			deletePst.setInt(1, id);
			int rows = deletePst.executeUpdate();
			return (rows == 1);
		} catch (SQLException |DatabaseException e) {
			throw new DAOException(e);
		}
	}

}
