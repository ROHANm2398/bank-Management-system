package com.soft;

// customers
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Register {

	public void register() {

		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

			Statement st = con.createStatement();

			long phone_number, customerID=0, Aadhar_number=0, phone;
			String Firstname, Middlename, Lastname;

			System.out.println("--------------------------------------------");
			System.out.print("Enter first name = ");
			Firstname = sc.next();
			System.out.print("Enter Middle name = ");
			Middlename = sc.next();
			System.out.print("Enter Lastname name = ");
			Lastname = sc.next();

			System.out.print("Enter Phone Number = ");
			phone_number = sc.nextLong();
			System.out.print("Enter Aadhar number = ");
			phone_number = sc.nextLong();
			System.out.print("Enter you login id = ");
			phone_number = sc.nextLong();

			String query = "insert into customers values(" + customerID + ",'" + Aadhar_number + "','" + Firstname
					+ "','" + Middlename + "', '" + Lastname + "','" + phone_number + "')";
			int row1 = st.executeUpdate(query);
			System.out.println("");
			System.out.println(row1 + " row inserted successfully...!");
			System.out.println("");
			System.out.println("** Login again to enjoy services");
			System.out.println("--------------------------------------------");
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// register

}// class
