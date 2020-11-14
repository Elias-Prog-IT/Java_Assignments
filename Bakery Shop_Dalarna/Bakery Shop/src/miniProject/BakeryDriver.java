/**
 * 
 * @author Elias Posluk 
 * Student-id:(h16elipo)
 * @date 20/05/2019
 * MiniProject
 * BakeryDriver.Java
 * Course: IK1052 - Introduction to object-oriented programming in java
 * Dalarna University
 * 
 */

package miniProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


// Driver class for Bakery Items management
public class BakeryDriver {

	// to format and parse dates
	private final static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");
	
	// the backup file to load and save
	private final static String BACKUP_FILE = "bakery.txt";

	
	// to read from user
	private static Scanner scanner = new Scanner(System.in);
	
	//list of items
	private static ArrayList<BakeryItem> items = new ArrayList<>();

	public static void main(String[] args) {
		
		boolean exit = false;
		
		while(!exit) {
			// show menu and read choice
			String choice = readMenuChoice();
			
			System.out.println();
			
			switch (choice) {
			case "1": // create item
				createBakeryItem();
				break;
				
			case "2": // show item
				showItem();
				break;
				
			case "3": // update item
				updateItem();
				break;
				
			case "4": // delete item
				deleteItem();
				break;
				
			case "5": // show item stats
				showItemStats();
				break;
				
			case "6": // check an item age
				checkItemAge();
				break;
				
			case "7": //save all items to file
				saveFile();
				break;
				
			case "8": // load items from file
				loadFromFile();
				break;
				
			case "9": // exit
				exit = true;
				System.out.println("Good bye!");
				break;

			default:
				System.out.println("Error: Invalid choice!");
				break;
			}

			System.out.println();
		}
	}

	
	// read a menu choice from user 
	private static String readMenuChoice() {
		// show menu
		System.out.println("1. Create new bakery item");
		System.out.println("2. Show an item");
		System.out.println("3. Update an item");
		System.out.println("4. Delete an item");
		System.out.println("5. Show total items");
		System.out.println("6. Check how old an item is");
		System.out.println("7. Save to file");
		System.out.println("8. Load from file");
		System.out.println("9. Exit");
		System.out.print("Please enter your choice: ");
		return scanner.nextLine();
	}

	
	// create a new bakery item
	public static void createBakeryItem() {
		try {
			
			// read all details
			
			System.out.print("Enter name of the item: ");
			String name = scanner.nextLine();

			System.out.print("Enter description of the item: ");
			String desc = scanner.nextLine();

			System.out.print("Is the packaging of the item broken? [y/N]: ");
			boolean broken = scanner.nextLine().equalsIgnoreCase("y");

			System.out.print("Enter the value of the item: ");
			double value = Double.parseDouble(scanner.nextLine());

			System.out.print("Enter the produced date of item (mm/dd/yyyy): ");
			Date produced = DATE_FORMATTER.parse(scanner.nextLine());

			// create item and add
			BakeryItem item = new BakeryItem(name, desc, broken, value, produced);
			items.add(item);

			System.out.println("Item added to list.");

		} catch (Exception e) {
			System.out.println("Error: Invalid input.");
		}
	}

	public static BakeryItem selectItem() {
		if (items.isEmpty()) {
			System.out.println("Error: No items to select");
			return null;
		}

		for (int i = 0; i < items.size(); i++) {
			System.out.printf("%d. %s - %s\n", i + 1, items.get(i).getName(), items.get(i).getDescription());
		}

		System.out.print("Please select the item: ");
		int index = Integer.parseInt(scanner.nextLine()) - 1;

		if (index < 0 || index >= items.size()) {
			System.out.println("Error: Invalid choice.");
			return null;
		}

		else
			return items.get(index);

	}

