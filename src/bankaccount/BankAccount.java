package bankaccount;

/**
 *
 * @author Ashley synchronized
 */
public class BankAccount {
                 
                 private long accountNo;
	private double accountBalance;
	// Lock lock = new ReentrantLock();

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
        
                  public synchronized boolean deposit(double value, User user) {
		// lock.lock();
		user.getBankAccount().accountBalance += value;
                                    // System.out.println(user.getBankAccount().accountBalance + " => " +
		// value)
		System.out.println();
		System.out.println("Operation for deposit  >> name:" + user.getUserName() + ", surname : " + user.getUserSurname()
						+ ", value => " + value + ", Account Balance = " + user.getBankAccount().accountBalance);
		// lock.unlock();
                                    return true;
                 
                  }

	public synchronized boolean withdraw(double value, User user) {
                                   // lock.lock();
		if (user.getBankAccount().accountBalance < value) {
			System.out.println("Can't withdraw (user:" + user.getUserName() + ",money:" + String.valueOf(value)
					+ ")! Your current account has insufficient funds");
			return false;
		}
		user.getBankAccount().accountBalance -= value;
		System.out.println();
                                   // System.out.println(user.getBankAccount().accountBalance + " => " +
		// value);
		System.out.println("Operation for withdraw >> name:" + user.getUserName() + ", surname : " + user.getUserSurname()
						+ ", value => " + value + ", Account Balance = " + user.getBankAccount().accountBalance);
		// lock.unlock();
                                    return true;
	}
}

// Runnable interface contains run method
class Transaction implements Runnable {
	private BankAccount sourceAccount, destinationAccount;
	private double amount;

	Transaction(BankAccount sourceAccount, BankAccount destinationAccount, double amount) {
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
	}
                    // run method prints when finished.
	public void run() {
		System.out.printf("%s completed ", Thread.currentThread().getName());
	}
}
