package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo {

	public static Connection dbconn;
	public static Statement stmt;

	public static ResultSet rset;
	public static ResultSetMetaData rsmd;

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

			// *** Step3: Defining a statement object *** //
			stmt = dbconn.createStatement();
			// System.out.println("Statement executed successfully");

			// *** Step4: Execute the query to retrieve the data *** //
			String query = "Select * from SEARCH_ENGINE";
			rset = stmt.executeQuery(query);
			// System.out.println("Query executed successfully");

			// Step5: Define the ResultSetMetaDataobject
			rsmd = rset.getMetaData();
			int i = 1;
			while (i <= rsmd.getColumnCount()) {
				String columnName = rsmd.getColumnName(i);
				String columnType = rsmd.getColumnTypeName(i);
				System.out.print("The name of the column " + i + " is: '");
				System.out.print(columnName);
				System.out.println("'");
				System.out.print("The data type of the column " + i + " is: ");
				System.out.println(columnType);
				i++;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// *** Step6: Close all the objects *** //
			try {
				rset.close();
				stmt.close();
				dbconn.close();
				// System.out.println("\n closing DBObjects done successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
