package com.fssa.crazyfitness.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.util.ConnectionDb;
import com.fssa.crazyfitness.dao.exceptions.DAOException;

public class UserDAO {

	/**
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public boolean emailCheck(String email) throws SQLException {
		final String selectQuery = "SELECT email FROM user WHERE email = ?";
		ResultSet rs = null;
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery)) {
			selectPst.setString(1, email);
			rs = selectPst.executeQuery();
			if(rs.next()) {
				// Email already exists, do not proceed with registration
				return false;
			}
			return true;

		} finally {
			rs.close();
		}
	}

	/**
	 * @param user
	 * @return
	 * @throws DAOException
	 */
	public boolean register(User user) throws DAOException {
		final String insertQuery = "INSERT INTO user (first_name,last_name,age,email,password,phone,address) VALUES (?,?,?,?,?,?,?)";

		try (Connection connect = ConnectionDb.getConnection();

				PreparedStatement insertPst = connect.prepareStatement(insertQuery)) {

			if (emailCheck(user.getEmail())) {
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
			} else {
				throw new DAOException("Your email is already registered please try another");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

// login user 
	/**
	 * @param email
	 * @return
	 * @throws DAOException
	 */
	public User getUserByEmail(String email) throws DAOException {
		final String selectQuery = "SELECT * FROM user WHERE email = ?";

		try (Connection connect = ConnectionDb.getConnection();
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
	/**
	 * @param user
	 * @return
	 * @throws DAOException
	 */
	public boolean update(User user) throws DAOException {
		final String updateQuery = "UPDATE user SET first_name= ?, last_name = ?,age = ?,password = ?,phone=?,address = ? WHERE email = ?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement pst = connect.prepareStatement(updateQuery)) {
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
