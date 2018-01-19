
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
}
