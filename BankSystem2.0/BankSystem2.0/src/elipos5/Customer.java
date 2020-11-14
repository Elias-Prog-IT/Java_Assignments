package elipos5;
import java.util.ArrayList;
import java.util.List;
/**
 * Customer.java Representerar bankkunden
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
 */

// representerar kunden
public class Customer {

	// information om kunden
	private String firstName;
	private String lastName;
	private String ssn;
	private List<Account> accounts;

	// skapar kunden
	public Customer(String firstName, String lastName, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		accounts = new ArrayList<>();
	}

	// lägger till konto
	public void addAccount(Account account) {
		accounts.add(account);
	}

	// Setters och getters

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getSsn() {
		return ssn;
	}

	//hämtar bankkonton som stränglista 
	public ArrayList<String> getBankAccounts() {
		ArrayList<String> list = new ArrayList<>();
		for (Account account : accounts) {
			list.add(account.toString());
		}
		return list;
	}

	// stänger alla bankkonton
	public ArrayList<String> closeBankAccounts() {
		ArrayList<String> list = new ArrayList<>();
		for (Account account : accounts) {
			list.add(account.closeAccount());
		}
		return list;
	}

	// hämtar en specifikkonto
	public Account getAccount(int accountId) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountId)
				return account;
		}

		return null;
	}

	// stänger konto
	public String closeAccount(int accountId) {
		Account account = getAccount(accountId);
		accounts.remove(account);
		return account.closeAccount();
	}

	// kund-strängrepresentation
	@Override
	public String toString() {
		return getFullName() + " " + getSsn();
	}
}