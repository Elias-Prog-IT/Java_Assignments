package elipos5;
/**
 * SavingsAccount.java Representerar sparkontot
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
 * 
 */
public class SavingsAccount extends Account 
{

	//standardränta
	private static final int INTEREST_RATE = 1, FREE_WITHDRAWL_LIMIT = 1, WITHDRAWL_RATE = 2;

	private double interestRate;
	private double withdrawlRate;
	private int countWithdrawls;

	//sparkontot
	public SavingsAccount() 
	{
		super("Savngs Account");
		interestRate = INTEREST_RATE;
		withdrawlRate = WITHDRAWL_RATE;
	}

	// Om det finns pengar/balans i kontot så kan man ta ut pengar.
	public boolean withdraw(double amount) 
	{
		// Om fritt uttagningsgräns har nåtts
		if (countWithdrawls == FREE_WITHDRAWL_LIMIT)
			amount += withdrawlRate * amount;

		if (amount > balance)
			return false;

		balance -= amount;
		countWithdrawls++;
		transactions.add(new Transaction(-amount, balance));
		return true;
	}

	// Beräknar ränta
	public double calcInterest() {
		return balance * interestRate / 100;
	}

	//stänger kontot
	public String closeAccount() {
		return accountNumber + " " + balance + " " + accountType + " " + interestRate + " " + calcInterest();
	}

	//strängrepresentation
	@Override
	public String toString() {
		return super.toString() + " " + interestRate;
	}
}