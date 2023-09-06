package com.fssa.crazyfitness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.util.ConnectionDb;
import com.fssa.crazyfitness.util.DatabaseException;

public class UserDAO {
	 
	private static final String COLUMN_USER_ID  = "user_id";
	private static final String COLUMN_FNAME = "first_name";
	private static final String COLUMN_LNAME = "last_name";
	private static final String COLUMN_AGE = "age";
	private static final String COLUMN_EMAIL  = "email";
	private static final String COLUMN_PASSWORD = "password";
	private static final String COLUMN_PHONE = "phone";
	private static final String COLUMN_ADDRESS = "address";

	private static User mapResultSetToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt(COLUMN_USER_ID));
		user.setEmail(rs.getString(COLUMN_EMAIL ));
		user.setFname(rs.getString(COLUMN_FNAME));
		user.setLname(rs.getString(COLUMN_LNAME));
		user.setAge(rs.getInt(COLUMN_AGE));
		user.setPassword(rs.getString(COLUMN_PASSWORD));
		user.setPhone(rs.getString(COLUMN_PHONE));
		user.setAddress(rs.getString(COLUMN_ADDRESS));
		return user;
	}
	/**
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public boolean emailCheck(String email) throws DAOException, SQLException {
		final String selectQuery = "SELECT email FROM user WHERE email = ?";
		ResultSet rs = null;
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery)) {
			selectPst.setString(1, email);
			rs = selectPst.executeQuery();

			// Email already exists, do not proceed with registration
			return rs.next();

		} catch (DatabaseException e) {
			throw new DAOException(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
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

			if (!emailCheck(user.getEmail())) {
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

		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
	}

// login user 
	/**
	 * @param email
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public User getUserByEmail(String email) throws DAOException {
		final String selectQuery = "SELECT * FROM user WHERE email = ?";

		ResultSet rs = null;
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement pst = connect.prepareStatement(selectQuery)) {
			pst.setString(1, email);

			rs = pst.executeQuery();
			if (rs.next()) {
			 return mapResultSetToUser(rs);
			}
			rs.close();
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
		return null;

	}
	

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public User getUserById(int id) throws DAOException {
		final String selectQuery = "SELECT * FROM user WHERE user_id= ? ";
		ResultSet rs = null;
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement pst = connect.prepareStatement(selectQuery);) {
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				return mapResultSetToUser(rs);
			}
			rs.close();
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public static List<User> getAllUsers() throws DAOException {
		final String selectAllUserQuery = "SELECT * FROM user";
		List<User> userList = new ArrayList<>();
		try (Connection connect = ConnectionDb.getConnection();
				Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(selectAllUserQuery)) {
			while (rs.next()) {
				User user = mapResultSetToUser(rs);
				userList.add(user);
			}

		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}
		return userList;
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

		} catch (SQLException | DatabaseException e) {
			throw new DAOException(e);
		}

	}
/**
 * 
 * @param id
 * @return
 * @throws DAOException
 */
	public boolean deleteUser(int id) throws DAOException {
		final String deleteQuery = "DELETE FROM user WHERE user_id=?";
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
