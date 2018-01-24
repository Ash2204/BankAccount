package bankaccount;

/**
 *
 * @author Ashley
 */
public class User {
	private String name;
	private String surname;
	private BankAccount bankAccount;
	private double[] transactionList;

	public User(String name, String surname, BankAccount bA, double[] tL) {
		this.name = name;
		this.surname = surname;
		this.bankAccount = bA;
		this.transactionList = tL;
	}

	public String getUserName() {
		return this.name;
	}

	public BankAccount getBankAccount() {
		return this.bankAccount;
	}

	public String getUserSurname() {
		return this.surname;
	}

}
