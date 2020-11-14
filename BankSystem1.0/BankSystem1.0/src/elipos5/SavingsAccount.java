package elipos5;

/**
*
* SavingsAccount class 
* 
* @author Elias Posluk
* @LTU_ID elipos-5
* @date   10/02/2018
* @version 1.0
* 
*/
public class SavingsAccount 
{

    private int account_number = 1001;
    private double balance;
    private double interest_rate;
    private String account_type;

    public SavingsAccount() 
    {

    }

    /**
     * Constructor
     *
     * @param balance the balance
     * @param rate the interest rate
     * @param accountNmb the account number
     * @param account_type the account type
     */
    public SavingsAccount(double balance, double rate, int accountNmb, String account_type) 
    {
        this.account_number = accountNmb;
        this.balance = balance;
        this.interest_rate = rate;
        this.account_type = account_type;
    }

    /**
     *
     * @param balance the balance to set
     */
    public void setBalance(double balance) 
    {
        this.balance = balance;
    }

    /**
     * @param rate the interest rate to set
     */
    public void setRate(double rate) 
    {
        this.interest_rate = rate;
    }

    /**
     * @param type the account type to set
     */
    public void setType(String type) 
    {
        this.account_type = type;
    }

    /**
     * @return the account number
     */
    public int getAccountNumber() 
    {
        return account_number;
    }

    /**
     * @return the account Type
     */
    public String getAccountType() 
    {
        return account_type;
    }

    /**
     * @return the interest rate
     */
    public double getRate() 
    {
        return interest_rate;
    }

    /**
     * @return the Balance
     */
    public double getBalance() 
    {
        return balance;
    }

    /**
     *
     * @param amount
     */
    public void deposit(double amount) 
    {
        balance += amount;
    }

    /**
     *
     * @param amount
     * @return
     */
    public boolean withdraw(double amount) 
    {
        if (balance > amount) 
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * calculate interest rate (balance * interest rate / 100)
     *
     * @return interest rate
     */
    public double getBalanceInclusiveRate() 
    {
        return balance * (interest_rate / 100);
    }

    /**
     * Retrieve presentation information about the account
     *
     * @return account number balance account type interest rate
     */
    @Override
    public String toString() 
    {
        return " " + getAccountNumber() + " " + getBalance() + "kr " + getAccountType() + " " + getRate();
    }
}