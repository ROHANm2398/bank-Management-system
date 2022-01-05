package com.soft;

// accounts
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Deposit {

	public void deposit() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			PreparedStatement ps = con
					.prepareStatement("update accounts set balance=balance+? where Account_Number=? ");
			Scanner sc = new Scanner(System.in);

			System.out.println("--------------------------------------------");
			System.out.println("Enter your account number");
			long account_number = sc.nextInt();
			System.out.println("Enter the deposit amount");
			int amt = sc.nextInt();

			ps.setInt(1, amt);
			ps.setLong(2, account_number);

			int rows = ps.executeUpdate();
			System.out.println("");

			if (rows > 0) {
				System.out.println("*** Rs " + amt + " Balance added to your account");

			} else
				System.out.println("!!! Sorry something went wrong !!!");
			System.out.println("--------------------------------------------");
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// deposit

}// class
