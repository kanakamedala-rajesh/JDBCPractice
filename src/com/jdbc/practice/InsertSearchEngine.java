package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertSearchEngine {
	public static Connection dbconn;
	public static Statement stmt;

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String dbURL = "jdbc:postgresql://localhost/MyDB";
			String user = "postgres";
			String pass = "root";
			dbconn = DriverManager.getConnection(dbURL, user, pass);
			stmt = dbconn.createStatement();
			// Step4: Read the data to insert
			Scanner in = new Scanner(System.in);
			int id = 7;
			System.out.println("Enter Search Engine Name: ");
			String name = in.nextLine();
			System.out.println("Enter Search Engine Url: ");
			String url = in.nextLine();
			in.close();
			StringBuilder query = new StringBuilder("Insert into SEARCH_ENGINE (id, name, url) values ");
			query.append("(" + id + ", '" + name.trim() + "', '" + url.trim() + "')");
			System.out.println(query);
			// Step5: Run the above query to insert the data
			int i = stmt.executeUpdate(query.toString());
			System.out.println(i + " record is inserted into 'Search_Engine' successfully..");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
