package crazyFitness.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crazyFitness.model.User;
import io.github.cdimascio.dotenv.Dotenv;
import crazyFitness.dao.exceptions.*;

public class UserDAO {
	
	// connecting to database
	public static Connection getConnection() throws SQLException {
		Connection connect = null;
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
		try {

			connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Fail to connect to the database");
		}
		return connect;
	}

	
	// register user
	public boolean register(User user) throws DAOException {
		final String insertQuery = "INSERT INTO user (first_name,last_name,age,email,password,phone,address) VALUES (?,?,?,?,?,?,?)";
		final String selectQuery = "SELECT email FROM user WHERE email = ?";

		try (Connection connect = getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery);
				PreparedStatement insertPst = connect.prepareStatement(insertQuery)) {

			// Check if the email already exists
			selectPst.setString(1, user.getEmail());
			ResultSet rs = selectPst.executeQuery();
			if (rs.next()) {
				// Email already exists, do not proceed with registration
				rs.close();
				return false;
			}
			rs.close();

			// If the email doesn't exist, proceed with the registration
			insertPst.setString(1, user.getFname());
			insertPst.setString(2, user.getLname());
			insertPst.setInt(3, user.getAge());
			insertPst.setString(4, user.getEmail());
			insertPst.setString(5, user.getPassword());
			insertPst.setString(6, user.getPhone());
			insertPst.setString(7, user.getAddress());

			int rows = insertPst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	
// login user
	public User getUserByEmail(String email) throws DAOException {
	    final String selectQuery = "SELECT * FROM user WHERE email = ?";
	    
	    try (Connection connect = getConnection();
	         PreparedStatement pst = connect.prepareStatement(selectQuery)) {
	        pst.setString(1, email);
	        
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            User user = new User();
	            user.setEmail(rs.getString("email"));
	            user.setFname(rs.getString("first_name"));
	            user.setLname(rs.getString("last_name"));
	            user.setAge(rs.getInt("age"));
	            user.setPassword(rs.getString("password"));
	            user.setPhone(rs.getString("phone"));
	            user.setAddress(rs.getString("address"));
	            
	            return user;
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	    
	    return null;
	}


	// update user
	public boolean update(User user) throws DAOException {
		final String updateQuery = "UPDATE user SET first_name= ?, last_name = ?,age = ?,password = ?,phone=?,address = ? WHERE email = ?";
		try (Connection connect = getConnection(); PreparedStatement pst = connect.prepareStatement(updateQuery)) {
			pst.setString(1, user.getFname());
			pst.setString(2, user.getLname());
			pst.setInt(3, user.getAge());
			pst.setString(4, user.getPassword());
			pst.setString(5, user.getPhone());
			pst.setString(6, user.getAddress());
			pst.setString(7, user.getEmail());

			int rows = pst.executeUpdate();
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

}
