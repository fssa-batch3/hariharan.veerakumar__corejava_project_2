package crazyFitness.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crazyFitness.dao.exceptions.DAOException;
import crazyFitness.model.Product;

public class ProductDAO {

	public static void main(String[] args) {
		try {
			Connection connect = getConnection();
			System.out.println(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		Connection connect = null;
		String url = "jdbc:mysql://localhost/crazyfitness";
		String username = "root";
		String password = "123456";
		try {

			connect = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Fail to connect to the database");
		}
		return connect;
	}

	public boolean CreateProduct(Product product) throws DAOException {
		String insertQuery = "INSERT INTO product (product_id,image_url,product_name,price,description) VALUES(?,?,?,?,?)";
		String selectQuery = "SELECT product_name FROM product WHERE product_name = ?";
		try (Connection connect = getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery);
				PreparedStatement insertPst = connect.prepareStatement(insertQuery);) {

			selectPst.setString(1, product.getProduct_name());
			ResultSet rs = selectPst.executeQuery();
			if (rs.next()) {
				// Product name already exists, do not proceed with registration
				rs.close();
				return false;
			}
			rs.close();
			insertPst.setInt(1, product.getProduct_id());
			insertPst.setString(2, product.getProduct_image());
			insertPst.setString(3, product.getProduct_name());
			insertPst.setInt(4, product.getProduct_price());
			insertPst.setString(5, product.getDescrption());
			int rows = insertPst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean UpdateProduct(Product product) throws DAOException {
		String updateQuery = "UPDATE product SET image_url = ?, product_name =?, price = ? ,description =? WHERE product_id =?";
		try (Connection connect = getConnection();
				PreparedStatement updatePst = connect.prepareStatement(updateQuery);) {
			updatePst.setString(1, product.getProduct_image());
			updatePst.setString(2, product.getProduct_name());
			updatePst.setInt(3, product.getProduct_price());
			updatePst.setString(4, product.getDescrption());
			updatePst.setInt(5, product.getProduct_id());
			int rows = updatePst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}
	
	public boolean DeleteProduct(int id) throws DAOException{
		String deleteQuery = "DELETE FROM product WHERE product_id = ?";
		try(Connection connect = getConnection();
			PreparedStatement deletePst = connect.prepareStatement(deleteQuery);){
			deletePst.setInt(1, id);
			int rows = deletePst.executeUpdate();
			return (rows ==1);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
