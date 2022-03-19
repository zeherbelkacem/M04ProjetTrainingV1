package com.belkacem.m04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * TRAINING APP: In this 1st version of the application, it is a question here
 * of proposing a set of training to buy in an application in console mode
 * certainly but which must be the most intuitive
 * 
 * @author Stagiaires11P - march 2022
 */

public class Training {

	/** Training data structure **/
	private static Map<Integer, List<String>> trainings = new HashMap<Integer, List<String>>();
	/** Training data structure (available soon) **/
	private static Map<Integer, List<String>> futurTrainings = new HashMap<Integer, List<String>>();
	/** Bucket data structure **/
	private static Map<Integer, List<String>> bucket = new HashMap<Integer, List<String>>();
	/** I/O Streams */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/* Start by filling our data structures */
		insertDataInTrainingMap();
		insertDataInFutureTrainingMap();

		/* Welcome store app message + Training products display for the home page */
		/*
		 * A plugin (ANSI Escape in Console) is used to add some aesthetics (font,
		 * color...) to the console display (ConsoleColors class is used
		 */
		System.out.println(ConsoleColors.BLACK_BOLD + "                     Hello and welcome to my FullTrainings app\n"
				+ "           We will offer you a list of training courses currently available" + ConsoleColors.RESET);
		displayAllTrainingList();

