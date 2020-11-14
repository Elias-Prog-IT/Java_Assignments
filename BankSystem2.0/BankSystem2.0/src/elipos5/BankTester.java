package elipos5;

/**
 * BankTester.java testar så att funktionaliteten med att skapa
 * bankkunder, sätta in pengar, ta ut pengar, skapa konton, ta bort konton och kunder, mm. 
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
 * 
 */
public class BankTester {

	public static void main(String[] args) {
		BankLogic bankLogic = new BankLogic();

		//Skapar kunder
		System.out.println(bankLogic.createCustomer("Marcus", "Carlsson", "8905221898"));
		System.out.println(bankLogic.createCustomer("Patrick", "Gustavsson", "6911258876"));
		System.out.println(bankLogic.createCustomer("Sofia", "Larsson", "7505121231"));

		// skapar kund med identisk socialNo/personnummer som redan finns i "systemet"
		System.out.println(bankLogic.createCustomer("Pat", "Gus", "6911258876"));

		// Hämtar alla kunder
		System.out.println(bankLogic.getAllCustomers());

		// Skapar konton
		System.out.println(bankLogic.createSavingsAccount("8905221898"));
		System.out.println(bankLogic.createSavingsAccount("8905221898"));
		System.out.println(bankLogic.createSavingsAccount("7505121231"));
		System.out.println(bankLogic.createCreditAccount("7505121231"));
		System.out.println(bankLogic.createCreditAccount("7505121231"));

		// Hämtar kund
		System.out.println(bankLogic.getCustomer("8905221898"));

		// Hämtar konto
		System.out.println(bankLogic.getAccount("7505121231", 1003));

		// Lägger in pengar och tar ut pengar
		System.out.println(bankLogic.deposit("8905221898", 1002, 700));
		System.out.println(bankLogic.withdraw("8905221898", 1002, 500));
		
		// tar ut pengar en andra gång
		System.out.println(bankLogic.withdraw("8905221898", 1002, 100));

		System.out.println(bankLogic.getTransactions("8905221898", 1002));

		// Försök att ta ut mer pengar än vad man har i kontot
		System.out.println(bankLogic.withdraw("8905221898", 1002, 500));

		//  Försök att ta ut pengar från en icke existerande konto
		System.out.println(bankLogic.withdraw("8905221898", 1003, 500));

		// stänger kontot
		System.out.println(bankLogic.closeAccount("8905221898", 1002));

		// försök att stänga ner ett konto som redan är avslutat
		System.out.println(bankLogic.closeAccount("8905221898", 1002));

		// tar bort bankkund
		System.out.println(bankLogic.deleteCustomer("8905221898"));

		// hämtar alla bankkunder
		System.out.println(bankLogic.getAllCustomers());

		// Tar ut från kreditkontot 
		System.out.println(bankLogic.withdraw("7505121231", 1004, 4500));
		System.out.println(bankLogic.withdraw("7505121231", 1004, 500));
		
		// Tar ut större belopp än vad det finns i kontot
		System.out.println(bankLogic.withdraw("7505121231", 1004, 100));
		
		System.out.println(bankLogic.getTransactions("7505121231", 1004));
		
		// stänger kreditkontot 
		System.out.println(bankLogic.closeAccount("7505121231", 1004));

	}
}