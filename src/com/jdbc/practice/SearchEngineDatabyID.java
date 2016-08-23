package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchEngineDatabyID {
	public static Connection dbconn;
	public static PreparedStatement stmt;
	public static ResultSet rs;

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String dbURL = "jdbc:postgresql://localhost/MyDB";
			String user = "postgres";
			String pass = "root";
			dbconn = DriverManager.getConnection(dbURL, user, pass);
			// Step4: Read the data to insert
			Scanner in = new Scanner(System.in);
			System.out.println("Enter Id to search");
			int id = in.nextInt();
			in.close();
			// Step3: Defining a PreparedStatementobject
			String query = "SELECT * FROM SEARCH_ENGINE WHERE id = ?";

			stmt = dbconn.prepareStatement(query);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(1)+'\t'+rs.getString(2));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
