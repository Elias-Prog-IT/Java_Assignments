package elipos5;
/**
*
* Main Class
* 
* @author Elias Posluk
 * @author Elias Posluk, 
 * @studentId elipos-5
 * @date 2019-04-29
* 
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    int val = 0;
    int user = 0;
    Scanner user_input = new Scanner(System.in);
    BankLogic bn = new BankLogic();

    public void Pause() 
    {
        try 
        {
            System.out.println("press any key to continue ...");
            System.in.read();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
 * method display all customers
 *
 */
    public void dispCustms(boolean pause) 
    {
        System.out.println("=====================================================");
        System.out.println("|             list of the bank's customers          |");
        System.out.println("=====================================================");
        System.out.println("|                       Customers:                   ");
        System.out.println("                        ----------                   ");
        for (String custm : bn.getAllCustomers()) 
        {
            System.out.println("|-." + custm + "                               ");

        }

        System.out.println("=====================================================");
        
        if (pause) 
        {
        	System.out.println("press any key to continue ..."
                + "");
            try 
            {
                System.in.read();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Method to make sure no data is available in the
    //input stream
    public static void inputFlush() 
    {
        int dummy;
        int bAvail;

        try {
            while ((System.in.available()) != 0) 
            {
                dummy = System.in.read();
            }
        }
        catch (java.io.IOException e) 
        {
            System.out.println("Input error");
        }
    }

    /*
     * data input methods for
     * string, int, char, and double
     * 
     * */

    public static String inString(String prompt) 
    {
        inputFlush();
        printPrompt(prompt);
        return inString();
    }

    public static String inString() 
    {
        int aChar;
        String s = "";
        boolean finished = false;

        while (!finished) 
        {
            try 
            {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n') 
                {
                    finished = true;
                } 
                else if ((char) aChar != '\r') 
                {
                    s = s + (char) aChar; // Enter into string
                }
            } 
            catch (java.io.IOException e) 
            {
                System.out.println("Input error");
                finished = true;
            }
        }
        return s;
    }

    public static int inInt(String prompt) 
    {
        while (true)
        {
            inputFlush();
            printPrompt(prompt);
            try 
            {
                return Integer.valueOf(inString().trim()).intValue();
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Not an integer");
            }
        }
    }

    public static char inChar(String prompt) 
    {
        int aChar = 0;

        inputFlush();
        printPrompt(prompt);

        try 
        {
            aChar = System.in.read();
        } 
        catch (java.io.IOException e) 
        {
            System.out.println("Input error");
        }
        inputFlush();
        return (char) aChar;
    }

    public static double inDouble(String prompt) 
    {
        while (true) 
        {
            inputFlush();
            printPrompt(prompt);
            try 
            {
                return Double.valueOf(inString().trim()).doubleValue();
            } 
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Not a floating point number");
            }
        }
    }

    public static void printPrompt(String prompt) 
    {
        System.out.print(prompt + " ");
        System.out.flush();
    }
    
    /*
     * five customers that already "have" an account in the bank
     * Prints out menu for the user as well
     * */
    public void printMenu() 
    {
        bn.createCustomer("Lotta", "Larsson", "7505121231");
        bn.createCustomer("Kalle ", "Karlsson ", "8505221898");
        bn.createCustomer("Pelle ", "Persson ", "6911258876");
        bn.createCustomer("Sofia", "Larsson", "44435123");
        bn.createCustomer("Gustavsson", "Sofia", "114214551");

        while (val != 10) 
        {
            dispCustms(false);
           
            System.out.println("==================================================");
            System.out.println("|                      Menu                      |");
            System.out.println("==================================================");
            System.out.println("|----------------------------                    |");
            System.out.println("|1. Retrieve a list of the bank's customers      |");
            System.out.println("|2. Add a new customer with a unique social      |");
            System.out.println("|security number                                 |");
            System.out.println("|3. Change a customer's name(personal            |");
            System.out.println("|identification number cannot be changed)        |");
            System.out.println("|----------------------------                    |");
            System.out.println("|4. Delete an existing customer,                 |");
            System.out.println("|any existing accounts are terminated            |");
            System.out.println("|5. Create a savings account for an existing     |");
            System.out.println("| customer, a unique account number is generated |");
            System.out.println("|----------------------------                    |");
            System.out.println("|6. See information about the selected           |");
            System.out.println("| customer including all accounts                |");
            System.out.println("|----------------------------                    |");
            System.out.println("|7. Deposit money in to an account               |");
            System.out.println("|8. Withdraw money from the account (but only if |");
            System.out.println("|the balance covers the withdrawal amount)       |");
            System.out.println("|9. Close Account                                |");
            System.out.println("|10. Exit                                        |");
            System.out.println("==================================================");
            System.out.print("Select option: ");

         
            try 
            {
                val = user_input.nextInt();
                if (val > 10) 
                {
                    System.out.println("Option does not exist");
                }
            } 
            catch (java.util.InputMismatchException e)
            {
                System.out.println("Wrong input");
            }
            
            menuAction(val, bn);
        }
    }

    public void menuAction(int val, BankLogic bn) 
    {

        switch (val) 
        {
            case 1://displays all the customers
                dispCustms(true);
                break;

            case 2://adds a new customer to the bank
                System.out.print("First Name: ");
                String fName = user_input.next();
                System.out.print("Last Name: ");
                String lName = user_input.next();
                System.out.print("Social security number: ");
                String ssn = user_input.next();

                if (bn.createCustomer(fName, lName, ssn)) 
                {
                    System.out.println("successful operation");
                    Pause();
                } 
                else 
                {
                    System.out.println("operation failed");
                    Pause();
                }

                break;

            case 3://changes a customers name
                System.out.print("Social security number: ");
                String ssn3 = user_input.next();
                if (bn.getCustomer(ssn3) != null) 
                {
                    System.out.print("New First Name: ");
                    String fName3 = user_input.next();
                    System.out.print("New Last Name: ");
                    String lName3 = user_input.next();
                    if (bn.changeCustomerName(fName3, lName3, ssn3)) 
                    {
                        System.out.println("change successful");
                        Pause();
                    }
                    else
                    {
                        System.out.println("change failed");
                        Pause();
                    }
                }
                else
                {
                    System.out.println("This social security number does not exist, return NULL");
                    Pause();
                }

                break;

            case 4://delete a customer
                System.out.print("Social security number: ");
                String ssn4 = user_input.next();
                if (bn.getCustomer(ssn4) != null) 
                {
                    ArrayList<String> temp = new ArrayList<String>();
                    temp = bn.deleteCustomer(ssn4);
                    if (temp != null) 
                    {

                        System.out.println("============================================");
                        System.out.println("|               Deleted Data               |");
                        System.out.println("============================================");
                        for (String d : temp) 
                        {
                            System.out.println("-." + d);

                        }
                        System.out.println("============================================");
                        System.out.println("successful operation");
                        Pause();
                    } 
                    else 
                    {
                        System.out.println("operation failed");
                        Pause();
                    }
                } 
                else
                {
                    System.out.println("This social security number does not exist, return NULL");
                    Pause();
                }

                break;

            case 5://Create a savings account for an existing customer
                System.out.print("Social security number: ");
                String ssn5 = user_input.next();
                if (bn.getCustomer(ssn5) != null) {
                    int nb = bn.createSavingsAccount(ssn5);
                    if (nb > 0) 
                    {
                        System.out.println("============================================");
                        System.out.println("|              Num Account                 |");
                        System.out.println("============================================");
                        System.out.println("-." + nb);
                        System.out.println("============================================");
                        System.out.println("successful operation");
                        Pause();
                    } 
                    else
                    {
                        System.out.println("operation failed");
                        Pause();
                    }

                }
                else 
                {
                    System.out.println("This social security number does not exist, return NULL");
                    Pause();
                }
                break;

            case 6://See information about the selected customer
                System.out.print("Social security number: ");
                String ssn6 = user_input.next();
                if (bn.getCustomer(ssn6) != null) {
                    System.out.println("============================================");
                    System.out.println(bn.getCustomer(ssn6).get(0));
                    System.out.println("=================Accounts===================");
                    int i = 0;
                    for (String inf : bn.getCustomer(ssn6)) 
                    {
                        if (i > 0)
                        {
                            System.out.println(inf);

                        }
                        i++;
                    }
                    if (i <= 1) 
                    {
                        System.out.println("         No accounts exist               ");
                    }
                    System.out.println("============================================");
                    Pause();
                } 
                else 
                {
                    System.out.println("This social security number does not exist, return NULL");
                    Pause();
                }
                break;

            case 7://Deposit money in to an account
                System.out.print("Social security number: ");
                String ssn7 = user_input.next();
                if (bn.getCustomer(ssn7) != null) 
                {
                    int IdAcc = inInt("Account number: ");
                    double amount = inDouble("Amount:");
                    if (bn.deposit(ssn7, IdAcc, amount)) 
                    {
                        System.out.println("successful operation");
                        Pause();
                    } 
                    else 
                    {
                        System.out.println("operation failed");
                        Pause();
                    }
                } 
                else 
                {
                    System.out.println("This social security number does not exist, return NULL");
                    Pause();
                }
                break;

            case 8://Withdraw money from the account
                System.out.print("Social security number: ");
                String ssn8 = user_input.next();
                if (bn.getCustomer(ssn8) != null) 
                {
                    int IdAcc = inInt("Account number: ");
                    double amount = inDouble("Amount:");
                    if (bn.withdraw(ssn8, IdAcc, amount)) 
                    {
                        System.out.println("successful operation");
                        Pause();
                    }
                    else 
                    {
                        System.out.println("operation failed");
                        Pause();
                    }
                } 
                else 
                {
                    System.out.println("This social security number does not exist, return NULL");
                    Pause();
                }
                break;
            case 9://Closes Account
                System.out.print("Social security number: ");
                String ssn9 = user_input.next();
                if (bn.getCustomer(ssn9) != null) {
                    int IdAcc = inInt("Account number: ");
                    String res = bn.closeAccount(ssn9, IdAcc);
                    if (res != null) 
                    {
                        System.out.println("============================================");
                        System.out.println("|               Deleted Data               |");
                        System.out.println("============================================");

                        System.out.println("-." + res);

                        System.out.println("============================================");

                        System.out.println("successful operation");
                        Pause();
                    } 
                    else 
                    {
                        System.out.println("operation failed");
                        Pause();
                    }
                }
                else
                {
                    System.out.println("This social security number does not exist ,return NULL");
                    Pause();
                }

                break;   
        }
    }

    public static void main(String[] args) 
    {
        Main p = new Main();
        p.printMenu();
    }
}