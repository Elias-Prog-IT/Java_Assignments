package elipos5;
import java.util.ArrayList;
import java.util.List;
/**
 * BankLogic.java Inneh�ller logiken f�r banken 
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
 * 
 */

//Inneh�ller logiken f�r banken
public class BankLogic {

	//list(a) av kunder
	private List<Customer> customers;

	//konstruktor
	public BankLogic() 
	{
		customers = new ArrayList<>();
	}

	//Returnerar en ArrayList som inneh�ller en presentation p� alla av bankens kunder
	public ArrayList<String> getAllCustomers() {
		ArrayList<String> list = new ArrayList<>();
		for (Customer customer : customers) {
			list.add(customer.toString());
		}

		return list;
	}

	//Skapar en ny bankkund baserad p� parametrarna som man har �verl�mnats till metoden. 
	//socialNo �r unik och avger om det redan finns en kund med den socialNo, om s� �r fallet 
	//S� skapas inte en ny kund.
	public boolean createCustomer(String name, String surname, String socialNo) {
		if (find(socialNo) != null)
			return false;

		customers.add(new Customer(name, surname, socialNo));
		return true;
	}

	//Returnerar en ArrayList <String> som inneh�ller kundens information
	//inkluderat kundens konton. Returnerar null om kunden inte hittas/finns
	public ArrayList<String> getCustomer(String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return null;

		ArrayList<String> details = customer.getBankAccounts();
		details.add(0, customer.toString());

		return details;

	}

	//D�per om kunden som man har valt ut, med hj�lp av socialNo/personnummer 
	public boolean changeCustomerName(String name, String surname, String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return false;

		customer.setFirstName(name);
		customer.setLastName(surname);
		return true;
	}


	//Tar bort kunden fr�n banken, med alla av klientens-konton tas ocks� bort
	public ArrayList<String> deleteCustomer(String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return null;

		ArrayList<String> details = customer.closeBankAccounts();
		details.add(0, customer.toString());

		customers.remove(customer);

		return details;
	}

	//Skapar sparkonto f�r kunden med socialNo/personnummer
	public int createSavingsAccount(String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return -1;

		SavingsAccount savingsAccount = new SavingsAccount();
		customer.addAccount(savingsAccount);
		return savingsAccount.getAccountNumber();
	}

	//Skapar kreditkonto f�r kunden med socialNo/personnummer
	public int createCreditAccount(String socialNo) {
		Customer customer = find(socialNo);
		if (customer == null)
			return -1;

		CreditAccount creditAccount = new CreditAccount();
		customer.addAccount(creditAccount);
		return creditAccount.getAccountNumber();
	}

	
	//Returnerar en str�ng som inneh�ller presentation av kontot med kontonummer
	//"accountId" som tillh�r kundens socialNo 
	public String getAccount(String socialNo, int accountId) {
		Account account = find(socialNo, accountId);
		if (account == null)
			return null;
		else
			return account.toString();
	}


	//G�r en ins�ttning p� kontot med kontonummer accountId tillh�rande till kunden med socialNo
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

	//St�nger kundens konto med hj�lp av socialNo och accountId
	public String closeAccount(String socialNo, int accountId) {
		Account account = find(socialNo, accountId);
		if (account == null)
			return null;

		return find(socialNo).closeAccount(accountId);
	}
	
	//F�r fram transaktionerna f�r ett specifik konto 
	public ArrayList<String> getTransactions (String socialNo, int accountId) {
		Account account = find(socialNo, accountId);
		if (account == null)
			return null;

		return account.getTransactions();
	}

	//Hj�lp metod som letar reda p� kunden med socialNo
	private Customer find(String socialNo) {
		for (Customer customer : customers) {
			if (customer.getSsn().equals(socialNo))
				return customer;
		}

		return null;
	}


	//Hj�lp metod som letar fram kontot med accountId tillh�rande kunden med ett specifik socialNo
	private Account find(String socialNo, int accountId) {
		Customer customer = find(socialNo);
		if (customer == null)
			return null;

		return customer.getAccount(accountId);
	}
}