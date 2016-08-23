package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMetaDataDemo {

	public static Connection dbconn;
	public static DatabaseMetaData dbmd;

	public static void main(String[] args) {
		try {

			// *** Step1: Loading the PostgreSQL driver *** //
			Class.forName("org.postgresql.Driver");
			// System.out.println("postgreSql driver loaded successfully");

			// *** Step2: Establish the Database Connection *** //
			String dbURL = "jdbc:postgresql://localhost/MyDB";
			String user = "postgres";
			String pass = "root";
			dbconn = DriverManager.getConnection(dbURL, user, pass);
			// System.out.println("Connection established Successfully");
			// Step3: Defining the DatabaseMetaDataobject
			dbmd = dbconn.getMetaData();
			System.out.println("Database Product: " + dbmd.getDatabaseProductName());
			System.out.println("Database Version: " + dbmd.getDatabaseProductVersion());
			System.out.println("Username: " + dbmd.getUserName());
			System.out.println("URL: " + dbmd.getURL());
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("SP Support: " + dbmd.supportsStoredProcedures());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// *** Step6: Close all the objects *** //
			try {

				dbconn.close();
				// System.out.println("\n closing DBObjects done successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
