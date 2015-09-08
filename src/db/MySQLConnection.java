package db;

import java.sql.*;
import java.util.concurrent.ExecutionException;

public class MySQLConnection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/employee_management_system";

	// Database credentials
	static final String USER = "binhnguyen";
	static final String PASS = "123456";

	private static Connection conn = null;
	
	private MySQLConnection() {
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to a selected database...\n");
			conn = DriverManager.getConnection(DB_URL, USER,PASS);
			System.out.println("Connected database succesfully...\n");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	

}