		/*
		 * On the home page, you have a menu to do some actions: add (buy), delete,
		 * display...
		 */
		storeMenu();
		scanner.close();
	}

	/**
	 * this method allows us to build our training shop. Start by filling an array
	 * by different training descriptions. End by filling a HashMap representing our
	 * training data structure (id is added)
	 */
	private static void insertDataInFutureTrainingMap() {
		String[][] trainingArray = { { "C++", "20", "C++/11: sysntax, oop, qt", "120" },
				{ "PHYTON", "10", "Fundamentals, poo...", "100" },
				{ "ANGURAL", "25", "Javascript, TypeScript", "250" } };
		for (int i = 0; i < trainingArray.length; i++)
			futurTrainings.put(-(i + 1), Arrays.asList(trainingArray[i]));
	}

	/**
	 * this method allows us to add the future training products. Start by filling
	 * an array by different training descriptions. End by filling a HashMap
	 * representing our training data structure (id is added)
	 */
	private static void insertDataInTrainingMap() {
		String[][] trainingArray = { { "JAVA", "20", "Java SE 8: sysntax, oop", "100" },
				{ "ADVANCED JAVA", "20", "Exceptions, files, thread, jcdb...", "100" },
				{ "C#", "15", "DotNet Core", "200" }, { "SPRING", "15", "Spring core/mvc/security", "300" },
				{ "PHP FRAMEWORKS", "20", "Symphony", "150" } };
		for (int i = 0; i < trainingArray.length; i++)
			trainings.put(i + 1, Arrays.asList(trainingArray[i]));
	}

	/**
	 * she makes a summary of the customer's purchases. it offers actions such as
	 * validating and empty the bucket, canceling the bucket or coming back later
	 * 
	 */
	private static void bucketSummary() {

		System.out.print(ConsoleColors.RED_BOLD
				+ "    |---------------------------------------  Your bucket summary  -----------------------------------------|");
		/* Table header */
		System.out.println();
		for (int i = 0; i < 112; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);
		System.out.print(String.format(ConsoleColors.GREEN_BOLD + "|%-18s|%-10s|%-41s|%-10s|%-12s|%-15s|", "COURSE",
				"DAYS/NB", "DESCRIPTION", "QUANTITY)", "UNIT PRICE", "TOTAL PRICE"));
		System.out.println();
		for (int i = 0; i < 112; i++)
			System.out.print("-" + ConsoleColors.RESET);
		System.out.println();

		/*
		 * Total orice for each selected training and total price for the whole bucket
		 */
		Double productTotalPrice = 0.0;
		Double TotalPrice = 0.0;

		/* Start to fill the table body with the selected training */
		for (Map.Entry<Integer, List<String>> entry : bucket.entrySet()) {
			productTotalPrice = Double.parseDouble(entry.getValue().get(3))
					* Double.parseDouble(entry.getValue().get(4));
			System.out.print(String.format("|%-18s|%-10s|%-41s|%-10s|%-12s|%-15s|", entry.getValue().get(0),
					entry.getValue().get(1), entry.getValue().get(2), entry.getValue().get(3), entry.getValue().get(4),
					productTotalPrice + " €"));
			System.out.println();
			for (int i = 0; i < 112; i++)
				System.out.print("-");
			TotalPrice += productTotalPrice;
			System.out.println();
		}

		/*
		 * The last table line: a small choice menu and the total bucket price in EURO
		 */
		System.out.print(String.format(ConsoleColors.RED_BOLD + "|%-95s|%-15s|",
				"Totals => => => To validate order (1) , (2) to cancel order or (3) to return back",
				TotalPrice + " €"));
		System.out.println();
		for (int i = 0; i < 112; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);

		/* Explore the given choice menu */
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
				/*Empty the entire bucket*/
				bucket.clear();
				System.out.println("Your bucket is cleared, thank you.");
			}
		}
	}

	/**
	 * This method allows us to have the initial training shop display. It also
	 * offers a display of training courses available soon
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

		// Build the table header
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

		/**
		 * Training available soon
		 */
		System.out.print(ConsoleColors.CYAN_BOLD
				+ "|                               Training available soon                             |\n");
		for (int i = 0; i < headerLength; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);
		for (Entry<Integer, List<String>> map : futurTrainings.entrySet()) {
			System.out.print(ConsoleColors.CYAN + "|");
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
			System.out.println(ConsoleColors.RESET);
		}
	}

	/**
	 * This method gives another format (table with header, body, lines, columns)
	 * for the training display. it allows the user selecting training to buy
	 */
	public static void displayAllTrainingListV2() {
		/* Start building the table header */
		for (int i = 0; i < 120; i++)
			System.out.print("-");
		System.out.println();
		System.out.print(ConsoleColors.RED_BOLD + String.format("|%-18s|%-10s|%-41s|%-10s|%-35s|", "COURSE", "DAYS/NB",
				"DESCRIPTION", "PRICE (€)", "Buy traing?"));
		System.out.println();
		for (int i = 0; i < 120; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);

		/* Build the table body with the available training data structure */
		for (Map.Entry<Integer, List<String>> entry : trainings.entrySet()) {
			System.out.print(String.format("|%-18s|%-10s|%-41s|%-10s|", entry.getValue().get(0),
					entry.getValue().get(1), entry.getValue().get(2), entry.getValue().get(3)));
			/* A last column to allow user to select the training id for buying */
			System.out.print(ConsoleColors.GREEN
					+ String.format("%-35s|", "To select this training, enter (" + entry.getKey() + ")")
					+ ConsoleColors.RESET);
			System.out.println();
			for (int i = 0; i < 120; i++)
				System.out.print("-");
			System.out.println();
		}
	}

	/**
	 * This method allows us to have a simple menu offering a range of actions to
	 * perform like: display training, add, delete, validate...
	 */
	private static void storeMenu() {
		int menuChoice = -1;
		while (menuChoice != 0) { // (0) to exit menu
			System.out.println(ConsoleColors.BLACK_BOLD + "--------------------- STORE MENU --------------------"
					+ ConsoleColors.RESET);
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
	 * This method allows user to remove the entire selected bucket line order or
	 * partially the quantity of the select bucket line order
	 */
	private static void removeTrainingFromBucket() {
		if (bucket.isEmpty())
			System.out.println("Sorry, your bucket is empty!!!");
		else {
			String answer = "yes";

			/* The principal loop */
			while (!answer.equalsIgnoreCase("no")) {
				Integer productId = 0;
				Integer quantity = 0;
				showBucket(bucket);

				/* Check if product entry is correct (available) */
				while (!bucket.containsKey(productId)) {
					System.out.println(
							"Select the product number you want to remove. Entry must be integer and correct ID !");

					/* Check if product entry is an integer */
					while (!scanner.hasNextInt()) {
						scanner.next();
						System.out.println("Wrong entry, enter only integers:");
					}
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

				/* Start removing (deleting) */
				if (!bucket.isEmpty()) {
					if (quantity.toString().equals(bucket.get(productId).get(4))) { // remove the entire selected bucket
																					// line order
						bucket.remove(productId);
						showBucket(bucket);
					} else { // remove the selected quantity from the selected bucket order line
						Integer newQuantity = Integer.parseInt(bucket.get(productId).get(4)) - quantity;
						bucket.get(productId).remove(4);
						bucket.get(productId).add(newQuantity.toString());
					}
					if (bucket.isEmpty()) {
						answer = "no";// exit
					} else {
						showBucket(bucket);
						System.out.println("Do you want to remove another Product: ?(yes/no)");
						answer = yesOrNoChoice(); // yes to continue adding, no to exit
					}
				}
			}
		}
	}

	/**
	 * Allows us to make an optimal communication between the user the training app
	 * 
	 * @return a String "yes" or "no"
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
	 * This method allows the user to select a product (training) and to add it to
	 * his bucket. After each add, the user has the choice to continue to add
	 * products, to validate his bucket, to cancel his bucket or to leave without
	 * cancellation
	 * 
	 */
	private static void addTrainingToBucket() {
		String answer = "yes";

		/* The main loop */
		while (!answer.equalsIgnoreCase("no")) {
			/** Select a quantity of training product */
			Integer quantity = 0;
			/** Select the training product ID */
			Integer productId = 0;
			List<String> bucketList = new ArrayList<String>();

			/* Display training products to user for each add */
			displayAllTrainingListV2();

			/* Check if the selected id exists */
			while (!trainings.containsKey(productId)) {
				System.out.println("Enter the  training's number please (intger only)");

				/* Check if the entry (product id) is an integer */
				while (!scanner.hasNextInt()) {
					scanner.next();
					System.out.println("Wrong entry, enter only integers:");
				}
				productId = scanner.nextInt();
			}

			System.out.println("choose the quantity for this training: ? 1,2,3,..");

			/** Check the entry (quantity) is an integer */
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Wrong entry, enter only integers:");
			}
			quantity = scanner.nextInt();

			// build list for map
			bucketList.addAll(trainings.get(productId));// copy the training list to bucket list (train
			if (bucket.containsKey(productId)) {// add the same product -> quantity incremented
				Integer newQuantity = quantity + Integer.parseInt(bucket.get(productId).get(4)); //
				bucketList.add(newQuantity.toString());
				bucket.put(productId, bucketList);
			} else { // new product in the bucket (first time)
				bucketList.add(quantity.toString());
				bucket.put(productId, bucketList);
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
					switchChoice = 4;
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
					System.out.println("Wrong choice!!!");
					;
				}
			}
		}
	}

	/**
	 * Each time a training is added, the method displays the details of this
	 * training as an order line
	 * 
	 * @param bucketI represent the selected training from training DB (I for ith
	 *                select training)
	 */
	private static void showBucket(Map<Integer, List<String>> bucketI) {
		for (Entry<Integer, List<String>> entry : bucketI.entrySet()) {
			System.out.print(ConsoleColors.BLUE_BOLD + "Product N°: " + entry.getKey() + " -> " + ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN + String.format("[%-60s]", entry.getValue().get(0) + ", "
					+ entry.getValue().get(1) + ", " + entry.getValue().get(2) + ", " + entry.getValue().get(3)));
			System.out.println(
					String.format("[%-15s]", " Qunatity -> (" + entry.getValue().get(4) + ")" + ConsoleColors.RESET));
		}
	}
}
