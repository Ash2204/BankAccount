package bankaccount;

/**
 *
 * @author Ashley
 */

public class CreateThread implements Runnable {

	private User user;
	private double[] transaction;
	private BankAccount userBank;
	
	
	@Override
	public void run() {
		// Wait to simulate io like database access ...
		
		for (int i = 0; i < transaction.length; i++) {
			if (transaction[i] > 0) {
				userBank.deposit(transaction[i], user);
			} else {
				if (!userBank.withdraw(-transaction[i], user)) {
					
				}
			}
			try {
				Thread.sleep(100);
			}
			catch(Exception e) {
				
			}
		}
		
	}

	public CreateThread(User user, BankAccount userBank, double[] transaction) {
		this.user = user;
		this.userBank = userBank;
		this.transaction = transaction;
	}
	
}

