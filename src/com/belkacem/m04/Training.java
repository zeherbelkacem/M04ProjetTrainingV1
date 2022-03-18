package com.belkacem.m04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 
 * @author Stagiaires11P
 *
 */

public class Training {

	/** Training data structure **/
	private static Map<Integer, List<String>> trainings = new HashMap<Integer, List<String>>();
	/** Bucket data structure **/
	private static Map<Integer, List<String>> bucket = new HashMap<Integer, List<String>>();
	/** I/O Streams */
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		insertDataInTrainingMap();
		/** Welcome store app message */
		System.out.print(ConsoleColors.BLACK_BOLD);
		System.out.println("                     Hello and welcome to my FullTrainings app");
		System.out.println("          We will offer you a list of training courses currently available");
		System.out.print(ConsoleColors.RESET);
		displayAllTrainingList();
		storeMenu();
		scanner.close();
	}

	/**
	 * 
	 */
	private static void bucketSummary() {

		System.out.print(ConsoleColors.RED_BOLD);
		for (int i = 0; i < 112; i++)
			System.out.print("-");
		System.out.println();
		System.out.print(
				"    ---------------------------------------  Your bucket summary  -----------------------------------------");
		System.out.println();
		for (int i = 0; i < 112; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);
		System.out.print(ConsoleColors.GREEN_BOLD);
		System.out.print(String.format("|%-18s|", "COURSE"));
		System.out.print(String.format("%-10s|", "DAYS/NB"));
		System.out.print(String.format("%-41s|", "DESCRIPTION"));
		System.out.print(String.format("%-10s|", "QUANTITY)"));
		System.out.print(String.format("%-12s|", "UNIT PRICE"));
		System.out.print(String.format("%-15s|", "TOTAL PRICE"));
		System.out.println();
		for (int i = 0; i < 112; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);
		Double productTotalPrice = 0.0;
		Double TotalPrice = 0.0;
		for (Map.Entry<Integer, List<String>> entry : bucket.entrySet()) {
			productTotalPrice = Double.parseDouble(entry.getValue().get(3))
					* Double.parseDouble(entry.getValue().get(4));
			System.out.print(String.format("|%-18s|", entry.getValue().get(0)));
			System.out.print(String.format("%-10s|", entry.getValue().get(1)));
			System.out.print(String.format("%-41s|", entry.getValue().get(2)));
			System.out.print(String.format("%-10s|", entry.getValue().get(4)));
			System.out.print(String.format("%-12s|", entry.getValue().get(3)));
			System.out.println(String.format("%-15s|", productTotalPrice + " €"));

			for (int i = 0; i < 112; i++)
				System.out.print("-");
			System.out.println();
			TotalPrice += productTotalPrice;
		}
		System.out.print(ConsoleColors.RED_BOLD);
		System.out.print(String.format("|%-95s|",
				"Totals => => => To validate order (1) , (2) to cancel order or (2) to return to the menu"));
		System.out.println(String.format("%-15s|", TotalPrice + " €"));
		for (int i = 0; i < 112; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);

		if (bucket.isEmpty()) {
			System.out.println("Your bucket si empty");

		} else {
			int answer = 0;
			while (answer != 1 && answer != 2 && answer != 3) {
				System.out.println("What do you want to do: ?(1/2,3)");
				while (!scanner.hasNextInt()) {
					scanner.next();
					System.out.println("Sorry, your entry must be integer");
				}
				answer = scanner.nextInt();
			}
			if (answer == 1 || answer == 2) {
				bucket.clear();
				System.out.println("Your bucket is cleared, thank you.");
			}
		}
	}

	/**
	 * 
	 */
	private static void insertDataInTrainingMap() {
		String[] training1Array = { "JAVA", "20", "Java SE 8: sysntax, oop", "100" };
		String[] training2Array = { "ADVANCED JAVA", "20", "Exceptions, files, thread, jcdb...", "100" };
		String[] training3Array = { "C#", "15", "DotNet Core", "200" };
		String[] training4Array = { "SPRING", "15", "Spring core/mvc/security", "300" };
		String[] training5Array = { "PHP FRAMEWORKS", "20", "Symphony", "150" };
		trainings.put(1, Arrays.asList(training1Array));
		trainings.put(2, Arrays.asList(training2Array));
		trainings.put(3, Arrays.asList(training3Array));
		trainings.put(4, Arrays.asList(training4Array));
		trainings.put(5, Arrays.asList(training5Array));
	}

	/**
	 */
	public static void displayAllTrainingList() {
		/*
		 * Define the table header elements (box sizes, box titles)
		 */
		// 1- Boxes sizes
		String courseHeader = new String("COURSE             ");
		String daysNumberHeader = new String("DAYS/NB  ");
		String desciptionHeader = new String("DESCRIPTION                               ");
		String priceHeader = new String("PRICE (€) ");
		int[] headerColumnsSize = { courseHeader.length(), daysNumberHeader.length(), desciptionHeader.length(),
				priceHeader.length() };

		// Dipslay the table header
		int headerLength = courseHeader.length() + daysNumberHeader.length() + desciptionHeader.length()
				+ priceHeader.length() + 5; // 5 is the number of the table columns + 1
		System.out.print(ConsoleColors.RED_BOLD);
		for (int i = 0; i < headerLength; i++)
			System.out.print("-");
		System.out.println();
		System.out.println(
				"|" + courseHeader + "|" + daysNumberHeader + "|" + desciptionHeader + "|" + priceHeader + "|");
		for (int i = 0; i < headerLength; i++)
			System.out.print("-");
		System.out.print(ConsoleColors.RESET);//
		System.out.println();

		/*
		 * Display the table body
		 */
		// Browse the training HashMap
		for (Entry<Integer, List<String>> map : trainings.entrySet()) {
			System.out.print("|");
			// Browse HashMap Value
			for (int i = 0; i < map.getValue().size(); i++) {
				System.out.print(map.getValue().get(i));
				for (int j = 0; j < headerColumnsSize[i] - map.getValue().get(i).length(); j++)
					System.out.print(" "); // fill column ????
				System.out.print("|"); // Draw next column border
			}

			System.out.println();
			for (int i = 0; i < headerLength; i++)
				System.out.print("-");// Draw next line
			System.out.println();
		}
	}

	/**
	 * 
	 * @param researchePlanes
	 */
	public static void displayAllTrainingListV2() {
		for (int i = 0; i < 120; i++)
			System.out.print("-");
		System.out.println();
		System.out.print(ConsoleColors.RED_BOLD);
		System.out.print(String.format("|%-18s|", "COURSE"));
		System.out.print(String.format("%-10s|", "DAYS/NB"));
		System.out.print(String.format("%-41s|", "DESCRIPTION"));
		System.out.print(String.format("%-10s|", "PRICE (€)"));
		System.out.print(String.format("%-35s|", "Buy traing?"));
		System.out.println();
		for (int i = 0; i < 120; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);
		for (Map.Entry<Integer, List<String>> entry : trainings.entrySet()) {
			System.out.print(String.format("|%-18s|", entry.getValue().get(0)));
			System.out.print(String.format("%-10s|", entry.getValue().get(1)));
			System.out.print(String.format("%-41s|", entry.getValue().get(2)));
			System.out.print(String.format("%-10s|", entry.getValue().get(3)));
			System.out.print(ConsoleColors.GREEN);
			System.out.print(String.format("%-35s|", "To select this training, enter (" + entry.getKey() + ")"));
			System.out.print(ConsoleColors.RESET);
			System.out.println();
			for (int i = 0; i < 120; i++)
				System.out.print("-");
			System.out.println();
		}

	}

	/**
	 * 
	 */
	private static void storeMenu() {
		int menuChoice = -1;
		while (menuChoice != 0) {
			System.out.print(ConsoleColors.BLACK_BOLD);
			System.out.println("--------------------- STORE MENU --------------------");
			System.out.print(ConsoleColors.RESET);
			System.out.println("To view all the available trainings,        enter (1)");
			System.out.println("To add training to bucket,                  enter (2)");
			System.out.println("To show and validate your bucket,           enter (3)");
			System.out.println("To remove product from bucket,              enter (4)");
			System.out.println("To exit,                                    enter (0)");
			System.out.println("-----------------------------------------------------");
			/** Only integer entries accepted */
			while (!scanner.hasNextInt()) {
				System.out.println("Wrong entry, make a right choice (ONLY INTEGERS ENTRIES)!");
				scanner.next();
			}
			menuChoice = scanner.nextInt();
			switch (menuChoice) {
			case 1:
				displayAllTrainingList();
				break;
			case 2:
				addTrainingToBucket();
				break;
			case 3:
				bucketSummary();
				break;
			case 4:

				removeTrainingFromBucket();
				break;
			case 0:
				menuChoice = 0;
				break;
			default:
				System.out.println("Wrong entry: ONLY INTEGERS ENTRIES ( 0 to 5)");
			}
		}
	}

	/**
	 * 
	 */

	private static void removeTrainingFromBucket() {
		if (bucket.isEmpty())
			System.out.println("Sorry, your bucket is empty!!!");
		else {
			String answer = "yes";
			while (!answer.equalsIgnoreCase("no")) {
				Integer productId = 0;
				Integer quantity = 0;
				showBucket(bucket);

				/** Check if product entry is correct (available) */
				while (!bucket.containsKey(productId)) {
					System.out.println(
							"Select the product number you want to remove. Entry must be integer and correct ID !");
					while (!scanner.hasNextInt()) {
						scanner.next();
						System.out.println("Wrong entry, enter only integers:");
					}
					// System.out.println("Sorry the selected product not available, select the
					// right number:");
					/** Check if choice entry is correct (integer) */
					productId = scanner.nextInt();
				}

				/**
				 * Check if quantity entry is less than or equal to the correct quantity
				 * (available)
				 */
				while (quantity > Integer.parseInt(bucket.get(productId).get(4)) || quantity < 1) {
					System.out.println("Select the quantity of this product you want to remove !");
					while (!scanner.hasNextInt()) {
						scanner.next();
						System.out.println("Wrong entry, enter only integers uentry out:");
					}
					quantity = scanner.nextInt();
				}
				// remove
				if (!bucket.isEmpty()) {
					if (quantity.toString().equals(bucket.get(productId).get(4))) {
						bucket.remove(productId);
						showBucket(bucket);
					} else {
						Integer newQuantity = Integer.parseInt(bucket.get(productId).get(4)) - quantity;
						bucket.get(productId).remove(4);
						bucket.get(productId).add(newQuantity.toString());
					}
					if (bucket.isEmpty()) {
						answer = "no";// get out
					} else {
						showBucket(bucket);
						System.out.println("Do you want to remove another Product: ?(yes/no)");
						answer = yesOrNoChoice();
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param scan
	 * @return
	 */
	private static String yesOrNoChoice() {
		String choice = scanner.next();
		while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
			System.out.println("Sorry, answer yes or no : ?(yes/no)");
			choice = scanner.next();
		}
		return choice;
	}

	/**
	 * 
	 */
	private static void addTrainingToBucket() {

		String answer = "yes";
		while (!answer.equalsIgnoreCase("no")) {
			Integer quantity = 0;
			Integer choice = 0;
			List<String> bucketList = new ArrayList<String>();
			displayAllTrainingListV2();

			while (!trainings.containsKey(choice)) {
				System.out.println("Enter the  training's number please (intger only)");
				while (!scanner.hasNextInt()) {
					scanner.next();
					System.out.println("Wrong entry, enter only integers:");
				}
				choice = scanner.nextInt();
			}

			/** Check if choice entry is correct (available) */
			/***/
			System.out.println("choose the quantity for this training: ? 1,2,3,..");
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Wrong entry, enter only integers:");
			}
			quantity = scanner.nextInt();

			// build list for map
			bucketList.addAll(trainings.get(choice));// copy the training list to bucket list (train
			if (bucket.containsKey(choice)) {// add the same product -> quantity incremented
				Integer newQuantity = quantity + Integer.parseInt(bucket.get(choice).get(4)); //
				bucketList.add(newQuantity.toString());
				bucket.put(choice, bucketList);
			} else { // new product in the bucket (first time)
				bucketList.add(quantity.toString());
				bucket.put(choice, bucketList);
			}
			showBucket(bucket);
			// after each add
			int switchChoice = 0;
			while (switchChoice != 4) {
				System.out.println(
						"Do your choice: (1) -> add new product, (2) -> validate bucket, (3) -> Ajust bucket, (4) -> exit");
				while (!scanner.hasNextInt())
					scanner.next();
				switchChoice = scanner.nextInt();
				switch (switchChoice) {
				case 1:
					switchChoice = 3;
					break;
				case 2:
					bucketSummary();
					break;
				case 3:
					removeTrainingFromBucket();
					break;
				case 4:
					answer = "no";
					break;

				default:
					break;
				}
			}
		}

	}

	/**
	 * 
	 * @param bucket2
	 */
	private static void showBucket(Map<Integer, List<String>> bucket2) {
		for (Entry<Integer, List<String>> entry : bucket2.entrySet()) {
			System.out.print(ConsoleColors.BLUE_BOLD);
			System.out.print("Product N°: " + entry.getKey() + " -> ");
			System.out.print(ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN);
			System.out.print(String.format("[%-60s]", entry.getValue().get(0) + ", " + entry.getValue().get(1) + ", "
					+ entry.getValue().get(2) + ", " + entry.getValue().get(3)));
			System.out.print(String.format("[%-15s]", " Qunatity -> (" + entry.getValue().get(4) + ")"));
			System.out.println(ConsoleColors.RESET);
		}
	}
}
