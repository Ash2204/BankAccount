
package bankaccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ashley
 */
public class Main {
    
    
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
  
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
