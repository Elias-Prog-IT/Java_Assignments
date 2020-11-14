package elipos5;
/**
 * Representerar kreditkonto
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
 */
public class CreditAccount extends Account 
{

	private static final double DEPOSIT_RATE = 0.5, DEBT_RATE = 7, CREDIT_LIMIT = 5000;

	private double creditLimit;
	private double depositRate;
	private double debtRate;

	// konstruktor 
	public CreditAccount() 
	{
		super("Credit Account");
		debtRate = DEBT_RATE;
		depositRate = DEPOSIT_RATE;
		creditLimit = CREDIT_LIMIT;
	}

	@Override
	public boolean withdraw(double amount) 
	{
		// Om balansen är mindre än kreditgränsen 
		if (balance - amount < -creditLimit)
			return false;

		balance -= amount;
		transactions.add(new Transaction(-amount, balance));
		return true;
	}

	
	//ränta
	public double calcInterest()
	{
		if (balance > 0)
			return balance * depositRate / 100;
		else
			return balance * debtRate / 100;
	}

	
	// stänger kontot
	@Override
	public String closeAccount() 
	{
		return accountNumber + " " + balance + " " + accountType + " " + depositRate + " " + " " + debtRate + " "
				+ calcInterest();
	}

	// strängrepresentation
	@Override
	public String toString() 
	{
		return super.toString() + " " + creditLimit + " " + depositRate + " " + debtRate;
	}

}