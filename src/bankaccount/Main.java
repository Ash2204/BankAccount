
package bankaccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ashley
 */
public class Main {
    
                  static User user1 = null;
	static User user2 = null;
	static User user3 = null;
	static User user4 = null;

                  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                  // prints first menu for the User to create a bank account, User, runs the simulation and exits the application.
	public static void printMenu() {
		System.out.println("1. Create Bank Account");
		System.out.println("2. Create User");
		System.out.println("3. Run Simulation");
		System.out.println("4. Exit");
		System.out.println(">> ");
	}
                  
                  // Creates the bank account, adds a account number and checks for errors 
                  public static BankAccount createAccount() {
		System.out.println("Create Bank Account");
		System.out.print("Bank Account number: > ");
		String strAccountNo = "";
		try {
			strAccountNo = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
                  if ("".equals(strAccountNo)) {
			System.out.println("[ERROR] Enter Bank Account number correctly");
			return null;
		}
                  
                  System.out.print("Starting Balance > ");
		String str_start_balance = "";
		try {
			str_start_balance = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if ("".equals(str_start_balance)) {
			System.out.println("[ERROR] Enter the starting balance correctly");
			return null;
		}

		try {
			Long accountNo = Long.valueOf(strAccountNo);
			Double start_balance = Double.valueOf(str_start_balance);
			BankAccount bank = new BankAccount(accountNo, start_balance);

			return bank;
		} catch (Exception e) {
			System.out.println("[ERROR] AccountNo should be a long type.");
		}

		return null;
	}
                 
                  // creates new users, defines names, surnames and transactions in array list
                  public static User createUser() {
		String name1 = "Saul", surname1 = "Goodman";
		String name2 = "Walter", surname2 = "White";
		String name3 = "Jessie", surname3 = "Pinkman";
		String name4 = "Hank", surname4 = "Schrader";

		BankAccount userBank1 = createAccount();
		BankAccount userBank2 = createAccount();
		BankAccount userBank3 = createAccount();
		BankAccount userBank4 = createAccount();

		double[] transaction1 = { 50, 10, -20, 10, -20, 20, 10, 50, -10, 10, -10, 50 };
		double[] transaction2 = { 20, 20, -20, 50, -20, 10, 50, 50, -20, 10, 10 };
		double[] transaction3 = { 50, 10, 10, -10, -10, 50, 20, -10, -1111 };
		double[] transaction4 = { 50, 10, -20, 20, 10, -20 };

		User user1 = new User(name1, surname1, userBank1, transaction1);
		User user2 = new User(name2, surname2, userBank2, transaction2);
		User user3 = new User(name3, surname3, userBank3, transaction3);
		User user4 = new User(name4, surname4, userBank4, transaction4);

		return null;
                  }
                  
                  
    public static void main(String args[]) {
        
        BankAccount bank = null;

		final double[] transaction1 = new double[] { 50, 10, -20, 10, -20, 20, 10, 50, -10, 10, -10, 50 };
		final double[] transaction2 = new double[] { 20, 20, -20, 50, -20, 10, 50, 50, -20, 10, 10 };
		final double[] transaction3 = new double[] { 50, 10, 10, -10, -10, 50, 20, -10, -20 };
		final double[] transaction4 = new double[] { 50, 10, -20, 20, 10, -20 };

		while (true) {
			printMenu();
			String sline = null;
			try {
				sline = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("");
			if ("1".equals(sline)) { // create a Account
				bank = createAccount();
				System.out.println("Successfully created account.\n");

			} else if ("2".equals(sline)) {
				// User User = createUser();

				if (bank == null) {
					System.out.println("Please create account.");
					continue;
				}

				BankAccount userBank = bank;
				String name1 = "Saul", surname1 = "Goodman";
				String name2 = "Walter", surname2 = "White";
				String name3 = "Jessie", surname3 = "Pinkman";
				String name4 = "Hank", surname4 = "Schrader";

				user1 = new User(name1, surname1, userBank, transaction1);
				user2 = new User(name2, surname2, userBank, transaction2);
				user3 = new User(name3, surname3, userBank, transaction3);
				user4 = new User(name4, surname4, userBank, transaction4);

				System.out.println("Successfully created user.\n");

			} else if ("3".equals(sline)) {

				if (user1 == null) {
					System.out.println("Please create user.");
					continue;
				}

				if (bank == null) {
					System.out.println("Please create account.");
					continue;
				}

				System.out.println("Start simulator !");
				BankAccount userBank = bank;
				Thread deposit_thread1 = new Thread() {

					@Override
					public void run() {
						// Wait to simulate io like database access ...
						super.run();
						for (int i = 0; i < transaction1.length; i++) {
							if (transaction1[i] > 0) {
								userBank.deposit(transaction1[i], user1);
							} else {
								if (!userBank.withdraw(-transaction1[i], user1)) {
								
								}
							}
						}
					}
				};
				deposit_thread1.start();
                                
                                                                       Thread deposit_thread2 = new Thread() {

					@Override
					public void run() {
						// Wait to simulate io like database access ...
						super.run();
						for (int i = 0; i < transaction2.length; i++) {
							if (transaction2[i] > 0) {
								userBank.deposit(transaction2[i], user2);
							} else {
								if (!userBank.withdraw(-transaction2[i], user2)) {

								}
							}
						}
					}
				};
				deposit_thread2.start();

				Thread deposit_thread3 = new Thread() {

					@Override
					public void run() {
						// Wait to simulate io like database access ...
						super.run();
						for (int i = 0; i < transaction3.length; i++) {
							if (transaction3[i] > 0) {
								userBank.deposit(transaction3[i], user3);
							} else {
								if (!userBank.withdraw(-transaction3[i], user3)) {

								}
							}
						}
					}
				};
				deposit_thread3.start();

				Thread deposit_thread4 = new Thread() {

					@Override
					public void run() {
						// Wait to simulate io like database access ...
						super.run();
						for (int i = 0; i < transaction4.length; i++) {
							if (transaction4[i] > 0) {
								userBank.deposit(transaction4[i], user4);
							} else {
								if (!userBank.withdraw(-transaction4[i], user4)) {

								}
							}
						}
					}
				};
				deposit_thread4.start();
			} else if ("4".equals(sline)) {
				break;
			}
		}

		System.out.println("End Bank Simulator. Bye!");
	}

}

