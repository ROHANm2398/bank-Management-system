package com.soft;
// loan
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Loan {

	public void loan() { 
		// TODO Auto-generated method stub
		try {
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// create connection to the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			java.sql.Statement stmt = con.createStatement();
			int flag = 0;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter your bank balance = ");
			int bal = sc.nextInt();
			
			if (bal > 5000) {
				flag = 1;
			} else {
				System.out.println("!!! Sorry you are not  eligible to apply for loan !!!");
				flag = 0;

			}

			if (flag == 1) {
				System.out.println("--------------------------------------------");
				System.out.println("Enter how much Amount you want as a loan");
				int amt = sc.nextInt();

				System.out.println("Enter Loan number");
				int lno = sc.nextInt();

				System.out.println("Enter which type  of loan do you want");
				String type = sc.next();

				System.out.println("Enter your customer ID");
				String cid = sc.next();
				System.out.println("--------------------------------------------");
				String query = "insert into loan values(" + lno + ",'" + amt + "','" + type + "','" + cid + "')";

				int row = stmt.executeUpdate(query);
				System.out
						.println("**********************************************************************************");
				System.out.println(" Your loan request has been succesfully submitted...  You will be notified soon");
				System.out
						.println("**********************************************************************************");

				stmt.close();
				con.close();
			} // if
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//loan

}//class
