
package bankaccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Ashley
 */
public class Main {
    
                  static ArrayList<User> userList = new ArrayList<User>();
	static ArrayList<double[]> transactionList = new ArrayList<double[]>();

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
			if ("1".equals(sline)) { // create a Account
				bank = createAccount();
				System.out.println("Successfully created account.\n");

			} else if ("2".equals(sline)) {
				// User user = createUser();

				if (bank == null) {
					System.out.println("Please create account.");
					continue;
				}
				
				transactionList  = new ArrayList<>();
				userList  = new ArrayList<>();

				
				
				BankAccount userBank = bank;
				
				boolean state = true;
				
				while (state) {
					//printMenu();
					
					System.out.println("Create a User");
					String user_name = null;
					String user_surname = null;
					String user_transaction = null;
					
					boolean name_state = true;
					while(name_state){
						System.out.print("User name: > ");
						
						user_name = "";
						try {
							user_name = br.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if ("".equals(user_name)) {
							System.out.println("[ERROR] Enter the starting user name correctly. try again !");
							continue;
						}
						name_state = false;
							
					}
					
					boolean sur_state = true;
					while(sur_state){
						System.out.print("User surname: > ");
						user_surname = "";
						try {
							user_surname = br.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if ("".equals(user_surname)) {
							System.out.println("[ERROR] Enter the starting user surname correctly, try again !");
							continue;
						}
						sur_state = false;
					}
					
					
					boolean transaction_state = true;
					while(transaction_state){
						System.out.print("User transaction: > ");
						
						user_transaction = "";
						try {
							user_transaction = br.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if ("".equals(user_transaction)) {
							System.out.println("[ERROR] Enter the starting user transaction correctly");
							continue;
						}
						transaction_state = false;
					}
					
					
					String[] transaction_string = user_transaction.split(",");
					
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
