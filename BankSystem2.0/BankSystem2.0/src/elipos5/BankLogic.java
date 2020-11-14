package elipos5;
import java.util.ArrayList;
import java.util.List;
/**
 * BankLogic.java Innehåller logiken för banken 
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
 * 
 */

//Innehåller logiken för banken
public class BankLogic {

	//list(a) av kunder
	private List<Customer> customers;

	//konstruktor
	public BankLogic() 
	{
		customers = new ArrayList<>();
	}

	//Returnerar en ArrayList som innehåller en presentation på alla av bankens kunder
	public ArrayList<String> getAllCustomers() {
		ArrayList<String> list = new ArrayList<>();
		for (Customer customer : customers) {
			list.add(customer.toString());
		}

		return list;
	}

	//Skapar en ny bankkund baserad på parametrarna som man har överlämnats till metoden. 
	//socialNo är unik och avger om det redan finns en kund med den socialNo, om så är fallet 
	//Så skapas inte en ny kund.
	public boolean createCustomer(String name, String surname, String socialNo) {
		if (find(socialNo) != null)
			return false;

		customers.add(new Customer(name, surname, socialNo));
		return true;
	}

	//Returnerar en ArrayList <String> som innehåller kundens information
	//inkluderat kundens konton. Returnerar null om kunden inte hittas/finns
	public ArrayList<String> getCustomer(String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return null;

		ArrayList<String> details = customer.getBankAccounts();
		details.add(0, customer.toString());

		return details;

	}

	//Döper om kunden som man har valt ut, med hjälp av socialNo/personnummer 
	public boolean changeCustomerName(String name, String surname, String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return false;

		customer.setFirstName(name);
		customer.setLastName(surname);
		return true;
	}


	//Tar bort kunden från banken, med alla av klientens-konton tas också bort
	public ArrayList<String> deleteCustomer(String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return null;

		ArrayList<String> details = customer.closeBankAccounts();
		details.add(0, customer.toString());

		customers.remove(customer);

		return details;
	}

	//Skapar sparkonto för kunden med socialNo/personnummer
	public int createSavingsAccount(String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return -1;

		SavingsAccount savingsAccount = new SavingsAccount();
		customer.addAccount(savingsAccount);
		return savingsAccount.getAccountNumber();
	}

	//Skapar kreditkonto för kunden med socialNo/personnummer
	public int createCreditAccount(String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return -1;

		CreditAccount creditAccount = new CreditAccount();
		customer.addAccount(creditAccount);
		return creditAccount.getAccountNumber();
	}

	
	//Returnerar en sträng som innehåller presentation av kontot med kontonummer
	//"accountId" som tillhör kundens socialNo 
	public String getAccount(String socialNo, int accountId) {
		Account account = find(socialNo, accountId);
		if (account == null)
			return null;
		else
			return account.toString();
	}


	//Gör en insättning på kontot med kontonummer accountId tillhörande till kunden med socialNo
	public boolean deposit(String socialNo, int accountId, double amount) {
		Account account = find(socialNo, accountId);
		if (account == null || amount <= 0)
			return false;

		account.deposit(amount);
		return true;
	}

	//tar ut pengar med kundens socialNo och accountId
	public boolean withdraw(String socialNo, int accountId, double amount) {
		Account account = find(socialNo, accountId);
		if (account == null || amount <= 0)
			return false;

		return account.withdraw(amount);
	}

	//Stänger kundens konto med hjälp av socialNo och accountId
	public String closeAccount(String socialNo, int accountId) {
		Account account = find(socialNo, accountId);
		if (account == null)
			return null;

		return find(socialNo).closeAccount(accountId);
	}
	
	//Får fram transaktionerna för ett specifik konto 
	public ArrayList<String> getTransactions (String socialNo, int accountId) {
		Account account = find(socialNo, accountId);
		if (account == null)
			return null;

		return account.getTransactions();
	}

	//Hjälp metod som letar reda på kunden med socialNo
	private Customer find(String socialNo) {
		for (Customer customer : customers) {
			if (customer.getSsn().equals(socialNo))
				return customer;
		}

		return null;
	}


	//Hjälp metod som letar fram kontot med accountId tillhörande kunden med ett specifik socialNo
	private Account find(String socialNo, int accountId) {
		Customer customer = find(socialNo);
		if (customer == null)
			return null;

		return customer.getAccount(accountId);
	}
}