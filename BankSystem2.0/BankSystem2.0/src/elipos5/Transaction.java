package elipos5;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Transaction.java Innehåller transaktion för banken och användaren
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
 * 
 */
public class Transaction {
	
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	//privata variabler för transaktion
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
	//strängrepresentation
	@Override
	public String toString() {
		return FORMATTER.format(date)+" " + amount + " " + balance;
	}
	
}