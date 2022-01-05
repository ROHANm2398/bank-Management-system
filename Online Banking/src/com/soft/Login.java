package com.soft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

	public boolean login() {

		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

			Statement st = con.createStatement();
			PreparedStatement pst = con.prepareStatement("select customer_ID,phone from customers");
			ResultSet rs = pst.executeQuery();

			String Username, Password;

			System.out.print("Enter login id = ");
			Username = sc.next();
			System.out.print("Enter phone number as Password = ");
			Password = sc.next();

			String query1 = "select customer_ID,phone from customers";
			ResultSet rs1 = pst.executeQuery(query1);
			List<String> s1 = new ArrayList<String>();
			List<String> s2 = new ArrayList<String>();

			while (rs1.next()) {
				s1.add(rs1.getString("customer_ID"));
				s2.add(rs1.getString("phone"));
			}
			
			con.close();
			st.close();

			if (s1.contains(Username) && s2.contains(Password)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}// login

}// class
