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

public class Withdraw {

	public void withdraw() {

		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			PreparedStatement ps = con
					.prepareStatement("update accounts set balance=balance-? where Account_Number=? ");
			PreparedStatement ps1 = con.prepareStatement("select Balance from accounts where Account_Number=? ");

			System.out.println("--------------------------------------------");
			System.out.println("Enter your account number");
			long account_number = sc.nextInt();

			System.out.println("Enter the withdraw amount");
			int amt = sc.nextInt();

			ps.setInt(1, amt);
			ps.setLong(2, account_number);
			ps1.setLong(1, account_number);

			Resultset rs = (Resultset) ps1.executeQuery();
			List<Integer> l = new ArrayList<>();

			while (((ResultSet) rs).next()) {
				l.add(((ResultSet) rs).getInt("Balance"));

			}
			int amount = l.get(0);
//			System.out.println("account balance = " + amount);
			System.out.println("");

			if (amount > amt) {
				ps.executeUpdate();
				System.out.println("*** Rs " + amt + " Has been withdrawn");
			} else {
				System.out.println("!!! Account balance is low !!!");
			}
			System.out.println("--------------------------------------------");

			ps1.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// withdraw

}// class
