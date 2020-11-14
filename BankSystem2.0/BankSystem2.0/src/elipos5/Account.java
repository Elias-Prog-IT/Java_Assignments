package elipos5;
import java.util.ArrayList;
/**
 * Account.java Inneh�ller kontouppgifter f�r banken och anv�ndaren
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
 */

public abstract class Account {

	// kontonummer som ska tilldelas, b�rjar fr�n 1001
	private static int currentAccountNumber = 1001;

	// kontouppgifter
	protected double balance;
	protected String accountType;
	protected int accountNumber;
	protected ArrayList<Transaction> transactions;

	public Account(String accountType) {
		this.accountType = accountType;
		balance = 0;
		accountNumber = currentAccountNumber++;
		transactions = new ArrayList<>();
	}

	//ins�ttning av pengar/belopp
	public void deposit(double amount) {
		balance += amount;
		transactions.add(new Transaction(amount, balance));
	}

	public abstract boolean withdraw(double amount);

	public abstract String closeAccount();

	//h�mtar kontonummer
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public ArrayList<String> getTransactions() {
		ArrayList<String> list = new ArrayList<>();
		for (Transaction transaction : transactions) {
			list.add(transaction.toString());
		}
		
		return list;
	}

	//str�ngrepresentation
	@Override
	public String toString() {
		return accountNumber + " " + balance + " " + accountType;
	}
}