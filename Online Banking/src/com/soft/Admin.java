package com.soft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
	public void admin() {
		Scanner sc = new Scanner(System.in);
		int options = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// loading driver class

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			Statement st = con.createStatement(); // Object creating to perform query
			PreparedStatement pst = con.prepareStatement("select userid,password from admin"); // Object creating to actuallly pass query
			ResultSet rs = pst.executeQuery(); // Object creating

			String Username, Password;

			System.out.print("Enter login id = ");
			Username = sc.next();
			System.out.print("Enter Password = ");
			Password = sc.next();

			String query1 = "select userid,password from admin";
			ResultSet rs1 = pst.executeQuery(query1);
			List<String> s1 = new ArrayList<String>();
			List<String> s2 = new ArrayList<String>();

			while (rs1.next()) {
				s1.add(rs1.getString("userid")); // add userid from table into list
				s2.add(rs1.getString("password")); // add password from table into list

			}

			if (s1.contains(Username) && s2.contains(Password)) { // comparing user entered values with records from the
																	// table
				System.out.println();
				System.out.println("*** correct credintials");
				System.out.println("-----------------------------------");
				do {
					System.out.println("Select choice = " 
				            + "\n1.To delete the details of customer"
							+ "\n2.To delete the details of Accounts" 
				            + "\n3.To delete the details of Loan"
							+ "\n4.To delete the details of Bank" 
				            + "\n5.To delete the details of bank_customer"
							+ "\n6.To add new details to customer" 
				            + "\n7.To add new details to Bank_customer"
				            + "\n0.Exit");
					System.out.println("------------------");
					System.out.println("Enter choice ");
					System.out.println("------------------");
					System.out.print("= ");
					options = sc.nextInt();

					switch (options) {
					case 1:
						// To delete the records from customer table

						System.out.println("-----------------------------------");
						System.out.print("Enter customer_ID of customer = ");
						int customer_ID = sc.nextInt();

						PreparedStatement pst1 = con.prepareStatement("delete from customers where customer_ID= ? ");
						pst1.setInt(1, customer_ID);

						int rs11 = pst1.executeUpdate();
						System.out.println("");
						System.out.println(rs11 + " Customer  deleted successfully...!");
						System.out.println("-----------------------------------");

//						con.close();
//						st.close();
						break;

					case 2:
						// To delete the records from Accounts Table

						System.out.println("-----------------------------------");
						System.out.print("Enter customer_ID of customer = ");
						customer_ID = sc.nextInt();

						PreparedStatement pst11 = con.prepareStatement("delete from accounts where customer_ID= ? ");
						pst11.setInt(1, customer_ID);

						int rs10 = pst11.executeUpdate();
						System.out.println("");
						System.out.println(rs10 + " Customer account deleted successfully...!");
						System.out.println("-----------------------------------");

//						con.close();
//						st.close();
						break;

					case 3:
						// To delete the records from Loan Table

						System.out.println("-----------------------------------");
						System.out.print("Enter customer_ID of customer = ");
						customer_ID = sc.nextInt();

						PreparedStatement pst2 = con.prepareStatement("delete from loan where customer_ID= ? ");
						pst2.setInt(1, customer_ID);

						int rs2 = pst2.executeUpdate();
						System.out.println("");
						System.out.println(rs2 + " loan requested deleted successfully...!");
						System.out.println("-----------------------------------");

//						con.close();
//						st.close();
						break;

					case 4:
						// To delete the records from Bank Table

						System.out.println("-----------------------------------");
						System.out.print("Enter customer_ID of customer = ");
						customer_ID = sc.nextInt();

						PreparedStatement pst3 = con.prepareStatement("delete from bank where customer_ID= ? ");
						pst3.setInt(1, customer_ID);

						int rs3 = pst3.executeUpdate();
						System.out.println("");
						System.out.println(rs3 + "  Bank Records deleted successfully...!");
						System.out.println("-----------------------------------");

//						con.close();
//						st.close();
						break;

					case 5:
						// To delete the records from bank_customer Table

						System.out.println("-----------------------------------");
						System.out.print("Enter customer_ID of customer = ");
						customer_ID = sc.nextInt();

						PreparedStatement pst4 = con
								.prepareStatement("delete from bank_customer where customerID= ? ");
						pst4.setInt(1, customer_ID);

						int rs4 = pst4.executeUpdate();
						System.out.println("");
						System.out.println(rs4 + " Customer removed successfully...!");
						System.out.println("-----------------------------------");

//						con.close();
//						st.close();
						break;

					case 6:
						// To insert into customers table

						System.out.println("-----------------------------------");
						System.out.print("Enter first name = ");
						String Firstname = sc.next();

						System.out.print("Enter Middle name = ");
						String Middlename = sc.next();

						System.out.print("Enter Lastname name = ");
						String Lastname = sc.next();

						System.out.print("Enter Phone Number = ");
						long phone = sc.nextLong();

						System.out.print("Enter Aadhar number = ");
						long Aadhar_number = sc.nextLong();

						System.out.print("Enter you login id = ");
						long customerID = sc.nextLong();

						String query = "insert into customers values(" + customerID + ",'" + Aadhar_number + "','"
								+ Firstname + "','" + Middlename + "', '" + Lastname + "','" + phone + "')";

						int row1 = st.executeUpdate(query);
						System.out.println("");
						System.out.println(row1 + " row inserted successfully...!");

						System.out.println("-----------------------------------");

						break;

					case 7:
						// To insert the records into Bank_ customer Table

						System.out.println("-----------------------------------");
						System.out.print("Enter Customer ID = ");
						long customerID1 = sc.nextLong();

						System.out.print("Enter bank_IFSC code = ");
						String bank_IFSC = sc.next();

						String query2 = "insert into bank_customer values(" + customerID1 + ",'" + bank_IFSC + "')";
						int row11 = st.executeUpdate(query2);

						System.out.println("");
						System.out.println(row11 + " row inserted successfully...!");
						System.out.println("-----------------------------------");

//						con.close();
//						st.close();
						break;

//					case 8:
//						// To insert the records into Accounts Table
//
//						System.out.println("-----------------------------------");
//						System.out.print("Enter Customer ID = ");
//						long customer_ID1 = sc.nextLong();
//
//						System.out.print("Enter the Account_Number = ");
//						long Account_Number = sc.nextLong();
//
//						System.out.print("Enter the balance = ");
//						int Balance = sc.nextInt();
//
//						System.out.print("Enter the Account_type = ");
//						String Account_type = sc.next();
//
//						String query3 = "insert into Accounts values(" + customer_ID1 + ",'" + Account_Number + "','"
//								+ Balance + "','" + Account_type + "')";
//
//						System.out.println("");
//						int row3 = st.executeUpdate(query3);
//						System.out.println(row3 + " row inserted successfully...!");
//						System.out.println("-----------------------------------");

//						con.close();
//						st.close();
//						break;
//
//					case 9:
//						// To insert the records into Loan Table
//
//						System.out.println("-----------------------------------");
//
//						System.out.println("Enter how much Amount you want as a loan");
//						int amt = sc.nextInt();
//
//						System.out.println("Enter Loan number");
//						int lno = sc.nextInt();
//
//						System.out.println("Enter which type  of loan do you want");
//						String type = sc.next();
//
//						System.out.println("Enter your customer ID");
//						String cid = sc.next();
//
//						String query11 = "insert into loan values(" + lno + ",'" + amt + "','" + type + "','" + cid
//								+ "')";
//
//						System.out.println("");
//						int row = st.executeUpdate(query11);
//						System.out.println(row + " row inserted successfully...!");
//						System.out.println("-----------------------------------");

//						con.close();
//						st.close();
//						break;
//
//					case 10:
//						// To insert the records into Bank Table
//
//						System.out.println("-----------------------------------");
//
//						System.out.print("Enter Customer ID = ");
//						long customer_ID11 = sc.nextLong();
//
//						System.out.print("Enter the IFSC Code of Branch = ");
//						String IFSC_code = sc.next();
//
//						System.out.print("Enter Bank_name = ");
//						String Bank_name = sc.next();
//
//						System.out.print("Enter Bank_address = ");
//						String Bank_address = sc.next();
//
//						String query5 = "insert into bank values(" + customer_ID11 + ",'" + IFSC_code + "','"
//								+ Bank_name + "','" + Bank_address + "')";
//
//						System.out.println("");
//						int row5 = st.executeUpdate(query5);
//						System.out.println(row5 + " row inserted successfully...!");
//						System.out.println("-----------------------------------");

//						con.close();
//						st.close();

//						break;

					}// switch
				} while (options != 0);// while
			} else {
				System.out.println("Incorrect credintials");

			} // else

			con.close();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();

		} // catch

	}// admin

}// class