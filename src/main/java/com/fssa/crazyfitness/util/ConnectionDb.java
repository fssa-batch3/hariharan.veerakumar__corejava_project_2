package com.fssa.crazyfitness.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

 public class ConnectionDb {
	public static Connection getConnection() throws DatabaseException {
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
		}catch(SQLException e) {
			throw new DatabaseException("Unable to connect to database",e);
		}
		

		return connect;
	}

}
