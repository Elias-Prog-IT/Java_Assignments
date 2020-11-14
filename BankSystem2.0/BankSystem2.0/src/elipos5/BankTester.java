package elipos5;

/**
 * BankTester.java testar s� att funktionaliteten med att skapa
 * bankkunder, s�tta in pengar, ta ut pengar, skapa konton, ta bort konton och kunder, mm. 
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

		// H�mtar alla kunder
		System.out.println(bankLogic.getAllCustomers());

		// Skapar konton
		System.out.println(bankLogic.createSavingsAccount("8905221898"));
		System.out.println(bankLogic.createSavingsAccount("8905221898"));
		System.out.println(bankLogic.createSavingsAccount("7505121231"));
		System.out.println(bankLogic.createCreditAccount("7505121231"));
		System.out.println(bankLogic.createCreditAccount("7505121231"));

		// H�mtar kund
		System.out.println(bankLogic.getCustomer("8905221898"));

		// H�mtar konto
		System.out.println(bankLogic.getAccount("7505121231", 1003));

		// L�gger in pengar och tar ut pengar
		System.out.println(bankLogic.deposit("8905221898", 1002, 700));
		System.out.println(bankLogic.withdraw("8905221898", 1002, 500));
		
		// tar ut pengar en andra g�ng
		System.out.println(bankLogic.withdraw("8905221898", 1002, 100));

		System.out.println(bankLogic.getTransactions("8905221898", 1002));

		// F�rs�k att ta ut mer pengar �n vad man har i kontot
		System.out.println(bankLogic.withdraw("8905221898", 1002, 500));

		//  F�rs�k att ta ut pengar fr�n en icke existerande konto
		System.out.println(bankLogic.withdraw("8905221898", 1003, 500));

		// st�nger kontot
		System.out.println(bankLogic.closeAccount("8905221898", 1002));

		// f�rs�k att st�nga ner ett konto som redan �r avslutat
		System.out.println(bankLogic.closeAccount("8905221898", 1002));

		// tar bort bankkund
		System.out.println(bankLogic.deleteCustomer("8905221898"));

		// h�mtar alla bankkunder
		System.out.println(bankLogic.getAllCustomers());

		// Tar ut fr�n kreditkontot 
		System.out.println(bankLogic.withdraw("7505121231", 1004, 4500));
		System.out.println(bankLogic.withdraw("7505121231", 1004, 500));
		
		// Tar ut st�rre belopp �n vad det finns i kontot
		System.out.println(bankLogic.withdraw("7505121231", 1004, 100));
		
		System.out.println(bankLogic.getTransactions("7505121231", 1004));
		
		// st�nger kreditkontot 
		System.out.println(bankLogic.closeAccount("7505121231", 1004));

	}
}