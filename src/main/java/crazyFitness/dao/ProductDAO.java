package crazyFitness.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crazyFitness.dao.exceptions.DAOException;
import crazyFitness.model.Product;
import io.github.cdimascio.dotenv.Dotenv;

public class ProductDAO {



	public boolean CreateProduct(Product product) throws DAOException {
		String insertQuery = "INSERT INTO product (product_id,image_url,product_name,price,description) VALUES(?,?,?,?,?)";
		String selectQuery = "SELECT product_id FROM product WHERE product_id = ?";
		try (Connection connect = UserDAO.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery);
				PreparedStatement insertPst = connect.prepareStatement(insertQuery);) {

			selectPst.setInt(1, product.getProduct_id());
			ResultSet rs = selectPst.executeQuery();
			if (rs.next()) {
				// Product id already exists, do not allow in database
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
		try (Connection connect = UserDAO.getConnection();
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
		try(Connection connect = UserDAO.getConnection();
			PreparedStatement deletePst = connect.prepareStatement(deleteQuery);){
			deletePst.setInt(1, id);
			int rows = deletePst.executeUpdate();
			return (rows ==1);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