	// show an items
	public static void showItem() {
		BakeryItem item = selectItem();
		if (item != null) { // if valid item selected
			// print all details
			System.out.println();
			System.out.println("Name: " + item.getName());
			System.out.println("Description: " + item.getDescription());
			System.out.println("Broken Packaging: " + item.brokenPackaging());
			System.out.printf("Value: $%.2f\n" , item.getValue());
			System.out.println("Produced date: " + DATE_FORMATTER.format(item.getProduced()));
		}
	}

	
	//update item
	public static void updateItem() {
		try {

			BakeryItem item = selectItem();
			if (item != null) {
				System.out.println();

				// update description if needed
				System.out.println("Description: " + item.getDescription());
				System.out.print("Do you want to change description? [y/N]: ");
				if (scanner.nextLine().equalsIgnoreCase("y")) {
					System.out.print("Enter new description: ");
					item.setDescription(scanner.nextLine());
				}

				// update Packaging if needed
				System.out.println("Broken Packaging: " + item.brokenPackaging());
				System.out.print("Do you want to change packaging detail? [y/N]: ");
				if (scanner.nextLine().equalsIgnoreCase("y")) {
					System.out.print("Is he packaging broken? [y/N]: ");
					item.setBrokenPackaging(scanner.nextLine().equalsIgnoreCase("y"));
				}

				// update Value if needed
				System.out.printf("Value: $%.2f\n", item.getValue());
				System.out.print("Do you want to change value? [y/N]: ");
				if (scanner.nextLine().equalsIgnoreCase("y")) {
					System.out.print("Enter the new value: ");
					item.setValue(Double.parseDouble(scanner.nextLine()));
				}

				
				// update Produced if needed
				System.out.println("Produced date: " + DATE_FORMATTER.format(item.getProduced()));
				System.out.print("Do you want to change produced date? [y/N]: ");
				if (scanner.nextLine().equalsIgnoreCase("y")) {
					System.out.print("Enter the new produced date: ");
					item.setProduced(DATE_FORMATTER.parse(scanner.nextLine()));
				}

			}

		} catch (Exception e) {
			System.out.println("Error: Invalid input.");
		}
	}

	
	// delete an item from list
	public static void deleteItem() {
		BakeryItem item = selectItem();
		if (item != null) {
			items.remove(item);
			System.out.println("Item removed");
		}
	}

	
	// show item stats
	public static void showItemStats() {
		if (items.isEmpty()) {
			System.out.println("No items in list");
			return;
		}

		// count total items
		int total = items.size();
		
		// Count items with unbroken packaging
		int unbroken = 0;
		for (BakeryItem bakeryItem : items) {
			if (!bakeryItem.isBrokenPackaging())
				unbroken++;
		}

		// print all items
		System.out.printf("Total baked items: %d\n", total);
		System.out.printf("Items with unbroken packaging: %.1f%%\n", unbroken * 100.0 / total);
	}

	
	// check an item's age
	public static void checkItemAge() {
		BakeryItem item = selectItem();
		if (item != null) {
			// get todays's date
			Date today = new Date();
			
			// get difference in milliseconds
			long diffInMillies = Math.abs(today.getTime() - item.getProduced().getTime());
			
			// get age in days
			long age = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			
			// print age
			System.out.printf("Items is %d days old.\n", age);
		}
	}

	
	// load items from file
	public static void loadFromFile() {
		try {
			// open file
			Scanner scanner = new Scanner(new File(BACKUP_FILE));
			while(scanner.hasNextLine()) {
				
				// parse and add to items
				items.add(new BakeryItem(scanner.nextLine(), scanner.nextLine(), 
						Boolean.parseBoolean(scanner.nextLine()),
						Double.parseDouble(scanner.nextLine()), 
						DATE_FORMATTER.parse(scanner.nextLine())));
			}
			
			scanner.close();
			
			System.out.println("Items loaded from file.");
			
		} catch (FileNotFoundException e) { // file not found
			System.out.println("Error: No data file found");
		}  catch (Exception e) { // other input errors
			System.out.println("Error: Invalid data in file");
		}
	}	
	
	// save items to file
	public static void saveFile() {
		try {
			// open writer to file
			PrintWriter pw = new PrintWriter(new File(BACKUP_FILE));
			
			// for each item
			for (BakeryItem item : items) { 
				// print details to file
				pw.println(item.getName());
				pw.println(item.getDescription());
				pw.println(item.isBrokenPackaging());
				pw.println(item.getValue());
				pw.println(DATE_FORMATTER.format(item.getProduced()));
			}
			
			// close to flush data to file
			pw.close();
			
			System.out.println("Items saved to file.");
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: No data file found");
		}  
	}
}