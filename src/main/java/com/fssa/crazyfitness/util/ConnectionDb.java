package com.fssa.crazyfitness.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	public static Connection getConnection()  {
		Connection connect = null;
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		DB_URL = System.getenv("DB_URL");
		DB_USER = System.getenv("DB_USER");
		DB_PASSWORD = System.getenv("DB_PASSWORD");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to database", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database driver class not found", e);
		}

		return connect;
	}

}
