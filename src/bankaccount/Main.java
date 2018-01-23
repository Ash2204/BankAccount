
package bankaccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ashley
 */
public class Main {
    
                  static user user1 = null;
	static user user2 = null;
	static user user3 = null;
	static user user4 = null;

                  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                  // prints first menu for the user to create a bank account, user, runs the simulation and exits the application.
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
                  public static user createUser() {
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

		user user1 = new user(name1, surname1, userBank1, transaction1);
		user user2 = new user(name2, surname2, userBank2, transaction2);
		user user3 = new user(name3, surname3, userBank3, transaction3);
		user user4 = new user(name4, surname4, userBank4, transaction4);

		return null;
                  }
                  
                  
    public static void main(String args[]) {
        
        BankAccount bank = null;
		
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
			if ("1".equals(sline)) { // creates Account
				bank = createAccount();
				System.out.println("Successfully created account.\n");

			} else if ("2".equals(sline)) {
				// User user = createUser();

				if (bank == null) {
					System.out.println("Please create account.");
					continue;
				}

				BankAccount userBank = bank;
				
				boolean state = true;
				
				while (state) {
					//printMenu();
					
					System.out.println("Create a User");
					System.out.print("User name: > ");
					
					String user_name = "";
					try {
						user_name = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if ("".equals(user_name)) {
						System.out.println("[ERROR] Enter the starting user name correctly");
					}
					
					System.out.print("User surname: > ");
					
					String user_surname = "";
					try {
						user_surname = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if ("".equals(user_surname)) {
						System.out.println("[ERROR] Enter the starting user surname correctly");
					}
					
					System.out.print("Please enter the user transactions using , to seperate values: > ");
					
					String transaction = "";
					try {
						transaction = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if ("".equals(transaction)) {
						System.out.println("[ERROR] Enter the starting user transaction correctly");
					}
					
					String[] transaction_string = transaction.split(",");
					
					double [] transaction_double = new double [transaction_string.length]; 
					
					for (int i=0; i<transaction_string.length; i++){ 
						transaction_double[i] = Double.parseDouble(transaction_string[i]); 
					} 
					
					User user = new User(user_name, user_surname, userBank, transaction_double);
					
					userList.add(user);
					transactionList.add(transaction_double);

					System.out.print("Continue for create user? (y/n) >");
					
					String continue_check = "";
					try {
						continue_check = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if ("n".equals(continue_check)) {
						state = false;
					}
					
					System.out.println("");
				}
				
			
			} else if ("3".equals(sline)) {

				if (userList == null) {
					System.out.println("Please create user.");
					continue;
				}

				if (bank == null) {
					System.out.println("Please create account.");
					continue;
				}

				System.out.println("Start simulator !");
				BankAccount userBank = bank;
				
				for (int i = 0;i < userList.size();i++){
					//CreateThread newThread= new CreateThread(userList.get(i), userBank, transactionList.get(i));
					
					Thread newThread = new Thread(new CreateThread(userList.get(i), userBank, transactionList.get(i)));
					newThread.start();
				}
				
				
			} else if ("4".equals(sline)) {
				break;
			}
		}

		System.out.println("End Bank Simulator. Bye!");
	}

}
