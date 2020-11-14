package elipos5;
import java.util.ArrayList;

/**
 *
 * Customer class 
 * 
 * @author Elias Posluk
 * @LTU_ID elipos-5
 * @date   10/02/2018
 * @version 1.0
 * 
 */

public class Customer 
{

    private String first_name;
    private String last_name;
    private String social_security_number;

    private ArrayList<SavingsAccount> accounts;

    public Customer() 
    {

    }

    /**
     *
     * @param fname the first name
     * @param lname the last name
     * @param ssn the social security number
     */
    public Customer(String fname, String lname, String ssn) 
    {
        this.first_name = fname;
        this.last_name = lname;
        this.social_security_number = ssn;
        accounts=new ArrayList<>();
    }

    /**
     * @return the first name
     */
    public String getFirst_name() 
    {
        return first_name;
    }

    /**
     * @param first_name the first name to set
     */
    public void setFirst_name(String first_name) 
    {
        this.first_name = first_name;
    }

    /**
     * @return the last name
     */
    public String getLast_name() 
    {
        return last_name;
    }

    /**
     * @param last_name the last name to set
     */
    public void setLast_name(String last_name) 
    {
        this.last_name = last_name;
    }

    /**
     * @return the social security number
     */
    public String getSocial_security_number() 
    {
        return social_security_number;
    }

    /**
     * @param social_security_number the social security number to set
     */
    public void setSocial_security_number(String social_security_number) 
    {
        this.social_security_number = social_security_number;
    }

    /**
     * @return The list of accounts
     */
    public ArrayList<SavingsAccount> getAccounts() 
    {
        return accounts;
    }

    /**
     * @param accounts The list of accounts to set
     */
    public void setAccounts(ArrayList<SavingsAccount> accounts) 
    {
        this.accounts = accounts;
    }

    /**
     * Retrieve customer account information
     *
     * @param account_number the account number to get
     * @return (account number balance account type interest rate)
     */
    public String getAccount(int account_number) 
    {
        String acc = "";
        if (this.accounts != null && this.accounts.size() > 0) 
        {
            for (SavingsAccount account : this.accounts) 
            {

                if (account.getAccountNumber() == account_number) 
                {
                    acc = account.toString();
                } 
                else 
                {
                    acc = "This account does not exist. ";

                }

            }
        } 
        else 
        {
            acc = " The list is empty. ";
        }
        return acc;
    }

    /**
     * Retrieve customer information
     *
     * @return first name last name social security number
     */
    @Override
    public String toString() 
    {
        return " " + this.first_name + " " + this.last_name + " " + this.social_security_number;
    }
}