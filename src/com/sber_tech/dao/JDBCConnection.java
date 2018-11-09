package com.sber_tech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    static final String JDBC_DRIVER = "mysql.jdbc.driver";
    static final String DB_URL = "localhost:3306:phonebook";
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("mysql.jdbc.driver");
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
        return conn;
    }
}
