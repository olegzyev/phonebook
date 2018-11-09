package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	// Database credentials
	static final String USER = "user";
	static final String PASS = "pass";
	Connection conn = null;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Register JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Open a connection
		System.out.println("Connecting to a selected database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("Connected database successfully...");
		return conn;
	}
}
