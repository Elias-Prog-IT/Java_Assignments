package elipos5;
import java.util.ArrayList;

/**
*
* Banklogic class 
* 
* @author Elias Posluk
* @LTU_ID elipos-5
* @date   10/02/2018
* @version 1.0
* 
*/
public class BankLogic {

    private ArrayList<Customer> Customers;
    private int bank_account_number;


    public BankLogic() 
    {
        this.bank_account_number = 1000;
        Customers = new ArrayList<Customer>();
    }

    /**
     * Returns an ArrayList <String> that contains a presentation of all of the
     * Bank s customers
     *
     * @return presentation of all of the Bank s customers
     */
    public ArrayList<String> getAllCustomers() 
    {
        ArrayList<String> presentation_customers = new ArrayList<String>();
        for (Customer customer : this.Customers) 
        {
            presentation_customers.add(customer.toString());
        }
        return presentation_customers;
    }

    /**
     * Creates a new customer based on the parameters submitted to the method
     *
     * @param name
     * @param surname
     * @param socialNo
     * @return true if customer was created otherwise returned false
     */
    public boolean createCustomer(String name, String surname, String socialNo) 
    {
        //socialNo must be unique, so if a customer already has that 
        if (!checkSocialNo(socialNo)) 
        {
            Customers.add(new Customer(name, surname, socialNo));
            return true;
        } 
        else  //socialNo already exist          
        {
            return false;
        }
    }

    /**
     * Returns an ArrayList <String> that contains the customer information
     * including its accounts.
     *
     * @param socialNo
     * @return the customer information (account balance account type of
     * interest rate), null if the customer is not found
     */
    public ArrayList<String> getCustomer(String socialNo) 
    {
        ArrayList<String> customer_information = new ArrayList<String>();
        if (checkSocialNo(socialNo)) 
        {
            Customer customer = customerFound(socialNo);
            customer_information.add(customer.toString());
            if (customer.getAccounts() != null)
            {

                customer.getAccounts().forEach((account) -> {
                    customer_information.add(account.toString());
                });

            }
            return customer_information;
        } 
        else //the customer is not found
        {
            return null;
        }

    }

    /**
     * Renaming the selected customer. The parameter socialNo indicates which
     * customer should be renamed.
     *
     * @param name
     * @param surname
     * @param socialNo
     * @return true if name changed otherwise returns false
     */
    public boolean changeCustomerName(String name, String surname, String socialNo) 
    {
        boolean change = false;
        if (checkSocialNo(socialNo)) 
        {
            Customer customer = customerFound(socialNo);
            customer.setFirst_name(name);
            customer.setLast_name(surname);
            change = true;

        } 
        else //the customer is not found
        {
            change = false;
        }
        return change;
    }

    /**
     * Removes the client from the bank, all client accounts are also removed
     * and the result is returned.
     *
     * @param socialNo
     * @return information about customer ( first name, last name, social
     * security number) ,null if no customer is deleted
     */
    public ArrayList<String> deleteCustomer(String socialNo) {
        ArrayList<String> customer_information = new ArrayList<String>();
        
        // newBalance;
        if (checkSocialNo(socialNo)) 
        {
            Customer customer = customerFound(socialNo);
            customer_information.add(customer.toString());
            if (customer.getAccounts() != null) 
            {

                customer.getAccounts().forEach((account) -> {
                    /*
                    Interest is calculated as Balance * Interest rate / 100 
                    (interest only required when removing accounts as
                    the bank in the version does not support annual change) 
                     */
                    double interest = account.getBalanceInclusiveRate();
                    customer_information.add(account.toString() + " " + interest);
                });
            }
            customer.setAccounts(null);
            Customers.remove(customer);

        } 
        else//the customer is not found
        {
            return null;
        }
        return customer_information;
    }

    /**
     * Creates an account for customer with social security number socialNo
     *
     * @param socialNo
     * @return the account number that the created account received,-1 returns
     * if no account was created
     */
    public int createSavingsAccount(String socialNo) 
    {
        boolean create = false;
        if (checkSocialNo(socialNo)) 
        {
            Customer customer = customerFound(socialNo);
            ArrayList<SavingsAccount> accountsCustomer = customer.getAccounts();
            /*
            Account number should be unique to the entire bank, 
            not just for an individual customer
             */
            this.bank_account_number++;
            SavingsAccount account = new SavingsAccount(0, 1, this.bank_account_number, " Savings Account ");
            accountsCustomer.add(account);
            customer.setAccounts(accountsCustomer);
            create = true;

        }
        if (create)
        {
            return bank_account_number;
        } 
        else 
        {
            return -1;
        }
    }

