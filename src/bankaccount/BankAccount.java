package bankaccount;

/**
 *
 * @author Ashley synchronized
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

	public boolean withdraw(double value, user user) {

		if (user.getBankAccount().accountBalance < value) {
			System.out.println("Can't withdraw (user:" + user.getUserName() + ",maney:" + String.valueOf(value)
					+ ")! Current account haven't sufficient");
			return false;
		}
		user.getBankAccount().accountBalance -= value;
		System.out.println();
		System.out.println("Operation for withdraw >> name:" + user.getUserName() + ", surname : " + user.getUserSurname()
						+ ", value => " + value + ", Account Balance = " + user.getBankAccount().accountBalance);
		return true;
	}
}

class Transaction implements Runnable {
	private BankAccount sourceAccount, destinationAccount;
	private double amount;

	Transaction(BankAccount sourceAccount, BankAccount destinationAccount, double amount) {
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
	}

	public void run() {
		System.out.printf("%s completed ", Thread.currentThread().getName());
	}
}
