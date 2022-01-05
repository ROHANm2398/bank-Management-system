package com.soft;

// accounts
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class ViewBalance {

	public void viewBalance() {

		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			PreparedStatement ps = con.prepareStatement("select Balance from accounts where Account_Number=? ");

			System.out.println("--------------------------------------------");
			System.out.println("Enter your account number");
			long account_number = sc.nextInt();

			ps.setLong(1, account_number);

			Resultset rs = (Resultset) ps.executeQuery();
			List<Integer> l = new ArrayList<>();

			while (((ResultSet) rs).next()) {
				l.add(((ResultSet) rs).getInt("Balance"));

			}
			int amount = l.get(0);
			System.out.println("");
			System.out.println("*** Account balance = Rs " + amount);
			System.out.println("--------------------------------------------");

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// viewBalance

}// class
