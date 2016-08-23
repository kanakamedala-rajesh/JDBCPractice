package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSetDEmo {

	public static Connection dbconn;
	public static Statement stmt;
	public static ResultSet rset;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			stmt = dbconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// System.out.println("Statement executed successfully");

			// *** Step4: Execute the query to retrieve the data *** //
			String query = "Select * from SEARCH_ENGINE";
			rset = stmt.executeQuery(query);
			// System.out.println("Query executed successfully");

			// *** Step5: Read the data from the resultset *** //
			// System.out.println("------------------------------");
			// Step5: Scroll the resultset in backward direction
			rset.afterLast();
			while (rset.previous()) {
				System.out.println(
						"Id: " + rset.getString(1) + "\t Name: " + rset.getString(2) + "\t Url: " + rset.getString(3));

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
