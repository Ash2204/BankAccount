
package bankaccount;

/**
 *
 * @author Ashley
 */
public class BankAccount {
                 
                 private long accountNo;
	private double accountBalance;
	

	public BankAccount(long accountNo, double accountBalance) {
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
	}

	public long getAccountNo() {
		return this.accountNo;
	}

	public double getAccountBalance() {
		return this.accountBalance;
	}
        
                  public boolean deposit(double value, user user) {
		
		user.getBankAccount().accountBalance += value;
		System.out.println();
		System.out.println("Operation for deposit  >> name:" + user.getUserName() + ", surname : " + user.getUserSurname()
						+ ", value => " + value + ", Account Balance = " + user.getBankAccount().accountBalance);
		return true;
}
