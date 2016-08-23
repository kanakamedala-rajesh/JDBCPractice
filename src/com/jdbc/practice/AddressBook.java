package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	public static Connection dbconn;

	public static PreparedStatement pstmt;
	public static Statement stmt;

	public static ResultSet rset;

	public static String dbURL = "jdbc:postgresql://localhost/person";
	public static String user = "postgres";
	public static String pass = "root";
	public static String Firstname, Lastname, Email, Phone;
	public static int rowsInserted = 0, id = 0;

	public static void main(String[] args) {

		// Function Calls

		Map<Integer, Person> map = prepareData();
		insertData(map);
		showData();
	}

	private static void showData() {

		try {
			// Display Table Data
			dbconn = DriverManager.getConnection(dbURL, user, pass);
			String query = "select * from person order by id desc";
			stmt = dbconn.createStatement();
			rset = stmt.executeQuery(query);
			System.out.println("ID \t First Name \t Last Name \t Email ID \t Phone Number ");
			System.out.println("---------------------------------------------------------------------------------");
			while (rset.next()) {
				System.out.println(rset.getInt(1) + " \t " + rset.getString(2) + " \t " + rset.getString(3) + " \t \t"
						+ rset.getString(4) + " \t\t " + rset.getString(5) + " ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void insertData(Map<Integer, Person> map) {

		try {
			dbconn = DriverManager.getConnection(dbURL, user, pass);

			// Retrieving ID Value by sorting elements in Descending order

			String query = "select * from person order by id desc";
			stmt = dbconn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				id = rset.getInt(1);
				id++;
			}

			// Insertion of values into table

			query = "Insert into person values (?, ?, ?, ?, ?)";
			pstmt = dbconn.prepareStatement(query);

			pstmt.setInt(1, id);
			pstmt.setString(2, Firstname);
			pstmt.setString(3, Lastname);
			pstmt.setString(4, Email);
			pstmt.setString(5, Phone);

			rowsInserted = pstmt.executeUpdate();
			if (rowsInserted != 0) {
				System.out.println("\nRow with id: " + id + " inserted succesfully\n");
			} else {
				System.out.println("Some unexpected error occured");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Map<Integer, Person> prepareData() {
		Map<Integer, Person> map = null;
		Person p = new Person();
		try {
			Class.forName("org.postgresql.Driver");

			// Reading Input values From User

			Scanner in = new Scanner(System.in);
			System.out.println("Enter First Name: ");
			Firstname = in.nextLine();
			System.out.println("Enter Last Name: ");
			Lastname = in.nextLine();
			System.out.println("Enter Email Id: ");
			Email = in.nextLine();
			System.out.println("Enter Phone Number: ");
			Phone = in.nextLine();
			in.close();

			// Setting values to person object

			p.setFirstName(Firstname);
			p.setLastName(Lastname);
			p.setEmail(Email);
			p.setPhone(Phone);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
