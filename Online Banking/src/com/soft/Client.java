package com.soft;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("--------------------------------------------------------------------------");
			System.out.print("Select what you want to perform = \n\n1 Login\n2 Register\n3 Admin login\n0 Exit\n\t ");
			System.out.print("Enter Choice: ");
			choice = sc.nextInt();
			System.out.println("--------------------------------------------------------------------------");

			switch (choice) {

			case 1:
				Login l = new Login();

				if (l.login()) {
					System.out.println("");
					System.out.println("***************** Successful logged in *****************");
					System.out.println("--------------------------------------------------------------------------");

					do {
						System.out.print("Enter choice of what you want to perform");

						System.out.print(
								"\n1.Deposit" + "\n2.Withdraw" + "\n3.Check balance" + "\n4.Loan" + "\n0.Exit\n");
						System.out.print("   Your choice = ");
						choice = sc.nextInt();

						switch (choice) {

						case 1:
							Deposit d = new Deposit(); // object creation
							d.deposit(); // calling deposite method
							break;

						case 2:
							Withdraw w = new Withdraw();
							w.withdraw();
							break;

						case 3:
							ViewBalance v = new ViewBalance();
							v.viewBalance();
							break;

						case 4:
							Loan ln = new Loan();
							ln.loan();
							break;

						}// switch

					} while (choice != 0);

				} else {
					System.out.println("");
					System.out.println("!!! Incorrect details entered !!!");

				}

				break;

			case 2:

				Register r = new Register();
				r.register();

				break;

			case 3:
				Admin ad = new Admin();
				ad.admin();
				break;

			}

		} while (choice != 0);

	}// main

}
// class