    /**
     * Returns a string containing presentation of the account with account
     * number accountId belonging to the customer socialNo
     *
     * @param socialNo
     * @param accountId
     * @return (account number balance, account type interest rate),null if
     * account is not available or if it does not belong to the customer
     */
    public String getAccount(String socialNo, int accountId) 
    {
        if (checkSocialNo(socialNo)) 
        {
            Customer customer = customerFound(socialNo);
            /*
            Returns a string containing presentation of the account with account number accountId belonging 
            to the customer socialNo (account number balance, account type interest rate).
             */
            String accountFound = null;
            if (customer.getAccounts() != null) 
            {
                for (SavingsAccount account : customer.getAccounts()) 
                {
                    if (account.getAccountNumber() == accountId) 
                    {
                        accountFound = account.toString();
                        break;
                    }

                }
            }

            return accountFound;
        } 
        else //the customer is not found
        {
            return null;
        }
    }

    /**
     * Make a deposit on account with account number accountId belonging to the
     * customer socialNo.
     *
     * @param socialNo
     * @param accountId
     * @param amount
     * @return true if it went well otherwise false
     */
    public boolean deposit(String socialNo, int accountId, double amount) 
    {
        boolean deposit = false;
        if (checkSocialNo(socialNo)) 
        {
            Customer customer = customerFound(socialNo);
            ArrayList<SavingsAccount> accounts = customer.getAccounts();
            for (SavingsAccount account : accounts) 
            {
                if (account.getAccountNumber() == accountId) 
                {
                    double balance = account.getBalance();
                    balance += amount;
                    account.setBalance(balance);
                    deposit = true;
                    break;
                }

            }
        } 
        else//the customer is not found 
        {
            return deposit;
        }
        return deposit;
    }

    /**
     * Make a withdrawal on account with account number accountId belonging to
     * the customer pNo
     *
     * @param socialNo
     * @param accountId
     * @param amount
     * @return true if it went well otherwise false
     */
    public boolean withdraw(String socialNo, int accountId, double amount) 
    {
        boolean withdraw = false;
        if (checkSocialNo(socialNo)) 
        {
            Customer customer = customerFound(socialNo);
            ArrayList<SavingsAccount> accounts = customer.getAccounts();
            for (SavingsAccount account : accounts) 
            {
                if (account.getAccountNumber() == accountId) 
                {
                    double balance = account.getBalance();

                    /*
                    The withdrawal is only made if the balance covers the withdrawal 
                    (the balance must not be less than 0)
                     */
                    if (balance >= amount)
                    {
                        balance -= amount;
                        account.setBalance(balance);
                        withdraw = true;
                    }

                    break;
                }

            }
        } 
        else //the customer is not found
        {
            return withdraw;
        }
        return withdraw;
    }

    private boolean checkSocialNo(String socialNo) 
    {
        boolean exist = false;
        for (Customer customer : this.Customers) 
        {
            if (customer.getSocial_security_number().equals(socialNo)) 
            {
                exist = true;
                break;
            }

        }
        return exist;
    }

    /**
     * Closes an account with account number accountId belonging to the customer
     * socialNo.When closing an account, the interest rate is calculated as the
     * balance * interest / 100.
     *
     * @param socialNr
     * @param accountId
     * @return Presentation of the account,null if no account was deleted
     */
    public String closeAccount(String socialNr, int accountId) 
    {
        String accountClosed = null;
        if (checkSocialNo(socialNr)) 
        {
            Customer customer = customerFound(socialNr);
            ArrayList<SavingsAccount> accounts = customer.getAccounts();
            for (SavingsAccount account : accounts) 
            {
                if (account.getAccountNumber() == accountId) 
                {
                    /*
                    When closing an account, the interest rate is calculated as the balance * interest / 100.
                    The only time that interest is applied is when the account is removed as the year shift is not handled in this version of the system.
                     */
                    double interest = account.getBalanceInclusiveRate();
                    //account.setBalance(newBalance);
                    accountClosed = account.toString() + " " + interest;
                    accounts.remove(account);
                    break;
                }

            }
        } 
        else //the customer is not found
        {
            return accountClosed;
        }
        
        return accountClosed;
    }

    private Customer customerFound(String socialNo) 
    {
        Customer customerFound = null;
        for (Customer customer : this.Customers) 
        {
            if (customer.getSocial_security_number().equals(socialNo)) 
            {
                customerFound = customer;
                break;
            }

        }
        return customerFound;
    }
}
