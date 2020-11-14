package elipos5;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Transaction.java Inneh�ller transaktion f�r banken och anv�ndaren
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
 * 
 */
public class Transaction {
	
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	//privata variabler f�r transaktion
	private Date date;
	private double amount;
	private double balance;
	
	public Transaction(double amount, double balance) {
		this.amount = amount;
		this.balance = balance;
		date = new Date();
	}
	
	public boolean isWithdrawl() {
		return amount < 0;
	}
	
	public boolean isDeposit() {
		return amount >= 0;
	}
	//str�ngrepresentation
	@Override
	public String toString() {
		return FORMATTER.format(date)+" " + amount + " " + balance;
	}
	
}