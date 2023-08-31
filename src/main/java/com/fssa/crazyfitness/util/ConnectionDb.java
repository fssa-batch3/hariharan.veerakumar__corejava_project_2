package com.fssa.crazyfitness.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	public static Connection getConnection() throws DatabaseException {
		Connection connect = null;

		String url;
		String user;
        String password;
		// Cloud DB
		url = System.getenv("DB_URL");
		user = System.getenv("DB_USER");
		password = System.getenv("DB_PASSWORD");

		// LocalHost
//		url = "jdbc:mysql://localhost:3306/crazyfitness";
//		user	= "root";
//		password = "123456";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DatabaseException("Unable to connect to database", e);
		} catch (ClassNotFoundException e) {
			throw new DatabaseException("Database driver class not found", e);
		}

		return connect;
	}

}
